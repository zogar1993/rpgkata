package net.jemzart.rpgkata.domain.character

enum class CharacterRange(val max: Int) {
	Melee(2),
	Ranged(20);

	companion object {
		fun from(name: String): CharacterRange {
			val capitalizedName = name.capitalize()
			return values().first { capitalizedName == it.name }
		}
	}
}