Feature: Product of chanel

  Background:
    Given The user access to the site


  Scenario: search Product into seachbar
    Given  The user click on the search bar
    When The User search for word into search bar "ROUGE ALLURE"
    And  The user Check if the displayed list items contain the desired word
    And  The user Select the second item from the list
    Then Verify that the product name displayed is the same as the one previously selected..


  Scenario: Add product to cart
    Given The user access to the Makeup category
    And The user Click on the RED ALLURE product
    And Add product to cart
    Then Verify the quantity and the total basket is equal to the price of the product






