package net.jemzart.rpgkata.tests

import net.jemzart.rpgkata.domain.Hero
import org.junit.Test

class Heal {
	@Test
	fun `damage is subtracted from health`(){
		val hero = Hero.create()
		val other = Hero.create()

		other.damage(hero, 5)
		hero.heal(hero, 3)

		assert(hero.health == 998)
	}

	@Test
	fun `the dead may not be healed`(){
		val hero = Hero.create()
		val other = Hero.create()

		other.damage(hero, 1000)
		hero.heal(hero, 3)

		assert(hero.health == 0)
	}

	@Test
	fun `health may not be raised above 1000`(){
		val hero = Hero.create()
		val other = Hero.create()

		other.damage(hero, 5)
		hero.heal(hero, 8)

		assert(hero.health == 1000)
	}

	@Test
	fun `can heal self`(){
		val hero = Hero.create()
		val other = Hero.create()

		other.damage(hero, 5)
		hero.heal(hero, 3)

		assert(hero.health == 998)
	}

	@Test
	fun `can only heal self`(){
		val hero = Hero.create()
		val other = Hero.create()

		hero.damage(other, 5)
		hero.heal(other, 3)

		assert(other.health == 995)
	}
}