# SeleniumJavaAPICore

## Overview

**SeleniumJavaAPICore** is a simple Maven project created to explore and demonstrate the core APIs provided by Selenium WebDriver.

Unlike a typical automation framework, this project focuses on learning Selenium concepts in isolation. Each example is implemented as an independent Java class that can be executed on its own, making it easy to understand a specific Selenium feature without additional framework code.

The project is intended for learners, interview preparation, and anyone who wants to understand how Selenium APIs work before moving on to building a complete automation framework.

---

## Project Goals

* Explore Selenium WebDriver core APIs
* Understand browser interactions through small, focused examples
* Learn Selenium concepts without the complexity of an automation framework
* Provide independently runnable examples for quick experimentation
* Serve as a reference while learning Selenium

---

## Project Structure

```
SeleniumJavaAPICore
│
├── src
│   └── test
│       └── java
│           ├── Selenium01...
│           ├── Selenium02...
│           ├── Selenium03...
│           ├── ...
│           └── Selenium25...
│
├── pom.xml
└── README.md
```

The project contains approximately **25 Java classes** under:

```
src/test/java/
```

Each class demonstrates a specific Selenium API or feature.

---

## Examples Covered

The project includes examples covering various Selenium concepts such as:

* Launching different browsers
* Navigating to web pages
* Browser navigation (Back, Forward, Refresh)
* Working with WebElements
* Locating elements using different locators
* Sending text and clicking elements
* Retrieving text and attributes
* Handling Alerts
* Handling Frames
* Working with Multiple Windows/Tabs
* Dropdown handling
* Mouse Actions
* Keyboard Actions
* JavaScript Executor
* Waiting strategies
* Taking Screenshots
* File Upload
* Drag and Drop
* Scrolling
* Checkboxes and Radio Buttons
* Web Tables
* and other commonly used Selenium APIs.

> **Note:** The exact topics may vary as additional examples are added over time.

---

## Running the Examples

Each Java class contains its own `main()` method and can be executed independently.

Simply:

1. Open the project in your IDE (IntelliJ IDEA, Eclipse, VS Code, etc.)
2. Navigate to any class under:

```
src/test/java/
```

3. Run the class as a Java Application.

No framework setup or TestNG configuration is required.

---

## Prerequisites

* Java 17 or later (or your configured JDK version)
* Maven
* Google Chrome (or the browser used in the examples)
* Internet connection for accessing demo websites

---

## Dependencies

The project uses Maven for dependency management.

Key dependency:

* Selenium Java

All required dependencies are defined in the project's `pom.xml`.

---

## Purpose

This project intentionally avoids framework design patterns such as:

* Page Object Model (POM)
* Base Classes
* TestNG/JUnit test structure
* Reporting
* Logging
* Configuration management
* Utility classes

The objective is to keep every example small, readable, and focused solely on understanding Selenium APIs.

Once comfortable with these APIs, they can be incorporated into a more structured automation framework.

---

## Who Is This Project For?

This project is useful for:

* Beginners learning Selenium WebDriver
* QA Engineers refreshing Selenium concepts
* Students practicing browser automation
* Developers exploring Selenium APIs
* Interview preparation

---

## Future Enhancements

Possible future additions include:

* More Selenium API examples
* Selenium 4 feature demonstrations
* Relative Locators
* Chrome DevTools Protocol (CDP) examples
* WebDriverManager integration
* Browser-specific examples
* Additional real-world scenarios

---

## License

This project is intended for learning and educational purposes.
