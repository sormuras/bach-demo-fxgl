module com.github.sormuras.bach.fxgl {
  requires com.almasb.fxgl.all;
  requires jdk.crypto.ec; // https://github.com/AlmasB/FXGL/issues/910

  exports com.github.sormuras.bach.fxgl to com.almasb.fxgl.core;
}
