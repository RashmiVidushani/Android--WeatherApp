🌦️ Weather Forecast Android App (Midterm Project)

This Android application allows users to retrieve and display real-time weather information for any city. Built using **Kotlin**, **MVVM architecture**, and **Retrofit**, the app integrates with the **Visual Crossing Weather API** to fetch data such as current temperature, daily high/low, precipitation probability, and general forecast description.

DEMO 


https://github.com/user-attachments/assets/da185573-dc03-4e82-9884-5c89af2e988f



---

### 📱 Features

- 🔍 Search weather data by city name  
- 📡 Fetch real-time weather from Visual Crossing API  
- 📈 Display current, max, and min temperature  
- 🌧️ Show forecast summary and precipitation probability  
- 💡 Loading indicator for API response  
- 🔄 MVVM design pattern with LiveData & ViewModel  
- 🎨 Clean and user-friendly UI using `ViewBinding`

---

### 🧠 Architecture

This project follows the **MVVM (Model-View-ViewModel)** architecture:

- `MainActivity` – Handles user interaction and binds the view  
- `WeatherViewModel` – Manages API calls and exposes LiveData  
- `WeatherRepository` – Abstracts API interaction  
- `WeatherService` – Retrofit interface for weather endpoint  
- `WeatherData`, `Day`, `CurrentConditions` – Data models

---

### 🛠️ Tech Stack

- Kotlin  
- Android SDK  
- ViewModel & LiveData  
- ViewBinding  
- Retrofit with GSON converter  
- Coroutines  
- Visual Crossing Weather API  

---

### 🖼️ Screenshots

<img src="https://github.com/user-attachments/assets/bbb293d0-42b9-4c4c-9a55-d6de4cae7a66" width="250"/>
<img src="https://github.com/user-attachments/assets/8fd45efb-6b92-4f75-8ac3-4044a786578e" width="250"/>

*(Replace the above placeholders with actual image URLs from your GitHub repo)*

---

### 📁 File Structure

```
├── ui/
│   └── MainActivity.kt
├── vm/
│   └── WeatherViewModel.kt
├── api/
│   └── WeatherService.kt
├── model/
│   ├── WeatherData.kt
│   ├── Day.kt
│   └── CurrentConditions.kt
├── repository/
│   └── WeatherRepository.kt
└── res/
    ├── layout/activity_main.xml
    └── drawable/weather_img.png
```

---

### 📝 How to Run

1. Clone this repository  
2. Replace the API key in `WeatherService.kt` with your own from [Visual Crossing](https://www.visualcrossing.com/)  
3. Build and run the project on an Android emulator or device

