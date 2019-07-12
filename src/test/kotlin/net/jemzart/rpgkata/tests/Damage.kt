package net.jemzart.rpgkata.tests

import net.jemzart.rpgkata.GameCharacterBuilder
import net.jemzart.rpgkata.actions.DealDamage
import net.jemzart.rpgkata.assertEquals
import net.jemzart.rpgkata.domain.GameCharacter
import org.junit.Before
import org.junit.Test

class Damage {
	private lateinit var dealDamage: DealDamage
	private lateinit var attacker: GameCharacter
	private lateinit var victim: GameCharacter

	@Before
	fun setUp(){
		dealDamage = DealDamage()
		attacker = GameCharacterBuilder().health(1000).build()
		victim = GameCharacterBuilder().health(1000).build()
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