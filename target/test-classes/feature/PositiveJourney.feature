Feature: This is my Positive test journey feature file

  @PositiveFlow
  Scenario: This will test a postive login flow and perform some actions
    Given User launch the SauceDemo Url
    Then User Proved the Username
    Then User Proved the Password
    When User Clicks on login button
    Then User should log into the Products page
    Then User should check products availability
    Then User clicks on product
    Then User should add product to cart
    Then User should go to cart and check product added
    Then User should click on checkout
    Then User should enter details for delivery and click on continue
    Then User shoudl capture order details
    Then Click on finish
    Then User should check order placed sucessfully
    Then User should navigate back to home
    Then User should log out of the application
 