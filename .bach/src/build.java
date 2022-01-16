import com.github.sormuras.bach.Bach;
import com.github.sormuras.bach.ToolCall;
import com.github.sormuras.bach.external.FXGL;
import com.github.sormuras.bach.external.GluonAttach;
import com.github.sormuras.bach.external.Jackson;
import com.github.sormuras.bach.external.JavaFX;
import com.github.sormuras.bach.external.Kotlin;
import com.github.sormuras.bach.simple.SimpleSpace;
import java.io.File;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class build {
  public static void main(String... args) {
    try (var bach = new Bach(args)) {
      var grabber =
          bach.grabber(
              FXGL.version("17"),
              GluonAttach.version("4.0.13"),
              Jackson.version("2.13.0"),
              JavaFX.version("18-ea+9"),
              Kotlin.version("1.6.10"));

      var space =
          SimpleSpace.of(bach)
              .withModule(
                  "com.github.sormuras.bach.fxgl",
                  module -> module.main("com.github.sormuras.bach.fxgl.Main"));

      space.grab(grabber, "com.almasb.fxgl.all");

      space.compile();

      if (!System.getenv().containsKey("CI")) {
        bach.logCaption("Launch FXGL-based Application");
        // FXGL calls System.exit(), don't launch in-process: space.runModule("com...bach.fxgl");
        var modulePaths =
            Stream.of(bach.path().workspace("modules"), bach.path().externalModules())
                .map(Object::toString)
                .collect(Collectors.joining(File.pathSeparator));
        var java =
            ToolCall.java(
                "--module-path", modulePaths, "--module", "com.github.sormuras.bach.fxgl");
        bach.run(java);
      }

      bach.logCaption("Link modules into a custom runtime image");
      space.link(jlink -> jlink.add("--launcher", "bach-fxgl=com.github.sormuras.bach.fxgl"));
    }
  }
}
