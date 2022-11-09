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
java --module-path .bach/out/main/modules:.bach/external-modules --module demo
```

- Windows
```shell script
java --module-path .bach\out\main\modules;.bach\external-modules --module demo
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

- Install [IDEA] and optionally set up [JDK] 17 using IDEA's built-in JDK setup wizard
- Clone this repository
- Initially "Run `bach build`" to resolve missing external modules
- "Run `Main`" to launch the demo application

[Bach]: https://github.com/sormuras/bach
[IDEA]: https://www.jetbrains.com/idea
[JDK]: https://jdk.java.net
[FXGL]: https://almasb.github.io/FXGL
