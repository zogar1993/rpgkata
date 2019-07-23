package net.jemzart.rpgkata.actions.characters

import net.jemzart.rpgkata.domain.character.GameCharacter
import net.jemzart.rpgkata.domain.character.GameCharacters
import net.jemzart.rpgkata.domain.terrain.Terrain

class CreateCharacter(private val characters: GameCharacters,
                      private val terrain: Terrain) {
	operator fun invoke(name: String) {
		val character = GameCharacter.create(name = name)
		terrain.place(character, 0)
		characters.put(character)
	}
}