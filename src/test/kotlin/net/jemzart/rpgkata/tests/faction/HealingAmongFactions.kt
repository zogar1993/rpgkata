package net.jemzart.rpgkata.tests.faction

import net.jemzart.rpgkata.GameCharacterBuilder
import net.jemzart.rpgkata.actions.ApplyHealing
import net.jemzart.rpgkata.actions.DealDamageToCharacter
import net.jemzart.rpgkata.actions.JoinFaction
import net.jemzart.rpgkata.assertEquals
import net.jemzart.rpgkata.domain.GameCharacter
import org.junit.Before
import org.junit.Test

class HealingAmongFactions {
	private val joinFaction = JoinFaction()
	private val dealDamage = DealDamageToCharacter()
	private val applyHealing = ApplyHealing()
	private lateinit var linuar: GameCharacter
	private lateinit var carrie: GameCharacter

	@Before
	fun setUp(){
		linuar = GameCharacterBuilder().build()
		carrie = GameCharacterBuilder().build()
	}

	@Test
	fun `a character can heal its ally`(){
		`linuar and carrie are allies`()
		`carrie is injured`()

		`linuar heals carrie`()

		`carrie should be healed`()
	}

	@Test
	fun `a character cant heal others who are not allies`(){
		`carrie is injured`()

		`linuar heals carrie`()

		`carrie should still be injured`()
	}

	private fun `linuar and carrie are allies`(){
		val faction = "FACTION"
		joinFaction.invoke(linuar, faction)
		joinFaction.invoke(carrie, faction)
	}

	private fun `carrie is injured`(){
		val aux = GameCharacterBuilder().build()
		dealDamage(aux, carrie, 1)
	}

	private fun `linuar heals carrie`(){
		applyHealing(linuar, carrie, 1)
	}

	private fun `carrie should be healed`(){
		assertEquals(GameCharacter.INITIAL_HEALTH, carrie.health)
	}

	private fun `carrie should still be injured`(){
		assertEquals(999, carrie.health)
	}
}