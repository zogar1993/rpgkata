package net.jemzart.rpgkata.actions

import net.jemzart.rpgkata.domain.character.GameCharacter

class LeaveFaction {
	operator fun invoke(character: GameCharacter, faction: String){
		character.leave(faction)
	}
}