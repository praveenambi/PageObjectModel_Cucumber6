Feature: Hacker Rank dashboard page

Background:
Given User is already logged into the application
|Username|Password|
|praveenambi9@gmail.com|mahadevia|


Scenario: Dashboard page title
Given User is on the dashboard page
When user gets the title of the page
Then title of the page should be " Dashboard | HackerRank"


Scenario: Bottom Links count 
Given User is on the Dashboard page
Then User gets the links count
|Contest Calendar|
|Blog|
|Scoring|
|Environment|
And Links count should be 7