plugins {
    id("java")
}

group = "iuh.fit.edu.vn"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
// Jackson core
    implementation("com.fasterxml.jackson.core:jackson-core:2.15.2")

    // Jackson databind (bao gồm ObjectMapper)
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.2")

    // Jackson annotations (tùy chọn, nhưng thường cần)
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.15.2")

    // Nếu bạn cần hỗ trợ định dạng ngày tháng mở rộng
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.15.2")
}

tasks.test {
    useJUnitPlatform()
}