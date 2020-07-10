object ApplicationId {
    const val id = "io.zeng.archapp"
}

object Modules {
    const val app = ":app"

    const val navigation = ":navigation"

    const val common = ":common"
    const val commonTest = ":common_test"

    const val local = ":data:local"
    const val remote = ":data:remote"
    const val model = ":data:model"
    const val repository = ":data:repository"

    const val featureHome = ":features:home"
    const val featureDetail = ":features:detail"
}

object Releases {
    const val versionCode = 1
    const val versionName = "1.0"
}

object Versions {
    const val kotlin = "1.3.72"
    const val gradle = "3.6.1"
    const val compileSdk = 28
    const val minSdk = 23
    const val targetSdk = 28
    const val appCompat = "1.1.0"
    const val coreKtx = "1.2.0"
    const val constraintLayout = "1.1.3"
    const val junit = "4.12"
    const val androidTestRunner = "1.1.2"
    const val espressoCore = "3.2.0"
    const val retrofit = "2.8.1"

    const val retrofitGson = "2.6.0"
    const val gson = "2.8.5"
    const val okHttp = "4.0.0"
    const val coroutines = "1.3.3"
    const val koin = "2.1.5"
    const val timber = "4.7.1"
    const val lifecycle = "2.2.0"
    const val nav = "2.2.1"
    const val room = "2.2.5"
    const val debugDb = "1.0.6"
    const val recyclerview = "1.0.0"
    const val safeArgs = "2.2.1"
    const val glide = "4.9.0"
    const val mockwebserver = "2.7.5"
    const val archCoreTest = "2.0.0"
    const val androidJunit = "1.1.0"
    const val mockk = "1.9.2"
    const val fragmentTest = "1.1.0"
    const val databinding = "3.3.2"

    const val rxjava = "2.2.16"
    const val rxandroid = "2.1.1"
    const val rxlifecycle = "3.1.0"
}

object Libraries {
    // KOIN
    const val koin = "org.koin:koin-androidx-scope:${Versions.koin}"
    const val koinViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"

    // ROOM
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomRunTime = "androidx.room:room-runtime:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    const val debugDb = "com.amitshekhar.android:debug-db:${Versions.debugDb}"

    // RETROFIT
//    const val retrofitCoroutineAdapter = "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.retrofitCoroutines}"
    const val gson = "com.google.code.gson:gson:${Versions.gson}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGsonConverter =
        "com.squareup.retrofit2:converter-gson:${Versions.retrofitGson}"
    const val httpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"

    // GLIDE
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
}

object Rx2Libraries {
    const val rxjava = "io.reactivex.rxjava2:rxjava:${Versions.rxjava}"
    const val rxandroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxandroid}"
}

object KotlinLibraries {
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val kotlinCoroutineCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val kotlinxCoroutineRx2 =
        "org.jetbrains.kotlinx:kotlinx-coroutines-rx2:${Versions.coroutines}"
}

object AndroidLibraries {
    // KOTLIN
    const val kotlinCoroutineAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    // ANDROID
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val lifecycleViewModel =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val lifecycleLivedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"

    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    const val navigation = "androidx.navigation:navigation-ui-ktx:${Versions.nav}"
    const val navigationFrag = "androidx.navigation:navigation-fragment-ktx:${Versions.nav}"
}


object Rxlifecycle {
    const val rxlifecycle = "com.trello.rxlifecycle3:rxlifecycle:${Versions.rxlifecycle}"

    // If you want to bind to Android-specific lifecycles
    const val rxlifecycleAndroid =
        "com.trello.rxlifecycle3:rxlifecycle-android:${Versions.rxlifecycle}"

    // If you want pre-written Activities and Fragments you can subclass as providers
    const val rxlifecycleComponents =
        "com.trello.rxlifecycle3:rxlifecycle-components:${Versions.rxlifecycle}"

    // If you want pre-written support preference Fragments you can subclass as providers
    const val rxlifecycleComponentsPreference =
        "com.trello.rxlifecycle3:rxlifecycle-components-preference:${Versions.rxlifecycle}"

    // If you want to use Android Lifecycle for providers
    const val rxlifecycleAndroidLifecycle =
        "com.trello.rxlifecycle3:rxlifecycle-android-lifecycle:${Versions.rxlifecycle}"

    // If you want to use Kotlin syntax
    const val rxlifecycleKotlin =
        "com.trello.rxlifecycle3:rxlifecycle-kotlin:${Versions.rxlifecycle}"

    // If you want to use Kotlin syntax with Android Lifecycle
    const val rxlifecycleAndroidLifecycleKotlin =
        "com.trello.rxlifecycle3:rxlifecycle-android-lifecycle-kotlin:${Versions.rxlifecycle}"
}

object TestLibraries {
    // ANDROID TEST
    const val androidTestRunner = "androidx.test:runner:${Versions.androidTestRunner}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    const val espressoContrib = "androidx.test.espresso:espresso-contrib:${Versions.espressoCore}"
    const val archCoreTest = "androidx.arch.core:core-testing:${Versions.archCoreTest}"
    const val junit = "androidx.test.ext:junit:${Versions.androidJunit}"
    const val fragmentNav = "androidx.fragment:fragment-testing:${Versions.fragmentTest}"

    // KOIN
    const val koin = "org.koin:koin-test:${Versions.koin}"

    // MOCK WEBSERVER
    const val mockWebServer = "com.squareup.okhttp:mockwebserver:${Versions.mockwebserver}"

    // MOCK
    const val mockkAndroid = "io.mockk:mockk-android:${Versions.mockk}"
    const val mockk = "io.mockk:mockk:${Versions.mockk}"

    // COROUTINE
    const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"

    // DATA BINDING
    const val databinding = "androidx.databinding:databinding-compiler:${Versions.databinding}"
}