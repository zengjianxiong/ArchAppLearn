object ApplicationId {
    val id = "io.zeng.archapp"
}

object Modules {
    val app = ":app"

    val navigation = ":navigation"

    val common = ":common"
    val commonTest = ":common_test"

    val local = ":data:local"
    val remote = ":data:remote"
    val model = ":data:model"
    val repository = ":data:repository"

    val featureHome = ":features:home"
    val featureDetail = ":features:detail"
}

object Releases {
    val versionCode = 1
    val versionName = "1.0"
}

object Versions {
    val kotlin = "1.3.61"
    val gradle = "3.5.3"
    val compileSdk = 28
    val minSdk = 23
    val targetSdk = 28
    val appCompat = "1.1.0"
    val coreKtx = "1.1.0"
    val constraintLayout = "1.1.3"
    val junit = "4.12"
    val androidTestRunner = "1.1.2"
    val espressoCore = "3.2.0"
    val retrofit = "2.6.0"

    val retrofitGson = "2.6.0"
    val gson = "2.8.5"
    val okHttp = "4.0.0"
    val coroutines = "1.3.3"
    val koin = "2.0.1"
    val timber = "4.7.1"
    val lifecycle = "2.1.0"
    val nav = "2.1.0"
    val room = "2.1.0"
    val debugDb = "1.0.6"
    val recyclerview = "1.0.0"
    val safeArgs = "2.1.0"
    val glide = "4.9.0"
    val mockwebserver = "2.7.5"
    val archCoreTest = "2.0.0"
    val androidJunit = "1.1.0"
    val mockk = "1.9.2"
    val fragmentTest = "1.1.0"
    val databinding = "3.3.2"

    val rxjava = "2.2.16"
    val rxandroid = "2.1.1"
    val rxlifecycle="3.1.0"
}

object Libraries {
    // KOIN
    val koin = "org.koin:koin-androidx-scope:${Versions.koin}"
    val koinViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"
    // ROOM
    val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    val roomRunTime = "androidx.room:room-runtime:${Versions.room}"
    val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    val debugDb = "com.amitshekhar.android:debug-db:${Versions.debugDb}"
    // RETROFIT
//    val retrofitCoroutineAdapter = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.retrofitCoroutines}"
    val gson = "com.google.code.gson:gson:${Versions.gson}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofitGson}"
    val httpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    // GLIDE
    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
}

object Rx2Libraries {
    val rxjava = "io.reactivex.rxjava2:rxjava:${Versions.rxjava}"
    val rxandroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxandroid}"
}

object KotlinLibraries {
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val kotlinCoroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    val kotlinxCoroutineRx2 = "org.jetbrains.kotlinx:kotlinx-coroutines-rx2:${Versions.coroutines}"
}

object AndroidLibraries {
    // KOTLIN
    val kotlinCoroutineAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    // ANDROID
    val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    val navigation = "androidx.navigation:navigation-ui-ktx:${Versions.nav}"
    val navigationFrag = "androidx.navigation:navigation-fragment-ktx:${Versions.nav}"
}


object Rxlifecycle {
    val rxlifecycle = "com.trello.rxlifecycle3:rxlifecycle:${Versions.rxlifecycle}"
    // If you want to bind to Android-specific lifecycles
    val rxlifecycleAndroid = "com.trello.rxlifecycle3:rxlifecycle-android:${Versions.rxlifecycle}"
    // If you want pre-written Activities and Fragments you can subclass as providers
    val rxlifecycleComponents = "com.trello.rxlifecycle3:rxlifecycle-components:${Versions.rxlifecycle}"
    // If you want pre-written support preference Fragments you can subclass as providers
    val rxlifecycleComponentsPreference =
        "com.trello.rxlifecycle3:rxlifecycle-components-preference:${Versions.rxlifecycle}"
    // If you want to use Android Lifecycle for providers
    val rxlifecycleAndroidLifecycle = "com.trello.rxlifecycle3:rxlifecycle-android-lifecycle:${Versions.rxlifecycle}"
    // If you want to use Kotlin syntax
    val rxlifecycleKotlin = "com.trello.rxlifecycle3:rxlifecycle-kotlin:${Versions.rxlifecycle}"
    // If you want to use Kotlin syntax with Android Lifecycle
    val rxlifecycleAndroidLifecycleKotlin =
        "com.trello.rxlifecycle3:rxlifecycle-android-lifecycle-kotlin:${Versions.rxlifecycle}"
}

object TestLibraries {
    // ANDROID TEST
    val androidTestRunner = "androidx.test:runner:${Versions.androidTestRunner}"
    val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    val espressoContrib = "androidx.test.espresso:espresso-contrib:${Versions.espressoCore}"
    val archCoreTest = "androidx.arch.core:core-testing:${Versions.archCoreTest}"
    val junit = "androidx.test.ext:junit:${Versions.androidJunit}"
    val fragmentNav = "androidx.fragment:fragment-testing:${Versions.fragmentTest}"
    // KOIN
    val koin = "org.koin:koin-test:${Versions.koin}"
    // MOCK WEBSERVER
    val mockWebServer = "com.squareup.okhttp:mockwebserver:${Versions.mockwebserver}"
    // MOCK
    val mockkAndroid = "io.mockk:mockk-android:${Versions.mockk}"
    val mockk = "io.mockk:mockk:${Versions.mockk}"
    // COROUTINE
    val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    // DATA BINDING
    val databinding = "androidx.databinding:databinding-compiler:${Versions.databinding}"
}