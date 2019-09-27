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

Then, launch the .bat file on windows (on other Operating System, search how to run .jar file on it)

### Prerequisites

Any device with OS that supports the JVM.
```
Windows, Mac OS, Linux...
```

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
