import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.2.51"
    id("org.jetbrains.kotlin.plugin.spring") version "1.2.51"
    id("org.springframework.boot") version "2.0.3.RELEASE"
    id("io.spring.dependency-management") version "1.0.6.RELEASE"
}

group = "io.github.alexbogovich"
version = "0.0.1-SNAPSHOT"

tasks.run {
    withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "1.8"
        }
    }

    withType<Wrapper> {
        gradleVersion = "4.9"
        distributionType = Wrapper.DistributionType.ALL
    }
}

repositories {
    mavenCentral()
}

dependencies {
    //    compile("org.springframework.boot:spring-boot-starter-data-jpa")
    // 	  compile("org.springframework.boot:spring-boot-starter-data-rest")
    compile("org.springframework.boot:spring-boot-starter-web")
    compile("com.fasterxml.jackson.module:jackson-module-kotlin")
    //	  compile("org.springframework.data:spring-data-rest-hal-browser")
    compile("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    compile("org.jetbrains.kotlin:kotlin-reflect")
    runtime("org.springframework.boot:spring-boot-devtools")
    //    runtime("com.h2database:h2")
    testCompile("org.springframework.boot:spring-boot-starter-test")
}