import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

kotlin {
    androidTarget {
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_1_8)
                }
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
            implementation(libs.kotlinx.datetime)
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.content.negotiation)
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }

        androidMain.dependencies {
            implementation(libs.ktor.client.okhttp)
//            implementation(libs.ktor.serialization.gson)
        }

        iosMain.dependencies {
            implementation(libs.ktor.client.ios)
        }
    }
}

android {
    namespace = "com.example.kmm_first_project"
    compileSdk = 35
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
