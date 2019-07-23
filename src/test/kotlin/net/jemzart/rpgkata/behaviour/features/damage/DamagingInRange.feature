Feature: Dealing damage to a character in range

  Background:
    Given character "linuar" is created
    Given character "carrie" is created

  Scenario Outline: Target is in range of a <range_type> attacker when they are <distance> meters apart
    Given "linuar" has a ranged type of <range_type>
    And "linuar" is <distance> meters apart from "carrie"
    When "linuar" deals 50 damage to "carrie"
    Then "carrie" should have received 50 damage
    Examples:
      | range_type | distance |
      | "melee"    | 1        |
      | "melee"    | 2        |
      | "ranged"   | 1        |
      | "ranged"   | 20       |

  Scenario Outline: Target is not in range of a <range_type> attacker when they are <distance> meters apart
    Given "linuar" has a ranged type of <range_type>
    And "linuar" is <distance> meters apart from "carrie"
    When "linuar" deals 50 damage to "carrie"
    Then "carrie" should be unharmed
    Examples:
      | range_type | distance |
      | "melee"    | 3        |
      | "ranged"   | 21       |