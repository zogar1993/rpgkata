package net.jemzart.rpgkata.actions

import net.jemzart.rpgkata.domain.GameCharacter

class ApplyHealing {
	operator fun invoke(healer: GameCharacter, target: GameCharacter, amount: Int){
		if (healer.isNotAlliedWith(target) && healer != target) return
		if (target.dead) return

		target.heal(amount)
	}
}