# 🏦 Banking API Test Automation Framework

A robust and scalable test automation framework for testing Banking APIs. Built using **Java**, **TestNG**, **Rest Assured**, **Maven**, and integrated with **Allure Reporting**


## 📁 Project Structure
banking-api-automation/
│
├── src/
│ ├── main/
│ │ └── java/
│ │ └── utils/ # Utilities like ConfigReader, Logger, etc.
│ └── test/
│ └── java/
│ ├── base/ # Base classes (e.g., BaseTest)
│ ├── tests/ # Test cases for different banking APIs
│ ├── data/ # Test data
│ └── assertions/ # Custom assertions
│
├── testng.xml # TestNG suite config
├── pom.xml # Maven dependencies and plugins
├── allure.properties # Allure config
├── Dockerfile / docker-compose.yml # Docker setup
├── Jenkinsfile # Jenkins CI pipeline
└── README.md # Project documentation


## 🔧 Technologies Used

- **Java 11+**
- **TestNG**
- **Rest Assured**
- **Maven**
- **Allure Reports**
- **Jenkins**
- **MySQL** (optional, for DB validation)
- **Log4j / SLF4J** for logging

---

## 🚀 Getting Started

### Prerequisites

- Java 11+
- Maven 3.6+
- Docker & Docker Compose (optional)
- Allure CLI (for report generation)




