plugins {
    id("java")
    id("io.freefair.lombok") version "6.6.2"
}

group = "com.chaottic"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")

    implementation("it.unimi.dsi:fastutil:8.5.11")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("com.google.guava:guava:31.1-jre")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}