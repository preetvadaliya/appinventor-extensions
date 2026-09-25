# appinventor-extensions

Extensions for [MIT App Inventor](https://appinventor.mit.edu).

## Repository layout

Each extension lives in its own directory with its sources, build tooling and
documentation. Built `.aix` files are attached to
[releases](../../releases) rather than committed.

## Building

App Inventor extensions are not standalone projects — they compile inside an App
Inventor source tree, against its annotation processor:

```bash
git clone https://github.com/mit-cml/appinventor-sources
cd appinventor-sources/appinventor
export JAVA_HOME=/path/to/jdk-17
ant extensions
```

Java 17 specifically. On newer JDKs the annotation processors are skipped and the
build fails later with a missing `simple_components.json`.

Built extensions land in `components/build/extensions/`.

## Licence

[MIT](LICENSE)
