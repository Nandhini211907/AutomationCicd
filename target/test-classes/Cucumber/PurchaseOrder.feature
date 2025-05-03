

Feature: Purchase the Order
  I want to use this template for my feature file

Background:
Given I landed on ecom page

  @tag2
  Scenario Outline: Positive Test of Purchasing order
    Given Logged in with username <mailid> and password <password>
    When I Add the product <name> to cart
    And Checkout <name> and submit order
    Then "THANKYOU FOR THE ORDER." message is displayed on confirmationpage

    Examples: 
      | mailid         | password |name           |
      |nandhini@test.in| Nandhini1|ADIDAS ORIGINAL|
