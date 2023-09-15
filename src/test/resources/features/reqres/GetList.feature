@TUGAS
  Feature: Get list resource in reqres
#    positive case
  Scenario Outline: Get list resources with valid parameter page
    Given Get list resouces with valid parameter page <page>
    When Send Request get list resources
    Then Status code should be 200 ok
    And Response body page should be <page>
    And Validate get list user JSON Schema "GetListResource.json"
    Examples:
      | page |
      | 1    |
      | 2    |
#    negative case
    Scenario Outline: Get list resources with wrong JSON Schema
      Given Get list resouces with valid parameter page <page>
      When Send Request get list resources
      Then Status code should be 200 ok
      And Response body page should be <page>
      And Validate get list user JSON Schema "UpdateUserSchema.json"
      Examples:
        | page |
        | 1    |
        | 2    |

    Scenario Outline: Get list resources with wrong JSON Schema
      Given Get list resouces with valid parameter page "<page1>"
      When Send Request get list resources
      Then Status code should be 404 not found
      Examples:
        | page1  |
        | @@page |