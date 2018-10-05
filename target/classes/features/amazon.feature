Feature: amazon shoping Feature

Scenario Outline: amazon Feature

Given user is Flipcart login Page
When user_enter_username_and_password
Then user is on Home page
Then user search items "<item1>" and add item to cart
Then user remove item from cart
Then user update shiping address 


Examples:
	| item1 | item2 |
	| Boat Ear Phone  | Fastrack watch |
