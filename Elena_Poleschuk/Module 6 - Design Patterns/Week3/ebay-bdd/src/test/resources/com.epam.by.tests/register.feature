Feature: register

  Scenario Outline: Enter invalid email during registration
    Given I open register form
    When I set email "<email>"
    Then the error notification "Please enter a valid email address." is displayed

    Examples: 
      | email   |
      | 11tt.hu |
      | 11@tt |
