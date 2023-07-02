buildscript {
  dependencies {
    classpath(libs.gradle)
  }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
  alias(androidx.plugins.application) apply false
  alias(androidx.plugins.library) apply false
  alias(kotlinx.plugins.android) apply false
  alias(androidx.plugins.test) apply false
}
