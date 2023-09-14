Feature: Alta QE BATCH 12
  @LATIHAN
  Scenario Outline: Get list user with valid parameter page
    Given Get list user with valid parameter page <page>
    When Send Request get list users
    Then Status code should be 200 OK
    And Response body page should be <page>
    And Validate get list user JSON Schema "ListUserSchema.json"
    Examples:
      | page |
      | 1    |
      | 2    |
    @LATIHAN
  Scenario: Post create New user with valid json
    Given Create New user with valid json "User.json"
    When Send request post create new user
    Then Status code should be 201 Created
    And  Response body name should be "Alfian" and job was "leader"
    And  Validate create a new user JSON schema "CreateUserSchema.json"
 @LATIHAN
  Scenario Outline: Put update user with valid json and number id
   Given Update user with valid json "<jsonFile>" and user id <id>
   When Send Request put update user
   Then Status code should be 200 OK
   And Response body name should be "<name>" and job was "<job>"
   And Validate update user JSON schema "UpdateUserSchema.json"
   Examples:
     | id | jsonFile         | name     | job                 |
     | 1  | UpdateUser.json  | morpheus | zion resident       |
     | 2  | UpdateUser2.json | Alfian   | Quality Engineering |
  @LATIHAN
  Scenario Outline:
   Given Delete a user with valid user id <id>
   When send Request delete user
   Then Status code should be 204 No Content
   Examples:
     | id |
     | 1  |
     | 2  |