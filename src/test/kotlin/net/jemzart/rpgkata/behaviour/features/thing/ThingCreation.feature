Feature: Thing Creation

  Background:
    Given a new game starts

  Scenario Outline: A thing may be created with any health value, like <health>
    Given thing "chair" is created with <health> health
    Then thing "chair" should have <health> health
    Examples:
      | health |
      | 50     |
      | 2000   |