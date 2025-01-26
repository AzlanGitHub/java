# Taschenrechner

Ein einfacher Taschenrechner mit JavaFX, der Grundrechenarten sowie erweiterte Funktionen wie Wurzelziehen, Kehrwert und CE-Unterstützung bietet.

## 📌 Features
✅ Addition, Subtraktion, Multiplikation, Division  
✅ Quadratwurzel (√)  
✅ Kehrwert (1/x)  
✅ Backspace (⌫) zum Löschen der letzten Ziffer  
✅ CE (Clear Entry) zum Löschen der aktuellen Eingabe  
✅ C (Clear) zum Zurücksetzen des gesamten Rechners  
✅ Benutzerfreundliches JavaFX-GUI  

## 🛠️ Installation & Nutzung
### Voraussetzungen:
- Java 17 oder neuer
- JavaFX
- IntelliJ IDEA oder Eclipse (optional)

### Installation:
1. **Repository klonen:**
   ```sh
   git clone https://github.com/AzlanGitHub/java.git
   cd taschenrechner
   ```
2. **Projekt in IntelliJ/Eclipse öffnen**
3. **Starten der Anwendung:**
   ```sh
   mvn javafx:run
   ```

## 📜 Verzeichnisstruktur
```
Taschenrechner/
│-- src/
│   ├── main/
│   │   ├── java/org/javafx/javafxml/calculator/
│   │   │   ├── MainApp.java
│   │   │   ├── JRechnerController.java
│   │   ├── resources/org/javafx/javafxml/calculator/
│   │   │   ├── Jrechner.fxml
│-- pom.xml (Falls Maven genutzt wird)
│-- README.md
```

## 📷 Screenshots
_Füge hier Screenshots deines Taschenrechners ein._

## 🚀 Geplante Features
🔹 Prozentrechnung (%)  
🔹 Speicherfunktionen (M+, M-, MR, MC)  
🔹 Dark Mode  


####################################################################################

Calculator JavaFX Application
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


License
This project is licensed under the MIT License – see the LICENSE file for details.







## 📄 Lizenz
Dieses Projekt steht unter der MIT-Lizenz – siehe die **LICENSE**-Datei für Details.

## 🙌 Beitrag leisten
Falls du Ideen oder Verbesserungen hast, bist du herzlich eingeladen, Pull Requests zu erstellen oder ein Issue zu melden! 🎉

