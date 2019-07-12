package net.jemzart.rpgkata.tests.level

import net.jemzart.rpgkata.GameCharacterBuilder
import net.jemzart.rpgkata.actions.DealDamage
import net.jemzart.rpgkata.assertEquals
import net.jemzart.rpgkata.domain.GameCharacter
import net.jemzart.rpgkata.domain.OVERLEVEL_DAMAGE_FACTOR
import org.junit.Test

class HigherDamageToLowerLevel {
	private val dealDamage: DealDamage = DealDamage()
	private lateinit var attacker: GameCharacter
	private lateinit var target: GameCharacter

	@Test
	fun `damage from lvl 5 to lvl 1 (4 lvl difference) is normal`(){
		`attacker is level`(5)
		`target is level`(1)

		`attacker deals damage to target`()

		`target should have received normal damage`()
	}

	@Test
	fun `damage from lvl 6 to lvl 1 (5 lvl difference) is increased`(){
		`attacker is level`(6)
		`target is level`(1)

		`attacker deals damage to target`()

		`target should have received increased damage`()
	}

	@Test
	fun `damage from lvl 6 to lvl 2 (4 lvl difference) is normal`(){
		`attacker is level`(6)
		`target is level`(2)

		`attacker deals damage to target`()

		`target should have received normal damage`()
	}

	@Test
	fun `damage from lvl 7 to lvl 2 (5 lvl difference) is increased`(){
		`attacker is level`(7)
		`target is level`(2)

		`attacker deals damage to target`()

		`target should have received increased damage`()
	}

	private fun `attacker deals damage to target`(){
		dealDamage(attacker = attacker, target = target, amount = DAMAGE)
	}

	private fun `attacker is level`(level: Int){
		attacker = GameCharacterBuilder().level(level).build()
	}

	private fun `target is level`(level: Int){
		target = GameCharacterBuilder().level(level).build()
	}

	private fun `target should have received normal damage`(){
		assertEquals(NORMAL_DAMAGE_RECEIVED, target.health)
	}

	private fun `target should have received increased damage`(){
		assertEquals(INCREASED_DAMAGE_RECEIVED, target.health)
	}

	private companion object {
		const val DAMAGE = 10
		const val INCREASED_DAMAGE_RECEIVED = GameCharacter.INITIAL_HEALTH - (DAMAGE * OVERLEVEL_DAMAGE_FACTOR).toInt()
		const val NORMAL_DAMAGE_RECEIVED = GameCharacter.INITIAL_HEALTH - DAMAGE
	}
}