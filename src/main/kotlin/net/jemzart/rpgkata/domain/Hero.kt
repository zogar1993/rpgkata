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
		hero.receiveDamage(amount)
	}

	private fun receiveDamage(amount: Int) {
		_health -= amount
	}

	fun heal(hero: Hero, amount: Int) {
		if (hero != this) return
		if (!hero.alive) return
		hero.receiveHealing(amount)
	}

	private fun receiveHealing(amount: Int) {
		_health += amount
	}

	companion object {
		private const val MAX_HEALTH = 1000
		private const val MIN_HEALTH = 0
		fun create(): Hero {
			return Hero()
		}
	}
}