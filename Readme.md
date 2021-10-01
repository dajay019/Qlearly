This project is used to execute automation tests for the chrome extension Qlearly

This project is capable of executing the test from Jenkins CI/CD and tests can be triggered in multiple ways
1. Trigger from Jenkins
2. Trigger from Command Prompt

Also tests can be run in multiple ways
1. Invoke gradle task
2. Invoke testng xml 
3. Invoke test class or method using IDE

Prerequisites:

Gradle 6.8, Java 1.8 or above needs to be installed

Libraries used:
Selenium, TestNg, WebdriverManager

Once the above prerequisites are installed, Please build this project using gradle and required dependencies will be downloaded
Project is customised to run on different groups

As of now group name is hardcoded in the task

Test Dependencies:
Considered the crx file extension is downloaded and available in the test client machine and provided in the test.properties file

Steps to execute:
Once the gradle build is successful, Please update the crx file path (on test client machine) in the test.properties file
Open command prompt and navigate to the path where build.gradle is accessible and run 
"gradle --rerun-tasks executetests" 
tests will be executed and reports are generated in the local machine workspace under reports directory

Test Coverage:
This suite contains:

1. Creating a board, verifying the board creation, loading, and deleting the board (BoardCRUDTests.java)
2. Creating a bookmark and verifying the successful creation, searching for a bookmark, deleting it and verifying for the successful deletion(BookmarkCRUDTests.java)
3. Opening four urls in the browser tabs and opening the plugin and then navigating to the 4th opened session and validating the url of the 4th session(InvokeExtensionTests.java)


