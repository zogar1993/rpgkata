package net.jemzart.rpgkata.actions.terrain

import net.jemzart.rpgkata.domain.character.GameCharacters
import net.jemzart.rpgkata.domain.terrain.Terrain

class PlaceCharacterAt(private val characters: GameCharacters,
                       private val terrain: Terrain) {
	operator fun invoke(characterName: String, coordinate: Int) {
		val character = characters.search(characterName)

		terrain.place(character, coordinate)

		characters.put(character)
	}
}