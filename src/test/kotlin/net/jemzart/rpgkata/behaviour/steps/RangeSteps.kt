package net.jemzart.rpgkata.behaviour.steps

import cucumber.api.java.en.Given
import net.jemzart.rpgkata.behaviour.distanceCharacters
import net.jemzart.rpgkata.behaviour.setCharacterRangeType

class RangeSteps {
	@Given("{string} has a ranged type of {string}")
	fun `{name} has a ranged type of {type}`(name: String, type: String) {
		setCharacterRangeType(name, type)
	}

	@Given("{string} is {int} meters apart from {string}")
	fun `{character} is {distance} meters apart from {character}`
		(characterA: String, distance: Int, characterB: String) {
		distanceCharacters(characterA, characterB, distance)
	}
}
