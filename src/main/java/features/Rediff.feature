Feature: Rediff Sample Feature

Scenario: Rediff webtable Feature

Given user is on rediff home Page
When user select groupZ under loser weekly tab 
Then user is reading table data
Then user store table data into hashmap
Then user store map data into excel data
Then close browser
