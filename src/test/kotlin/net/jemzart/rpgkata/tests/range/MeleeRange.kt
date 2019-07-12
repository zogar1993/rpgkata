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
	private lateinit var victim: GameCharacter

	@Before
	fun setUp(){
		attacker = GameCharacterBuilder().health(GameCharacter.INITIAL_HEALTH).melee().build()
		victim = GameCharacterBuilder().health(GameCharacter.INITIAL_HEALTH).build()
	}

	@Test
	fun `melee characters can deal damage 1 meter apart`(){
		`attacker and victim are at a distance in meters of`(1)

		`attacker deals damage to victim`()

		`victim should have received damage`()
	}

	@Test
	fun `melee characters can deal damage 2 meter apart`(){
		`attacker and victim are at a distance in meters of`(2)

		`attacker deals damage to victim`()

		`victim should have received damage`()
	}

	@Test
	fun `melee characters can't deal damage 3 meter apart`(){
		`attacker and victim are at a distance in meters of`(3)

		`attacker deals damage to victim`()

		`victim should not have received damage`()
	}

	private fun `attacker and victim are at a distance in meters of`(distance: Int){
		attacker.setDistanceFrom(victim, distance)
	}

	private fun `attacker deals damage to victim`(){
		dealDamage(attacker = attacker, victim = victim, amount = DAMAGE)
	}

	private fun `victim should have received damage`(){
		assertEquals(DAMAGE_RECEIVED, victim.health)
	}

	private fun `victim should not have received damage`(){
		assertEquals(GameCharacter.INITIAL_HEALTH, victim.health)
	}

	private companion object {
		const val DAMAGE = 10
		const val DAMAGE_RECEIVED = GameCharacter.INITIAL_HEALTH - DAMAGE
	}
}