package net.jemzart.rpgkata

import org.junit.Test

class DamageIncreaseWhenHigherInLevel {
	@Test
	fun `damage from lvl 5 to lvl 1 (4 lvl difference) is normal`(){
		val attacker = HeroBuilder().level(5).build()
		val victim = HeroBuilder().level(1).build()

		attacker.damage(victim, 10)

		assert(victim.health == 990)
	}

	@Test
	fun `damage from lvl 6 to lvl 1 (5 lvl difference) is increased by 50%`(){
		val attacker = HeroBuilder().level(6).build()
		val victim = HeroBuilder().level(1).build()

		attacker.damage(victim, 10)

		assertEquals(985, victim.health)
	}

	@Test
	fun `damage from lvl 6 to lvl 2 (4 lvl difference) is normal`(){
		val attacker = HeroBuilder().level(6).build()
		val victim = HeroBuilder().level(2).build()

		attacker.damage(victim, 10)

		assert(victim.health == 990)
	}

	@Test
	fun `damage from lvl 7 to lvl 2 (5 lvl difference) is increased by 50%`(){
		val attacker = HeroBuilder().level(7).build()
		val victim = HeroBuilder().level(2).build()

		attacker.damage(victim, 10)

		assertEquals(985, victim.health)
	}
}