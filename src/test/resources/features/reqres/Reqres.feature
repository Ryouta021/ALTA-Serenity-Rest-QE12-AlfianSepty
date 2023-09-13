Feature: Alta QE BATCH 12
  @LATIHAN
  Scenario Outline: Get list user with valid parameter page
    Given Get list user with valid parameter page <page>
    When Send Request get list users
    Then Status code should be 200 OK
    Examples:
      | page |
      | 1    |
      | 2    |
    @LATIHAN
  Scenario: Post create New user with valid json
    Given Create New user with valid json "User.json"
    When Send request post create new user
    Then Status code should be 201 Created
 @LATIHAN
  Scenario Outline: Put update user with valid json and number id
   Given Update user with valid json "<jsonFile>" and user id <id>
   When Send Request put update user
   Then Status code should be 200 OK
   Examples:
     | id | jsonFile         |
     | 1  | UpdateUser.json  |
     | 2  | UpdateUser2.json |

  @LATIHAN
  Scenario Outline:
   Given Delete a user with valid user id <id>
   When send Request delete user
   Then Status code should be 204 No Content
   Examples:
     | id |
     | 1  |
     | 2  |

