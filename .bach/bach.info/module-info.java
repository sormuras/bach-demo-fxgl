import com.github.sormuras.bach.ProjectInfo;
import com.github.sormuras.bach.ProjectInfo.*;

@ProjectInfo(
    name = "bach-fxgl",
    version = "1-ea",
    options = @Options(tools = @Tools(skip = "javadoc")),
    libraries =
        @Libraries(
            externalLibraries = {
              @ExternalLibrary(name = LibraryName.JAVAFX, version = "16"),
              @ExternalLibrary(name = LibraryName.FXGL, version = "11.14"),
              @ExternalLibrary(name = LibraryName.SORMURAS_MODULES, version = "2021.04.13")
            }))
module bach.info {
  requires com.github.sormuras.bach;
}
