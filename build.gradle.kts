import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.2.6.RELEASE"
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    kotlin("jvm") version "1.3.71"
    kotlin("plugin.spring") version "1.3.71"
    kotlin("plugin.jpa") version "1.3.71"
}

group = "com.demo.hexagonal"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("com.h2database:h2")
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

// START integration test configurations

sourceSets {
    create("test-integration") {
        compileClasspath += sourceSets.main.get().output
        runtimeClasspath += sourceSets.main.get().output
    }
}

val testIntegrationImplementation by configurations.getting {
    extendsFrom(configurations.testImplementation.get())
}

configurations["testIntegrationRuntimeOnly"].extendsFrom(configurations.runtimeOnly.get())

dependencies {
    testIntegrationImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}

val testIntegration = task<Test>("testIntegration") {
    description = "Runs integration tests."
    group = "verification"

    testClassesDirs = sourceSets["test-integration"].output.classesDirs
    classpath = sourceSets["test-integration"].runtimeClasspath
    shouldRunAfter("test")
}

tasks.check { dependsOn(testIntegration) }

// END integration test configurations

// START architecture test configurations

sourceSets {
    create("test-architecture") {
        compileClasspath += sourceSets.main.get().output
        runtimeClasspath += sourceSets.main.get().output
    }
}

val testArchitectureImplementation by configurations.getting {
    extendsFrom(configurations.testImplementation.get())
}

configurations["testArchitectureRuntimeOnly"].extendsFrom(configurations.runtimeOnly.get())

dependencies {
    testArchitectureImplementation("com.tngtech.archunit:archunit-junit5:0.13.1")
}

val testArchitecture = task<Test>("testArchitecture") {
    description = "Runs architecture tests."
    group = "verification"

    testClassesDirs = sourceSets["test-architecture"].output.classesDirs
    classpath = sourceSets["test-architecture"].runtimeClasspath
    shouldRunAfter("test")
}

tasks.check { dependsOn(testArchitecture) }

// END architecture test configurations
