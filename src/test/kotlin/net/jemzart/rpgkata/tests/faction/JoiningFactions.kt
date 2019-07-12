package net.jemzart.rpgkata.tests.faction

import net.jemzart.rpgkata.actions.JoinFaction
import net.jemzart.rpgkata.assertEquals
import net.jemzart.rpgkata.domain.GameCharacter
import org.junit.Test

class JoiningFactions {
	private val joinFaction: JoinFaction = JoinFaction()

	@Test
	fun `a newly created character belongs to no faction`(){
		val character = `a newly created character`()

		assertEquals(0, character.factions.size)
	}

	@Test
	fun `a character may join factions`(){
		val character = `a character`()

		joinFaction(character, FACTION_A)
		joinFaction(character, FACTION_B)

		assert(FACTION_A in character.factions)
		assert(FACTION_B in character.factions)
	}

	private fun `a newly created character`(): GameCharacter = GameCharacter.create()
	private fun `a character`(): GameCharacter = GameCharacter.create()

	companion object{
		const val FACTION_A = "A"
		const val FACTION_B = "B"
	}
}