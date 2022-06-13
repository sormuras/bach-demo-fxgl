package project;

import com.github.sormuras.bach.Configurator;
import com.github.sormuras.bach.Project;

public final class BachFxglConf implements Configurator {
    @Override
    public Project configureProject(Project project) {
        return project
            .with(FXGL.version("17.1"))
            .with(GluonAttach.version("4.0.14"))
            .with(Jackson.version("2.13.3"))
            //.with(JavaFX.version("18.0.1"))
            .with(Kotlin.version("1.7.0"));
    }
}
