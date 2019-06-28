package net.jemzart.rpgkata.domain

class Health(value: Int){
	val value = when {
		value > MAX_HEALTH -> MAX_HEALTH
		value < MIN_HEALTH -> MIN_HEALTH
		else -> value
	}
	val alive = this.value > MIN_HEALTH
	operator fun plus(amount: Int) = Health(value + amount)
	operator fun minus(amount: Int) = Health(value - amount)

	companion object {
		const val MAX_HEALTH = 1000
		const val MIN_HEALTH = 0
	}
}