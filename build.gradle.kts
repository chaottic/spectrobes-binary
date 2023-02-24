plugins {
    `java-library`
    id("io.freefair.lombok") version "6.6.2"
}

group = "com.chaottic"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.blamejared.com")
}

dependencies {
    implementation("org.jetbrains:annotations:23.0.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")

    api("it.unimi.dsi:fastutil:8.5.11")
    api("com.google.code.gson:gson:2.10.1")
    api("com.google.guava:guava:31.1-jre")

    api("net.darkhax.namespaced:namespaced:1.0.0")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}