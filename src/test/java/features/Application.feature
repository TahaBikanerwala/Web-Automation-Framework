Feature: Login
  Scenario: To Verify user is able to login to the Gmail account with valid credentials
    Given User is on the homepage
    When User clicks on login
    And Enters username
    And Enters password
    Then User should be redirected to emailpage

#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
