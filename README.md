**NIT3213 Final Assignment – s4679306Assignment2**
**Student Name: Kailash Parajuli**
**Student ID: s4679306**
**Campus: Footscray**
**Project Overview**
This project was developed as part of the NIT3213 Mobile Application Development unit.
The Android application demonstrates secure user authentication, API data retrieval, and structured information display across three core screens: Login, Dashboard, and Details.
It implements the Model–View–ViewModel (MVVM) architecture and uses dependency injection with Hilt. The application communicates with a remote API through Retrofit and Moshi, following clean code and modular design principles.

**Application Features**
**1. Login Screen**
- Consists of two input fields: Username and Password.
- Accepts credentials as: Username: Kailash, Password: 4679306
- Sends a POST request to: https://nit3213api.onrender.com/footscray/auth
- Performs validation for empty inputs and displays relevant error messages for invalid credentials.
- On successful authentication, retrieves a keypass and navigates to the Dashboard screen.

**2. Dashboard Screen**
- Uses a RecyclerView to display a list of entities fetched from the endpoint https://nit3213api.onrender.com/dashboard/{keypass}.
- Displays key entity information (property1 and property2) in each list item.
- Each item is clickable and opens a detailed view of that entity.
- Includes loading indicators and error handling for failed network requests.

**3. Details Screen**
- Displays full information about the selected entity: Property 1, Property 2, and Description.
- Includes a Material Toolbar with back navigation.
- Uses a scrollable and accessible layout designed with Material Design 3 guidelines.

**Architecture and Technologies Used**
Layer	Description
Architecture Pattern	MVVM (Model–View–ViewModel)
Programming Language	Kotlin
Dependency Injection	Dagger Hilt
Networking	Retrofit2 with Moshi for JSON parsing
UI Components	AndroidX and Material Design 3
Testing Frameworks	JUnit4, Coroutines Test, and MockK
Build System	Gradle (Kotlin DSL)
API Reference
Base URL: https://nit3213api.onrender.com/
Endpoints:
- POST /footscray/auth : Authenticates the user and returns a keypass
- GET /dashboard/{keypass} : Retrieves a list of entities using the keypass
  Example Response (Login):
  {
  "keypass": "investments"
  }

**Unit Testing**
Test File: app/src/test/java/com/example/s4679306assignment2/LoginViewModelTest.kt

**Test Coverage:**
- Validates error handling for blank username and password fields.
- Tests successful login with correct credentials.
- Tests failed login with incorrect credentials.
- Uses a FakeRepository to avoid external network dependency.

**Run Tests:**
./gradlew test or use Android Studio's Run → Run 'LoginViewModelTest' option.

**How to Run the Application**
1. Open the project in Android Studio Ladybug or newer.
2. Ensure that Gradle is synced and JDK 17+ is configured.
3. Create and start an emulator (API Level 34 or higher).
4. Click Run to build and deploy the app.
5. Log in using Username: Kailash, Password: 4679306.

**Developer Notes**
- Written entirely in Kotlin with ViewModel and LiveData.
- Uses Retrofit and Moshi for API communication.
- Hilt provides dependency injection for cleaner architecture.
- UI follows Material Design 3 guidelines for accessibility.
- All API endpoints tested and verified working.

