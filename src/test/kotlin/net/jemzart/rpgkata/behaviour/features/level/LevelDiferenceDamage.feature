Feature: Damage modifiers according to level difference between attacker and target.

  Background:
    Given character "linuar" is created
    Given character "carrie" is created

  Scenario Outline: 5 levels above modifier. Attacker level: <attacker_level>. Target: level <target_level>.
    Given "linuar" is level <attacker_level>
    Given "carrie" is level <target_level>
    When "linuar" deals 100 damage to "carrie"
    Then "carrie" should have 850 health
    Examples:
      | attacker_level | target_level |
      | 6              | 1            |
      | 7              | 1            |
      | 7              | 2            |

  Scenario Outline: 5 levels beneath modifier. Attacker level: <attacker_level>. Target: level <target_level>.
    Given "linuar" is level <attacker_level>
    Given "carrie" is level <target_level>
    When "linuar" deals 100 damage to "carrie"
    Then "carrie" should have 950 health
    Examples:
      | attacker_level | target_level |
      | 1              | 6            |
      | 1              | 7            |
      | 2              | 7            |

  Scenario Outline: No level modifier. Attacker level: <attacker_level>. Target level: <target_level>.
    Given "linuar" is level <attacker_level>
    Given "carrie" is level <target_level>
    When "linuar" deals 100 damage to "carrie"
    Then "carrie" should have 900 health
    Examples:
      | attacker_level | target_level |
      | 1              | 1            |
      | 1              | 4            |
      | 4              | 1            |
      | 5              | 2            |
      | 2              | 5            |