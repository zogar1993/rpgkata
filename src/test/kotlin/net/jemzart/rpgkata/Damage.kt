package net.jemzart.rpgkata

import net.jemzart.rpgkata.domain.Hero
import org.junit.Test

class Damage {
	@Test
	fun `damage is subtracted from health`(){
		val attacker = Hero.create()
		val victim = Hero.create()

		attacker.damage(victim, 5)

		assert(victim.health == 995)
	}

	@Test
	fun `damage exceeding current health leaves victim with 0 health`(){
		val attacker = Hero.create()
		val victim = Hero.create()

		attacker.damage(victim, 1005)

		assert(victim.health == 0)
	}

	@Test
	fun `damage exceeding current health leaves victim dead`(){
		val attacker = Hero.create()
		val victim = Hero.create()

		attacker.damage(victim, 1005)

		assert(!victim.alive)
	}

	@Test
	fun `damage equaling current health leaves victim dead`(){
		val attacker = Hero.create()
		val victim = Hero.create()

		attacker.damage(victim, 1000)

		assert(!victim.alive)
	}

	@Test
	fun `cant deal damage to self`(){
		val attacker = Hero.create()

		attacker.damage(attacker, 1000)

		assert(attacker.health == 1000)
	}
}