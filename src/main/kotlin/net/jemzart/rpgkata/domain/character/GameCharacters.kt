package net.jemzart.rpgkata.domain.character

class GameCharacters(vararg names: String) {
	private val characters = names.map { it to GameCharacter.create(name = it) }.toMap().toMutableMap()
	fun put(character: GameCharacter) {
		characters[character.name] = character
	}

	fun search(name: String): GameCharacter {
		return characters.getValue(name)
	}
}