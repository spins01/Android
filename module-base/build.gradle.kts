plugins {
    id("modulePlugin")
}

android {
    namespace = "com.app.module.base"
}

dependencies {

    api(project(":lib-res"))
    api(libs.xiaojinzi.android.support.init)
    api(libs.xiaojinzi.android.support.activitystack)
    api(libs.xiaojinzi.android.support.ktx.retrofit)
    api(libs.xiaojinzi.android.module.storage)
    api(libs.xiaojinzi.android.module.ffmpeg)
    api(libs.kcomponent.core)
    api(libs.xiaojinzi.android.reactive.core)
    api(libs.xiaojinzi.android.reactive.template)
    api(libs.xiaojinzi.android.reactive.template.compose)

    api(libs.compose.runtime)
    api(libs.compose.runtime.android)
    api(libs.compose.ui.android)
    api(libs.compose.foundation.android)
    api(libs.compose.foundation.layout.android)
    api(libs.compose.material.android)
    api(libs.compose.material3)

    api(libs.glance.appwidget)
    api(libs.glance.material3)

    api(libs.bundles.baseLibrary)

//    api(libs.coil_compose)
//    api(libs.coil_kotlin)

//    api("io.coil-kt:coil:2.6.0")
//    api("io.coil-kt:coil-compose:2.6.0")

}