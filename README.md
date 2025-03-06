
# NOGs - Android App

This is the Android application for the NOGs project, developed using Java, Retrofit, and Gradle. The app integrates with the backend API to manage donations, categories, user profiles, and other features.

## Technologies Used

- **Java**
- **Android SDK**
- **Retrofit** (for API integration)
- **Gradle** (for dependency management and build automation)

## Features

### 1. **User Management**
The app allows users to sign up, log in, and manage their profiles. It integrates with the backend API to create and update user information.

### 2. **Donations**
Users can view available donation categories, make donations, and track their contributions through the app. It communicates with the backend API to retrieve and post donation data.

### 3. **Categories of Donations**
The app displays a list of donation categories fetched from the backend API. Users can filter and select categories for their donations.

## Setup and Installation

### 1. **Clone the Repository**
First, clone the repository to your local machine:
```bash
git clone https://github.com/deividsantosr/ong-project-android.git
```

### 2. **Open the Project**
Open the project in Android Studio.

### 3. **Configure API Base URL**
In the `RetrofitConfig` class or wherever the base URL is defined, make sure the API base URL is correctly set. Example:
```java
new Retrofit.Builder().baseUrl("127.0.0.1")
```

### 4. **Run the Project**
Once everything is set up, you can run the app on an emulator or a physical device using Android Studio.

### 5. **API Integration**
The app uses Retrofit to integrate with the backend API. Make sure that the API endpoints are correctly configured in your Retrofit client class.

## App Screens

- **Home Screen:** Displays donation categories and general app navigation.
- **Donation Screen:** Users can choose a category and make a donation.
- **User Profile Screen:** Allows users to view and update their profile.

## Contributing

Feel free to contribute by opening issues, submitting pull requests, or suggesting features.

## License

This project is licensed under the [MIT License](LICENSE).
