buildscript {
  dependencies {
    classpath("com.android.tools.build:gradle:8.0.2")
  }
}
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
  alias(androidx.plugins.application) apply false
  alias(androidx.plugins.library) apply false
  alias(kotlinx.plugins.android) apply false
  alias(androidx.plugins.test) apply false
}