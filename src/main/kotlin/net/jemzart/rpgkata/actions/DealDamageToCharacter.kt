package net.jemzart.rpgkata.actions

import net.jemzart.rpgkata.domain.GameCharacter
import net.jemzart.rpgkata.domain.OVERLEVEL_DAMAGE_FACTOR
import net.jemzart.rpgkata.domain.UNDERLEVEL_DAMAGE_FACTOR

class DealDamageToCharacter {
	operator fun invoke(attacker: GameCharacter, target: GameCharacter, amount: Int){
		if (attacker == target) return
		if (!attacker.reaches(target)) return
		if (attacker.isAlliedWith(target)) return

		val total = when {
			attacker.level >= target.level + 5 -> (amount * OVERLEVEL_DAMAGE_FACTOR).toInt()
			target.level >= attacker.level + 5 -> (amount * UNDERLEVEL_DAMAGE_FACTOR).toInt()
			else -> amount
		}

		target.damage(total)
	}
}