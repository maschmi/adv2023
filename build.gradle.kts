plugins {
    kotlin("jvm") version "1.9.21"
    application
}

group = "de.maschmi"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}


dependencies {
    val kotestVersion = "5.8.0"
    testImplementation(kotlin("test"))
    testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
}


tasks.withType<Test>().configureEach {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}