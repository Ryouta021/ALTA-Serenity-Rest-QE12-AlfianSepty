@TUGAS
Feature: Login
#    positive case
  Scenario: Post login with valid json
    Given login with valid json "Account.json"
    When Send request post login
    Then Status code should be 200 ok
#    negative case
  Scenario: Post login with invalid json
    Given login with invalid json "InvalidAccount.json"
    When Send request post login
    Then Status code should be 400 Bad Request
    And Validate Post Login user JSON Schema "LoginUserInvalid.json"