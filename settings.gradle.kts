pluginManagement {
  repositories {
    google {
      content {
        includeGroupByRegex("com\\.android.*")
        includeGroupByRegex("com\\.google.*")
        includeGroupByRegex("androidx.*")
      }
    }
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

rootProject.name = "TravelBudgetManager"
include(":app")
include(":data")
include(":data:travel")
include(":data:traveller")
include(":data:expense")
include(":data:traveller_expense")
include(":data:module")
include(":core")
include(":core:ui")
