package net.jemzart.rpgkata.tests

import net.jemzart.rpgkata.GameCharacterBuilder
import net.jemzart.rpgkata.actions.DealDamageToCharacter
import net.jemzart.rpgkata.assertEquals
import net.jemzart.rpgkata.domain.GameCharacter
import org.junit.Before
import org.junit.Test

class Damage {
	private lateinit var dealDamage: DealDamageToCharacter
	private lateinit var attacker: GameCharacter
	private lateinit var target: GameCharacter

	@Before
	fun setUp(){
		dealDamage = DealDamageToCharacter()
		attacker = GameCharacterBuilder().build()
		target = GameCharacterBuilder().build()
	}

	@Test
	fun `damage is subtracted from health`(){
		dealDamage(attacker = attacker, target = target, amount = 5)

		assertEquals(995, target.health)
	}

	@Test
	fun `damage exceeding current health leaves target with 0 health`(){
		dealDamage(attacker = attacker, target = target, amount = 1005)

		assertEquals(0, target.health)
	}

	@Test
	fun `damage exceeding current health leaves target dead`(){
		dealDamage(attacker = attacker, target = target, amount = 1005)

		assert(!target.alive)
	}

	@Test
	fun `damage equaling current health leaves target dead`(){
		dealDamage(attacker = attacker, target = target, amount = 1000)

		assert(!target.alive)
	}

	@Test
	fun `cant deal damage to self`(){
		dealDamage(attacker = attacker, target = attacker, amount = 1000)

		assertEquals(1000, attacker.health)
	}
}