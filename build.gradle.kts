plugins {
	java
	id("org.springframework.boot") version "3.5.5"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.genomatogenoma"
version = "0.0.1-SNAPSHOT"
description = "Demo project for Spring Boot"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("org.springframework.session:spring-session-jdbc")
	implementation("org.mapstruct:mapstruct:1.4.2.Final")
	implementation("junit:junit:4.13.1")
	implementation("org.junit.jupiter:junit-jupiter:5.8.1")
	implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.17.2")

	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	annotationProcessor("org.mapstruct:mapstruct-processor:1.4.2.Final")

	runtimeOnly("org.postgresql:postgresql")

	// ✅ Test dependencies
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.junit.jupiter:junit-jupiter:5.11.3")
	testImplementation("org.mockito:mockito-core:5.14.2")
	testImplementation("org.mockito:mockito-junit-jupiter:5.14.2")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
