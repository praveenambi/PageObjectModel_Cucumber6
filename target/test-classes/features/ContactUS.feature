Feature: Contact us feature file

Scenario Outline: Contact US scenario with different set of data
Given User navugates to the contact page
When User fill the form using the given Sheet name "<SheetName>" and rownumber <RowNumber>
And User click on the send button
Then user see a success message "Your message has been successfully sent to our team."

Examples: 
|SheetName|RowNumber|
|UserDetails|0|
|UserDetails|1|