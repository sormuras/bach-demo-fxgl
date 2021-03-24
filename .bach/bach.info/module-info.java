import com.github.sormuras.bach.ProjectInfo;
import com.github.sormuras.bach.ProjectInfo.Externals;
import com.github.sormuras.bach.ProjectInfo.Externals.Name;
import com.github.sormuras.bach.ProjectInfo.Tools;

@ProjectInfo(
    name = "bach-fxgl",
    version = "1-ea",
    tools = @Tools(skip = "javadoc"),
    // <editor-fold desc="Libraries - External Modules">
    lookupExternal = {
      @ProjectInfo.External(
          module = "com.fasterxml.jackson.annotation",
          via = "com.fasterxml.jackson.core:jackson-annotations:2.11.2"),
      @ProjectInfo.External(
          module = "com.fasterxml.jackson.databind",
          via = "com.fasterxml.jackson.core:jackson-databind:2.11.2"),
    },
    lookupExternals = {
      @Externals(name = Name.JAVAFX, version = "16"),
      @Externals(name = Name.FXGL, version = "11.14"),
      @Externals(name = Name.SORMURAS_MODULES, version = "2021.03")
    }
    // </editor-fold>
    )
module bach.info {
  requires com.github.sormuras.bach;
}
