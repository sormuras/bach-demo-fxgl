import static com.github.sormuras.bach.api.ExternalLibraryName.*;

import com.github.sormuras.bach.api.ProjectInfo;
import com.github.sormuras.bach.api.ProjectInfo.*;

@ProjectInfo(
    name = "bach-fxgl",
    version = "1-ea",
    external =
        @External(
            libraries = {
              @ExternalLibrary(name = JAVAFX, version = "16"),
              @ExternalLibrary(name = FXGL, version = "11.15"),
              @ExternalLibrary(name = SORMURAS_MODULES, version = "2021.04.13")
            }),
    tool =
        @Tool(
            skip = "javadoc",
            tweaks =
                @Tweak(
                    tool = "jlink",
                    with = "--launcher",
                    more = "bach-fxgl=com.github.sormuras.bach.fxgl")))
module bach.info {
  requires com.github.sormuras.bach;
}
