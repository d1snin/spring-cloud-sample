version = "0.0.1"

val springStarterVersion = "2.5.5"
val springCloudStarterVersion = "3.0.4"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-validation:$springStarterVersion")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb:$springStarterVersion")
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign:$springCloudStarterVersion")
    implementation("org.springframework.cloud:spring-cloud-starter-loadbalancer:$springCloudStarterVersion")
}