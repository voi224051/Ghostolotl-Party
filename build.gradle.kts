plugins {
    kotlin("jvm") version "2.0.20"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("io.papermc.paperweight.userdev") version "1.7.2"
    id("xyz.jpenilla.run-paper") version "2.3.1"
}

group = "dev.voik"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/") {
        name = "papermc-repo"
    }
    maven("https://oss.sonatype.org/content/groups/public/") {
        name = "sonatype"
    }
    maven("https://repo.dmulloy2.net/repository/public/")
}

dependencies {
    paperweightDevelopmentBundle("io.papermc.paper:dev-bundle:1.21.1-R0.1-SNAPSHOT")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("io.github.cdimascio:dotenv-kotlin:6.4.2")
    compileOnly("io.papermc.paper:paper-api:1.21.1-R0.1-SNAPSHOT")
//    compileOnly("com.comphenix.protocol:ProtocolLib:5.3.0-SNAPSHOT")
}

val targetJavaVersion = 21
kotlin {
    jvmToolchain(targetJavaVersion)
}

tasks.build {
    dependsOn("shadowJar")
}

tasks.processResources {
    val props = mapOf("version" to version)
    inputs.properties(props)
    filteringCharset = "UTF-8"
    filesMatching("paper-plugin.yml") {
        expand(props)
    }
}

tasks.runServer {
    minecraftVersion("1.21.1")
}

