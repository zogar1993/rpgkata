package net.jemzart.rpgkata.tests

import net.jemzart.rpgkata.actions.ApplyHealing
import net.jemzart.rpgkata.actions.DealDamage
import net.jemzart.rpgkata.assertEquals
import net.jemzart.rpgkata.domain.GameCharacter
import org.junit.Test

class Heal {
	private val dealDamage: DealDamage = DealDamage()
	private val applyHealing: ApplyHealing = ApplyHealing()

	@Test
	fun `healing is added to health`(){
		val hero = `get hero with a health of`(995)

		applyHealing(healer = hero, target = hero, amount = 3)

		assert(hero.health == 998)
	}

	@Test
	fun `the dead may not be healed`(){
		val hero = `get hero with a health of`(0)

		applyHealing(healer = hero, target = hero, amount = 3)

		assert(hero.health == 0)
	}

	@Test
	fun `health may not be raised above 1000`(){
		val hero = `get hero with a health of`(995)

		applyHealing(healer = hero, target = hero, amount = 8)

		assert(hero.health == GameCharacter.INITIAL_HEALTH)
	}

	@Test
	fun `can heal self`(){
		val hero = `get hero with a health of`(995)

		applyHealing(healer = hero, target = hero, amount = 3)

		assert(hero.health == 998)
	}

	@Test
	fun `can only heal self`(){
		val hero = GameCharacter.create()
		val other = `get hero with a health of`(995)

		applyHealing(healer = hero, target = hero, amount = 3)

		assert(other.health == 995)
	}

	private fun `get hero with a health of`(value: Int): GameCharacter {
		val hero = GameCharacter.create()
		val aux = GameCharacter.create()
		dealDamage(aux, hero, GameCharacter.INITIAL_HEALTH - value)
		assertEquals(value, hero.health)
		return hero
	}
}