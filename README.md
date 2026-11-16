# Contact Service — Java & JUnit 5 Testing

**Java · JUnit 5 · Input validation · CRUD operations**  
*SNHU CS 320: Software Testing, Automation, and Quality Assurance — Academic project*

A small in-memory contact-management service built around explicit validation rules. I implemented the `Contact` data model and `ContactService` operations, then wrote unit tests that check valid workflows, boundary conditions, and failure behavior.

## What it demonstrates

- Creating, looking up, updating, and deleting contact records.
- Rejecting duplicate IDs and missing contacts.
- Enforcing field constraints and preserving the contact ID.
- Testing that an invalid update **does not partially modify** a stored contact.
- Separating domain validation from service-level operations.

## Rules and tests

| Contact field | Rule enforced |
| --- | --- |
| Contact ID | Required, maximum 10 characters, immutable after creation |
| First name | Required, maximum 10 characters |
| Last name | Required, maximum 10 characters |
| Phone | Exactly 10 numeric digits |
| Address | Required, maximum 30 characters |

The test classes contain **18 `@Test` methods in `ContactTest.java` and 11 in `ContactServiceTest.java`** (29 methods total). This is a count of methods in the repository, **not a claim that tests were run or passed in this update**.

## Code structure

| File | Responsibility |
| --- | --- |
| [Contact.java](Contact.java) | Contact model, setters, and validation |
| [ContactService.java](ContactService.java) | In-memory CRUD operations |
| [ContactTest.java](ContactTest.java) | Contact construction, limits, and invalid input tests |
| [ContactServiceTest.java](ContactServiceTest.java) | Service workflows, duplicates, missing IDs, and atomic update behavior |
| [Project Two reflections](CS320_Project_Two_Summary_and_Reflections_Fernando_Rivas.docx) | Original written testing report |
| [Original README/reflection](docs/reflection.md) | Course portfolio reflection preserved intact |

## Running the tests in Eclipse

1. Create a Java project in Eclipse.
2. Add the four `.java` files above to `src` (the code uses the default package).
3. Add **JUnit 5** to the project's build path.
4. Right-click `ContactTest.java` or `ContactServiceTest.java` and choose **Run As → JUnit Test**.

No database or web server is required. Because this portfolio does not include a Maven or Gradle build file, no command-line build is represented as verified.

## Testing approach

The code uses `assertEquals`, `assertThrows`, `assertSame`, and other JUnit assertions to verify both expected results and error handling. The service builds a validated replacement contact before changing an existing one, protecting stored fields from partial updates after invalid input.

**Coverage note:** No coverage percentage is claimed here; an accurate value should come from running coverage tooling on this exact revision.

[GitHub profile](https://github.com/Fernando-2) · [Portfolio](https://frflux.com)
