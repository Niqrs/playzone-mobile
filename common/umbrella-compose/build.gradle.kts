plugins {
    id("multiplatform-compose-setup")
    id("android-setup")
}

android {
    namespace = ProjectConfig.namespace("common.umbrella_compose")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":common:core"))
                implementation(project(":common:auth:data"))
                implementation(project(":common:games:data"))
                implementation(project(":common:tournaments:data"))
            }
        }
    }
}