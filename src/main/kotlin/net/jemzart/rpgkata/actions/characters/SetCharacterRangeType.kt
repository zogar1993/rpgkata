package net.jemzart.rpgkata.actions.characters

import net.jemzart.rpgkata.domain.character.CharacterRange
import net.jemzart.rpgkata.domain.character.GameCharacters

class SetCharacterRangeType(private val characters: GameCharacters) {
	operator fun invoke(characterName: String, rangeType: String) {
		val character = characters.search(characterName)
		character.range = CharacterRange.from(rangeType)
		characters.put(character)
	}
}