# space-invaders-android

This is a simple remake of the classic Space Invaders game. Multiple types of interaction were added to the game. The spaceship can be moved by using virtual buttons or the accelerometer. There are three ways to control the shots:

1. Touch where you want the shot to go;
2. Touch anywhere on the screen, but shot will follow a straight line from the spaceship's current position;
3. Press a virtual button (shot will also follow a straight line)

You can choose whichever fits you best in the **Settings** menu.

## Building and running

Firstly, you have to create a local.properties file and define the location of the Android SDK. For example, this is the content of my local.properties:
```properties
sdk.dir=D\:\\ProgramFiles\\JetBrains\\Utility\\Android\\SDK
```

After that, connect your AVD or your USB debugging enabled physical device and run
```
gradlew build
gradlew installDebug
```
to build and install the app, respectively. To run it, you can simply click on its icon in the app drawer, or run the following command:
```
gradlew run
```

To uninstall the app, execute:
```
gradlew uninstallAll
```
