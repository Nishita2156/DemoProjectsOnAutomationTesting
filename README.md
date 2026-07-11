# QA Automation Engineer - 30-Day Challenge 🚀

![Tests](https://img.shields.io/github/actions/workflow/status/Nishita2156/DemoProjectsOnAutomationTesting/tests.yml?style=flat-square)
![Java](https://img.shields.io/badge/Java-21-orange?style=flat-square)
![Selenium](https://img.shields.io/badge/Selenium-4.15-green?style=flat-square)
![TestNG](https://img.shields.io/badge/TestNG-7.7-blue?style=flat-square)
![RestAssured](https://img.shields.io/badge/RestAssured-5.4-purple?style=flat-square)
![Maven](https://img.shields.io/badge/Maven-3.9-red?style=flat-square)

## 📋 Project Overview

A **comprehensive QA automation testing portfolio** built in 30 days, covering:
- ✅ UI Automation (Selenium WebDriver)
- ✅ API Testing (RestAssured)
- ✅ Database Integration Testing (JDBC/SQLite)
- ✅ Full-Stack Testing (UI + API + DB)
- ✅ Performance & Security Testing
- ✅ Error Handling & Edge Cases

**Total: 214+ Production Tests | 10,000+ Lines of Code**

---

## 📊 Project Statistics

| Category | Count |
|----------|-------|
| **Total Days** | 20/30 Complete |
| **Total Tests** | 214+ |
| **Test Classes** | 20 |
| **Lines of Code** | 10,000+ |
| **Skills Mastered** | 90+ |
| **Pass Rate** | 100% |

---

## 🏗️ Project Structure
DemoProjectsOnAutomationTesting/
├── src/
│   ├── main/java/org/example/
│   │   ├── Day1VariablesBasics.java
│   │   ├── Day2ControlFlow.java
│   │   └── ... (Java fundamentals)
│   └── test/java/org/example/
│       ├── LoginPage.java (POM)
│       ├── ProductPage.java (POM)
│       ├── CartPage.java (POM)
│       ├── DatabaseHelper.java
│       ├── Day8_SeleniumSetup.java
│       ├── Day9_Locators_Mastery.java
│       ├── Day10_WaitsActionsInteractions.java
│       ├── Day11_PageObjectModel.java
│       ├── Day12_TestNGAdvanced.java
│       ├── Day13_CapstoneProject.java (77+ UI tests)
│       ├── Day14_APITestingBasics.java
│       ├── Day15_AdvancedAPITesting.java
│       ├── Day16_ErrorHandlingEdgeCases.java
│       ├── Day17_DatabaseIntegrationTesting.java
│       ├── Day18_FullStackTestingProject.java
│       ├── Day19_PerformanceSecurityTesting.java
│       └── Day20_Week3Capstone.java (Complete Order Management System)
├── pom.xml
├── .github/
│   └── workflows/
│       └── tests.yml (CI/CD Pipeline)
└── README.md
---

## 🧪 Testing Coverage

### Week 1: Java Fundamentals (40+ Programs)
- Variables & Data Types
- Control Flow (if/else, loops)
- Methods & Arrays
- Object-Oriented Programming
- Inheritance & Polymorphism
- QA Testing Theory
- GitHub Portfolio Setup

### Week 2: Selenium UI Automation (77+ Tests)
- **Day 8:** Selenium Setup & Basics
- **Day 9:** Locator Strategies Mastery
- **Day 10:** Waits, Actions & Interactions
- **Day 11:** Page Object Model Pattern
- **Day 12:** TestNG Advanced Features
- **Day 13:** E-Commerce Capstone (Complete workflow testing)

**Test Environment:** SauceDemo (https://www.saucedemo.com)

### Week 3: API & Database Testing (97+ Tests)
- **Day 14:** API Testing Basics (13 tests)
- **Day 15:** Advanced API Testing (19 tests)
- **Day 16:** Error Handling & Edge Cases (20 tests)
- **Day 17:** Database Integration (15 tests)
- **Day 18:** Full-Stack Testing (10 tests)
- **Day 19:** Performance & Security (13 tests)
- **Day 20:** Week 3 Capstone - Order Management System (7 tests)

**Test Environment:** JSONPlaceholder API + SQLite Database

---

## 🎯 Key Testing Patterns

### Page Object Model (POM)
```java
// Encapsulates UI elements and interactions
LoginPage loginPage = new LoginPage(driver);
loginPage.login("standard_user", "secret_sauce");
```

### Database Helper
```java
// Simplifies database operations
DatabaseHelper dbHelper = new DatabaseHelper();
dbHelper.executeUpdate("INSERT INTO orders VALUES (...)");
ResultSet result = dbHelper.executeQuery("SELECT * FROM orders");
```

### RestAssured API Testing
```java
given()
    .header("Content-Type", "application/json")
    .body(requestBody)
.when()
    .post("/posts")
.then()
    .statusCode(201)
    .body("id", notNullValue());
```

---

## 🔧 Technologies Used

| Technology | Version | Purpose |
|------------|---------|---------|
| Java | 21.0.11 | Programming Language |
| Selenium | 4.15.0 | UI Automation |
| TestNG | 7.7.1 | Test Framework |
| RestAssured | 5.4.0 | API Testing |
| Maven | 3.9+ | Build Tool |
| WebDriverManager | 6.3.4 | Driver Management |
| SQLite | 3.42.0 | Database |
| GitHub Actions | Latest | CI/CD Pipeline |

---

## 🚀 Getting Started

### Prerequisites
- Java JDK 21+
- Maven 3.9+
- Chrome/Chromium browser
- Git

### Installation

```bash
# Clone the repository
git clone https://github.com/Nishita2156/DemoProjectsOnAutomationTesting.git

# Navigate to project
cd DemoProjectsOnAutomationTesting

# Install dependencies
mvn clean install

# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=Day13_CapstoneProject

# Run with test report
mvn test -e
```

---

## 📈 Test Execution

### Local Execution
```bash
# Run all tests
mvn clean test

# Run specific week
mvn test -Dtest=Day14*,Day15*,Day16*,Day17*,Day18*,Day19*,Day20*

# Run with detailed logging
mvn test -X
```

### CI/CD Pipeline
Tests automatically run on:
- ✅ Every push to `main` branch
- ✅ Every pull request
- ✅ Every push to `develop` branch

**View Results:** GitHub Actions tab in repository

---

## 💡 Key Achievements

✅ **UI Automation**
- Page Object Model implementation
- 77+ Selenium test cases
- SauceDemo e-commerce testing
- Advanced waits & interactions

✅ **API Testing**
- RESTful API testing with RestAssured
- 65+ API test scenarios
- Authentication & security testing
- Performance & load testing

✅ **Database Testing**
- JDBC integration
- Full CRUD operations
- Transaction testing
- Data integrity validation

✅ **Full-Stack Testing**
- End-to-end workflows (UI → API → DB)
- Complete order management system
- Data consistency across layers

✅ **Security Testing**
- SQL injection prevention
- XSS attack testing
- Sensitive data exposure checks
- HTTPS/TLS verification

✅ **Performance Testing**
- Load testing (concurrent requests)
- Response time percentiles (P50, P95, P99)
- Throughput measurement
- Database query optimization

---

## 📊 Test Results Summary

| Week | Topic | Tests | Status |
|------|-------|-------|--------|
| Week 1 | Java + QA Theory | 40+ | ✅ COMPLETE |
| Week 2 | Selenium UI | 77+ | ✅ COMPLETE |
| Week 3 | API + Database | 97+ | ✅ COMPLETE |
| **TOTAL** | **20/30 Days** | **214+** | **✅ 100% PASS** |

---

## 🎓 Skills Mastered (90+)

**Core Testing:** Automation, Manual Testing, Test Planning, Test Design, Defect Management

**UI Testing:** Selenium WebDriver, Locator Strategies, Page Object Model, TestNG, Data-Driven Testing

**API Testing:** RestAssured, HTTP Methods, JSON/XML, Authentication, Performance Testing

**Database:** JDBC, SQLite, SQL Queries, CRUD Operations, Transactions, Constraints

**Security:** SQL Injection Prevention, XSS Testing, HTTPS Verification, Sensitive Data Protection

**Performance:** Load Testing, Stress Testing, Response Time Analysis, Throughput Measurement

**DevOps:** GitHub Actions, CI/CD Pipelines, Maven, Git Version Control

---

## 🔄 CI/CD Pipeline Status

[![GitHub Actions](https://img.shields.io/github/actions/workflow/status/Nishita2156/DemoProjectsOnAutomationTesting/tests.yml?style=flat-square&logo=github)](https://github.com/Nishita2156/DemoProjectsOnAutomationTesting/actions)

**Latest Test Run:**
- ✅ All tests passing
- 📊 214+ tests executed
- ⏱️ Average runtime: < 5 minutes
- 🎯 Pass rate: 100%

---

## 📝 Test Reports

Test reports are automatically generated and can be viewed at:
target/surefire-reports/
---

## 💼 Professional Portfolio

This project demonstrates:
- ✅ Professional coding practices
- ✅ Test automation expertise
- ✅ Full-stack testing knowledge
- ✅ CI/CD integration
- ✅ Security awareness
- ✅ Performance optimization
- ✅ GitHub proficiency

---

## 🤝 Contributing

This is a personal portfolio project. For improvements or suggestions:
1. Fork the repository
2. Create a feature branch
3. Submit a pull request

---

## 📧 Contact

**GitHub:** [@Nishita2156](https://github.com/Nishita2156)  
**Portfolio:** https://github.com/Nishita2156/DemoProjectsOnAutomationTesting

---

## 📜 License

This project is open source and available under the MIT License.

---

## 🎯 30-Day Challenge Completion Status

| Milestone | Status |
|-----------|--------|
| Week 1 Complete | ✅ Day 7 |
| Week 2 Complete | ✅ Day 13 |
| Week 3 Complete | ✅ Day 20 |
| CI/CD Integration | ✅ Day 21 |
| Interview Ready | ⏳ Day 25 |
| Job Search Ready | ⏳ Day 30 |

---

## 🚀 Next Steps

- [ ] Complete Day 21-22: CI/CD Setup
- [ ] Complete Day 23-25: Interview Preparation
- [ ] Complete Day 26-28: Resume & Portfolio Polish
- [ ] Complete Day 29-30: Job Search Strategy
- [ ] Start applying to QA positions!

---

## 🎉 Thank You

Built with ❤️ during the 30-Day QA Automation Engineer Challenge

**Status: PROFESSIONAL QA AUTOMATION ENGINEER ✅**