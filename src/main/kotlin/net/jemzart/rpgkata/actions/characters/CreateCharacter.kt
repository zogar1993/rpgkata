package net.jemzart.rpgkata.actions.characters

import net.jemzart.rpgkata.domain.character.GameCharacter
import net.jemzart.rpgkata.domain.character.GameCharacters

class CreateCharacter(private val characters: GameCharacters) {
	operator fun invoke(name: String) {
		val character = GameCharacter.create(name = name)
		characters.put(character)
	}
}