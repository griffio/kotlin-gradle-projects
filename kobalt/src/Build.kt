import com.beust.kobalt.*
import com.beust.kobalt.plugin.packaging.assemble
import com.beust.kobalt.plugin.kotlin.*

val repos = repos()

val p = project {

    name = "kotlin-gradle-projects"
    group = "com.example"
    artifactId = name
    version = "0.1"

    sourceDirectories {
        path("src/main/java", "src/main/kotlin")
    }

    sourceDirectoriesTest {
        path("src/test/java", "src/test/kotlin")
    }

    dependencies {
        compile("com.google.guava:guava:18.0")
    }

    dependenciesTest {
//        compile("org.testng:testng:6.9.5")

    }

    assemble {
        jar {
        }
    }
}
