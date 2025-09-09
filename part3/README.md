# Part 3: Malware Analysis Emulation Scenario

Create a simple calculator script emulator in Java

## Project structure

```shell
.
├── bin/
├── src
    ├── main
        ├── antlr4/
            ├── org.technical/
        ├── java/
            ├── org.technical/
                ├── core/
                    ├── calculator/
                    ├── evaluator/
                ├── driver/
        ├── resources/
    ├── test
        ├── java/
            ├── org.technical/
├── target/
├── .gitignore
├── pom.xml
├── README.md
```

## Prerequisites

- [JDK](https://www.oracle.com/fr/java/technologies/javase/jdk11-archive-downloads.html) (version 11)

- [Apache Maven](https://maven.apache.org/download.cgi)

- [SDK Man](https://sdkman.io/install/) `Optional for java and maven version manager`

## Usage

- Mark directory src as sources root

- Generate required classes based on grammar .g4 file
    ```shell
  cd part3
  mvn antlr4:antlr4
  ```
  or
    ```shell
  cd part3
  sh bin/antlr4.sh
  ```
  
- Make your IDE includes the generated-sources in its imports.
  - In IntelliJ IDEA, you can right-click the project folder at the top of the project tab (in our case `part3`) and then click `Maven > Generate Sources and Update Folders`

- Run Calculator.java and input calculation (Ex: 2 + 3). You can refer to unit test for more cases located at `src/test/java/org/technical`.

- Leave the calculation blank or type `exit` to exit the program.

## Bonus: Building and running application using Docker

- Build docker image
  ```shell
  cd part3
  docker build -t calculator -f Dockerfile .
  ```
  or
  ```shell
  cd part3
  sh bin/build_docker.sh
  ```
  
- Run container
  ```shell
  docker run --rm -it calculator
  ```
  or
  ```shell
  cd part3
  sh bin/run_docker_container.sh
  ```