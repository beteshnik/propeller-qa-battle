@all
@authorization
Feature: Authorization

  @authorization
  Scenario Outline: Authorization with correct data
    When User logs in with <login> and <password>
    And User chooses <decision1> in the alert
    And User chooses <decision2> in the alert
    Then User checks Main page opens <result>
    Examples:
      | login | password | decision1 | decision2 | result |
  #with correct data
      | test  | test     | accept    | accept    | true   |
  #with incorrect login, password
      | test1 | test3    | accept    | accept    | false  |
  #without alert acception
      | test1 | test     | accept    | accept    | false  |

