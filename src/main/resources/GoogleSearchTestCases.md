# Google Search Page Test Cases

## TC_001: Valid Google Search

**Precondition:**
- User is on the Google Search homepage
- Internet connection is available

**Test Steps:**
1. Enter search keyword: "Playwright Automation"
2. Click the "Google Search" button
3. Wait for the search results page to load

**Expected Result:**
- Search results page is displayed
- Results related to "Playwright Automation" are shown
- Search keyword appears in the search box

**Actual Result:** [Fill after testing]

**Status:** [Pass/Fail]

**Priority:** High (Core search functionality)

**Test Data:**
- Search Keyword: Playwright Automation

---

## TC_002: Search Using Enter Key

**Precondition:**
- User is on the Google Search homepage
- Internet connection is available

**Test Steps:**
1. Enter search keyword: "Selenium WebDriver"
2. Press the Enter key
3. Wait for the search results page to load

**Expected Result:**
- Search is executed successfully
- Search results page is displayed
- Relevant results for "Selenium WebDriver" are shown

**Actual Result:** [Fill after testing]

**Status:** [Pass/Fail]

**Priority:** Medium

**Test Data:**
- Search Keyword: Selenium WebDriver

---

## TC_003: Verify Search Suggestions

**Precondition:**
- User is on the Google Search homepage
- Internet connection is available

**Test Steps:**
1. Type "Weather" in the search box
2. Observe the autocomplete suggestions

**Expected Result:**
- Search suggestions are displayed in a dropdown
- Suggestions are relevant to the entered text
- User can select any suggestion

**Actual Result:** [Fill after testing]

**Status:** [Pass/Fail]

**Priority:** Medium

**Test Data:**
- Partial Search Text: Weather

---

## TC_004: Search with Special Characters

**Precondition:**
- User is on the Google Search homepage
- Internet connection is available

**Test Steps:**
1. Enter search keyword: "@#$%^&*()"
2. Click the "Google Search" button
3. Wait for the results page to load

**Expected Result:**
- Application handles special characters gracefully
- No system error or crash occurs
- Search results or relevant message is displayed

**Actual Result:** [Fill after testing]

**Status:** [Pass/Fail]

**Priority:** Low

**Test Data:**
- Search Keyword: @#$%^&*()

---

## TC_005: Search with Empty Input

**Precondition:**
- User is on the Google Search homepage
- Internet connection is available

**Test Steps:**
1. Leave the search box empty
2. Click the "Google Search" button

**Expected Result:**
- No search is executed
- User remains on the Google homepage
- No application error is displayed

**Actual Result:** [Fill after testing]

**Status:** [Pass/Fail]

**Priority:** Medium

**Test Data:**
- Search Keyword: Empty/Blank Input

---

**Total Test Cases:** 5  
**High Priority:** 1  
**Medium Priority:** 3  
**Low Priority:** 1