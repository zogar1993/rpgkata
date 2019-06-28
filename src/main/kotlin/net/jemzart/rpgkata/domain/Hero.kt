package net.jemzart.rpgkata.domain

class Hero private constructor(private val range: FighterRange) {
	val alive get() = health > MIN_HEALTH
	var level = 1; private set
	val health get() = _health.value
	private val distances = mutableMapOf<Hero, Int>()

	private var _health = Health(INITIAL_HEALTH)
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
		if (hero in distances.keys && distances.getValue(hero) > range.max) return
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

	fun setDistanceFrom(hero: Hero, distance: Int) {
		distances[hero] = distance
	}

	companion object {
		const val MAX_HEALTH = 1000
		const val MIN_HEALTH = 0
		const val INITIAL_HEALTH = MAX_HEALTH
		fun create(level: Int = 1, range: FighterRange = FighterRange.Melee): Hero {
			val hero = Hero(range = range)
			hero.level = level
			return hero
		}
	}
}