Feature: Joining Factions

  Background:
    Given character "linuar" is created

  Scenario: A character may join many factions
    Given "linuar" joins faction "underworld"
    Given "linuar" joins faction "angels"
    Then "linuar" should be part of "underworld"
    Then "linuar" should be part of "angels"