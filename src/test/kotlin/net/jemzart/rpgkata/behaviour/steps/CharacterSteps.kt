package net.jemzart.rpgkata.behaviour.steps

import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import net.jemzart.rpgkata.behaviour.*
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue

class CharacterSteps {
	@Given("character {string} is created")
	fun `character {name} is created`(name: String) {
		createCharacter(name)
	}

	@Given("{string} is dead")
	fun `{name} is dead`(name: String) {
		val character = characters.search(name)
		character.damage(2000)
	}

	@Given("{string} has {int} health")
	fun `{name} has {amount} health`(name: String, amount: Int) {
		val character = characters.search(name)
		character.damage(character.health - amount)
	}

	@Given("{string} is level {int}")
	fun `{name} is level {level}`(name: String, level: Int) {
		setCharacterLevel(name, level)
	}

	@Then("{string} should be level {int}")
	fun `{name} should be level {level}`(name: String, level: Int) {
		val character = characters.search(name)
		assertEquals(level, character.level)
	}

	@Then("{string} should have {int} health")
	fun `{name} should have {health} health`(name: String, health: Int) {
		val character = characters.search(name)
		assertEquals(health, character.health)
	}

	@Then("{string} should be alive")
	fun `character {name} should be alive`(name: String) {
		val character = characters.search(name)
		assertTrue(character.alive)
	}

	@Then("{string} should be dead")
	fun `character {name} should be dead`(name: String) {
		val character = characters.search(name)
		assertTrue(character.dead)
	}

	@Then("{string} heals {string} by {int}")
	fun `{healer} heals {target} by {amount}`(healer: String, target: String, amount: Int) {
		applyHealingToCharacter(healer, target, amount)
	}
}
