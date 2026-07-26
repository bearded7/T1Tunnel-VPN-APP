#!/bin/bash
set -e

# Resolve paths relative to this script's location so it can be run from
# anywhere (repo root, scripts/, etc.) instead of assuming a fixed cwd.
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
REPO_ROOT="$(cd "$SCRIPT_DIR/.." && pwd)"
GO_DIR="$REPO_ROOT/native/go"
LIBS_DIR="$REPO_ROOT/app/libs"

echo "Installing gomobile..."
go install golang.org/x/mobile/cmd/gomobile@latest
export PATH="$PATH:$(go env GOPATH)/bin"
gomobile init

cd "$GO_DIR"
echo "Downloading Xray dependencies..."
go mod tidy

echo "Building Android Xray AAR (arm64-v8a, armeabi-v7a, x86_64)..."
mkdir -p "$LIBS_DIR"
# -javapkg pins the generated Java/Kotlin package name so it matches the
# `import com.t1tunnel.xray.Xray` used in XrayEngine.kt. Without this flag
# gomobile derives the package from the Go package name ("xray") instead,
# which would not match and fail to compile.
gomobile bind \
  -target=android/arm64,android/arm,android/amd64 \
  -androidapi=21 \
  -javapkg=com.t1tunnel.xray \
  -o "$LIBS_DIR/xray.aar" \
  github.com/t1tunnel/xraywrapper

echo "Xray AAR generated at $LIBS_DIR/xray.aar"
