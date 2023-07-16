plugins {
  alias(androidx.plugins.application)
  alias(kotlinx.plugins.android)
  alias(libs.plugins.apollo)
  kotlin("kapt")
  alias(libs.plugins.hilt)
}

kapt {
  correctErrorTypes = true
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
    release {
      isMinifyEnabled = true
      isShrinkResources = true
      proguardFiles(
        getDefaultProguardFile("proguard-android-optimize.txt"),
        "proguard-rules.pro"
      )
      signingConfig = signingConfigs.getByName("debug")
    }

    debug {
      isMinifyEnabled = false
      applicationIdSuffix = ".debug"
      versionNameSuffix = "-debug"
      isDebuggable = true
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
  kotlinOptions {
    jvmTarget = "17"
  }
  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = "1.4.8"
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
  implementation(androidx.datastore.preferences)
  implementation(androidx.splashscreen)

  // Hilt
  implementation(libs.hilt.android)
  kapt(libs.hilt.compiler)
  implementation(androidx.hilt.navigation)

  // Kotlinx
  implementation(kotlinx.bom)
  implementation(kotlinx.bundles.coroutines)

  // Accompanist
  implementation(libs.accompanist.pager)
  implementation(libs.accompanist.pager.indicators)
  implementation(libs.accompanist.webview)

  implementation(libs.apollo)
  implementation(libs.bundles.voyager)
}
