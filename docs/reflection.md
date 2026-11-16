# CS 320: Software Testing, Automation, and Quality Assurance

**Fernando Rivas**

This portfolio contains my Contact Service implementation and JUnit tests from Project One, along with my summary and reflections report from Project Two. The projects helped me connect software requirements to specific tests and think more carefully about how I verify my own code.

## Project Artifacts

| File | Purpose |
| --- | --- |
| [Contact.java](ContactService/Contact.java) | Defines a contact, validates its fields, and keeps the contact ID from changing. |
| [ContactService.java](ContactService/ContactService.java) | Stores contacts in memory and supports adding, finding, updating, and deleting contacts. |
| [ContactTest.java](ContactService/ContactTest.java) | Tests contact creation, field limits, null values, valid updates, and invalid inputs. |
| [ContactServiceTest.java](ContactService/ContactServiceTest.java) | Tests service operations, duplicate IDs, missing contacts, and preservation of original data after an invalid update. |
| [Project Two Summary and Reflections Report](ProjectTwo/CS320_Project_Two_Summary_and_Reflections_Fernando_Rivas.docx) | Explains my testing approach and reflects on the contact, task, and appointment services. |

The Contact Service uses Java and JUnit 5. It stores data in memory and does not require a database or user interface.

## How can I ensure that my code, program, or software is functional and secure?

I can build confidence in my software by using the requirements as a checklist and testing both successful behavior and error conditions. In the Contact Service, I wrote JUnit tests for creating contacts, updating information, deleting contacts, and rejecting duplicate IDs. I also tested null values, character limits, and phone numbers containing invalid characters. One useful test checks that an invalid update leaves the original contact information unchanged. Reviewing coverage helps me find code that my tests have not exercised, but passing tests and high coverage do not prove that every defect has been found. For security, I would combine input validation with code review, dependency checks, and appropriate access controls when building a complete application. I would also keep sensitive information out of the source code and rerun regression tests after changes.

## How do I interpret user needs and incorporate them into a program?

I start by identifying what the user needs the program to do and turning those needs into clear, testable requirements. For this project, that meant supporting contact management while following rules such as limiting contact IDs to 10 characters and requiring phone numbers to contain exactly 10 digits. I connected each rule to validation in the code and tests that checked whether the rule was followed. I also considered what should happen when something goes wrong, such as adding a duplicate ID or looking up a contact that does not exist. If a requirement is unclear, I would ask the stakeholder for clarification instead of assuming what they meant. This approach helps me build behavior that matches the user's expectations and gives me a way to verify it.

## How do I approach designing software?

I approach software design by breaking the problem into smaller parts with clear responsibilities. In this project, the Contact class handles contact data and field validation, while ContactService manages the collection and its operations. Keeping those responsibilities separate made it easier to understand the code and test each part. I also tried to prevent problems through design, such as making the contact ID immutable and validating all proposed changes before updating an existing contact. I prefer starting with a straightforward solution that meets the requirements, then improving it as testing reveals issues. This course reinforced that testing belongs throughout development because it helps me evaluate design decisions and catch mistakes before they become harder to fix.

## Running the Contact Tests

Add all four Java files from the ContactService folder to a Java project's source folder and include JUnit 5 on the build path. The files use the default Java package. Run ContactTest and ContactServiceTest as JUnit tests.
