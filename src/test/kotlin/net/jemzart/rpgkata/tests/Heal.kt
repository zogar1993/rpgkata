package net.jemzart.rpgkata.tests

import net.jemzart.rpgkata.actions.ApplyHealing
import net.jemzart.rpgkata.actions.DealDamage
import net.jemzart.rpgkata.domain.Hero
import org.junit.Test

class Heal {
	private val dealDamage: DealDamage = DealDamage()
	private val applyHealing: ApplyHealing = ApplyHealing()

	@Test
	fun `healing is added to health`(){
		val hero = Hero.create()
		val other = Hero.create()

		other.damage(hero, 5)
		hero.heal(hero, 3)

		assert(hero.health == 998)
	}

	@Test
	fun `the dead may not be healed`(){
		val hero = `get hero with a health of`(0)

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

	fun `get hero with a health of`(value: Int): Hero {
		val hero = Hero.create()
		val aux = Hero.create()
		dealDamage(aux, hero, Hero.INITIAL_HEALTH - value)
		return hero
	}
}