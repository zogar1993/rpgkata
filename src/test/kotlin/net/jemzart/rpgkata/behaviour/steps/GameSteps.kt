package net.jemzart.rpgkata.behaviour.steps

import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import net.jemzart.rpgkata.actions.characters.CreateCharacter
import net.jemzart.rpgkata.actions.characters.SetCharacterLevel
import net.jemzart.rpgkata.actions.characters.SetCharacterRangeType
import net.jemzart.rpgkata.actions.damage.DealDamageToCharacter
import net.jemzart.rpgkata.actions.damage.DealDamageToThing
import net.jemzart.rpgkata.actions.distance.DistanceCharacters
import net.jemzart.rpgkata.actions.factions.JoinFaction
import net.jemzart.rpgkata.actions.factions.LeaveFaction
import net.jemzart.rpgkata.actions.healing.ApplyHealingToCharacter
import net.jemzart.rpgkata.actions.things.CreateThing
import net.jemzart.rpgkata.behaviour.*
import net.jemzart.rpgkata.domain.character.GameCharacters
import net.jemzart.rpgkata.domain.thing.Things
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue

class GameSteps {
	@Given("a new game starts")
	fun `a new game starts`() {
		characters.clear()
		things.clear()
	}
}
