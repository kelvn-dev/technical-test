# Part 1: Java and Object-Oriented Programming Test

Develop a Java application that reads a text file, parses its contents, and provides a detailed analysis of the words used, along with a summary report generation feature.

## Project structure

```shell
.
├── src
    ├── common/
    ├── config/
    ├── enums/
    ├── model/
    ├── service/
    ├── utils/
├── static/
├── README.md
```

## Prerequisites

- [JDK](https://www.oracle.com/fr/java/technologies/javase/jdk11-archive-downloads.html)

## Usage

- Mark directory src as sources root
- Put your text file into directory static
- Run src/Application.java and input path (Ex: part1/static/example.txt)

## Highlights

The system involves 3 main interfaces defined with type parameter extend from BaseFile
=> **These generic interfaces support extension in the future if we want to add parser, analyzer and report generator for other file types than text, for example image or pdf**

The system involves 3 main services:
- TextFileParser: take a file path as input and read the contents of file into model TextFile 
- TextFileAnalyzer: Count the number of times each word appears, all words and all distinct words
- TextFileReportGenerator: take a TextFile model as input and generate report using pre-configure template


Applied OOP principles:
- encapsulation: private fields with public getters/setters
- inheritance: model BaseFile contain common fields like id, contentType, ... for other models like TextFile or ImageFile to extend, which reuse code and create hierarchical structure
- abstraction: make class BaseFile abstract to avoid instantiating
- polymorphism: not yet

## What can be improved ?
- Apply design pattern Singleton => When switching to Springboot, we will auto have this through DI mechanism
- Apply design pattern Builder to construct complex file objects step by step => Using lombok annotation @Builder

