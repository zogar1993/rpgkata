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
	private lateinit var victim: GameCharacter

	@Test
	fun `damage from lvl 5 to lvl 1 (4 lvl difference) is normal`(){
		`attacker is level`(5)
		`victim is level`(1)

		`attacker deals damage to victim`()

		`victim should have received normal damage`()
	}

	@Test
	fun `damage from lvl 6 to lvl 1 (5 lvl difference) is increased`(){
		`attacker is level`(6)
		`victim is level`(1)

		`attacker deals damage to victim`()

		`victim should have received increased damage`()
	}

	@Test
	fun `damage from lvl 6 to lvl 2 (4 lvl difference) is normal`(){
		`attacker is level`(6)
		`victim is level`(2)

		`attacker deals damage to victim`()

		`victim should have received normal damage`()
	}

	@Test
	fun `damage from lvl 7 to lvl 2 (5 lvl difference) is increased`(){
		`attacker is level`(7)
		`victim is level`(2)

		`attacker deals damage to victim`()

		`victim should have received increased damage`()
	}

	private fun `attacker deals damage to victim`(){
		dealDamage(attacker = attacker, victim = victim, amount = DAMAGE)
	}

	private fun `attacker is level`(level: Int){
		attacker = GameCharacterBuilder().health(GameCharacter.INITIAL_HEALTH).level(level).build()
	}

	private fun `victim is level`(level: Int){
		victim = GameCharacterBuilder().health(GameCharacter.INITIAL_HEALTH).level(level).build()
	}

	private fun `victim should have received normal damage`(){
		assertEquals(NORMAL_DAMAGE_RECEIVED, victim.health)
	}

	private fun `victim should have received increased damage`(){
		assertEquals(INCREASED_DAMAGE_RECEIVED, victim.health)
	}

	private companion object {
		const val DAMAGE = 10
		const val INCREASED_DAMAGE_RECEIVED = GameCharacter.INITIAL_HEALTH - (DAMAGE * OVERLEVEL_DAMAGE_FACTOR).toInt()
		const val NORMAL_DAMAGE_RECEIVED = GameCharacter.INITIAL_HEALTH - DAMAGE
	}
}