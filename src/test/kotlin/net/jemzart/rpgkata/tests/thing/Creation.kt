package net.jemzart.rpgkata.tests.thing

import net.jemzart.rpgkata.domain.Thing
import org.junit.Test

class Creation {
	@Test
	fun `a thing is created with 2000 health`(){
		val thing = Thing.create(health = 2000)

		assert(thing.health == 2000)
	}

	@Test
	fun `a thing is created with 200 health`(){
		val thing = Thing.create(health = 200)

		assert(thing.health == 200)
	}
}
