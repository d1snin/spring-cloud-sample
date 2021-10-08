version = "0.0.1"

val springStarterVersion = "2.5.5"
val jacksonModuleKotlinVersion = "2.13.0"
val springStarterNetflixVersion = "3.0.4"

dependencies {
    implementation(project(":spring-cloud-sample-core"))
    implementation("org.springframework.boot:spring-boot-starter-web:$springStarterVersion")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonModuleKotlinVersion")
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign:$springStarterNetflixVersion")
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client:$springStarterNetflixVersion")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb:$springStarterVersion")
    testImplementation("org.springframework.boot:spring-boot-starter-test:$springStarterVersion")
}