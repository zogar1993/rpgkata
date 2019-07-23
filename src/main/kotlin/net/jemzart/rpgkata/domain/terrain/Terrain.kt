package net.jemzart.rpgkata.domain.terrain

import net.jemzart.rpgkata.domain.character.GameCharacter
import kotlin.math.absoluteValue

class Terrain {
	private val characters = mutableMapOf<GameCharacter, Int>()

	fun place(character: GameCharacter, coordinate: Int){
		characters[character] = coordinate
	}

	fun distanceBetween(characterA: GameCharacter, characterB: GameCharacter): Int {
		return (characters.getValue(characterA) - characters.getValue(characterB)).absoluteValue
	}

	fun clear() {
		characters.clear()
	}
}