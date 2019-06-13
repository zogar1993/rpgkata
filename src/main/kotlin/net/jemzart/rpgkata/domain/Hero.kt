package net.jemzart.rpgkata.domain

class Hero private constructor() {
	val alive get() = health > 0
	var level = 1; private set
	var health = 1000; private set

	fun damage(hero: Hero, amount: Int) {
		hero.receiveDamage(amount)
	}

	private fun receiveDamage(damage: Int) {
		if (health - damage < 0)
			health = 0
		else
			health -= damage
	}

	fun heal(hero: Hero, amount: Int) {
		if (!hero.alive) return
		hero.receiveHealing(amount)
	}

	private fun receiveHealing(amount: Int) {
		if (health + amount > 1000)
			health = 1000
		else
			health += amount
	}

	companion object {
		fun create(): Hero {
			return Hero()
		}
	}
}