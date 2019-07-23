package net.jemzart.rpgkata.actions.damage

import net.jemzart.rpgkata.domain.OVERLEVEL_DAMAGE_FACTOR
import net.jemzart.rpgkata.domain.UNDERLEVEL_DAMAGE_FACTOR
import net.jemzart.rpgkata.domain.character.GameCharacter
import net.jemzart.rpgkata.domain.character.GameCharacters
import net.jemzart.rpgkata.domain.terrain.Terrain

class DealDamageToCharacter(
	private val characters: GameCharacters,
	private val terrain: Terrain
) {
	operator fun invoke(attackerName: String, targetName: String, amount: Int) {
		val attacker = characters.search(attackerName)
		val target = characters.search(targetName)

		if (attacker == target) return
		if (attacker.doesNotReach(target)) return
		if (attacker.isAlliedWith(target)) return

		val levelModifier = when {
			attacker.level >= target.level + 5 -> OVERLEVEL_DAMAGE_FACTOR
			target.level >= attacker.level + 5 -> UNDERLEVEL_DAMAGE_FACTOR
			else -> 1.0
		}

		target.damage((amount * levelModifier).toInt())

		characters.put(target)
	}

	private fun GameCharacter.doesNotReach(character: GameCharacter): Boolean {
		val distance = terrain.distanceBetween(this, character)
		return this.range.max < distance
	}
}