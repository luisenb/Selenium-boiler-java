# Selenium with Java Boilerplate

This repository serves as a boilerplate for setting up Selenium with Java projects. It provides a foundation for automating web tests using Selenium WebDriver in Java, with connections to Selenoid.

## Table of Contents
- [Introduction](#introduction)
- [Page Object Model](#page-object-model)
- [Lombok for Model Mapping](#lombok-for-model-mapping)
- [Thread Local for Parallel Execution Safety](#thread-local-for-parallel-execution-safety)
- [Connecting to Selenoid](#connecting-to-selenoid)

## Introduction
Selenium is a popular tool for automating web browsers. It enables testers to simulate user interactions with web applications for automated testing purposes. This boilerplate utilizes Selenium WebDriver with Java for web automation tasks.

## Page Object Model
The Page Object Model (POM) is a design pattern used in test automation to enhance test maintenance and reduce code duplication. In this pattern, web pages are represented as Java classes, and each class encapsulates the behavior and elements of a specific page in the application. The tests interact with these page objects rather than directly with the web elements, resulting in cleaner and more maintainable test code.

## Lombok for Model Mapping
Lombok is a Java library that helps reduce boilerplate code by automatically generating getter, setter, equals, hashCode, and toString methods for Java classes. In this boilerplate, Lombok is utilized for mapping models to simplify the creation of data objects used in test automation. By annotating the model classes with Lombok annotations, developers can avoid writing repetitive code for getters, setters, and other standard methods.

## Thread Local for Parallel Execution Safety
Thread safety is crucial in parallel test execution scenarios to prevent data corruption or interference between concurrent test cases. This boilerplate employs Thread Local, a mechanism in Java that provides thread-local variables, ensuring that each thread accessing a variable has its own, independently initialized copy. By using Thread Local, parallel execution of tests can be safely managed without conflicts or race conditions.

## Connecting to Selenoid 
[Selenoid](https://aerokube.com/selenoid/latest/) is a powerful Golang implementation of the original Selenium hub code. It utilizes Docker to launch browsers for Selenium tests. By connecting to Selenoid, you can easily manage and scale your Selenium test infrastructure. This boilerplate provides instructions and configurations for connecting your Selenium tests to Selenoid.

---
This boilerplate is designed to provide a structured foundation for Selenium-based test automation projects in Java. It incorporates best practices such as the Page Object Model for maintainability, Lombok for reducing boilerplate code, Thread Local for parallel execution safety, and connection to Selenoid for managing Selenium test infrastructure. Feel free to customize and extend it according to your project requirements. Happy testing!
