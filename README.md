![Push Run](https://github.com/gamzepala/RestAssuredRestfulBooker/actions/workflows/workflow.yml/badge.svg)

# Table of Contents
1. [Introduction](#1-introduction)
2. [Test Plan](#2-test-plan)
3. [How to run tests on your local](#3-how-to-run-the-tests-on-your-local)
4. [View reports in your local](#4-view-reports-in-your-local)
5. [How to run the test in a CI/CD](#5-how-to-run-the-test-in-a-cicd-github)
6. [Test Environment and Tech Stack](#6-test-environment-and-tech-stack)
7. [Possible improvements](#7-possible-improvements)

## 1. Introduction
This repository is a demonstration of how API restful-booker tested.
It includes Rest Assured and Cucumber integration for putting BDD practice into it.
GitHub Runners used as a CI/CD. After tests completed, Extent Reports creates fancy report. 

## 2. Test Plan
All details about the object, approach, features to be tested and more in [Test Plan](src/test/resources/docs/test_plan.md)

## 3. How to run test in your local
1. Clone the repository
```
https://github.com/gamzepala/RestAssuredRestfulBooker.git
```

2. The project supports Maven build. To run the tests with Maven, open a command window and run:
```
mvn clean verify
```
**Hint:** If you want to execute a specific test, would recommend to use annotations like @debug, @regression or @smoke
```
Feature: Creates a new booking in the API
  As a user
  I want to create a new booking
  So that I can make a reservation
  
  @debug
  Scenario: Create a new booking
    Given I have a valid booking payload with the following details
    When I perform a POST request
    Then the create response code should be verified
    And the response body should be correct
```

```
mvn clean test -D"cucumber.filter.tags=@debug"
```
## 4. View reports in your local
The command provided above will produce a test report in the `test-output/SparkReport/Spark.html` directory.
After running the tests, it will be provided you a report link automatically. Just click!

## 5. How to run the test in a CI/CD
Follow the link below to see the  workflow. **IMPORTANT NOTE:** After test execution done, please go to `Artifacts` and download `Full Report`
to comprehensive report with cool graphs. Then find `Spark.html` file and just click!
<a href="https://github.com/gamzepala/RestAssuredRestfulBooker/actions/runs/4177896378" target="_blank">Sample Workflow Run</a>

`See Sample Report`


```
https://github.com/gamzepala/RestAssuredRestfulBooker/blob/development/.github/workflows/workflow.yml
```

## 6. Test Environment and Tech Stack
* restful-booker API
* Rest Assured
* Cucumber 7
* See the other dependencies in pom.xml

## 7. Possible Improvements
* Add request and response body into the html file
* Split out the jobs in the workflow file
* Automated Test management results update like Zephyr or Azure DevOps Test Plan
* Of course more edge scenarios to try to break the API and ensure the robustnuss

## Important Note
The JAVA and MAVEN must be installed and set the environment variable depends on your OS
