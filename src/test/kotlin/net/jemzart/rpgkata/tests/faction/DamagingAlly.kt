package net.jemzart.rpgkata.tests.faction

import net.jemzart.rpgkata.GameCharacterBuilder
import net.jemzart.rpgkata.actions.DealDamage
import net.jemzart.rpgkata.actions.JoinFaction
import net.jemzart.rpgkata.assertEquals
import net.jemzart.rpgkata.domain.GameCharacter
import org.junit.Before
import org.junit.Test

class DamagingAlly {
	private val joinFaction: JoinFaction = JoinFaction()
	private val dealDamage: DealDamage = DealDamage()
	private lateinit var attacker: GameCharacter
	private lateinit var target: GameCharacter

	@Before
	fun setUp(){
		attacker = GameCharacterBuilder().build()
		target = GameCharacterBuilder().build()
	}
	
	@Test
	fun `attacker cannot deal damage to her ally`(){
		`attacker and target are allies`()

		`attacker deals damage to her ally`()

		`her ally should not have received damage`()
	}
	
	private fun `attacker and target are allies`(){
		val faction = "FACTION"
		joinFaction.invoke(attacker, faction)
		joinFaction.invoke(target, faction)
	}

	private fun `attacker deals damage to her ally`(){
		dealDamage(attacker, target, 1)
	}

	private fun `her ally should not have received damage`(){
		assertEquals(GameCharacter.INITIAL_HEALTH, target.health)
	}
}