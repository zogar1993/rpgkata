package net.jemzart.rpgkata.actions.things

import net.jemzart.rpgkata.domain.thing.Thing
import net.jemzart.rpgkata.domain.thing.Things

class CreateThing(private val things: Things) {
	operator fun invoke(name: String, health: Int) {
		val thing = Thing.create(name = name, health = health)
		things.put(thing)
	}
}