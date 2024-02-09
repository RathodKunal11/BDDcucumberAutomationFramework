Feature: Create Alumni


Scenario Outline: Verify that the user can create alumni successfully
Given user is on alumni landing page
When user clicks on the create alumni button
And enters the data "<SheetName>" and <RowNum> into all mandatory fields
And click on the create button
Then alumni record should be display in the first row of alumni detail table

Examples: 
|SheetName|RowNum|
|CreateAlumni|0|
