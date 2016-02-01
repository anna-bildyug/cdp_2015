    Feature: item details
    
    Scenario: open item details via name link
    Given I find item "iPhone 4S"
    When I press item link
    Then the term nameItem should be in item name
    
    Scenario: open item details via image link
    Given I find item "iPhone 4S"
    When I press image link
    Then the term nameItem should be in item name    