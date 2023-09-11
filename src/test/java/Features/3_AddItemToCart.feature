Feature: Add random item to the cart Scenarios

  Scenario: Add item to the cart
    Given User open HomePage and login
    When Click on Samsung galaxy s6 Item
    And Click on Add To Cart
    Then Assert that display "Samsung galaxy s6" Item in CartPage