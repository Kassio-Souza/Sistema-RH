#!/usr/bin/env bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "$0")/.." && pwd)"
BUILD_DIR="$ROOT_DIR/out"

mkdir -p "$BUILD_DIR"

# Compile targeting Java 16 (project baseline) using only standard library and bundled stubs.
find "$ROOT_DIR/out" -mindepth 1 -delete >/dev/null 2>&1 || true

javac --release 16 -d "$BUILD_DIR" $(find "$ROOT_DIR/src/main/java" -name "*.java")

echo "Compilation finished. To run the application UI, execute:\n  java -cp $BUILD_DIR Main"
