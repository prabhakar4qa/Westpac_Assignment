$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("/Users/rahularora/Downloads/salesforceautomation/src/test/java/Features/Login.feature");
formatter.feature({
  "line": 1,
  "name": "Salesforce login feature",
  "description": "",
  "id": "salesforce-login-feature",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Login with valid credentials",
  "description": "",
  "id": "salesforce-login-feature;login-with-valid-credentials",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "User is on login page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "User login to the app",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "User is on the Homepage",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginStepDef.user_on_login_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "LoginStepDef.user_login_to_the_app()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "LoginStepDef.user_Navigates_To_HomePage()"
});
formatter.result({
  "status": "skipped"
});
});