#!/bin/bash

BASE_DIR=$(dirname "$(dirname "$(readlink -f "$0")")")
SRC_DIR="$BASE_DIR/src"
BIN_DIR="$BASE_DIR/bin"

mkdir -p "$BIN_DIR"

javac -d "$BIN_DIR" "$SRC_DIR"/*.java

if [ $? -eq 0 ]; then
    java -cp "$BIN_DIR" Main "$@"
else
    echo "❌ Erro na compilação!"
    exit 1
fi