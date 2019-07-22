package net.jemzart.rpgkata.actions

import net.jemzart.rpgkata.domain.character.GameCharacter
import net.jemzart.rpgkata.domain.character.GameCharacters

class ApplyHealingToCharacter(private val characters: GameCharacters) {
	operator fun invoke(healer: GameCharacter, target: GameCharacter, amount: Int){
		if (healer.isNotAlliedWith(target) && healer != target) return
		if (target.dead) return

		target.heal(amount)
	}

	operator fun invoke(healerName: String, targetName: String, amount: Int){
		val healer = characters.search(healerName)
		val target = characters.search(targetName)

		if (healer.isNotAlliedWith(target) && healer != target) return
		if (target.dead) return

		target.heal(amount)

		characters.put(target)
	}
}