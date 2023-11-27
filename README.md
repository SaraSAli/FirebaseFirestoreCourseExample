# Firebase Firestore Course Application Example
This Android application is designed to help students learn about Firebase Firestore by providing a practical example of its implementation. The app consists of two screens: one to display all the courses stored in Firestore, and the other to upload course data to Firestore.

## Features
* Display all courses: The main screen of the app lists all the courses stored in the Firebase Firestore database. Each course entry includes the course name, code, and description.

* Upload course data: By clicking on the floating action button at the bottom of the screen, users can navigate to the upload screen. This screen allows them to input course details, such as the name, code, and description, and upload the data to Firestore.

## Getting Started

To get started with this project, follow the steps below:

1. Clone the repository to your local machine or download the source code files.
2. Open the project in Android Studio.
3. Ensure that you have set up Firebase Firestore in your Firebase project. If not, create a new Firebase project and enable Firestore as the database.
4. Connect the app to your Firebase project by adding the necessary Firebase configuration files (google-services.json) to the project.
5. Build and run the app on an Android device or emulator.

## Understanding Firebase Firestore
Firebase Firestore is a flexible, scalable NoSQL cloud database provided by Google Firebase. It allows you to store and synchronize data between clients and the cloud effortlessly. Firestore organizes data into collections and documents, providing powerful querying capabilities and real-time updates.

In this app, Firestore is utilized to store and retrieve course data. Each course is represented as a document within a "courses" collection. The document contains fields for the course name, code, and description.

To access Firestore, the app integrates the Firebase Android SDK and utilizes Firestore's APIs for reading and writing data. The app demonstrates how to retrieve and display courses from Firestore, as well as how to upload new course data.

## Screenshots
1. Main Activity
   * ![image](https://github.com/SaraSAli/FirebaseFirestoreCourseExample/assets/17590461/2ad90ee5-d6c1-402e-8ad8-0f2b4e829cf9)
2. Upload Course Data Activity
   * ![image](https://github.com/SaraSAli/FirebaseFirestoreCourseExample/assets/17590461/09469e8e-f774-401b-b606-3027ec647dd7)

  
Feel free to explore the code and experiment with Firestore in this app. Happy learning and building with Firebase Firestore!
