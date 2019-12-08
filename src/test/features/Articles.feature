@all
@articles
Feature: Articles

  Background:
    Given User logs in

  # Кол-во статей по разделам - неизменяемое и является очень важдным для заказчика показателем
  @articlesinsection
  Scenario Outline: Check section and articles quantity
    When User checks articles quantity 0
    And User opens section <section>
    Then User checks articles quantity <quantity>
    Examples:
      | section           | quantity |
      | Advertisers       | 2        |
      | Publishers        | 2        |
      | Top level clients | 10       |

