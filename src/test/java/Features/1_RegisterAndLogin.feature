Feature: RegisterAndLogin Scenarios

  Scenario: RegisterAndLogin
    Given user open HomePage and click on login
    When user Enter Username, Password
    And user click on Register button
    Then Assert that user can login by Username, Password and display Welcome username in HomePage
