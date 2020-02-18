Feature: As a user, I want to book a room for a customer

  Scenario: Make a new booking
    Given Customer is on the hotel booking page
    When Customer enter the details and click Save
      | firstName | Adam       |
      | lastName  | Dougal     |
      | price     | 85.75      |
      | deposit   | true       |
      | checkin   | 2020-02-16 |
      | checkout  | 2020-02-20 |
    Then Customer should be able to add a new booking