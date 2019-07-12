package net.jemzart.rpgkata

import net.jemzart.rpgkata.domain.FighterRange
import net.jemzart.rpgkata.domain.GameCharacter

class GameCharacterBuilder {
	private var level: Int = 1
	private var health: Int = GameCharacter.INITIAL_HEALTH
	private var range = FighterRange.Melee

	fun level(level: Int): GameCharacterBuilder {
		this.level = level
		return this
	}

	fun melee(): GameCharacterBuilder {
		range = FighterRange.Melee
		return this
	}

	fun ranged(): GameCharacterBuilder {
		range = FighterRange.Ranged
		return this
	}

	fun health(health: Int): GameCharacterBuilder {
		this.health = health
		return this
	}

	fun build(): GameCharacter {
		return GameCharacter.create(level = level, range = range)
	}
}