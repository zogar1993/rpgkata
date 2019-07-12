package net.jemzart.rpgkata.tests

import net.jemzart.rpgkata.domain.GameCharacter
import org.junit.Test

class Creation {
	@Test
	fun `a character is created with 1000 health`(){
		val character = GameCharacter.create()

		assert(character.health == 1000)
	}

	@Test
	fun `a character is created with level 1`(){
		val character = GameCharacter.create()

		assert(character.level == 1)
	}

	@Test
	fun `a character is created alive`(){
		val character = GameCharacter.create()

		assert(character.alive)
	}
}
