 @TUGAS
   Feature: Delete User
  Scenario Outline: Delete User with valid id
   Given Delete a user with valid user id <id>
   When send Request delete user
   Then Status code should be 204 No Content
   Examples:
     | id |
     | 1  |
     | 2  |