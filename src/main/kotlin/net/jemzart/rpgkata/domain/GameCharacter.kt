package net.jemzart.rpgkata.domain

class GameCharacter private constructor(private val range: FighterRange) {
	var factions: List<String> = listOf(); private set
	val alive get() = _health.alive
	var level = 1; private set
	val health get() = _health.value
	private val distances = mutableMapOf<GameCharacter, Int>()

	private var _health = Health(INITIAL_HEALTH)

	fun damage(character: GameCharacter, amount: Int) {
		if (character == this) return
		if (character in distances.keys && distances.getValue(character) > range.max) return
		character._health -= calculateDamage(character, amount)
	}

	private fun calculateDamage(character: GameCharacter, amount: Int): Int {
		return when {
			level >= character.level + 5 -> (amount * OVERLEVEL_DAMAGE_FACTOR).toInt()
			character.level >= level + 5 -> (amount * UNDERLEVEL_DAMAGE_FACTOR).toInt()
			else -> amount
		}
	}

	fun heal(character: GameCharacter, amount: Int) {
		if (character != this) return
		if (!character.alive) return
		character._health += amount
	}

	fun setDistanceFrom(character: GameCharacter, distance: Int) {
		distances[character] = distance
	}

	fun join(faction: String) {
		factions += faction
	}

	companion object {
		const val INITIAL_HEALTH = Health.MAX_HEALTH
		fun create(level: Int = 1, range: FighterRange = FighterRange.Melee): GameCharacter {
			val hero = GameCharacter(range = range)
			hero.level = level
			return hero
		}
	}
}