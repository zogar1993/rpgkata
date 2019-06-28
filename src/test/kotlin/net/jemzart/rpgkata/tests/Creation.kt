package net.jemzart.rpgkata.tests

import net.jemzart.rpgkata.domain.Hero
import org.junit.Test

class Creation {
	@Test
	fun `a character is created with 1000 health`(){
		val character = Hero.create()

		assert(character.health == 1000)
	}

	@Test
	fun `a character is created with level 1`(){
		val character = Hero.create()

		assert(character.level == 1)
	}

	@Test
	fun `a character is created alive`(){
		val character = Hero.create()

		assert(character.alive)
	}
}
