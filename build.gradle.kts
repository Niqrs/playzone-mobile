buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:8.0.0-alpha10")
    }
    repositories {
        mavenCentral()
    }
}
plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.application").apply(false)
    id("com.android.library").apply(false)
    kotlin("android").apply(false)
    kotlin("multiplatform").apply(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
