# IP Finder

A simple Java Swing application that resolves a hostname or IP address and displays the lookup results.

## Features

- Enter a hostname or IP address
- Perform DNS lookup asynchronously
- Display host name, canonical name, IP address, and IPv6 status
- Responsive UI with a spinner indicator during lookup

## Requirements

- Java SDK installed (JDK 8 or newer)
- No build tool required

## Build and Run

From the project folder, compile and run with:

```powershell
cd "c:\Users\lc\Desktop\New folder\IPFinder"
javac *.java panel4\*.java
java MainWindow
```

If you want to keep the icon, make sure `icon.png` remains in the same directory as `MainWindow.java`.

## Usage

1. Start the application
2. Enter a hostname or IP address into the text field
3. Click the search button
4. Wait for the spinner to finish
5. View the lookup results in the text area

## Notes

- The application uses Swing and a `SwingWorker` thread to keep the UI responsive during network lookup.
- If you see an error dialog, verify the input and try again.
