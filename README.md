# 🛸 Bach + FXGL

[Bach.java] demo based on [Basic Game Example](https://github.com/AlmasB/FXGL/wiki/Basic-Game-Example-%28FXGL-11%29) by [FXGL].

## Prepare

- Download [JDK] 11 or later
- Clone this repository
- Open a command shell and ensure `jshell --version` is working correctly

## Build

Change into the base directory of your cloned project and call:

```shell script
jshell https://sormuras.de/bach/build
```

## Run via Java Launcher

- Linux/Mac
```shell script
java --module-path .bach/workspace/modules:lib --module com.github.sormuras.bach.fxgl
```

- Windows
```shell script
java --module-path .bach\workspace\modules;lib --module com.github.sormuras.bach.fxgl
```

## Run via custom runtime image

- Linux/Mac
```shell script
.bach/workspace/image/bin/bach-fxgl
```

- Windows
```shell script
.bach\workspace\image\bin\bach-fxgl[.bat]
```

[Bach.java]: https://github.com/sormuras/bach
[JDK]: https://jdk.java.net
[FXGL]: https://almasb.github.io/FXGL
