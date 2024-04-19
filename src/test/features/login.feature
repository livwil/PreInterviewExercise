Feature: User Login and Shopping Cart

Scenario: Successful login and adding an item to the cart
  Given the user navigates to the login page
  When the user logs in with valid credentials
  Then the login should be successful
  And the user identifies the highest-priced item and add that item to the shopping cart
  Then the item should be successfully added to the cart