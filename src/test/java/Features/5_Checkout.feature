Feature: Complete successful checkout with random item

  Scenario: Complete checkout
    Given user open HomePage and click on Item
    When click Add to Cart In ItemPage and navigate to CartPage
    And Click on Place Order
    And Fills required Data
    Then Assert that display Successfully message "Thank you for your purchase!"