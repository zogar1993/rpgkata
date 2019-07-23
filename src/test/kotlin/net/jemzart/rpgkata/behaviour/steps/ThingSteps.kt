package net.jemzart.rpgkata.behaviour.steps

import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import net.jemzart.rpgkata.behaviour.createThing
import net.jemzart.rpgkata.behaviour.things
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue

class ThingSteps {
	@Given("thing {string} is created with {int} health")
	fun `character {name} is created with {health} health`(name: String, health: Int) {
		createThing(name, health)
	}

	@Then("thing {string} should have {int} health")
	fun `thing {name} should have {health} health`(name: String, health: Int) {
		val thing = things.search(name)
		assertEquals(health, thing.health)
	}

	@Then("thing {string} should be destroyed")
	fun `thing {name} should be destroyed`(name: String) {
		val thing = things.search(name)
		assertTrue(thing.destroyed)
	}
}
