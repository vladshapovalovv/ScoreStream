@file:Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.kotlin) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.dagger.hilt) apply false
    id("com.google.gms.google-services") version "4.3.15" apply false

}