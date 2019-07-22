Feature: Character Creation

  Scenario: A character is created with default values
    Given character "linuar" is created
    Then "linuar" should be level 1
    Then "linuar" should have 1000 health
    Then "linuar" should be alive