package net.jemzart.rpgkata.actions

import net.jemzart.rpgkata.domain.character.GameCharacters

class SetCharacterLevel(private val characters: GameCharacters) {
	operator fun invoke(name: String, level: Int){
		val character = characters.search(name)
		character.level = level
		characters.put(character)
	}
}