plugins {
  id("com.google.devtools.ksp")
  alias(libs.plugins.android.library)
  alias(libs.plugins.jetbrains.kotlin.android)
}

android {
  namespace = "com.cbpark.module"
  compileSdk = 34

  defaultConfig {
    minSdk = 26

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    consumerProguardFiles("consumer-rules.pro")
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
  kotlinOptions {
    jvmTarget = "17"
  }
}

dependencies {
  implementation(project(":data:travel"))
  implementation(project(":data:traveller"))
  implementation(project(":data:expense"))
  implementation(project(":data:traveller_expense"))

  implementation(libs.androidx.core.ktx)
  implementation(libs.androidx.appcompat)
  implementation(libs.material)
  testImplementation(libs.junit)
  androidTestImplementation(libs.androidx.junit)
  androidTestImplementation(libs.androidx.espresso.core)

  implementation(libs.androidx.room.runtime)
  implementation(libs.androidx.room.ktx)
  implementation(libs.androidx.room.paging)
  ksp(libs.androidx.room.compiler)
  annotationProcessor(libs.androidx.room.compiler)
  testImplementation(libs.androidx.room.testing)

  implementation(libs.symbol.processing.api)

  // Hilt Dagger
  implementation(libs.bundles.hilt.dagger)
  ksp(libs.bundles.hilt.dagger.compiler)

  // Serialization
  implementation(kotlin("stdlib"))
  implementation(libs.kotlinx.serialization.json)
}