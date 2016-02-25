Scenario: User can add one product to cart

Given I am on the main page
When I open catalogue
When I open brand page with the name <brandName>
When I add product with the name <productName> to cart
Then the cart isn't empty

Examples:
|brandName|productName|
|Nike     |AIR        |

Scenario: User can add multiple products to cart

Given I am on the main page
When I open catalogue
When I open brand page with the name <brandName>
When I add product with the name <productName> to cart
Then the cart contains <number> items

Examples:
|brandName|productName|number|
|Nike     |Polo       |2     |

Scenario: User can delete product from cart

When I delete product from cart
Then the cart contains <number> items

Examples:
|brandName  |productName|number|
|Adidas     |AIR        |1     |

Scenario: Product are in cart after refreshing the page

When I refresh the page
Then the cart isn't empty


Scenario: Products are in cart after leaving the cart

When I move to the main page
Then the cart contains <number> items

Examples:
|number|
|1     | 
