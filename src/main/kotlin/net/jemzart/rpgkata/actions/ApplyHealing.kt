package net.jemzart.rpgkata.actions

import net.jemzart.rpgkata.domain.GameCharacter

class ApplyHealing {
	operator fun invoke(healer: GameCharacter, target: GameCharacter, amount: Int){
		healer.heal(target, amount)
	}
}