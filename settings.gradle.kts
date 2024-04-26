pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "My Weather"
include(":app")
include(":data")
include("features:weather-main")

include(":domain")
include(":entity")
include("core:datastore")
include(":features:tables")
