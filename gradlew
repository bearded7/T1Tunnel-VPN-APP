#!/bin/sh
# This script downloads and runs the Gradle wrapper if it's missing.
set -e

if [ ! -f gradle/wrapper/gradle-wrapper.jar ]; then
    echo "Downloading Gradle wrapper..."
    mkdir -p gradle/wrapper
    curl -sL "https://github.com/gradle/gradle/raw/v8.7.0/gradle/wrapper/gradle-wrapper.jar" -o gradle/wrapper/gradle-wrapper.jar
fi
exec ./gradle/wrapper/gradlew "$@"
