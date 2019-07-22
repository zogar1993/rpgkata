package net.jemzart.rpgkata.actions

import net.jemzart.rpgkata.domain.character.GameCharacter
import net.jemzart.rpgkata.domain.Thing

class DealDamageToThing {
	operator fun invoke(attacker: GameCharacter, target: Thing, amount: Int){
		target.damage(amount)
	}
}