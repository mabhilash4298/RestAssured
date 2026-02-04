Feature: Create a new user
  Scenario: Create user with name and job
    Given the API base URI is set
    When I send a POST request to "/users/login" with body:
      | userName |JhonKumar3@Test|
      |passWord|Abhilash@1234|

    Then the response status code should be 200 TokenSet
#    And the response should contain "name" as "John"
#    And the response should contain "job" as "Engineer"
