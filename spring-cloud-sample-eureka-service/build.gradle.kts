version = "1.0.0"

extra["springCloudVersion"] = "Hoxton.SR9"

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

dependencies {
    implementation("org.springframework.cloud:spring-cloud-starter-config")
    implementation("org.springframework.cloud:spring-cloud-starter-netflix-eureka-server") {
        // see https://stackoverflow.com/questions/24080541/getting-nosuchmethoderror-javax-servlet-servletcontext-addservlet-in-spring-boo/26232535#26232535
        exclude("javax.servlet", "servlet-api")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
    }
}