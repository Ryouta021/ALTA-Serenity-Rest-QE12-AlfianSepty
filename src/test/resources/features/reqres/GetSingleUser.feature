@TUGAS
Feature: Get single user
#positive case
  Scenario Outline: Get single user with valid parameter page
    Given Single user with valid parameter <page>
    When Send request get single user
    Then Status code should be 200 ok
    Examples:
      | page |
      | 1 |
      | 2 |
#negative case
  Scenario Outline: Get single user with exceed parameter page
    Given Single user with exceed parameter <page>
    When Send request get single user
    Then Status code should be 404 not found
    Examples:
      | page    |
      | 400  |
      | 1000 |
