Feature: Dealing damage to a thing

  Background:
    Given character "linuar" is created
    Given thing "chair" is created with 500 health

  Scenario: Damage is subtracted from target health
    When "linuar" deals 50 damage to thing "chair"
    Then thing "chair" should have 450 health

  Scenario: Exceeding damage destroys the thing
    When "linuar" deals 2000 damage to thing "chair"
    Then thing "chair" should have 0 health
    Then thing "chair" should be destroyed