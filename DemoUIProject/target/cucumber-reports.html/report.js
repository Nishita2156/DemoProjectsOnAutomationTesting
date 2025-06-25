$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/main/java/com/demo/features/Demo.feature");
formatter.feature({
  "name": "Automation Practice App Testing",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "User Registration and Login",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the user launches the automation app",
  "keyword": "Given "
});
formatter.match({
  "location": "com.demo.bdd.AutomationSteps.launchApp()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user registers with username \"testuser\" and password \"testpass\"",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the user logs in with username \"testuser\" and password \"testpass\"",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "the user should see the dashboard",
  "keyword": "Then "
});
formatter.match({
  "location": "com.demo.bdd.AutomationSteps.verifyDashboard()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "Modal and Popup Test",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the user is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "com.demo.bdd.AutomationSteps.ensureLoggedIn()"
});
formatter.result({
  "error_message": "org.openqa.selenium.TimeoutException: Expected condition failed: waiting for visibility of element located by By.id: loginUsername (tried for 10 second(s) with 500 milliseconds interval)\nBuild info: version: \u00274.26.0\u0027, revision: \u00278ccf0219d7\u0027\nSystem info: os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u002717.0.4.1\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 137.0.7151.120, chrome: {chromedriverVersion: 137.0.7151.119 (e0ac9d12dff..., userDataDir: C:\\Users\\NISHIT~1\\AppData\\L...}, fedcm:accounts: true, goog:chromeOptions: {debuggerAddress: localhost:59641}, networkConnectionEnabled: false, pageLoadStrategy: normal, platformName: windows, proxy: Proxy(), se:cdp: ws://localhost:59641/devtoo..., se:cdpVersion: 137.0.7151.120, setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:extension:credBlob: true, webauthn:extension:largeBlob: true, webauthn:extension:minPinLength: true, webauthn:extension:prf: true, webauthn:virtualAuthenticators: true}\nSession ID: e5c244cfe6a0d39a3b74ca0dedb37292\r\n\tat org.openqa.selenium.support.ui.WebDriverWait.timeoutException(WebDriverWait.java:84)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:228)\r\n\tat com.demo.bdd.AutomationSteps.loginUser(AutomationSteps.java:45)\r\n\tat com.demo.bdd.AutomationSteps.ensureLoggedIn(AutomationSteps.java:60)\r\n\tat ✽.the user is logged in(file:///C:/Users/Nishita%20Jannat%20Alam/Desktop/NewWorkspace/DemoUIProject/src/main/java/com/demo/features/Demo.feature:10)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "the user opens the modal",
  "keyword": "When "
});
formatter.match({
  "location": "com.demo.bdd.AutomationSteps.openModal()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the modal should display correct content",
  "keyword": "Then "
});
formatter.match({
  "location": "com.demo.bdd.AutomationSteps.validateModalContent()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "Hover and List Update",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the user is logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "com.demo.bdd.AutomationSteps.ensureLoggedIn()"
});
formatter.result({
  "error_message": "org.openqa.selenium.TimeoutException: Expected condition failed: waiting for visibility of element located by By.id: loginUsername (tried for 10 second(s) with 500 milliseconds interval)\nBuild info: version: \u00274.26.0\u0027, revision: \u00278ccf0219d7\u0027\nSystem info: os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u002717.0.4.1\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities {acceptInsecureCerts: false, browserName: chrome, browserVersion: 137.0.7151.120, chrome: {chromedriverVersion: 137.0.7151.119 (e0ac9d12dff..., userDataDir: C:\\Users\\NISHIT~1\\AppData\\L...}, fedcm:accounts: true, goog:chromeOptions: {debuggerAddress: localhost:59673}, networkConnectionEnabled: false, pageLoadStrategy: normal, platformName: windows, proxy: Proxy(), se:cdp: ws://localhost:59673/devtoo..., se:cdpVersion: 137.0.7151.120, setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:extension:credBlob: true, webauthn:extension:largeBlob: true, webauthn:extension:minPinLength: true, webauthn:extension:prf: true, webauthn:virtualAuthenticators: true}\nSession ID: 2766a186b395fc755878b8fa740dd7e8\r\n\tat org.openqa.selenium.support.ui.WebDriverWait.timeoutException(WebDriverWait.java:84)\r\n\tat org.openqa.selenium.support.ui.FluentWait.until(FluentWait.java:228)\r\n\tat com.demo.bdd.AutomationSteps.loginUser(AutomationSteps.java:45)\r\n\tat com.demo.bdd.AutomationSteps.ensureLoggedIn(AutomationSteps.java:60)\r\n\tat ✽.the user is logged in(file:///C:/Users/Nishita%20Jannat%20Alam/Desktop/NewWorkspace/DemoUIProject/src/main/java/com/demo/features/Demo.feature:15)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "the user hovers over the menu",
  "keyword": "When "
});
formatter.match({
  "location": "com.demo.bdd.AutomationSteps.hoverMenu()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the hover menu should appear",
  "keyword": "Then "
});
formatter.match({
  "location": "com.demo.bdd.AutomationSteps.checkHoverMenu()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the user adds a new list item",
  "keyword": "When "
});
formatter.match({
  "location": "com.demo.bdd.AutomationSteps.addItem()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the item count should increase",
  "keyword": "Then "
});
formatter.match({
  "location": "com.demo.bdd.AutomationSteps.verifyItemAdded()"
});
formatter.result({
  "status": "skipped"
});
});