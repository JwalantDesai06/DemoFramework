Feature: This is my Negative test journey feature file

	@NegativeFlow
	Scenario: This will test a negative login flow and perform some actions
    Given User launch the SauceDemo Url
    Then User checks username in valid username list
    Then User Proved the Username
    Then User Proved the Password
    When User Clicks on login button
    Then User should should see error message
 