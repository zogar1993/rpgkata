package net.jemzart.rpgkata.tests.faction

import net.jemzart.rpgkata.actions.JoinFaction
import net.jemzart.rpgkata.actions.LeaveFaction
import net.jemzart.rpgkata.assertEquals
import net.jemzart.rpgkata.domain.GameCharacter
import org.junit.Test

class LeavingFactions {
	private val joinFaction: JoinFaction = JoinFaction()
	private val leaveFaction: LeaveFaction = LeaveFaction()

	@Test
	fun `a character may leave a faction`(){
		val character = `a character who joined factions`(FACTION_A, FACTION_B)

		leaveFaction(character, FACTION_A)

		assert(FACTION_A !in character.factions)
		assert(FACTION_B in character.factions)
	}

	private fun `a character who joined factions`(vararg factions: String): GameCharacter {
		val character = GameCharacter.create()
		for (faction in factions)
			joinFaction(character, faction)
		return character
	}

	companion object{
		const val FACTION_A = "A"
		const val FACTION_B = "B"
	}
}