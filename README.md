📚 Bookstore API Automation Framework with CI/CD (RestAssured + TestNG)
💻 Tech Stack Overview
| Component            | Description                                                      |
| -------------------- | ---------------------------------------------------------------- |
| 🧠 **IDE**           | IntelliJ IDEA / Eclipse                                          |
| ☕ **Language**       | Java 11+                                                         |
| 🔄 **Framework**     | RestAssured + TestNG – Structured, maintainable API automation   |
| 🛠 **Build Tool**    | Maven – Dependency & build management                            |
| 📊 **Reporting**     | Allure Report – Rich UI for test results & trends                |
| ✅ **Test Execution** | TestNG – Parallel execution, flexible grouping, retry mechanisms |
| 🚀 **CI/CD**         | GitHub Actions – Automates test execution + artifact upload      |


🧪 Why This Stack?
✅ TestNG over JUnit:

Better test orchestration: parallel execution, dependencies, retry logic

Better compatibility with Maven + Allure

Fits non-Spring Boot projects

✅ Allure Reporting:

Visual test case dashboards

Categorizes issues (Product issues vs. Test issues)

Tracks historical trends across builds

Integrated seamlessly in GitHub Actions CI/CD

✨ Project Highlights:
✅ CRUD API Automation:
Covers end-to-end operations for books API:

Endpoint	Operation
POST /books	Create a new book
GET /books/{id}	Get book by ID
PUT /books/{id}	Update book by ID
GET /books	Get all books
DELETE /books/{id}	Delete book by ID

✅ Test Scenarios Implemented:

✅ Positive & negative tests

✅ Request chaining: ID created in POST → reused in GET/PUT/DELETE

✅ Validation tests (e.g., missing required fields, invalid price)

✅ Header validation

✅ Error handling (404, 422)

✅ Utilities:

RequestBuilder.java → builds reusable RestAssured specs

ConfigManager.java → fetches baseUrl based on environment (dev/qa/prod)

ResponseValidator.java → reusable assertions for status code, headers

✅ Configurable Environment:

config.properties allows switching API environments via system property -Denv=qa

✅ CI/CD with GitHub Actions:

Installs Maven, builds project

Executes tests

Generates & uploads Allure reports

🚀 How to Set Up & Run Locally
1️⃣ Prerequisites:

Java 11+

Maven

FastAPI server running locally (or in test env)

2️⃣ Clone Repository:

bash
Copy
Edit
git clone <repo-url>
3️⃣ Update config if needed:
Edit src/test/resources/config.properties to point base.url to your API server.

4️⃣ Run Tests:

bash
Copy
Edit
mvn clean test
5️⃣ Generate Allure Report:

bash
Copy
Edit
mvn allure:serve
🔄 CI/CD Workflow (GitHub Actions)
Every push to main triggers:

Checkout code

Set up JDK + Maven

Cache Maven dependencies

Run tests

Upload Allure results as artifact

Generate Allure report

✅ No Jenkins needed
✅ .github/workflows/api-tests.yml preconfigured

📝 How This Framework Meets Requirements:
 Comprehensive CRUD test coverage

 Positive + Negative + Validation scenarios

 Request chaining between tests

 Reusable utility classes

 Configurable environments

 Allure reporting for insights

 CI/CD integration via GitHub Actions

📁 Artifacts & Reports:
Test results → /target/allure-results

Reports → /target/allure-report

