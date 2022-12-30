import Dependencies

//import org.gradle.api.JavaVersion

plugins {
    id("com.android.library")
}

android {
    compileSdk = 33

    defaultConfig {
        minSdk = 26
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2"
    }

    sourceSets {
        named("main") {
            manifest.srcFile("src/androidMain/AndroidManifest.xml") //TODO: ???
            res.srcDirs("src/androidMain/res", "src/commonMain/resources")
        }
    }

    dependencies {
        implementation(Dependencies.Android.Compose.runtime)
    }
}
    