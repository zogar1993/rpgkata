Feature: Damage modifiers according to level difference between attacker and target.

  Background:
    Given character "linuar" is created
    And character "carrie" is created

  Scenario Outline: 5 levels above modifier. Attacker level: <attacker_level>. Target: level <target_level>.
    Given "linuar" is level <attacker_level>
    And "carrie" is level <target_level>
    When "linuar" deals 100 damage to "carrie"
    Then "carrie" should have received 150 damage
    Examples:
      | attacker_level | target_level |
      | 6              | 1            |
      | 7              | 1            |
      | 7              | 2            |

  Scenario Outline: 5 levels beneath modifier. Attacker level: <attacker_level>. Target: level <target_level>.
    Given "linuar" is level <attacker_level>
    And "carrie" is level <target_level>
    When "linuar" deals 100 damage to "carrie"
    Then "carrie" should have received 50 damage
    Examples:
      | attacker_level | target_level |
      | 1              | 6            |
      | 1              | 7            |
      | 2              | 7            |

  Scenario Outline: No level modifier. Attacker level: <attacker_level>. Target level: <target_level>.
    Given "linuar" is level <attacker_level>
    And "carrie" is level <target_level>
    When "linuar" deals 100 damage to "carrie"
    Then "carrie" should have received 100 damage
    Examples:
      | attacker_level | target_level |
      | 1              | 1            |
      | 5              | 1            |
      | 1              | 5            |
      | 10             | 10           |