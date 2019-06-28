package net.jemzart.rpgkata

import net.jemzart.rpgkata.actions.DealDamage
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

		`attacker deals 10 damage to victim`()

		`victim should have a health value of`(NORMAL_DAMAGE_RECEIVED)
	}

	@Test
	fun `damage from lvl 2 to lvl 6 (4 lvl difference) is normal`(){
		`attacker is level`(2)
		`victim is level`(6)

		`attacker deals 10 damage to victim`()

		`victim should have a health value of`(NORMAL_DAMAGE_RECEIVED)
	}

	@Test
	fun `damage from lvl 1 to lvl 6 (5 lvl difference) is decreased by 50%`(){
		`attacker is level`(1)
		`victim is level`(6)

		`attacker deals 10 damage to victim`()

		`victim should have a health value of`(INCREASED_DAMAGE_RECEIVED)
	}

	@Test
	fun `damage from lvl 2 to lvl 7 (5 lvl difference) is decreased by 50%`(){
		`attacker is level`(2)
		`victim is level`(7)

		`attacker deals 10 damage to victim`()

		`victim should have a health value of`(INCREASED_DAMAGE_RECEIVED)
	}

	private fun `attacker deals 10 damage to victim`(){
		dealDamage(attacker = attacker, victim = victim, amount = 10)
	}

	private fun `attacker is level`(level: Int){
		attacker = HeroBuilder().health(Hero.MAX_HEALTH).level(level).build()
	}

	private fun `victim is level`(level: Int){
		victim = HeroBuilder().health(Hero.MAX_HEALTH).level(level).build()
	}

	private fun `victim should have a health value of`(health: Int){
		assertEquals(health, victim.health)
	}

	private companion object {
		const val INCREASED_DAMAGE_RECEIVED = 995
		const val NORMAL_DAMAGE_RECEIVED = 990
	}
}