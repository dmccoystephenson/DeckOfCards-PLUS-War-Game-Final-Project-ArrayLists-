#!/usr/bin/env bash
# Builds the browser version of War into build/web: index.html plus war.jar,
# which web/index.html runs with CheerpJ. CheerpJ runs Java 8 bytecode by
# default, so the classes are compiled with --release 8. The classes in src/
# are compiled as they are; web/java/BrowserMain.java is the browser-only
# entry point.
set -euo pipefail
cd "$(dirname "$0")/.."

rm -rf build/browser-classes build/web
mkdir -p build/browser-classes build/web
javac --release 8 -d build/browser-classes src/*.java web/java/BrowserMain.java
jar cf build/web/war.jar -C build/browser-classes .
cp web/index.html build/web/index.html
echo "Built build/web:"
ls -l build/web
