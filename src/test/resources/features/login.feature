Feature: User Login

  Scenario: Successful login with valid credentials
    Given the user navigates to the login page
    When the user enters email "i202332634@cibertec.pe" and password "Test@12345"
    And clicks on the login button
    Then the user should see the name "Renán" in the page header

  Scenario: Failed login with wrong password
    Given the user navigates to the login page
    When the user enters email "i202332634@cibertec.pe" and password "wrongpass"
    And clicks on the login button
    Then the user should see the login warning "Warning: No match for E-Mail Address and/or Password."