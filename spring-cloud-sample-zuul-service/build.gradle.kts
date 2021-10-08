version = "1.1.0"

val eurekaClientVersion = "3.0.4"
val zuulVersion = "2.2.9.RELEASE"

dependencies {
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-client:$eurekaClientVersion")
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-zuul:$zuulVersion")
}