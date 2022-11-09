module demo {
  requires com.almasb.fxgl.all;
  requires jdk.crypto.ec; // https://github.com/AlmasB/FXGL/issues/910

  exports demo to com.almasb.fxgl.core;
}
