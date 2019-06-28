package net.jemzart.rpgkata

import org.junit.Test

class DamageDecreaseWhenLowerInLevel {
	@Test
	fun `damage from lvl 1 to lvl 5 (4 lvl difference) is normal`(){
		val attacker = HeroBuilder().level(1).build()
		val victim = HeroBuilder().level(5).build()

		attacker.damage(victim, 10)

		assertEquals(990, victim.health)
	}

	@Test
	fun `damage from lvl 1 to lvl 6 (5 lvl difference) is decreased by 50%`(){
		val attacker = HeroBuilder().level(1).build()
		val victim = HeroBuilder().level(6).build()

		attacker.damage(victim, 10)

		assertEquals(995, victim.health)
	}

	@Test
	fun `damage from lvl 2 to lvl 6 (4 lvl difference) is normal`(){
		val attacker = HeroBuilder().level(2).build()
		val victim = HeroBuilder().level(6).build()

		attacker.damage(victim, 10)

		assertEquals(990, victim.health)
	}

	@Test
	fun `damage from lvl 2 to lvl 7 (5 lvl difference) is decreased by 50%`(){
		val attacker = HeroBuilder().level(2).build()
		val victim = HeroBuilder().level(7).build()

		attacker.damage(victim, 10)

		assertEquals(995, victim.health)
	}
}