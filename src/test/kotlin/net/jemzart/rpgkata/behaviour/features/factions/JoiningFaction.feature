Feature: Joining Factions

  Background:
    Given a new game starts
    And character "linuar" is created

  Scenario: A character may join many factions
    Given "linuar" joins faction "underworld"
    And "linuar" joins faction "angels"
    Then "linuar" should be part of "underworld"
    And "linuar" should be part of "angels"