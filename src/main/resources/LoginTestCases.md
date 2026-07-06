# Login Page Test Cases

## TC_001: Valid Login with Correct Credentials
**Precondition:** User is on login page, valid account exists
**Test Steps:**
1. Enter username: "john_doe"
2. Enter password: "SecurePass123"
3. Click Login button
   **Expected Result:** User logged in, redirected to dashboard
   **Priority:** High

## TC_002: Invalid Username
**Precondition:** User is on login page
**Test Steps:**
1. Enter username: "invalid_user"
2. Enter password: "AnyPassword123"
3. Click Login button
   **Expected Result:** Error message: "Username not found"
   **Priority:** High

## TC_003: Invalid Password
**Precondition:** User is on login page
**Test Steps:**
1. Enter username: "john_doe"
2. Enter password: "WrongPassword"
3. Click Login button
   **Expected Result:** Error message: "Password incorrect"
   **Priority:** High

## TC_004: Empty Username Field
**Precondition:** User is on login page
**Test Steps:**
1. Leave username field empty
2. Enter password: "AnyPassword123"
3. Click Login button
   **Expected Result:** Error message: "Username is required"
   **Priority:** High

## TC_005: Empty Password Field
**Precondition:** User is on login page
**Test Steps:**
1. Enter username: "john_doe"
2. Leave password field empty
3. Click Login button
   **Expected Result:** Error message: "Password is required"
   **Priority:** High

## TC_006: Both Fields Empty
**Precondition:** User is on login page
**Test Steps:**
1. Leave both username and password empty
2. Click Login button
   **Expected Result:** Error message: "Username and Password are required"
   **Priority:** High

## TC_007: SQL Injection Attempt
**Precondition:** User is on login page
**Test Steps:**
1. Enter username: "admin' OR '1'='1"
2. Enter password: "anything"
3. Click Login button
   **Expected Result:** Not logged in, error message shown, system secure
   **Priority:** Critical (Security)

## TC_008: Forgot Password Link
**Precondition:** User is on login page
**Test Steps:**
1. Click "Forgot Password?" link
2. Verify page redirects to password reset
   **Expected Result:** Redirected to password reset page
   **Priority:** Medium

## TC_009: Login with Special Characters
**Precondition:** User is on login page
**Test Steps:**
1. Enter username: "user@domain"
2. Enter password: "Pass@123!#$"
3. Click Login button
   **Expected Result:** User logged in successfully
   **Priority:** Medium

## TC_010: Case Sensitivity Test
**Precondition:** User is on login page
**Test Steps:**
1. Enter username: "john_doe" (lowercase)
2. Enter password: "CorrectPass123"
3. Click Login button
   **Expected Result:** Either logs in or error message shown
   **Priority:** Medium