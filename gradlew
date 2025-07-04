#!/bin/bash
set -e
GRADLEW_URL="https://services.gradle.org/distributions/gradle-7.2-bin.zip"
WRAPPER_DIR="./gradle/wrapper"

mkdir -p "$WRAPPER_DIR"
cd "$WRAPPER_DIR"
wget -q "$GRADLEW_URL" -O gradle.zip
unzip -q gradle.zip
cd -
./gradle/wrapper/gradle-7.2/bin/gradle "$@"
