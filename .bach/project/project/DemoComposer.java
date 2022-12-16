package project;

import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.spi.ToolProvider;
import run.bach.Composer;
import run.bach.Project;
import run.bach.ProjectTool;
import run.bach.ProjectTools;
import run.duke.Duke;
import run.duke.Workbench;

public class DemoComposer extends Composer {
  @Override
  public Project createProject() {
    return new Project(
        new Project.Name("bach-demo-fxgl"),
        new Project.Version("0-ea"),
        new Project.Space(
            "main", 0, "demo/demo.Main", new Project.DeclaredModule(Path.of("demo"))));
  }

  @Override
  public ProjectTools createProjectTools() {
    return new ProjectTools(new Link());
  }

  static class Link extends ProjectTool {
    Link() {}

    Link(Workbench workbench) {
      super(workbench);
    }

    @Override
    public String name() {
      return "link";
    }

    @Override
    public ToolProvider provider(Workbench workbench) {
      return new Link(workbench);
    }

    @Override
    public int run(PrintWriter out, PrintWriter err, String... args) {
      var image = folders().out("main", "image");
      var paths = project().spaces().space("main").toRuntimeSpace().toModulePath(folders());
      run(Duke.treeDelete(image));
      run(
          "jlink",
          jlink ->
              jlink
                  .with("--output", image)
                  .with("--launcher", "demo=demo")
                  .with("--add-modules", "demo")
                  .with("--module-path", paths.orElse(".")));
      return 0;
    }
  }
}
