plugins {
    id("multiplatform-compose-setup")
    id("android-setup")
}

android {
    namespace = ProjectConfig.namespace("common.auth.compose")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:auth:presentation"))
                implementation(project(":common:core-compose"))
                implementation(project(":common:core-utils"))

                implementation(Dependencies.Other.ViewModel.core)
                implementation(Dependencies.Other.ViewModel.compose)
                implementation(Dependencies.Other.ViewModel.odyssey)

                implementation(Dependencies.Other.Navigation.core)
                implementation(Dependencies.Other.Navigation.compose)
            }
        }

        androidMain {
            dependencies {
                implementation(Dependencies.Android.Compose.ui)
                implementation(Dependencies.Android.Compose.material)
                implementation(Dependencies.Android.Compose.icons)
                implementation(Dependencies.Android.Compose.tooling)
            }
        }
    }
}