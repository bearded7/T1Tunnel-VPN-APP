#!/bin/bash
set -e
echo "Installing gomobile..."
go install golang.org/x/mobile/cmd/gomobile@latest
gomobile init
cd ../native/go
echo "Downloading Xray dependencies..."
go mod tidy
echo "Building Android ARM64 Xray AAR..."
mkdir -p ../../app/libs
gomobile bind -target=android/arm64 -o ../../app/libs/xray.aar github.com/t1tunnel/xraywrapper
cd ../..
echo "Xray AAR generated at app/libs/xray.aar"
