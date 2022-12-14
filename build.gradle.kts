buildscript {
    val compose_version by extra("1.1.1")
    dependencies {
        classpath(Build.hiltAndroidGradlePlugin)
        classpath(Build.androidBuildTools)
        classpath(Build.kotlinGradlePlugin)
    }
}// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "7.4.0-alpha02" apply false
    id("com.android.library") version "7.4.0-alpha02" apply false
    id("org.jetbrains.kotlin.android") version "1.6.10" apply false
    id("org.jetbrains.kotlin.jvm") version "1.6.10" apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}