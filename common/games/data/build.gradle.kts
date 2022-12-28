plugins {
    id("multiplatform-setup")
    id("android-setup")
    kotlin("plugin.serialization")
}

android {
    namespace = ProjectConfig.namespace("common.games.data")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(project(":common:games:api"))
                implementation(project(":common:core"))
            }
        }
    }
}