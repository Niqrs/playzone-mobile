plugins {
    id("multiplatform-setup")
    id("android-setup")
}

android {
    namespace = ProjectConfig.namespace("common.auth.presentation")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(project(":common:auth:api"))
                api(project(":common:games:api")) //TODO: API???
                api(project(":common:core"))

                implementation(Dependencies.Other.ViewModel.core)
            }
        }
    }
}