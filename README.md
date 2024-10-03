# Team information

Team Name: U-knownZero

Team Members: 
Lee Eng Jie (33002703)
Yeoh Ming Wei (32205449)
Yew Yee Perng (32205481)
Avril Chai (32693885)

Tutorial: 01

## Asscessible Links
Sprint 1 : Deliverables 
https://docs.google.com/document/d/1OSiONmpIVZ0FsyEYIXhzUv-2LBXr43WsVkGXME_UIV4/edit

Design Model (Lucid Chart)
https://lucid.app/lucidchart/0d282603-0e54-4bc8-a1bd-4c80ed131544/edit?invitationId=inv_71229c40-28e8-4575-90ab-6e5b8b2c145c&page=0_0#

UI Design (Lucid Chart)
https://lucid.app/lucidchart/2d0d3718-f78d-4f49-aa7b-6e902ceeff70/edit?invitationId=inv_08ddc6aa-9aec-44ca-b761-9e263d451137&page=0_0#

## Sprint 4 Information (Revised from Sprint 3)
Java version "22.0.1" 2024-04-16
Java(TM) SE Runtime Environment (build 22.0.1+8-16)
SDK : javafx-sdk-22.0.1 (Make sure that the downloaded SDK is for the right operating system)

To ensure the application works, please make sure to update the same Java version as the one above. 
How to check Java version:
1. Click search button at the bottom left.
2. Type `cmd` and open Command Prompt. 
3. Type `java --version` and press enter to check the Java version. 
4. If it's not the latest Java, download from this website. https://www.oracle.com/my/java/technologies/downloads/#jdk22-windows

### How to run the application?
There are two different ways to open the application:

**1. Run through executable JAR File.**
You can run through clicking the executable JAR file through this directory.
> ~\YOUR_DOWNLOAD_PATH\fit3077-git\out\artifacts\fit3077_git_jar

If it doesn't work, consider trying to build the artifacts again.
Link: https://taylorial.com/tools/jar/, (Configuring Jar to be Created)

The javafx-sdk-22.0.1\lib directory is here: 
> ~\YOUR_DOWNLOAD_PATH\fit3077-git\Project\Sprint2_YeohMingWei_32205449\javafx-sdk-22.0.1

**2. Build from IntelliJ**
1. Go to File > Project Structure.
2. In the Project section, set JDK to version 22.0.1.
3. In the Modules section folder directory, go to `Project\src\` and mark `main` as Source folder. 
4. In the Libraries section , press the '+' button and press Java.
5. Locate to this folder `~\YOUR_DOWNLOAD_PATH\fit3077-git\Project\Sprint2_YeohMingWei_32205449\javafx-sdk-22.0.1\lib` and press add.
> This may be differed due to different operating system, ensure that the downloaded SDK is for the correct OS and link the path to the right library.
6. Go to Run > Edit Configuration. 
7. Press '+' button and create a new application. 
8. Change the running program to Game.main.
9. Add VM options : `--module-path "\path\to\javafx-sdk-22.0.1\lib" --add-modules javafx.controls,javafx.fxml`, `\path\to\` is the local address. I had located the directory of the javafx above.
> This may be differed due to different operating system, ensure that the downloaded SDK is for the correct OS and link the path to the right library.
10. Run the program.

**Troubleshoots**
- Graphics Device initialization failed for : es2, sw
    A: Ensure that you download the correct SDK from JavaFX website and redo Method 2 Build from IntelliJ, step 3 - 9. This is due to different operating system that causes the issue.

- Any JavaFX libraries are not found.
    A: Reboot IntelliJ, or check the directory as well. (Redo Method 2 Build from IntelliJ, step 3 - 9)

Contact me if the application doesn't work: 
Monash email: myeo0008@student.monash.edu
Discord: nekronfeonix
Phone Number: 018-9510388

## Documents
Directory: ~\YOUR_DOWNLOAD_PATH\fit3077-git\Project\Sprint2_YeohMingWei_32205449\docs

## Documents for Sprint 3
Directory: ~\YOUR_DOWNLOAD_PATH\fit3077-git\Project\Sprint 3 Docs

## Documents for Sprint 4 (With Executable Files)
Directory: ~\YOUR_DOWNLOAD_PATH\fit3077-git\Sprint 4 Doc and Exe
