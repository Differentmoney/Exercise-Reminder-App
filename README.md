# Exercise-Reminder-App
Android application designed for Physical therapists to be able to schedule and send SMS reminder to their patients registered in the FHIR server 
Deployment

To setup the application for testing clone the project directory from github and run
the application using Android Studio.

Start off by downloading android studio if currently not on device.

The project directory can be cloned by running:
    git clone https://github.com/Differentmoney/Exercise-Reminder-App.git

Once the repository is cloned, open the CS_6440_physical_therapy_app in Android Studio.

The Gradle build system for this project requires a minimum version of Java 11 to be installed.
As an extra precaution it is good to verify that the correct version of Java is selected for the Gradle JDK in the Gradle Settings menu which can be accessed by clicking File/Project Structure/Gradle.settings

Before running the program in android studio, the AVD needs to be set up in order to emulate an android device which this app is intended for.
Follow ths guide to set up an AVD device:
https://developer.android.com/studio/run/managing-avds
** For the hardware profile please use Pixel 3 XL

Once all the above steps have been completed select the Pixel 3 XL as the AVD device from the bar on the top center of Android studio. Next click the the green play button to run the application.

Give the app about 1 minute for intial load process.

Once the app is launched you will be prompted by a login which will ask you to enter your username and password.

Use the following credentials to login:
    username: angulo1234
    password: 1234

Disclaimer:
During the design and testing of the application, we used a free trial Twilio account to manage the sending and receiving of SMS messages, due to the Twilio account being a trial account there are limitations placed on the extent of messaging so for the current configuration, Twilio only permits sending of SMS to one designated default phone number. Within the current state of the code, Twilio is set to send SMS to the phones of the corresponding patients which were retrieved from FHIR as is the intended design. The current limitation of the Twilio trial account bars this functionailty from being realized and for now serves as a proof of concept of the app's intended design.
# Note during development the AVD used to test the application was a Pixel 3 XL, thus some android devices with much smaller screen dimensions may experience differences in scaling.
