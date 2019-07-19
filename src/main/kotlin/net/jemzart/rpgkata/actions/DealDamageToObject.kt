package net.jemzart.rpgkata.actions

import net.jemzart.rpgkata.domain.GameCharacter
import net.jemzart.rpgkata.domain.OVERLEVEL_DAMAGE_FACTOR
import net.jemzart.rpgkata.domain.Thing
import net.jemzart.rpgkata.domain.UNDERLEVEL_DAMAGE_FACTOR

class DealDamageToThing {
	operator fun invoke(attacker: GameCharacter, target: Thing, amount: Int){
		target.damage(amount)
	}
}