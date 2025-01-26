# Kundenverwaltung( Customer Management Application  )

## Beschreibung ( Description )

Dieses Projekt ermöglicht das Speichern und Löschen von Kundendaten.
(This project allows for the storage and deletion of customer data. )

## Features
- Kunden hinzufügen (add customer) 
- Kunden löschen (delete customer)

## Installation
1. Repository klonen ( clone repository ):
   ```bash
   git clone https://github.com/AzlanGitHub/java.git
   ```
2. In das Projektverzeichnis wechseln ( change directory ) :
   ```bash
   cd projekverzeichnis

   ```
3. Abhängigkeiten installieren ( install dependencies):
   ```bash
   mvn install
   ```

## Nutzung (usage)
1. Anwendung starten (start application :
   ```bash
   java -jar kundenverwaltung.jar
   ```


HOW TO CREATE RUNNABLE Application(jar file)
##########################################


This is a JavaFX-based calculator application developed with Maven and JavaFX. 
It uses various JavaFX libraries along with additional dependencies like ControlsFX and FormsFX.

### Prerequisites ###
JDK 17 or higher
JavaFX SDK (version 11 or above)
Maven (for building and managing dependencies)

####### 1. Clone the Repository ######
bash(CMD)
git clone https://github.com/YourUsername/Calculator.git
cd Calculator

####### 2. Set up JavaFX SDK #########

Download the JavaFX SDK from: https://gluonhq.com/products/javafx/
JavaFX Downloads
Extract the downloaded SDK and remember the path, for example, C:\javafx-sdk-22.

##### 3. Install Dependencies #######

Make sure you have Maven installed in your IDE. If not, please install in it! Read documentation of your IDE and https://openjfx.io/openjfx-docs/#introduction.
Run the following command in the project folder to download all required dependencies:
bash in your IDE
mvn clean install

##### 4. Running the Application ######
Option 1: Run with Maven and JavaFX Plugin
You can directly run the application using Maven:

bash
mvn javafx:run
Option 2: Build an Executable JAR
Run this command to create an executable JAR file:

bash
mvn clean package
The JAR file will be created in the target folder. To run the application, use the following command:

bash

java -jar target/calculator-1.0-SNAPSHOT.jar
Option 3: Run with JavaFX SDK
If you’ve created a JAR but are facing issues with JavaFX modules, ensure you're specifying the correct module path:
bash
java --module-path "C:\javafx-sdk-22\lib;target/lib" --add-modules javafx.controls,javafx.fxml -jar target/calculator-1.0-SNAPSHOT.jar

Note: Replace C:\javafx-sdk-22\lib with the actual path to your JavaFX SDK.

5. Running Tests
If you want to run unit tests, you can do so using Maven:

mvn test


## Lizenz
Dieses Projekt steht unter der MIT-Lizenz. Weitere Informationen siehe [LICENSE](LICENSE).

