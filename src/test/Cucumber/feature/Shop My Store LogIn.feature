Feature: Shop My Store LogIn

  Scenario Outline: Create new user with address information
    Given Login user to My Store
    When User go to page - add new address
    And User completed information <alias>, <address>, <city>, <postCode>, <county>, <phone> on address page
    Then User delete 'My address'
    And Close browser

    Examples:
      | alias | address | city    | postCode | county          | phone           |
      | Wacek | Blotna  | Wachock | 11-111   | United Kingdom  | +48 111 111 111 |



