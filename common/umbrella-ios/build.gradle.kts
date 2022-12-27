plugins {
    id("multiplatform-setup")
    id("android-setup") //TODO: WHY?
}

android {
    namespace = ProjectConfig.namespace("common.umbrella_ios")
}