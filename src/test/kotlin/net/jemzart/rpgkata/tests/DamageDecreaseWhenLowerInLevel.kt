package net.jemzart.rpgkata.tests

import net.jemzart.rpgkata.HeroBuilder
import net.jemzart.rpgkata.actions.DealDamage
import net.jemzart.rpgkata.assertEquals
import net.jemzart.rpgkata.domain.Hero
import org.junit.Test

class DamageDecreaseWhenLowerInLevel {
	private val dealDamage: DealDamage = DealDamage()
	private lateinit var attacker: Hero
	private lateinit var victim: Hero

	@Test
	fun `damage from lvl 1 to lvl 5 (4 lvl difference) is normal`(){
		`attacker is level`(1)
		`victim is level`(5)

		`attacker deals damage to victim`()

		`victim should have received normal damage`()
	}

	@Test
	fun `damage from lvl 2 to lvl 6 (4 lvl difference) is normal`(){
		`attacker is level`(2)
		`victim is level`(6)

		`attacker deals damage to victim`()

		`victim should have received normal damage`()
	}

	@Test
	fun `damage from lvl 1 to lvl 6 (5 lvl difference) is decreased by 50%`(){
		`attacker is level`(1)
		`victim is level`(6)

		`attacker deals damage to victim`()

		`victim should have received increased damage`()
	}

	@Test
	fun `damage from lvl 2 to lvl 7 (5 lvl difference) is decreased by 50%`(){
		`attacker is level`(2)
		`victim is level`(7)

		`attacker deals damage to victim`()

		`victim should have received increased damage`()
	}

	private fun `attacker deals damage to victim`(){
		dealDamage(attacker = attacker, victim = victim, amount = DAMAGE)
	}

	private fun `attacker is level`(level: Int){
		attacker = HeroBuilder().health(Hero.INITIAL_HEALTH).level(level).build()
	}

	private fun `victim is level`(level: Int){
		victim = HeroBuilder().health(Hero.INITIAL_HEALTH).level(level).build()
	}

	private fun `victim should have received normal damage`(){
		assertEquals(NORMAL_DAMAGE_RECEIVED, victim.health)
	}

	private fun `victim should have received increased damage`(){
		assertEquals(INCREASED_DAMAGE_RECEIVED, victim.health)
	}

	private companion object {
		const val DAMAGE = 10
		const val INCREASED_DAMAGE_RECEIVED = Hero.INITIAL_HEALTH - (DAMAGE * 0.5).toInt()
		const val NORMAL_DAMAGE_RECEIVED = Hero.INITIAL_HEALTH - DAMAGE
	}
}