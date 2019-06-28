package net.jemzart.rpgkata.tests

import net.jemzart.rpgkata.HeroBuilder
import net.jemzart.rpgkata.actions.DealDamage
import net.jemzart.rpgkata.assertEquals
import net.jemzart.rpgkata.domain.Hero
import org.junit.Before
import org.junit.Test

class Damage {
	private lateinit var dealDamage: DealDamage
	private lateinit var attacker: Hero
	private lateinit var victim: Hero

	@Before
	fun setUp(){
		dealDamage = DealDamage()
		attacker = HeroBuilder().health(1000).build()
		victim = HeroBuilder().health(1000).build()
	}

	@Test
	fun `damage is subtracted from health`(){
		dealDamage(attacker = attacker, victim = victim, amount = 5)

		assertEquals(995, victim.health)
	}

	@Test
	fun `damage exceeding current health leaves victim with 0 health`(){
		dealDamage(attacker = attacker, victim = victim, amount = 1005)

		assertEquals(0, victim.health)
	}

	@Test
	fun `damage exceeding current health leaves victim dead`(){
		dealDamage(attacker = attacker, victim = victim, amount = 1005)

		assert(!victim.alive)
	}

	@Test
	fun `damage equaling current health leaves victim dead`(){
		dealDamage(attacker = attacker, victim = victim, amount = 1000)

		assert(!victim.alive)
	}

	@Test
	fun `cant deal damage to self`(){
		dealDamage(attacker = attacker, victim = attacker, amount = 1000)

		assertEquals(1000, attacker.health)
	}
}