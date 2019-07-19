package net.jemzart.rpgkata.domain

class HealthBar(val max: Int){
	var current = max
		private set(value) {
			field = when {
				value > max -> max
				value < EMPTY_VALUE -> EMPTY_VALUE
				else -> value
			}
		}

	val empty get() = this.current == EMPTY_VALUE

	fun increaseBy(amount: Int){
		current += amount
	}
	fun decreaseBy(amount: Int){
		current -= amount
	}

	companion object {
		const val MAX_HEALTH = 1000
		const val EMPTY_VALUE = 0
	}
}