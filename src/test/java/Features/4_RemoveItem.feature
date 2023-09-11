Feature: Remove Items Scenarios

  Scenario: Remove item from cart
    Given User open HomePage and login
    When click on Cart Page
    And Click on Delete Item
    Then Assert That Item "Samsung galaxy s6" not found in CartList