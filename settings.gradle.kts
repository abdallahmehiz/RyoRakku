pluginManagement {
  repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
  }
}
dependencyResolutionManagement {
  versionCatalogs {
    create("kotlinx") {
      from(files("gradle/kotlinx.versions.toml"))
    }
    create("androidx") {
      from(files("gradle/androidx.versions.toml"))
    }
    create("compose") {
      from(files("gradle/compose.versions.toml"))
    }
  }

  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
    google()
    mavenCentral()
  }
}
rootProject.name = "RyoRakku"
include(":app")
