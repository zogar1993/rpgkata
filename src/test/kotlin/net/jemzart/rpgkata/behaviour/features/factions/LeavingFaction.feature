Feature: Joining Factions

  Background:
    Given character "linuar" is created

  Scenario: A character may leave a faction
    Given "linuar" joins faction "underworld"
    Given "linuar" joins faction "angels"
    Given "linuar" leaves faction "angels"
    Then "linuar" should be part of "underworld"
    Then "linuar" should not be part of "angels"