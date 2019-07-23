package net.jemzart.rpgkata.domain.thing

import net.jemzart.rpgkata.domain.HealthBar

class Thing(val name: String,
            private val healthBar: HealthBar) {
	val destroyed get() = healthBar.empty
	val health get() = healthBar.current

	fun damage(amount: Int) {
		healthBar.decreaseBy(amount)
	}

	companion object {
		fun create(name: String, health: Int): Thing {
			return Thing(name, HealthBar(health))
		}
	}
}