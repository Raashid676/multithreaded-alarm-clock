# ⏰ Multithreaded Alarm Clock (Java)

A simple console-based alarm clock built in Java that runs the clock logic on a **separate thread**, so the countdown/timer doesn't block the main program. Set an alarm time, and when it goes off, it plays a looping sound until you press **ENTER** to stop it.

## ✨ Features

- Set an alarm using a simple `hh:mm:ss AM/PM` time format
- Runs on a dedicated background thread using Java's `Runnable` and `Thread`
- Live-updating clock display in the console (`HH:MM:SS`)
- Automatically schedules for the next day if the entered time has already passed today
- Plays a looping `.wav` alarm sound when the alarm triggers
- Stop the alarm anytime by pressing **ENTER**
- Basic input validation with retry on invalid time format

## 🛠️ Tech Stack

- **Language:** Java
- **Core Concepts:** Multithreading (`Thread`, `Runnable`), `java.time` API, `javax.sound.sampled` (Java Sound API)

## 📁 Project Structure

```
multithreaded-alarm-clock/
├── Main.java          # Entry point — handles user input and starts the alarm thread
├── AlarmClock.java     # Runnable class — handles the countdown and alarm sound logic
└── alarm-sound.wav      # Alarm ringtone (update path in Main.java)
```

## 🚀 Getting Started

### Prerequisites

- Java JDK 8 or higher installed
- A `.wav` audio file for the alarm sound

### Setup

1. Clone the repository
```bash
   git clone https://github.com/your-username/multithreaded-alarm-clock.git
   cd multithreaded-alarm-clock
```

2. Update the `filePath` variable in `Main.java` to point to your `.wav` file:
```java
   String filePath = "path/to/your/alarm-sound.wav";
```

3. Compile the project
```bash
   javac Main.java AlarmClock.java
```

4. Run the program
```bash
   java Main
```

### Usage

1. When prompted, enter the alarm time in `hh:mm:ss AM/PM` format (e.g. `02:12:00 PM`)
2. The console will display a live-updating clock
3. When the alarm time is reached, the alarm sound will start playing on a loop
4. Press **ENTER** to stop the alarm

## 🧵 How It Works

- The `AlarmClock` class implements `Runnable` and runs the time-checking loop on a separate `Thread`, keeping the UI/input responsive.
- Every second, it checks the current time (`LocalTime.now()`) against the target alarm time.
- Once the alarm time is reached, it uses the Java Sound API (`Clip`, `AudioInputStream`) to loop the alarm sound continuously until the user presses ENTER.

## 🔮 Future Improvements

- [ ] Support for multiple/recurring alarms
- [ ] Snooze functionality
- [ ] GUI version using JavaFX or Swing
- [ ] Configurable alarm sound via file picker
- [ ] Cross-platform default file path handling

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

## 🤝 Contributing

Contributions, issues, and feature requests are welcome! Feel free to check the [issues page](../../issues).

---

⭐ If you found this project useful, consider giving it a star!
