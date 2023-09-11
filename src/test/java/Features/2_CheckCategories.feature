Feature: Check the listed Categories has Items Scenarios

  Scenario: Phones
    Given user open HomePage
    When  click on Phones
    Then Assert that results of Phones Contains "Phone"


  Scenario: laptops
    Given user open HomePage
    When  click on laptops
    Then Assert that results of laptops Contains "laptop"



  Scenario: monitors
    Given user open HomePage
    When  click on monitors
    Then Assert that results of Monitors Contains "monitor"