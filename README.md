# Appium Test Automation Framework

A robust mobile test automation framework built with Appium, designed for scalability and maintainability. This framework helps you write and maintain high-quality mobile tests efficiently.

## Test Results

![Test Execution Results](https://github.com/user-attachments/assets/ef8bec1a-4c76-4b08-a126-00472053907e)

The screenshot above shows the test execution results from our framework, demonstrating successful test runs and detailed reporting capabilities.

## Tech Stack

- **Appium**: Cross-platform mobile testing
- **Java**: Core programming language
- **TestNG**: Test organization and execution
- **Maven**: Dependency management
- **ExtentReports**: Test reporting
- **Selenium**: Mobile automation foundation

## Prerequisites

- Java JDK 17+
- Maven 3.6.0+
- Appium Server
- Android SDK (for Android testing)
- Xcode (for iOS testing, macOS only)
- Node.js and npm

## Quick Start

1. Clone and setup:
   ```bash
   git clone [repository-url]
   cd monefy-app-test-automation
   npm install -g appium
   mvn clean install
   ```

2. Run tests:
   ```bash
   # Run all tests
   mvn clean test

   # Run specific groups
   mvn clean test -Dtest=testng.xml -Dgroups=expense
   ```

## Project Structure

```
├── src/
│   ├── main/java/        # Framework code
│   └── test/java/        # Test cases
├── reports/              # Test execution reports
├── testng.xml           # TestNG configuration
└── pom.xml              # Maven configuration
```

## Key Features

- **Scalability**: Modular design with Page Object Model
- **Maintainability**: Centralized configuration and reusable components
- **Reporting**: Detailed HTML reports with failure screenshots