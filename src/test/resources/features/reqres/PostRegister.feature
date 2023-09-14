@TUGAS
Feature: Register
#    positive case
  Scenario: Post Register with valid json
    Given Register with valid json "RegisterValid.json"
    When Send request post register
    Then Status code should be 200 ok
#    negative case
  Scenario: Post Register with invalid json
    Given Register with invalid json "RegisterInvalid.json"
    When Send request post register
    Then Status code should be 400 Bad Request