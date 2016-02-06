Feature: login

  Scenario: logout
    Given I login with userName "elenpoleschu_0" and password "London1+"
    When I sign out
    Then message about sign out "You've signed out. See you again soon!" is displayed

  Scenario: login with correct data
    Given I enter userName "elenpoleschu_0" and password "London1+"
    When I perfom submit
    Then drop in to the main page
