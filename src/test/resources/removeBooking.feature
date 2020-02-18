Feature: As a user I want to delete an existing booking

  Background:
    Given Customer is on the hotel booking page
    When Customer enter the details and click Save
      | firstName | Adam       |
      | lastName  | Dougal     |
      | price     | 89.99      |
      | deposit   | true       |
      | checkin   | 2020-02-16 |
      | checkout  | 2020-02-17 |

  Scenario: Delete my booking
    When I delete my booking
    Then My booking is deleted