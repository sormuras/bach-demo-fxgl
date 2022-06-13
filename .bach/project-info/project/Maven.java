package project;

import java.util.StringJoiner;

/** Maven-related helpers. */
final class Maven {

  public static final String CENTRAL_REPOSITORY = "https://repo.maven.apache.org/maven2";
  public static final String DEFAULT_CLASSIFIER = "", DEFAULT_TYPE = "jar";

  public static Builder builder(String group, String artifact, String version) {
    return new Builder(group, artifact, version);
  }

  public static String central(String group, String artifact, String version) {
    return Maven.builder(group, artifact, version).build();
  }

  public static String central(String group, String artifact, String version, String classifier) {
    return Maven.builder(group, artifact, version).classifier(classifier).build();
  }

  /** A builder of Maven coordinates. */
  public record Builder(
      String repository,
      String group,
      String artifact,
      String version,
      String classifier,
      String type) {

    public Builder(String group, String artifact, String version) {
      this(CENTRAL_REPOSITORY, group, artifact, version, DEFAULT_CLASSIFIER, DEFAULT_TYPE);
    }

    public String build() {
      var joiner = new StringJoiner("/").add(repository);
      joiner.add(group.replace('.', '/')).add(artifact).add(version);
      var file = artifact + '-' + (classifier.isBlank() ? version : version + '-' + classifier);
      return joiner.add(file + '.' + type).toString();
    }

    public Builder repository(String repository) {
      return new Builder(repository, group, artifact, version, classifier, type);
    }

    public Builder group(String group) {
      return new Builder(repository, group, artifact, version, classifier, type);
    }

    public Builder artifact(String artifact) {
      return new Builder(repository, group, artifact, version, classifier, type);
    }

    public Builder version(String version) {
      return new Builder(repository, group, artifact, version, classifier, type);
    }

    public Builder classifier(String classifier) {
      return new Builder(repository, group, artifact, version, classifier, type);
    }

    public Builder type(String type) {
      return new Builder(repository, group, artifact, version, classifier, type);
    }
  }

  /** Hidden default constructor. */
  private Maven() {}
}
