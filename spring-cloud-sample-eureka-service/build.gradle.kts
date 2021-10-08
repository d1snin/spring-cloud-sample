version = "1.0.0"

val springStarterNetflixVersion = "3.0.4"

dependencies {
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-server:$springStarterNetflixVersion") {
        // see https://stackoverflow.com/questions/24080541/getting-nosuchmethoderror-javax-servlet-servletcontext-addservlet-in-spring-boo/26232535#26232535
        exclude("javax.servlet", "servlet-api")
    }
}