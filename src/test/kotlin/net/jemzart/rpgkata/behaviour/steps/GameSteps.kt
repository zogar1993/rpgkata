package net.jemzart.rpgkata.behaviour.steps

import cucumber.api.java.en.Given
import net.jemzart.rpgkata.behaviour.*

class GameSteps {
	@Given("a new game starts")
	fun `a new game starts`() {
		characters.clear()
		things.clear()
		terrain.clear()
	}
}
