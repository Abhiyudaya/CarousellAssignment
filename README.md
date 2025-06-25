# Android Coding Challenge 1 – Carousell News 📱

Thank you for reviewing my submission for the Carousell Android Coding Challenge! This project demonstrates a clean, testable, and scalable Android architecture using modern tools and practices.

---

## 🧠 Overview

The goal of this challenge is to build a **Carousell News** application that:
- Displays a list of articles from a provided JSON API
- Shows title, description, timestamp, and image
- Supports sorting by recent or popularity via the action bar menu

---

## 🔗 API Used

[Carousell News JSON](https://storage.googleapis.com/carousell-interview-assets/android/carousell_news.json)

---

## 🎯 Features

- One-screen news list app with clean MVVM architecture
- Sort by **Recent** (latest first) or **Popular** (rank + time)
- User-friendly, relative time formatting (e.g., “5 days ago”, “1 year ago”)
- Text truncation for long titles/descriptions (2-line max)
- Center-cropped image thumbnails for each article
- Option menu to toggle between sorting strategies

---

## 🛠️ Tech Stack

| Tool/Library        | Purpose                          |
|---------------------|----------------------------------|
| Kotlin              | Programming language             |
| MVVM Architecture   | Project structure & state management |
| Hilt                | Dependency Injection             |
| Retrofit + OkHttp   | Networking                       |
| Coroutines          | Async handling                   |
| Glide               | Image loading                    |
| ConstraintLayout    | UI Layout                        |
| LiveData + ViewModel| Lifecycle-aware UI               |
| ViewBinding         | Safe view referencing            |

---

## 📷 Screenshots

_Design followed as per Carousell guidelines (not included here due to proprietary constraints)._

---

## ✅ How to Run

1. Open project in **Android Studio Giraffe** or newer
2. Let Gradle sync (Internet required)
3. Run the app on an emulator/device with API level 24+

---

## 🧪 Testing

Includes basic tests for ViewModel behavior using:
- `JUnit`
- `MockK`
- `Coroutines Test`

Run all tests with:
```bash
./gradlew test
```

---

## 📦 Project Structure

```
CarousellAssignment/
├── app/                    # App module - UI & Presentation
│   └── NewsActivity.kt
├── myapplication/          # Shared module - data, network
│   ├── repository/
│   ├── network/
│   └── model/
├── build.gradle.kts        # Module build configs
├── libs.versions.toml      # Centralized dependencies
└── README.md               # You're here!
```

---

## 🧹 Improvements If More Time

- UI tests with Espresso or Jetpack Compose Testing
- Caching mechanism with Room or DiskLRU
- Pagination for large result sets
- Dark mode & accessibility

---

## 📬 Submission Instructions

- Archive this project (`.zip` or `.tar.gz`)
- Email to Carousell team with subject: **YourName (Android Coding Challenge)**

---

## 👨‍💻 Author

Abhiyudaya Vatsa  
Date: June 2025

---

_This project is submitted solely for educational and evaluation purposes._
