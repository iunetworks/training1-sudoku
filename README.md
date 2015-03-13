# Open Sudoku 
 
[![Build Status](https://travis-ci.org/iunetworks/training1-sudoku.svg)](https://travis-ci.org/iunetworks/training1-sudoku)  

Open source [demo project](http://212.34.226.170/) to showcase BDD.

## Setting up the workspace

Following tools must be installed to be able to contribute to this project.

1. [git](http://git-scm.com/) - source version control
2. [jdk 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html) - We will use java for product development 
3. [maven](http://maven.apache.org/download.cgi) - A build tool 
4. [Phantom JS](http://phantomjs.org/download.html) - Headless browser for automated functional testing

##### Important:
To verify you have successfully installed all tools use following command

- Git
 `git --version`
- JDK `javac -version`. (Make sure you have **JDK 7**)
- Maven `mvn --version`
- PhantomJS `phantomjs --version`

You can use your preferred [IDE](http://en.wikipedia.org/wiki/Comparison_of_integrated_development_environments#Java). 

## Downloading source code

If you simply want to download the sources the you can clone the repository by:

    git clone https://github.com/iunetworks/training1-sudoku.git

In case if you are planning to participate to project then you have to:

1. Register at [github](https://github.com)
2. Fork the [training1-sudoku](https://github.com/iunetworks/training1-sudoku) repository
3. Then clone your copy of repository

## Building the project

If you have done everything correctly, then following command will build the project and run all tests. 

    cd training1-sudoku
    mvn install

To run the project locally you can simply type

    cd training1-sudoku/sudoku-mw
    mvn jetty:run -P run-jetty

Then open browser and type [http://localhost:8080](http://localhost:8080) and enjoy the Open Sudoku.

## Contributing to project

### Business Analysts (BA)
Business analytics contribute to project by writing user stories on how system should behave. Stories can be written
in english as well as in armenian languages. 

All stories ar located in `soduku-mw/test/resrouces/jbehave/stories` 
directory. Each story is text file ending with `.story.en.txt` if it is written in english or `.story.hy.txt` if 
it stated in armenian.

After adding a new story or modifying existing a BA must validate the story to make sure it's written in correct format.
See [jbahve manual](http://jbehave.org/reference/stable/developing-stories.html#writing) on how to write stories.

Use following command to validate stories

    cd sudoku-mw
    mvn  -P jbehave-dry verify

The command will run the jbehave stories in 'dryRun' mode.

If you also need to see the implementation prgoress (QA and DEV) you can call:

    mvn  -P jbehave-local verify

(You might get Build Failure result which you can ignore)

In both cases you can find the results in `sudoku-mw/target/jbehave/view/reposts.html`
  

### Quality Engineers / QA

Quality engineers contribute to project by writing automated tests on project as described in stories. The tests are
introduced as JBehave steps (POJO classes with annotated mappings to user stories). 

In this project we will use selenium web driver with PhantomJS browser for automating user stories.
 
#### Useful tips

To make a quick check if there are any unimplemented stories use dryRun mode

    cd sudoku-mw
    mvn  -P jbehave-dry verify
    
To check the implementation you can run the jetty during during verification with

    mvn  -P jbehave-local verify

In case if you want to run the tests against  already running web application use

    mvn  -P jbehave-remote verify -Dapp.host=http://localhost:8083 
    
To only run application to check the UI

    mvn -P run-jetty jetty:start


### Developers

Developers contributing to project by implementing requirements. 

Following are the implementation guidelines, which **MUST**  be followed unconditionally.
  
###### 1. Write ONLY what is required, no extra code must be committed.

We use [jacoco](http://www.eclemma.org/jacoco/) to track code coverage and after each change developer must run  
BDD tests to verify that they still have 100% coverage of code. 

The important thing is that BDD tests only need to cover the final product which in our case is the sudoku-mw. The
sudoku-dao in this case is used as external library which is not necessary to be documented by user stories. 
Still the sudoku-dao module/library MUST be 100% covered by unit tests.
 
Before each push (also can be before each commit) developer must verify 100% coverage by
 
    mvn -P run-all verify
    
The coverage reports can be found in `target/site/jacoco` directory of each module.

###### 2. Always take the shortest way to implement requirement.

While coverage report can somehow help to avoid unused code still it can't stop a developer from writing code that
is doing more than expected. The code quality will be reviewed and pull request can be rejected if developer didn't use
obviously shorter implementation of task.

To demonstrate what does it meant to code only what is required here is some exaggerated example.

Suppose you have a task implement a method `greet(String name)` which 
 
 1. When called with `greet("World")` will `return "Hello World"`
 
 normally you will write similar code
 
```java
    public String greet(String name) {
        return "Hello " + name;
    }
```

This looks OK, BUT... obviously as the requirement only asks `greet("World")` to return `"Hello World"` you could also write it this way 

```java
    public String greet(String name) {
        return "Hello World";
    }
```

At least is doesn't concatenate the two strings.

In case if there also requirement for method to return `"Hello Java"` when called with `greet("Java")` then the first
implementation will become acceptable.

As mentioned this example is little bit exaggerated, but still it clearly demonstrates the main point: your code MUST only do 
what is ASKED and not what you IMPLY.

