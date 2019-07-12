package net.jemzart.rpgkata.actions

import net.jemzart.rpgkata.domain.GameCharacter

class DealDamage {
	operator fun invoke(attacker: GameCharacter, victim: GameCharacter, amount: Int){
		attacker.damage(victim, amount)
	}
}