Feature: Dealing damage to a character

  Background:
    Given a new game starts
    And character "linuar" is created
    And character "carrie" is created

  Scenario: Can heal self
    Given "linuar" has 900 health
    When "linuar" heals "linuar" by 50
    Then "linuar" should have 950 health

  Scenario: The dead may not be healed
    Given "linuar" is dead
    When "linuar" heals "linuar" by 50
    Then "linuar" should have 0 health
    And "linuar" should be dead

  Scenario: Health may not be raised above 1000
    Given "linuar" has 900 health
    When "linuar" heals "linuar" by 200
    Then "linuar" should have 1000 health

  Scenario: Cannot heal other
    Given "carrie" has 900 health
    When "linuar" heals "carrie" by 50
    Then "carrie" should have 900 health

  Scenario: Can heal ally
    Given "linuar" and "carrie" join faction "underworld"
    And "carrie" has 900 health
    When "linuar" heals "carrie" by 50
    Then "carrie" should have 950 health