@all
@profile
Feature: Profile

  Background:
    Given User logs in

  #На данной странице есть возможность посмотреть/изменить данные о пользователе.
  # Вся информация должна сохраняться и отображаться при последующем просмотре.
  @profilefio
  Scenario Outline: Check profile name edition
    When User open User profile settings
    And User sets first name <firstName> and last name <lastName>
    Then User checks first name <firstName> and last name <lastName> saved
    Examples:
      | firstName           | lastName |
      | Мария-Магдалена       | Иванова        |

