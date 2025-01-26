Simple Text Editor
This is a simple text editor application that allows users to create, edit, and save text files. 
It provides basic text editing functionality with a user-friendly interface.

Features
Create new text files
Open existing text files
Save text files

Requirements
Java 8 or higher
Maven (for building the application)
IDE (e.g., IntelliJ IDEA, Eclipse)
Installation
Clone the repository:

bash

git clone https://github.com/yourusername/simple-text-editor.git
Navigate to the project directory:

bash

cd simple-text-editor
Build the project using Maven:

bash

mvn clean install
After the build completes, you can run the application using the following command:

bash

mvn exec:java
Alternatively, you can run the Main class directly from your IDE.

Creating an Executable Application
To create an executable JAR file of the application:

Navigate to the project directory if you're not already there.

Build the project with the following Maven command:

bash

mvn clean package
After the build is successful, you will find the executable JAR file in the target folder.

You can run the JAR file with:

bash

java -jar target/simple-text-editor-1.0-SNAPSHOT.jar
License
MIT License

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
