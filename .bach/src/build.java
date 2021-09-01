import com.github.sormuras.bach.Bach;
import com.github.sormuras.bach.ToolCall;
import com.github.sormuras.bach.external.FXGL;
import com.github.sormuras.bach.external.GluonAttach;
import com.github.sormuras.bach.external.Jackson;
import com.github.sormuras.bach.external.JavaFX;
import com.github.sormuras.bach.external.Kotlin;
import java.util.List;

class build {
  public static void main(String... args) {
    try (var bach = new Bach(args)) {
      var grabber =
          bach.grabber(
              FXGL.version("11.17"),
              GluonAttach.version("4.0.12"),
              Jackson.version("2.12.4"),
              JavaFX.version("16"),
              Kotlin.version("1.5.30"));

      var builder = bach.builder().conventional("com.github.sormuras.bach.fxgl");

      builder.grab(grabber, "com.almasb.fxgl.all");

      builder.compile();

      if (!System.getenv().containsKey("CI")) {
        bach.logCaption("Launch FXGL-based Application");
        // FXGL calls System.exit(), don't launch in-process: builder.runModule("com...bach.fxgl");
        var modulePaths = List.of(bach.path().workspace("modules"), bach.path().externalModules());
        var java =
            ToolCall.java()
                .with("--module-path", modulePaths)
                .with("--module", "com.github.sormuras.bach.fxgl");
        bach.run(java);
      }

      bach.logCaption("Link modules into a custom runtime image");
      builder.link(jlink -> jlink.with("--launcher", "bach-fxgl=com.github.sormuras.bach.fxgl"));
    }
  }
}
