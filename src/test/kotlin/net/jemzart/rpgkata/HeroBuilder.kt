package net.jemzart.rpgkata

import net.jemzart.rpgkata.domain.Hero

class HeroBuilder {
	private var level: Int = 1
	private var health: Int = Hero.MAX_HEALTH

	fun level(level: Int): HeroBuilder {
		this.level = level
		return this
	}

	fun health(health: Int): HeroBuilder {
		this.health = health
		return this
	}

	fun build(): Hero {
		return Hero.create(level = level)
	}
}