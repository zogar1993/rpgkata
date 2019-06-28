package net.jemzart.rpgkata

import net.jemzart.rpgkata.domain.FighterRange
import net.jemzart.rpgkata.domain.Hero

class HeroBuilder {
	private var level: Int = 1
	private var health: Int = Hero.INITIAL_HEALTH
	private var range = FighterRange.Melee

	fun level(level: Int): HeroBuilder {
		this.level = level
		return this
	}

	fun melee(): HeroBuilder {
		range = FighterRange.Melee
		return this
	}

	fun ranged(): HeroBuilder {
		range = FighterRange.Ranged
		return this
	}

	fun health(health: Int): HeroBuilder {
		this.health = health
		return this
	}

	fun build(): Hero {
		return Hero.create(level = level, range = range)
	}
}