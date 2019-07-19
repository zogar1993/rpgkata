package net.jemzart.rpgkata.domain

class GameCharacter private constructor(private val range: CharacterRange) {
	var factions: List<String> = listOf(); private set
	val alive get() = _health.alive
	val dead get() = !alive
	var level = INITIAL_LEVEL; private set
	val health get() = _health.value
	private val distances = mutableMapOf<GameCharacter, Int>()

	private var _health = Health(INITIAL_HEALTH)

	fun heal(amount: Int) {
		this._health += amount
	}

	fun damage(amount: Int){
		this._health -= amount
	}

	fun setDistanceFrom(character: GameCharacter, distance: Int) {
		distances[character] = distance
	}

	fun join(faction: String) {
		factions += faction
	}

	fun leave(faction: String) {
		factions -= faction
	}

	fun reaches(character: GameCharacter): Boolean {
		return !(character in distances.keys && distances.getValue(character) > range.max)
	}

	fun isAlliedWith(target: GameCharacter): Boolean {
		return factions.intersect(target.factions).isNotEmpty()
	}

	fun isNotAlliedWith(target: GameCharacter) = !isAlliedWith(target)

	companion object {
		const val INITIAL_HEALTH = Health.MAX_HEALTH
		const val INITIAL_LEVEL = 1
		fun create(level: Int = INITIAL_LEVEL, range: CharacterRange = CharacterRange.Melee): GameCharacter {
			val hero = GameCharacter(range = range)
			hero.level = level
			return hero
		}
	}
}