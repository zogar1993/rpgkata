package net.jemzart.rpgkata

import net.jemzart.rpgkata.domain.Hero
import org.junit.Test

class Heal {
	@Test
	fun `damage is subtracted from health`(){
		val hero = Hero.create()
		val other = Hero.create()

		hero.damage(other, 5)
		hero.heal(other, 3)

		assert(other.health == 998)
	}

	@Test
	fun `the dead may not be healed`(){
		val hero = Hero.create()
		val other = Hero.create()

		hero.damage(other, 1000)
		hero.heal(other, 3)

		assert(other.health == 0)
	}

	@Test
	fun `health may not be raised above 1000`(){
		val hero = Hero.create()
		val other = Hero.create()

		hero.damage(other, 5)
		hero.heal(other, 8)

		assert(other.health == 1000)
	}
}