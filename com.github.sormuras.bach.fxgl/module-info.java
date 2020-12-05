module com.github.sormuras.bach.fxgl {
  requires com.almasb.fxgl.all;
  requires jdk.crypto.ec; // https://stackoverflow.com/questions/55439599

  exports com.github.sormuras.bach.fxgl to
      com.almasb.fxgl.core;
}
