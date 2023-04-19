plugins {
    application
    id("java")
}


group = "org.example"
version = "1.0-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_18

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.2")
    testImplementation("org.mockito:mockito-junit-jupiter:5.2.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.2")
}

application {
    mainClass.set("com.interview.salestaxcalculator.SalesTaxCalculatorApp")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

tasks.getByName<Jar>("jar") {
    enabled = true
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "com.interview.salestaxcalculator.SalesTaxCalculatorApp"
    }
}

tasks.getByName<JavaExec>("run") {
    standardInput = System.`in`
}