package net.jemzart.rpgkata.behaviour.steps

import cucumber.api.java.en.Then
import net.jemzart.rpgkata.behaviour.characters
import net.jemzart.rpgkata.behaviour.joinFaction
import net.jemzart.rpgkata.behaviour.leaveFaction
import org.junit.Assert.assertTrue

class FactionSteps {
	@Then("{string} joins faction {string}")
	fun `{character} joins faction {faction}`(character: String, faction: String) {
		joinFaction(character, faction)
	}

	@Then("{string} leaves faction {string}")
	fun `{character} leaves faction {faction}`(character: String, faction: String) {
		leaveFaction(character, faction)
	}

	@Then("{string} and {string} join faction {string}")
	fun `{character} and {character} join faction {faction}`(characterA: String, characterB: String, faction: String) {
		joinFaction(characterA, faction)
		joinFaction(characterB, faction)
	}

	@Then("{string} should be part of {string}")
	fun `{character} should be part of {faction}`(name: String, faction: String) {
		val character = characters.search(name)
		assertTrue(faction in character.factions)
	}

	@Then("{string} should not be part of {string}")
	fun `{character} should not be part of {faction}`(name: String, faction: String) {
		val character = characters.search(name)
		assertTrue(faction !in character.factions)
	}
}
