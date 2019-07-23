Feature: Dealing damage to a character

  Background:
    Given character "linuar" is created
    And character "carrie" is created

  Scenario: Damage is subtracted from target health
    When "linuar" deals 5 damage to "carrie"
    Then "carrie" should have 995 health

  Scenario: Damage exceeding current health leaves target at 0 health
    When "linuar" deals 1005 damage to "carrie"
    Then "carrie" should have 0 health

  Scenario: Damage equal to current target health leaves target at 0 health and dead
    When "linuar" deals 1005 damage to "carrie"
    Then "carrie" should have 0 health
    And "carrie" should be dead

  Scenario: Damage exceeding current target health leaves target at 0 health and dead
    When "linuar" deals 1005 damage to "carrie"
    Then "carrie" should have 0 health
    And "carrie" should be dead

  Scenario: Cannot attack self
    When "linuar" deals 500 damage to "linuar"
    Then "linuar" should be unharmed

  Scenario: Cannot attack ally
    Given "linuar" and "carrie" join faction "underworld"
    When "linuar" deals 500 damage to "carrie"
    And "carrie" should be unharmed