package net.jemzart.rpgkata.domain

class Hero private constructor() {
	val alive get() = health > MIN_HEALTH
	var level = 1; private set
	val health get() = _health.value
	private var _health = Health(MAX_HEALTH)
	class Health(value: Int){
		val value = when {
			value > MAX_HEALTH -> MAX_HEALTH
			value < MIN_HEALTH -> MIN_HEALTH
			else -> value
		}
		operator fun plus(amount: Int) = Health(value + amount)
		operator fun minus(amount: Int) = Health(value - amount)
	}

	fun damage(hero: Hero, amount: Int) {
		if (hero == this) return
		hero._health -= calculateDamage(hero, amount)
	}

	private fun calculateDamage(hero: Hero, amount: Int): Int {
		return when {
			level >= hero.level + 5 -> (amount * 1.5).toInt()
			hero.level >= level + 5 -> (amount * 0.5).toInt()
			else -> amount
		}
	}

	fun heal(hero: Hero, amount: Int) {
		if (hero != this) return
		if (!hero.alive) return
		hero._health += amount
	}

	companion object {
		const val MAX_HEALTH = 1000
		const val MIN_HEALTH = 0
		fun create(level: Int = 1): Hero {
			val hero = Hero()
			hero.level = level
			return hero
		}
	}
}