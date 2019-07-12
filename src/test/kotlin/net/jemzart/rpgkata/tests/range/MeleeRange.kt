package net.jemzart.rpgkata.tests.range

import net.jemzart.rpgkata.GameCharacterBuilder
import net.jemzart.rpgkata.actions.DealDamage
import net.jemzart.rpgkata.assertEquals
import net.jemzart.rpgkata.domain.GameCharacter
import org.junit.Before
import org.junit.Test

class MeleeRange {
	private val dealDamage: DealDamage = DealDamage()
	private lateinit var attacker: GameCharacter
	private lateinit var target: GameCharacter

	@Before
	fun setUp(){
		attacker = GameCharacterBuilder().melee().build()
		target = GameCharacterBuilder().build()
	}

	@Test
	fun `melee characters can deal damage 1 meter apart`(){
		`attacker and target are at a distance in meters of`(1)

		`attacker deals damage to target`()

		`target should have received damage`()
	}

	@Test
	fun `melee characters can deal damage 2 meter apart`(){
		`attacker and target are at a distance in meters of`(2)

		`attacker deals damage to target`()

		`target should have received damage`()
	}

	@Test
	fun `melee characters can't deal damage 3 meter apart`(){
		`attacker and target are at a distance in meters of`(3)

		`attacker deals damage to target`()

		`target should not have received damage`()
	}

	private fun `attacker and target are at a distance in meters of`(distance: Int){
		attacker.setDistanceFrom(target, distance)
	}

	private fun `attacker deals damage to target`(){
		dealDamage(attacker = attacker, target = target, amount = DAMAGE)
	}

	private fun `target should have received damage`(){
		assertEquals(DAMAGE_RECEIVED, target.health)
	}

	private fun `target should not have received damage`(){
		assertEquals(GameCharacter.INITIAL_HEALTH, target.health)
	}

	private companion object {
		const val DAMAGE = 10
		const val DAMAGE_RECEIVED = GameCharacter.INITIAL_HEALTH - DAMAGE
	}
}