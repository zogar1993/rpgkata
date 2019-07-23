package net.jemzart.rpgkata.actions.distance

import net.jemzart.rpgkata.domain.character.GameCharacters

class DistanceCharacters(private val characters: GameCharacters) {
	operator fun invoke(characterAName: String, characterBName: String, distance: Int){
		val characterA = characters.search(characterAName)
		val characterB = characters.search(characterBName)

		characterA.setDistanceFrom(characterB, distance)
		characterB.setDistanceFrom(characterA, distance)

		characters.put(characterA)
		characters.put(characterB)
	}
}