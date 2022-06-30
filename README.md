# 🛸 Bach + FXGL

[Bach] demo based on [Basic Game Example](https://github.com/AlmasB/FXGL/wiki/Basic-Game-Example-%28FXGL-11%29) by [FXGL].

## Prepare

- Download [JDK] 17 or later
- Clone this repository

## Build

Change into the root directory of your cloned project and call:

- Linux/Mac
```shell script
.bach/bin/bach build
```

- Windows
```shell script
.bach\bin\bach build
```

## Run via Java Launcher

- Linux/Mac
```shell script
java --module-path .bach/out/main/modules:.bach/external-modules --module com.github.sormuras.bach.fxgl
```

- Windows
```shell script
java --module-path .bach\out\main\modules;.bach\external-modules --module com.github.sormuras.bach.fxgl
```

## Run via custom runtime image

- Linux/Mac
```shell script
.bach/out/main/image/bin/bach-fxgl
```

- Windows
```shell script
.bach\out\main\image\bin\bach-fxgl
```

## Using IntelliJ IDEA to prepare, build, and run

- Download and install IDEA
- Install [JDK] 17 using IDEA's built-in JDK installation support
- Clone this repository

### Run via shared Run Configurations

- Initially "Run `bach build`" to resolve missing external modules
- "Run `Main`" to launch the demo application

[Bach]: https://github.com/sormuras/bach
[IDEA]: https://www.jetbrains.com/idea
[JDK]: https://jdk.java.net
[FXGL]: https://almasb.github.io/FXGL
