#!/usr/bin/env bash
#  build.sh - Construit le compilateur While (front-end).
#
#   1. ANTLR 3 génère WhileLexer.java / WhileParser.java depuis While.g (-> gen/)
#   2. javac compile src/ + gen/ (-> build/)
#
#  Usage : ./build.sh          (puis ./whilec --help)
set -euo pipefail

ROOT="$(cd "$(dirname "$0")" && pwd)"
ANTLR="$ROOT/lib/antlr-3.5.3-complete-no-st3.jar"
GRAMMAR="$ROOT/src/whilec/frontend/While.g"
GEN="$ROOT/gen/whilec/frontend"

command -v java  >/dev/null || { echo "java introuvable (JDK 17+ requis)"; exit 1; }
command -v javac >/dev/null || { echo "javac introuvable (JDK 17+ requis)"; exit 1; }

echo "[1/2] Génération du lexer et du parser (ANTLR 3.5.3)..."
rm -rf "$ROOT/gen" "$ROOT/build"
mkdir -p "$GEN" "$ROOT/build"
java -cp "$ANTLR" org.antlr.Tool -fo "$GEN" "$GRAMMAR"

echo "[2/2] Compilation Java..."
find "$ROOT/src" "$ROOT/gen" -name '*.java' > "$ROOT/build/sources.txt"
javac --release 17 -encoding UTF-8 -cp "$ANTLR" -d "$ROOT/build" @"$ROOT/build/sources.txt"

echo "OK : compilateur construit dans build/. Essayez : ./whilec --ast tests/syntax/ok/04_arithmetique.while"
