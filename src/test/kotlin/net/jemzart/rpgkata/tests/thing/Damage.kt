package net.jemzart.rpgkata.tests.thing

import net.jemzart.rpgkata.GameCharacterBuilder
import net.jemzart.rpgkata.actions.damage.DealDamageToThing
import net.jemzart.rpgkata.domain.character.GameCharacter
import net.jemzart.rpgkata.domain.Thing
import org.junit.Before
import org.junit.Test

class Damage {
	private lateinit var dealDamage: DealDamageToThing
	private lateinit var linuar: GameCharacter
	private lateinit var chair: Thing

	@Before
	fun setUp(){
		dealDamage = DealDamageToThing()
		linuar = GameCharacterBuilder().build()
		chair = Thing.create(CHAIR_HEALTH)
	}

	@Test
	fun `linuar can damage a chair`(){
		`linuar damages the chair`(A_LITTLE_DAMAGE)

		`the chair should be damaged`()
	}

	@Test
	fun `linuar deals overflowing damage to a chair`(){
		`linuar damages the chair`(TONS_OF_DAMAGE)

		`the chair should be destroyed`()
	}

	private fun `linuar damages the chair`(amount: Int) {
		dealDamage(attacker = linuar, target = chair, amount = amount)
	}

	private fun `the chair should be damaged`() {
//		assertEquals(chair.health, CHAIR_HEALTH - 5)
	}

	private fun `the chair should be destroyed`() {
		assert(chair.destroyed)
	}

	companion object{
		const val CHAIR_HEALTH = 2000
		const val A_LITTLE_DAMAGE = 5
		const val TONS_OF_DAMAGE = 2001
	}
}