plugins {
    id("org.springframework.boot") version "2.4.2"
    id("java")
    maven
}

repositories {
    // Use JCenter for resolving dependencies.
    mavenLocal()
    mavenCentral()
}
apply(plugin = "io.spring.dependency-management")

dependencies {
    // Use JUnit test framework.
    testImplementation("junit:junit:4.13")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.google.guava:guava:29.0-jre")
}

