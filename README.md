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
- [👩‍💻 About the Developer](https://github.com/florencialecha/madison-island-qa-automation-java-selenium/blob/main/README.md#-about-the-developer)

## 🧠 Mindmap Overview
![Madison Island MindMap](https://user-images.githubusercontent.com/106263642/235736608-9601c393-abb6-4aa8-940e-603008706546.png)

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
1. **User registration and authentication:** This test ensures that users can successfully create accounts and log into them. Verifying that authentication works properly is crucial for the user experience and the platform's security. The test should cover the registration process, form validation, and login functionality.
2. **Browse and search for available clothing items:** This test verifies that users can easily search for and find the products they want. Testing this functionality ensures that users can effectively navigate the store's catalog. The test should cover various search criteria, filters, and navigation through product categories.
3. **Add items to the shopping cart and proceed to checkout:** This test is critical for the online store's operation, as it allows users to add products to their cart and complete the purchase. Ensuring that this process runs smoothly is essential for maintaining customer satisfaction and sales. The test should cover adding different products to the cart, updating the cart, and going through the entire checkout process.
4. **Apply discounts and promotions during checkout:**  This test ensures that discounts and promotions are correctly applied at the time of payment, making sure customers receive the expected offers and that the billing system is accurate. The test should cover the application of various discount codes, promotional offers, and their validation during the checkout process.
5. **Manage user account settings and order history:** This test verifies that users can manage their accounts, such as changing passwords, updating contact information, and reviewing their order history. Testing this functionality ensures that the online store maintains user data security and privacy while offering a good customer experience. The test should cover different account management actions and the ability to view and interact with order history.

The criteria for choosing these test scenarios were based on the following factors:
- High impact on the user experience
- Critical functionalities for the online store's operation
- Ensuring correct price calculation and payment processing
- Verification of proper application of discounts and promotions
- Maintaining the security and privacy of user data

## 👩‍💻 About the Developer
Hi, I'm [Florencia](https://www.linkedin.com/in/florencialecha/), the developer of this project. I'm a software engineer with a strong focus on test automation and quality assurance. My passion lies in creating clean, maintainable, and efficient test suites that ensure the reliability and performance of software systems. I continuously strive to enhance my skills and deliver high-quality solutions that meet both business and user needs.
Feel free to connect with me on [LinkedIn](https://www.linkedin.com/in/florencialecha/) or check out my [GitHub](https://github.com/florencialecha) for more projects.
