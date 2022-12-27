plugins {
    id("multiplatform-setup")
    id("android-setup")
}

android {
    namespace = ProjectConfig.namespace("common.games.data")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:core"))
            }
        }
    }
}