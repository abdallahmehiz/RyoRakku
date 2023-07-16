buildscript {
  dependencies {
    classpath(libs.gradle)
    classpath(libs.hilt.gradle.plugin)
  }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
  alias(androidx.plugins.application) apply false
  alias(androidx.plugins.library) apply false
  alias(kotlinx.plugins.android) apply false
  alias(androidx.plugins.test) apply false
  alias(libs.plugins.hilt) apply false
}
