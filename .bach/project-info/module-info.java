module project {
  requires com.github.sormuras.bach;

  provides java.util.spi.ToolProvider with
      project.Build;
}
