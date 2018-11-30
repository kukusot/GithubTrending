# Project specifications
1. A list of trending Github repositories of android
2. A simple “Detail View” of the detail information of the repository, been accessed when the user taps on one of the repositories of the list.

## Installation
Clone or download this repository, and open the project in Android Studio.
The project should be able to compile and run.
If you have any questions/problems please feel free to contact me.

## Project Architecture
The application architecture is MVVM using Architecture Components.
Paging is done with the [Paging Library](https://developer.android.com/topic/libraries/architecture/paging/) from the Architecture Components.
It allows to unit test every layer and keep view logic and business logic independent.
For async working the app relies solely on Kotlin coroutines.

## Tools used
* [Dagger 2](https://github.com/google/dagger) for dependency injection
* [Retrofit](https://github.com/square/retrofit) and [OkHttp](https://github.com/square/okhttp) for network calls
* [Gson](https://github.com/google/gson) for convenient JSON parsing

## Reflections
* For the time being tests are not implemented. But with the current app architecture, it is very easy to test the 3 layers of the App (UI, Viewmodels and Data).