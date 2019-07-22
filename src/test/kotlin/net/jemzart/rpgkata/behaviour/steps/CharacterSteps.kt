package net.jemzart.rpgkata.behaviour.steps

import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import net.jemzart.rpgkata.behaviour.*
import org.junit.Assert

class CharacterSteps {
	@Given("character {string} is created")
	fun `character {name} is created`(name: String) {
		createCharacter(name)
	}

	@Given("{string} is dead")
	fun `{name} is dead`(name: String) {
		dealDamageToCharacter(THE_SHADOW, name, 2000)
	}

	@Given("{string} has {int} health")
	fun `{name} has {amount} health`(name: String, amount: Int) {
		val character = characters.search(name)
		dealDamageToCharacter(THE_SHADOW, name, character.health - amount)
	}

	@Then("{string} should be level {int}")
	fun `character {name} should be level {level}`(name: String, level: Int) {
		val character = characters.search(name)
		Assert.assertEquals(level, character.level)
	}

	@Then("{string} should have {int} health")
	fun `character {name} should have {health} health`(name: String, health: Int) {
		val character = characters.search(name)
		Assert.assertEquals(health, character.health)
	}

	@Then("{string} should be alive")
	fun `character {name} should be alive`(name: String) {
		val character = characters.search(name)
		Assert.assertTrue(character.alive)
	}

	@Then("{string} should be dead")
	fun `character {name} should be dead`(name: String) {
		val character = characters.search(name)
		Assert.assertTrue(character.dead)
	}

	@Then("{string} deals {int} damage to {string}")
	fun `{attacker} deals {amount} damage to {target}`
		(attacker: String, amount: Int, target: String) {
		dealDamageToCharacter(attacker, target, amount)
	}

	@Then("{string} heals {string} by {int}")
	fun `{healer} heals {target} by {amount}`
		(healer: String, target: String, amount: Int) {
		applyHealingToCharacter(healer, target, amount)
	}
}
