package project;

import com.github.sormuras.bach.Bach;
import com.github.sormuras.bach.ToolCall;
import com.github.sormuras.bach.ToolOperator;
import java.io.PrintWriter;

public class Build implements ToolOperator {
  @Override
  public int run(Bach bach, PrintWriter out, PrintWriter err, String... args) {
    bach.run("com.github.sormuras.bach/build"); // run default build tool

    var main = bach.project().spaces().main();
    var paths = bach.configuration().paths();
    var modulePaths = bach.project().spaces().test().toModulePath(paths).orElseThrow();

    if (!System.getenv().containsKey("CI")) {
      bach.run(
          ToolCall.of("java")
              .with("--module-path", modulePaths)
              .with("--module", main.modules().list().get(0).name()));
    }

    var image = paths.out(main.name(), "image");
    bach.run("tree", "--mode", "CLEAN", image);
    bach.run(
        ToolCall.of("jlink")
            .with("--output", image)
            .with("--launcher", "demo=demo")
            .with("--add-modules", main.modules().names(","))
            .with("--module-path", modulePaths));

    return 0;
  }
}
