package net.jemzart.rpgkata.behaviour.steps

import cucumber.api.java.en.Then
import net.jemzart.rpgkata.behaviour.*
import net.jemzart.rpgkata.domain.character.GameCharacter
import org.junit.Assert.assertEquals

class DamageSteps {
	@Then("{string} should have received {int} damage")
	fun `{name} should have received {amount} damage`(name: String, amount: Int) {
		val character = characters.search(name)
		val health = GameCharacter.INITIAL_HEALTH - amount
		assertEquals(health, character.health)
	}

	@Then("{string} should be unharmed")
	fun `character {name} should be unharmed`(name: String) {
		val character = characters.search(name)
		assertEquals(GameCharacter.INITIAL_HEALTH, character.health)
	}

	@Then("{string} deals {int} damage to {string}")
	fun `{attacker} deals {amount} damage to {target}`
		(attacker: String, amount: Int, target: String) {
		dealDamageToCharacter(attacker, target, amount)
	}
}
