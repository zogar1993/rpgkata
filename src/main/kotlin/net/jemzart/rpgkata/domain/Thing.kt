package net.jemzart.rpgkata.domain

class Thing(private val healthBar: HealthBar) {
	val destroyed get() = healthBar.empty
	val health get() = healthBar.current

	fun damage(amount: Int) {
		healthBar.decreaseBy(amount)
	}

	companion object {
		fun create(health: Int): Thing{
			return Thing(HealthBar(health))
		}
	}
}