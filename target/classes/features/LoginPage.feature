Feature: HackerRank login page feature


Scenario: Login page title
Given User is on the Hackerrank page
When User gets the title of the page
Then the page title should be  "HackerRank"


Scenario: Forgot password Link
Given user is on the login page
Then Forgot password link should be present


Scenario: Login with valid credentials
Given user is on the login page
When user enters the emails id "Praveenambi9@gmail.com"
And User enters the password "mahadevia"
And User click on the login button
Then User should navigate to the home page and Title should be "My Account"
