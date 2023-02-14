![Manual Run](https://github.com/alipala/gitlabapi/actions/workflows/manual.yml/badge.svg)

# Table of Contents
1. [Introduction](#1-introduction)
2. [Test Plan](#2-test-plan)
3. [How to run tests on your local](#3-how-to-run-the-tests-on-your-local)
4. [View reports in your local](#4-view-reports-in-your-local)
5. [How to run the test in a CI/CD](#5-how-to-run-the-test-in-a-cicd-github)
6. [Automated Zephyr Test Result Publishing](#6-automated-zephyr-test-result-publishing)
7. [Test Environment and Tech Stack](#7-test-environment-and-tech-stack)

## 1. Introduction
This repository is a demonstration of how GitLab Issues API tested.
It includes Serenity BDD with Rest Assured and Cucumber integration for putting BDD practice into it.
GitHub Runners used as a CI/CD. After tests completed, Serenity BDD creates fancy reports. One of them
full report contains test automation graphs, the other one is single page report.

## 2. Test Plan
All details about the object, approach, features to be tested and more in [Test Plan](src/test/resources/docs/test_plan.md)

## 3. How to run test in your local
1. Clone the repository
```
https://github.com/alipala/gitlabapi.git
```

2. The project supports Maven build. To run the tests with Maven, open a command window and run:
```
mvn clean verify
```

## 4. View reports in your local
The command provided above will produce a Serenity test report in the `target/site/serenity/index.html` directory.
After running the tests, it will be provided you a report link automatically. Just click!

## 5. How to run the test in a CI/CD
Follow the link below to see the manual workflow. **IMPORTANT NOTE:** After test execution done, please go to `Artifacts` and download `Full Report`
to comprehensive report with cool graphs. Then find `index.html` file and just click!
<a href="https://github.com/alipala/gitlabapi/actions/runs/2424251475/" target="_blank">Sample Workflow Run</a>

`See Sample Report`

https://user-images.githubusercontent.com/16635008/171510272-86db1d88-083a-47a9-88e1-a9cf4e9fa5a8.mp4

```
https://github.com/alipala/gitlabapi/actions/workflows/manual.yml   
```

## 6. Automated Zephyr Test Result Publishing
The solution automatically update the test results stored in Zephyr Scale test management tool.
There is an integration between TA and Zephyr Scale using Zephyr Rest Client API

> ![Overall Tests](src/test/resources/docs/Zephyr-1.png?raw=true)
> ![Individual Test](src/test/resources/docs/Zephyr-2.png?raw=true)

## 7. Test Environment and Tech Stack
* Gitlab Issue API
* Serenity BDD
* Rest Assured
* Cucumber 6
* See the other dependencies in pom.xml

## Important Note
The JAVA and MAVEN must be installed and set the environment variable depends on your OS
