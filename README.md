# 🛸 Bach + FXGL

[Bach] demo based on [Basic Game Example](https://github.com/AlmasB/FXGL/wiki/Basic-Game-Example-%28FXGL-11%29) by [FXGL].

## Prepare

- Download and install [JDK] 22 or later
- Clone this repository with submodules

## Build

Change into the root directory of your cloned project and call:

```shell script
java @build
```

## Run via Java Launcher

- Linux/Mac
```shell script
java --module-path .bach/out/main/modules:lib --module demo
```

- Windows
```shell script
java --module-path .bach\out\main\modules;lib --module demo
```

## Run via custom runtime image

- Linux/Mac
```shell script
.bach/out/main/image/bin/demo
```

- Windows
```shell script
.bach\out\main\image\bin\demo
```

## Using IntelliJ IDEA

- Install [IDEA] and optionally set up [JDK] 22 or later using IDEA's built-in JDK setup wizard
- Clone this repository with submodules
- Initially "Run `java @build`" to restore missing required modules
- "Run `Main`" to launch the demo application

[Bach]: https://github.com/sormuras/bach
[IDEA]: https://www.jetbrains.com/idea
[JDK]: https://jdk.java.net
[FXGL]: https://almasb.github.io/FXGL
