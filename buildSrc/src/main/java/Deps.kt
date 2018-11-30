object Versions {
    val versionCode = 1
    val versionName = "1.0"
    val kotlin = "1.3.10"
    val androidGradlePlugin = "3.2.1"
    val sdkVersion = 28
    val minSdkVersion = 21
    val appCompat = "1.0.2"
    val constraintLayout = "2.0.0-alpha2"
    val jUnit = "4.12"
    val testRunner = "1.1.1-alpha01"
    val espresso = "3.1.1-alpha01"
    val dagger = "2.16"
    val retrofit = "2.4.0"
    val retrofitCoroutines = "0.9.2"
    val gsonRetrofitConverter = "2.4.0"
    val okHttp = "3.11.0"
    val okIo = "1.15.0"
    val gson = "2.8.5"
    val coroutines = "1.0.1"
    val materialVersion = "1.0.0"
    val lifecycleVersion = "2.0.0"
    val paging = "2.1.0-beta01"

}

object Deps {
    val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.androidGradlePlugin}"
    val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    val jUnit = "junit:junit:${Versions.jUnit}"
    val androidTestRunner = "androidx.test:runner:${Versions.testRunner}"
    val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    val kotlinDagger = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    val kotlinDaggerProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
    val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    val daggerAndroid = "com.google.dagger:dagger-android:${Versions.dagger}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofitCoroutines =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.retrofitCoroutines}"
    val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    val okHttpLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    val okIo = "com.squareup.okio:okio:${Versions.okIo}"
    val gson = "com.google.code.gson:gson:${Versions.gson}"
    val gsonRetrofitConverter = "com.squareup.retrofit2:converter-gson:${Versions.gsonRetrofitConverter}"
    val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    val meterialComponents = "com.google.android.material:material:${Versions.materialVersion}"
    val lifeCycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleVersion}"
    val paging = "androidx.paging:paging-runtime:${Versions.paging}"

}