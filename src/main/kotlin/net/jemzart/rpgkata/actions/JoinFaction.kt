package net.jemzart.rpgkata.actions

import net.jemzart.rpgkata.domain.GameCharacter

class JoinFaction {
	operator fun invoke(character: GameCharacter, faction: String){
		character.join(faction)
	}
}