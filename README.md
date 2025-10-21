# s4679306Assignment2

Android app for NIT3213 Final Assignment – Login → Dashboard (RecyclerView) → Details.
Uses Retrofit + Moshi, Coroutines, Hilt DI, MVVM, and unit tests.

## Student
- Name: Kailash Parajuli
- Student ID: s4679306
- Campus: Footscray

## API
Base: https://nit3213api.onrender.com/

- POST /footscray/auth
  Body: {"username":"Kailash","password":"4679306"}
  → { "keypass": "topicName" }

- GET /dashboard/{keypass}
  → { "entities":[ {...} ], "entityTotal": 7 }

## Build & Run
1. Open in Android Studio (AGP 8.5+, Kotlin 2.0).
2. Sync Gradle.
3. Run app on Android 8.0+ device/emulator.
4. Login screen is prefilled; tap **Login**.

## Notes
- If project name must be numeric-only, rename to `4679306Assignment2`.
- If your cohort isn't Footscray, change the auth path in `ApiService`.
