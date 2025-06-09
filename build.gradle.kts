plugins {
    id("java")
    id("org.springframework.boot") version "3.1.5"
    id("io.spring.dependency-management") version "1.1.3"
    id("org.owasp.dependencycheck") version "12.1.1"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("org.springframework.boot:spring-boot-starter-oauth2-resource-server")
    implementation("org.springframework.boot:spring-boot-starter-amqp")
    implementation("org.springframework.boot:spring-boot-starter-validation")

    implementation("com.mysql:mysql-connector-j:8.0.33")
    implementation("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")

    // Optional explicit JWT parser (not strictly needed)
    implementation("com.nimbusds:nimbus-jose-jwt:9.37")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    constraints {
        // org.owasp.dependencycheck needs at least this version of jackson. Other plugins pull in older versions..
        add("implementation", "com.fasterxml.jackson:jackson-bom:2.18.3")
        // org.owasp.dependencycheck needs these versions. Other plugins pull in older versions..
        add("implementation", "org.apache.commons:commons-lang3:3.17.0")
        add("implementation", "org.apache.commons:commons-text:1.13.0")
    }
}

tasks.test {
    useJUnitPlatform()
}
