package net.jemzart.rpgkata.domain.character

import net.jemzart.rpgkata.domain.HealthBar

class GameCharacter private constructor(val name: String) {
	var range: CharacterRange = CharacterRange.Melee
	var factions: List<String> = listOf(); private set
	val alive get() = !dead
	val dead get() = healthBar.empty
	var level = INITIAL_LEVEL
	val health get() = healthBar.current

	private var healthBar = HealthBar(INITIAL_HEALTH)

	fun heal(amount: Int) {
		healthBar.increaseBy(amount)
	}

	fun damage(amount: Int) {
		healthBar.decreaseBy(amount)
	}

	fun join(faction: String) {
		factions += faction
	}

	fun leave(faction: String) {
		factions -= faction
	}

	fun isAlliedWith(target: GameCharacter): Boolean {
		return factions.intersect(target.factions).isNotEmpty()
	}

	fun isNotAlliedWith(target: GameCharacter) = !isAlliedWith(target)

	companion object {
		const val INITIAL_HEALTH = HealthBar.MAX_HEALTH
		const val INITIAL_LEVEL = 1
		fun create(name: String): GameCharacter {
			val hero = GameCharacter(name)
			hero.level = INITIAL_LEVEL
			return hero
		}
	}
}