@TUGAS
Feature: Get single user
#positive case
  Scenario Outline: Get single user with valid id
    Given Single user with valid id <id>
    When Send request get single user
    Then Status code should be 200 ok
#    And Response body id should be "<id2>"
    And Validate get single user JSON schema "GetSingleUser.json"
    Examples:
      | id | id2 |
      | 2  | 2   |
#negative case
  Scenario Outline: Get single user with exceed id
    Given Single user with exceed parameter <id>
    When Send request get single user
    Then Status code should be 404 not found
    Examples:
      | id    |
      | 400  |
      | 1000 |
