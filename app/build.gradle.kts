
plugins {
  alias(androidx.plugins.application)
  alias(kotlinx.plugins.android)
  alias(libs.plugins.apollo)
  kotlin("kapt")
}
apollo {
  service("service") {
    packageName.set("xyz.mehiz.ryorakku")
  }
}

android {
  namespace = "xyz.mehiz.ryorakku"
  compileSdk = 33

  defaultConfig {
    applicationId = "xyz.mehiz.ryorakku"
    minSdk = 24
    targetSdk = 33
    versionCode = 1
    versionName = "0.0.0-1rc"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    vectorDrawables {
      useSupportLibrary = true
    }
  }

  buildTypes {
    getByName("release") {
      isMinifyEnabled = true
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
  kotlinOptions {
    jvmTarget = "1.8"
  }
  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = "1.4.0"
  }
  packagingOptions {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }
}

dependencies {
  // Compose
  implementation(platform(compose.bom))
  implementation(compose.activity)
  implementation(compose.ui)
  implementation(compose.ui.tooling)
  implementation(compose.ui.graphics)
  implementation(compose.navigation)

  implementation(compose.material3.core)

  // Androidx
  implementation(androidx.lifecycle.runtimektx)
  implementation(androidx.corektx)

  // Kotlinx
  implementation(kotlinx.bom)
  implementation(kotlinx.bundles.coroutines)


  testImplementation(libs.junit)
  implementation(libs.apollo)
  implementation(libs.bundles.voyager)

  // Dagger - Hilt
  implementation(libs.hilt.android)
  implementation(libs.hilt.navigation.compose)
  kapt(libs.hilt.android.compiler)
  kapt(libs.hilt.compiler)
}