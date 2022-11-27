import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.21"
    application
    kotlin("plugin.serialization") version "1.7.21"
}

group = "es.ruymi"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("io.ktor:ktor-network:2.1.3")
    // Para hacer el logging
    implementation("io.github.microutils:kotlin-logging-jvm:3.0.3")
    implementation("ch.qos.logback:logback-classic:1.4.4")

// Serializa Json
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
    // Kotlin DataTime:  * https://github.com/Kotlin/kotlinx-datetime
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
}


tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}