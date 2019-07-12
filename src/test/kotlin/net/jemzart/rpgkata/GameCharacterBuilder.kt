package net.jemzart.rpgkata

import net.jemzart.rpgkata.domain.CharacterRange
import net.jemzart.rpgkata.domain.GameCharacter

class GameCharacterBuilder {
	private var level: Int = 1
	private var health: Int = GameCharacter.INITIAL_HEALTH
	private var range = CharacterRange.Melee

	fun level(level: Int): GameCharacterBuilder {
		this.level = level
		return this
	}

	fun melee(): GameCharacterBuilder {
		range = CharacterRange.Melee
		return this
	}

	fun ranged(): GameCharacterBuilder {
		range = CharacterRange.Ranged
		return this
	}

	fun build(): GameCharacter {
		return GameCharacter.create(level = level, range = range)
	}
}