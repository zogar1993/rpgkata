package net.jemzart.rpgkata.actions

import net.jemzart.rpgkata.domain.character.GameCharacters

class LeaveFaction(private val characters: GameCharacters) {
	operator fun invoke(characterName: String, factionName: String){
		val character = characters.search(characterName)

		character.leave(factionName)

		characters.put(character)
	}
}