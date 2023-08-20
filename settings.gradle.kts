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

rootProject.name = "ScoreStream"
include(":app")
include(":feature:onboarding")
include(":feature:livescore")
include(":feature:webview")
include(":component:designsystem")
include(":util:lifecycle")
include(":util:network")
