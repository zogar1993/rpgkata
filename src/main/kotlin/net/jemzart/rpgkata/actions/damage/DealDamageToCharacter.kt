package net.jemzart.rpgkata.actions.damage

import net.jemzart.rpgkata.domain.OVERLEVEL_DAMAGE_FACTOR
import net.jemzart.rpgkata.domain.UNDERLEVEL_DAMAGE_FACTOR
import net.jemzart.rpgkata.domain.character.GameCharacters

class DealDamageToCharacter(private val characters: GameCharacters) {
	operator fun invoke(attackerName: String, targetName: String, amount: Int) {
		val attacker = characters.search(attackerName)
		val target = characters.search(targetName)

		if (attacker == target) return
		if (!attacker.reaches(target)) return
		if (attacker.isAlliedWith(target)) return

		val total = when {
			attacker.level >= target.level + 5 -> (amount * OVERLEVEL_DAMAGE_FACTOR).toInt()
			target.level >= attacker.level + 5 -> (amount * UNDERLEVEL_DAMAGE_FACTOR).toInt()
			else -> amount
		}

		target.damage(total)

		characters.put(target)
	}
}