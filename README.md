#  Magento Web Automation Framework

## Overview
This project automates the workflow on Link (https://magento.softwaretestingboard.com/) using Selenium with Java, TestNG, and Maven. to automate a user scenario on the Magento Software Testing Board website.

## Automated Scenario
The framework automates the following end-to-end user flow:

1. **Launch Magento Website**
2. **Create a New User Account** with dynamically generated credentials.
3. **Navigate to the Hot Sellers** section on the Home Page.
4. **Add 2 Products to the Compare List**
5. **Assert** that both products are successfully added


## Prerequisites
Ensure the following are installed before running the automation:
- **Java** 
- **Maven** (for dependency management)
- **Google Chrome** or **FireFox**
-  **IDE** (IntelliJ IDEA)
## Installation
1. **Clone the Repository**:
   ```sh
   git clone <repository-url>
   cd cd <repository-folder>
   ```
2. **Set Up Dependencies**:
    - Ensure `pom.xml` includes dependencies for:
        - Selenium WebDriver
        - TestNG
        - WebDriverManager
    - Run:
      ```sh
      mvn clean install
      mvn test
      ```

## Configuration
- Update `config.properties` with:
  ```properties
  url=https://magento.softwaretestingboard.com/
  firstName=mario
  lastName=Nabil
  password=P@ssw0rd
  confirmPassword=P@ssw0rd
  ```

## Running the Tests
Run tests using TestNG:
```sh
mvn test
```

## Debugging
- For debugging, screenshots are captured in `screenshots/` on failure.

## Reporting
- TestNG reports are generated in `target/surefire-reports/index.html`.


