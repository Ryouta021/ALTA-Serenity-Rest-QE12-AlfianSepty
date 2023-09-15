@TUGAS
Feature: Update USER
#  positive case
Scenario Outline: Put update user with valid json and number id
Given Update user with valid json "<jsonFile>" and user id <id>
When Send Request put update user
Then Status code should be 200 ok
And Response body name should be "<name>" and job was "<job>"
And Validate update user JSON schema "UpdateUserSchema.json"
Examples:
  | id | jsonFile         | name     | job                 |
  | 1  | UpdateUser.json  | morpheus | zion resident       |
  | 2  | UpdateUser2.json | Alfian   | Quality Engineering |

# negative case
Scenario: Put update user with invalid json and number id
  Given Update user with invalid json "InvalidUpdateUser.json" and invalid user "id"
  When Send Request put update user
  Then Status code should be 404 not found