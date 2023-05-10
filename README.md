# 🚀 Java-Selenium Course Final Project - Abstracta | Test Automation for Online Clothing Store

⚠️ This repository contains information about the test automation for an online clothing store.

The Final Test Automation is a project for the software test automation course, which involves designing test cases for key functionalities, creating 5 automated tests using Selenium WebDriver and TestNG, applying the Page Object pattern, and generating reports with Allure. The test suite is designed to explore and validate the functionalities of the online clothing store at http://magento-demo.lexiconn.com.

## 📚 Table of Contents
- [🧠 Mindmap Overview](https://github.com/florencialecha/madison-island-qa-automation-java-selenium/blob/main/README.md#-mindmap-overview)
- [🌟 Features](https://github.com/florencialecha/madison-island-qa-automation-java-selenium/blob/main/README.md#-features)
- [🎯 Overview](https://github.com/florencialecha/madison-island-qa-automation-java-selenium/blob/main/README.md#-overview)
- [💻 Technologies](https://github.com/florencialecha/madison-island-qa-automation-java-selenium/blob/main/README.md#-technologies)
- [⚙️ Setup](https://github.com/florencialecha/madison-island-qa-automation-java-selenium/blob/main/README.md#%EF%B8%8F-setup)
- [🚀 Usage](https://github.com/florencialecha/madison-island-qa-automation-java-selenium/blob/main/README.md#-usage)
- [📊 Allure Reports](https://github.com/florencialecha/madison-island-qa-automation-java-selenium/blob/main/README.md#-allure-reports)
- [📃 Test Scenarios](https://github.com/florencialecha/madison-island-qa-automation-java-selenium/blob/main/README.md#-test-scenarios)
- [🛠️ Next Steps]()
- [👩‍💻 About the Developer](https://github.com/florencialecha/madison-island-qa-automation-java-selenium/blob/main/README.md#-about-the-developer)

## 🧠 Mindmap Overview
![MadisonIslandMindMap - v2](https://user-images.githubusercontent.com/106263642/236925054-a8a6743b-2bdd-4721-8a64-c718839c8b3a.png)

## 🌟 Features
- Exploration session to understand the domain and functionalities
- Design of test cases for key functionalities
- 5 automated tests using Selenium WebDriver and TestNG
- Test suite in testng.xml
- Page Object pattern applied to all tests
- Data Provider for one test with two sets of data
- Allure reports for test results

## 🎯 Overview
For the final test automation project, we have immersed ourselves in exploring the online clothing store and identifying key functionalities that could be interesting to automate. This repository contains 5 automated tests for the application, designed to cover various user flows and ensure the system's reliability.

Feel free to explore the repository to gain a deeper understanding of the test automation process and the decisions made throughout the creation of these automated tests.

## 💻 Technologies
- Java
- Selenium WebDriver
- TestNG
- Maven
- Allure Reports
- GitHub

## ⚙️ Setup
- Clone the repository
- Install Java and Maven
- Configure the WebDriver according to your browser
- Update the testng.xml file with the desired test suite configuration

## 🚀 Usage
- Build the project using Maven: `mvn clean install`
- Run the test suite: `mvn test`
- Generate Allure reports: `mvn allure:serve`

## 📊 Allure Reports
After running the tests, view the Allure reports generated to analyze the test results and identify any issues or improvements needed.

## 📃 Test Scenarios
- **Search for Available Clothing Items:** This test verifies that users can easily search for and find the products they want using various search criteria, filters, and navigation through product categories.
- **Filtered Search Test:** This test ensures that users can apply different combinations of filters to search results (e.g., price range, color, size) and obtain results that match both the search keyword and the applied filter.
-  **No Results Search Test:** This test serves as a negative test case, verifying that the search functionality returns no results and displays an appropriate message when the user inputs an invalid or non-existent search keyword.
- **Product Details from Search Test:** This test ensures that users can access product details from search results, displaying relevant information such as product images, description, price, and available sizes/colors.

The criteria for choosing these test scenarios were based on the following factors:
- High impact on the user experience.
- Critical functionalities for the online store's operation.
- Ensuring the search functionality works with various inputs and filters.
- Proper handling of negative test cases and special characters.
- Ease of navigation through product categories and access to product details.
- Frequent execution requirement, which reduces costs associated with manual testing.

By focusing on these test cases, the testing suite ensures that users can effectively navigate the store's catalog, find desired products, and access relevant product information. Additionally, these tests help to verify the robustness and reliability of the search functionality. Automating these tests, which need to be executed frequently, reduces the time and resources spent on manual testing, leading to more efficient testing processes and cost savings.
[Test Cases] (https://docs.google.com/spreadsheets/d/1Ar-mBKZa_ANOgNw-iFRsttCOSc7ret6GbcdpJ8nrZ_4/edit?usp=sharing)

## 🛠️ Next Steps
- Refactor duplicated test methods such as opening the home page, product search, page title checking, and page path checking.
- Evaluate the use of data-driven testing and if there is room for improvement in data handling.
- Consider breaking down catalogSearchPage and DetailsProductPage into smaller components to enable method reusability such as title checking and breadcrumbs checking.
- Expand test coverage to include all categories and subcategories, login, sign in, and add to cart functionalities.

## 👩‍💻 About the Developer
Hi, I'm [Florencia](https://www.linkedin.com/in/florencialecha/), the developer of this project. I'm a software engineer with a strong focus on test automation and quality assurance. My passion lies in creating clean, maintainable, and efficient test suites that ensure the reliability and performance of software systems. I continuously strive to enhance my skills and deliver high-quality solutions that meet both business and user needs.
Feel free to connect with me on [LinkedIn](https://www.linkedin.com/in/florencialecha/) or check out my [GitHub](https://github.com/florencialecha) for more projects.
