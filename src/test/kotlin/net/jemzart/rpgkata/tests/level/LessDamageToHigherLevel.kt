package net.jemzart.rpgkata.tests.level

import net.jemzart.rpgkata.GameCharacterBuilder
import net.jemzart.rpgkata.actions.DealDamageToCharacter
import net.jemzart.rpgkata.assertEquals
import net.jemzart.rpgkata.domain.character.GameCharacter
import net.jemzart.rpgkata.domain.UNDERLEVEL_DAMAGE_FACTOR
import org.junit.Test

class LessDamageToHigherLevel {
	private val dealDamage: DealDamageToCharacter = DealDamageToCharacter()
	private lateinit var attacker: GameCharacter
	private lateinit var target: GameCharacter

	@Test
	fun `damage from lvl 1 to lvl 5 (4 lvl difference) is normal`(){
		`attacker is level`(1)
		`target is level`(5)

		`attacker deals damage to target`()

		`target should have received normal damage`()
	}

	@Test
	fun `damage from lvl 2 to lvl 6 (4 lvl difference) is normal`(){
		`attacker is level`(2)
		`target is level`(6)

		`attacker deals damage to target`()

		`target should have received normal damage`()
	}

	@Test
	fun `damage from lvl 1 to lvl 6 (5 lvl difference) is decreased`(){
		`attacker is level`(1)
		`target is level`(6)

		`attacker deals damage to target`()

		`target should have received reduced damage`()
	}

	@Test
	fun `damage from lvl 2 to lvl 7 (5 lvl difference) is decreased`(){
		`attacker is level`(2)
		`target is level`(7)

		`attacker deals damage to target`()

		`target should have received reduced damage`()
	}

	private fun `attacker deals damage to target`(){
		dealDamage(attacker = attacker, target = target, amount = DAMAGE)
	}

	private fun `attacker is level`(level: Int){
		attacker = GameCharacterBuilder().level(level).build()
	}

	private fun `target is level`(level: Int){
		target = GameCharacterBuilder().level(level).build()
	}

	private fun `target should have received normal damage`(){
		assertEquals(NORMAL_DAMAGE_RECEIVED, target.health)
	}

	private fun `target should have received reduced damage`(){
		assertEquals(INCREASED_DAMAGE_RECEIVED, target.health)
	}

	private companion object {
		const val DAMAGE = 10
		const val INCREASED_DAMAGE_RECEIVED = GameCharacter.INITIAL_HEALTH - (DAMAGE * UNDERLEVEL_DAMAGE_FACTOR).toInt()
		const val NORMAL_DAMAGE_RECEIVED = GameCharacter.INITIAL_HEALTH - DAMAGE
	}
}