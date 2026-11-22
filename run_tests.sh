#!/usr/bin/env bash
#  run_tests.sh - Tests de non-régression du front-end.
#
#  tests/syntax/ok/*.while : doivent être acceptés (code 0) ; si un fichier
#                            .ast de même nom existe, l'AST affiché par
#                            "whilec --ast" doit lui être identique.
#  tests/syntax/ko/*.while : doivent être rejetés (code 1) ; si un fichier
#                            .err existe, les messages d'erreur doivent lui
#                            être identiques.
#
#  Usage : ./run_tests.sh            lance les tests
#          ./run_tests.sh --update   (re)génère les fichiers .ast / .err attendus
#                                    (à faire après une modification VOULUE,
#                                     puis relire le diff avec git diff)
set -u
ROOT="$(cd "$(dirname "$0")" && pwd)"
cd "$ROOT"

UPDATE=0
[ "${1:-}" = "--update" ] && UPDATE=1

[ -d build/whilec ] || ./build.sh || exit 2

pass=0; fail=0
red()   { printf '\033[31m%s\033[0m\n' "$*"; }
green() { printf '\033[32m%s\033[0m\n' "$*"; }

# programmes valides
for f in tests/syntax/ok/*.while; do
  expected="${f%.while}.ast"
  actual="$(./whilec --ast "$f" 2>&1)"; code=$?
  if [ $UPDATE -eq 1 ] && [ $code -eq 0 ]; then printf '%s\n' "$actual" > "$expected"; fi
  if [ $code -ne 0 ]; then
    red "ÉCHEC  $f (rejeté alors qu'il est valide)"; echo "$actual" | sed 's/^/       /'; fail=$((fail+1))
  elif [ -f "$expected" ] && ! diff -q <(printf '%s\n' "$actual") "$expected" >/dev/null; then
    red "ÉCHEC  $f (AST différent de $expected)"
    diff <(printf '%s\n' "$actual") "$expected" | head -20 | sed 's/^/       /'; fail=$((fail+1))
  else
    green "OK     $f"; pass=$((pass+1))
  fi
done

# programmes invalides
for f in tests/syntax/ko/*.while; do
  expected="${f%.while}.err"
  actual="$(./whilec -q "$f" 2>&1)"; code=$?
  if [ $UPDATE -eq 1 ] && [ $code -eq 1 ]; then printf '%s\n' "$actual" > "$expected"; fi
  if [ $code -ne 1 ]; then
    red "ÉCHEC  $f (code $code au lieu de 1 : devait être rejeté)"; fail=$((fail+1))
  elif [ -f "$expected" ] && ! diff -q <(printf '%s\n' "$actual") "$expected" >/dev/null; then
    red "ÉCHEC  $f (message différent de $expected)"
    diff <(printf '%s\n' "$actual") "$expected" | sed 's/^/       /'; fail=$((fail+1))
  else
    green "OK     $f"; pass=$((pass+1))
  fi
done

echo
echo "Résultat : $pass réussi(s), $fail échec(s)."
[ $fail -eq 0 ]
