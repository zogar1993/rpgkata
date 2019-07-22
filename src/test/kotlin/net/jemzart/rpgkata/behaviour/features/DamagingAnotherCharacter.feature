Feature: Dealing damage to a character

  Background:
    Given character "linuar" is created
    Given character "carrie" is created

  Scenario: Damage is subtracted from target health
    When "linuar" deals 5 damage to "carrie"
    Then "carrie" should have 995 health

  Scenario: Damage exceeding current health leaves target at 0 health
    When "linuar" deals 1005 damage to "carrie"
    Then "carrie" should have 0 health

  Scenario: Damage equal to current target health leaves target at 0 health and dead
    When "linuar" deals 1005 damage to "carrie"
    Then "carrie" should have 0 health
    Then "carrie" should be dead

  Scenario: Damage exceeding current target health leaves target at 0 health and dead
    When "linuar" deals 1005 damage to "carrie"
    Then "carrie" should have 0 health
    Then "carrie" should be dead

  Scenario: Cannot attack self
    When "linuar" deals 500 damage to "linuar"
    Then "linuar" should have 1000 health