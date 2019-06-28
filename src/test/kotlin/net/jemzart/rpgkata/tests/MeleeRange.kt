package net.jemzart.rpgkata.tests

import net.jemzart.rpgkata.HeroBuilder
import net.jemzart.rpgkata.actions.DealDamage
import net.jemzart.rpgkata.assertEquals
import net.jemzart.rpgkata.domain.Hero
import org.junit.Before
import org.junit.Test

class MeleeRange {
	private val dealDamage: DealDamage = DealDamage()
	private lateinit var attacker: Hero
	private lateinit var victim: Hero

	@Before
	fun setUp(){
		attacker = HeroBuilder().health(1000).melee().build()
		victim = HeroBuilder().health(1000).build()
	}

	@Test
	fun `melee characters can deal damage 1 meter apart`(){
		`attacker and victim are at a distance in meters of`(1)

		`attacker deals damage to victim`()

		`victim should have received damage`()
	}

	@Test
	fun `melee characters can deal damage 2 meter apart`(){
		`attacker and victim are at a distance in meters of`(2)

		`attacker deals damage to victim`()

		`victim should have received damage`()
	}

	@Test
	fun `melee characters can't deal damage 3 meter apart`(){
		`attacker and victim are at a distance in meters of`(3)

		`attacker deals damage to victim`()

		`victim should not have received damage`()
	}

	private fun `attacker and victim are at a distance in meters of`(distance: Int){
		attacker.setDistanceFrom(victim, distance)
	}

	private fun `attacker deals damage to victim`(){
		dealDamage(attacker = attacker, victim = victim, amount = DAMAGE)
	}

	private fun `victim should have received damage`(){
		assertEquals(DAMAGE_RECEIVED, victim.health)
	}

	private fun `victim should not have received damage`(){
		assertEquals(Hero.INITIAL_HEALTH, victim.health)
	}

	private companion object {
		const val DAMAGE = 10
		const val DAMAGE_RECEIVED = Hero.INITIAL_HEALTH - DAMAGE
	}
}