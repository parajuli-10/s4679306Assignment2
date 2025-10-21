#!/usr/bin/env sh
# Simple Gradle startup script for Unix/macOS
DIR="$(cd "$(dirname "$0")" && pwd)"
exec "$DIR/gradle/wrapper/gradle-wrapper.jar" "$@"
