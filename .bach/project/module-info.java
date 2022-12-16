import run.bach.Command;

@Command(name = "build", args = "run.bach/build + link")
module project {
  requires run.bach;

  provides run.bach.Composer with
      project.DemoComposer;
}
