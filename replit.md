# Android Medication Tracker - Project Information

## Project Overview
This is a native Android mobile application written in Java that manages medication tracking with CRUD (Create, Read, Update, Delete) operations.

**Project Name**: crudroom  
**Application Type**: Android Mobile App  
**Language**: Java  
**Build System**: Gradle  
**Database**: Room (SQLite local database)

## Application Features
- Add, edit, and delete medications
- Track medication name, dosage, and next dose date
- Search medications by name
- Material Design UI with RecyclerView
- Local database persistence using Android Room

## Technical Stack
- **Language**: Java 8
- **Android SDK**: API 24-34 (Android 7.0 to Android 14)
- **Architecture**: MVVM (Model-View-ViewModel)
- **Database**: Room Persistence Library
- **UI Components**: 
  - RecyclerView for list display
  - Material Design Components
  - FloatingActionButton for adding items
  - AlertDialog for edit/delete operations

## Key Components
- `MainActivity.java` - Main UI controller
- `Medication.java` - Room entity (data model with fields: id, medicationName, dosage, type, recurrence, startDate, endDate, createdDate)
- `MedicationDao.java` - Database access object
- `MedicationDatabase.java` - Room database configuration (version 3)
- `MedicationViewModel.java` - ViewModel for UI data
- `MedicationRepository.java` - Data repository pattern
- `MedicationAdapter.java` - RecyclerView adapter

## Database Schema
### Medication Table
- `id` (Primary Key, auto-generated) - Read-only
- `medicationName` (String) - Editable, required
- `dosage` (String) - Editable, optional (e.g., "500mg", "10ml")
- `type` (String) - Editable, optional (e.g., "Comprimido", "Xarope")
- `recurrence` (String) - Editable, optional (e.g., "Diária", "Semanal")
- `startDate` (String) - Editable, required
- `endDate` (String) - Editable, optional
- `createdDate` (String) - Read-only, auto-generated timestamp

## Important Limitations on Replit
⚠️ **This Android application cannot run on Replit** because:
1. Replit does not support Android SDK or Android emulators
2. Android apps require either a physical Android device or Android Studio's emulator
3. The Replit environment is optimized for web applications, backend services, and CLI tools

## How to Run This Project

### Option 1: Android Studio (Recommended)
1. Download and install [Android Studio](https://developer.android.com/studio)
2. Clone this repository
3. Open the project in Android Studio
4. Wait for Gradle sync to complete
5. Run the app on an emulator or connected Android device

### Option 2: Command Line with Android SDK
1. Install Android SDK and set up ANDROID_HOME environment variable
2. Install Java Development Kit (JDK) 8 or higher
3. Run `./gradlew assembleDebug` to build the APK
4. Install the APK on a device or emulator

## Build Commands
- Build debug APK: `./gradlew assembleDebug`
- Run tests: `./gradlew test`
- Clean build: `./gradlew clean`

## Recent Changes
- **2025-11-20**: Modified database structure:
  - Removed field: `nextDoseDate`
  - Added fields: `dosage`, `type`, `recurrence`, `startDate`, `endDate`
  - Updated database version from 1 to 3
  - Updated all frontend components to display and edit new fields
  - Modified RecyclerView to show: dosage, type, recurrence, start date, and end date
  - Updated dialog form with new input fields
- **2025-11-20**: Project imported to Replit (cannot be executed in this environment)

## Notes
- This project is in Portuguese (Brazilian) - UI strings and messages are in Portuguese
- The app uses Material Design 3 components
- Database schema is managed by Room migration system
