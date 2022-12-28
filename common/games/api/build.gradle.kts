plugins {
    id("multiplatform-setup")
    id("android-setup") //TODO: ???
}

android {
    namespace = ProjectConfig.namespace("common.games.api")
}