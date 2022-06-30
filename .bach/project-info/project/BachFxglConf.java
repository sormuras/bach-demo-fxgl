package project;

import com.github.sormuras.bach.Configurator;
import com.github.sormuras.bach.Project;

public final class BachFxglConf implements Configurator {
    @Override
    public Project configureProject(Project project) {
        return project
            .with(FXGL.version("17.1"))
            .with(GluonAttach.version("4.0.14"));
    }
}
