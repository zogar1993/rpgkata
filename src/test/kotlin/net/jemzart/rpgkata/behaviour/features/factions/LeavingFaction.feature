Feature: Joining Factions

  Background:
    Given character "linuar" is created

  Scenario: A character may leave a faction
    Given "linuar" joins faction "underworld"
    And "linuar" joins faction "angels"
    And "linuar" leaves faction "angels"
    Then "linuar" should be part of "underworld"
    And "linuar" should not be part of "angels"