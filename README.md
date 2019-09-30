# EscapeGameOnline
OpenClassRooms Exercise :
EscapeGame Online Project for Gameplay Studio (virtual company).

The goal of this game is to guess a combination of N numbers with a maximum of attempts. These elements are adjustable in the file game_settings.properties.

An indication is provided, after each attempt, in the form of a sequence of mathematical signs.

The '+' sign indicates that the figure to be found on this position is greater.

The '-' sign that the figure to be found is smaller.

The '=' sign indicates that you have the correct number on this position.

```
If the secret combination is '555' and the proposition is '950',
the indication provided by the computer or to provide will be '-=+'.
```
Three game modes:

Challenger Mode: The computer must guess your secret combination (note it before starting the game).

Defender mode: Try to guess the number chosen by the computer.

Duel Mode: Each player chooses his secret combination. The first to find it wins the round (unlimited number of attempts).

## Getting Started

Get a copy of the project by cloning it from github on your local machine and import as Maven project for development and testing.

Else, simply download files in this folder : [EscapeGameLauncher](https://github.com/rvallet/escapegameonline/tree/master/EscapeGameLauncher) 

Then, launch the .bat file on windows (read section [Prerequisites](https://github.com/rvallet/escapegameonline#prerequisites) below).

NOTE : By launching the file DEV-MODE.bat, you will force the activation of this mode (whatever the setting of the properties file).

### Options 
Edit the following file in a text editor : [/main/resources/game_settings.properties](https://github.com/rvallet/escapegameonline/blob/master/src/main/resources/game_settings.properties)

##### Game Options :
Change the values above to adjust the length of the secret number, the maximum number of attempts, or to activate the dev mode (displays the secret combination of the computer when dual and defender modes are started).

Default settings :
```
#Number of digit : replace value with the length of the combination to find
settings.nbDigit=4

#Number of tries : replace value with the numbers of tries you want
settings.nbTries=5

#Developer mode : replace value with "true" or "false"
settings.devMode=false
```

Another way to enable the development option is to add the 'dev' parameter when manually launching the .jar file :
```
java -jar escape-game-online.jar dev
```

##### Language Options :
Change the values above to adjust the language fr-FR or in en-US.

Note : Adding additional language support is possible by translating an existing file into a new game_content_xx-XX.properties file and adding the new case management to the PropertiesReader file.

Default settings :
```
#Choice of Language : replace value with "fr-FR" or "en-US" (or add new value here and in constructor Utils>PropertiesReader)
settings.language=fr-FR

#Folders : Add new line with the name of new content translation files (.properties) and parameter this new case in constructor Utils>PropertiesReader
settings.languageChoiceFR=game_content_fr-FR.properties
settings.languageChoiceEN=game_content_en-US.properties
```
### Prerequisites

Any device with Operating System (OS) that supports the Java Virtual Machine (JVM) .
```
Windows, Mac OS, Linux...
```
Windows ~~> Install the [Java Runtime Environment (JRE)](https://docs.oracle.com/javase/9/install/installation-jdk-and-jre-microsoft-windows-platforms.htm#GUID-2B9D2A17-176B-4BC8-AE2D-FD884161C958)
## Built With

* [IntelliJ IDEA](https://www.jetbrains.com/idea/) - IDE (SDK12)
* [Maven](https://maven.apache.org/) - Dependency Management
* [PlantUML](http://plantuml.com/en/) - UML Diagrams

## Versioning

For the versions available, see the [tags on this repository](https://github.com/rvallet/escapegameonline/tags).
For the the stable releases, see the  [releases on this directory](https://github.com/rvallet/escapegameonline/releases)

## Authors

* **Rémy VALLET** - *Initial work* - [rvallet](https://github.com/rvallet)

See also the list of [contributors](https://github.com/rvallet/escapegameonline/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](https://github.com/rvallet/escapegameonline/blob/master/LICENSE.md) file for details
