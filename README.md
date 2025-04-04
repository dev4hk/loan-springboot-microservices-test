# ✅ Loan Service Testing Framework – BDD

A test automation framework designed for the **Loan Microservices Project**, following **Behavior-Driven Development (BDD)** principles.  
It integrates **Cucumber**, **Selenium**, and **TestNG** to create a scalable, maintainable, and readable testing suite.

---

## 🚀 Overview

This framework simplifies the testing process of `loan-springboot-microservice` by:

- Embracing **BDD** for clear, human-readable test scenarios
- Using **Page Object Model** for reusability and modularity
- Supporting cross-browser testing with **Selenium WebDriver**
- Leveraging **TestNG** for structured test execution and reporting

---

## 🧪 Technologies Used

- 🥒 **Cucumber** – BDD syntax and Gherkin-based test scenarios
- 🧪 **Selenium WebDriver** – Browser automation
- 🔍 **TestNG** – Test orchestration and assertions
- 📦 **PicoContainer** – Dependency injection for shared test context

---

## 🧱 Key Components

### 🔹 `PageObjectManager`
- Manages all page object instances
- Prevents redundant object creation
- Provides access to page-specific objects on demand

### 🔹 `TestBase`
- Responsible for WebDriver setup and configuration
- Provides common methods to initialize and control browsers

### 🔹 `TestContext`
- Central test context holder that:
  - Manages credentials and session data
  - Connects `TestBase`, `PageObjectManager`, and scenario-specific state
- Injected into step definitions via **PicoContainer**

### 🔹 `BasePageComponent`
- Abstract base class for all page objects
- Provides navigation and utility methods used across pages

### 🔹 **Page Objects** (e.g., `ManagerSummaryPage`, `ManagerCounselPage`, etc.)
- Represent specific pages in the loan system
- Extend `BasePageComponent`
- Encapsulate actions and validations for each page

### 🔹 **Step Definitions** (e.g., `AuthenticationStepDefinitions`, `ApplicationStepDefinitions`, etc.)
- Define the executable logic behind Cucumber steps
- Use `TestContext` to interact with the web application and pages

---

## 🔄 Dependency Injection with PicoContainer

The framework uses **PicoContainer** to inject `TestContext` into all step definition classes.  
This allows:

- Shared WebDriver across steps
- Consistent access to page objects
- Cleaner, more modular step definition logic

---

## 🧭 Framework Diagram

![UML Class Diagram](images/diagram.png)
