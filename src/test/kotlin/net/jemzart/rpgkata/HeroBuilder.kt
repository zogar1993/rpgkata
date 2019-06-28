package net.jemzart.rpgkata

import net.jemzart.rpgkata.domain.Hero

class HeroBuilder {
	private var level: Int = 1

	fun level(level: Int): HeroBuilder {
		this.level = level
		return this
	}

	fun build(): Hero {
		return Hero.create(level = level)
	}
}