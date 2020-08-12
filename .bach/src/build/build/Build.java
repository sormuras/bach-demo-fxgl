package build;

import de.sormuras.bach.Bach;
import de.sormuras.bach.Configuration;
import de.sormuras.bach.Project;
import de.sormuras.bach.project.Feature;
import de.sormuras.bach.project.Link;
import java.util.Locale;

public class Build {
  public static void main(String... args) {
    var configuration = Configuration.ofSystem();
    var project =
        Project.ofCurrentDirectory()
            .without(Feature.CREATE_API_DOCUMENTATION)
            .without(Feature.CREATE_CUSTOM_RUNTIME_IMAGE)
            .with(
                Link.of(
                    "com.fasterxml.jackson.databind",
                    "https://repo.maven.apache.org/maven2/com/fasterxml/jackson/core/jackson-databind/2.11.2/jackson-databind-2.11.2.jar"))
            .with(
                Link.of(
                    "com.fasterxml.jackson.annotation",
                    "https://repo.maven.apache.org/maven2/com/fasterxml/jackson/core/jackson-annotations/2.11.2/jackson-annotations-2.11.2.jar"))
            .with(linkModuleOfJavaFX("base"))
            .with(linkModuleOfJavaFX("controls"))
            .with(linkModuleOfJavaFX("fxml"))
            .with(linkModuleOfJavaFX("graphics"))
            .with(linkModuleOfJavaFX("media"))
            .with(linkModuleOfJavaFX("swing"));

    new Bach(configuration, project).build();
  }

  // https://repo.maven.apache.org/maven2/org/openjfx
  static Link linkModuleOfJavaFX(String suffix) {
    var group = "org.openjfx";
    var version = "14.0.2.1";
    var platform = of("linux", "mac", "win");
    var coordinates = String.join(":", group, "javafx-" + suffix, version, platform);
    return Link.ofCentral("javafx." + suffix, coordinates);
  }

  static <T> T of(T linux, T mac, T windows) {
    var os = System.getProperty("os.name").toLowerCase(Locale.ENGLISH);
    if (os.contains("win")) return windows;
    if (os.contains("mac")) return mac;
    return linux;
  }
}
