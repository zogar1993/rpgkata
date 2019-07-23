package net.jemzart.rpgkata.actions.damage

import net.jemzart.rpgkata.domain.character.GameCharacters
import net.jemzart.rpgkata.domain.thing.Things

class DealDamageToThing(private val characters: GameCharacters,
                        private val things: Things) {
	operator fun invoke(attackerName: String, thingName: String, amount: Int) {
		val thing = things.search(thingName)
		thing.damage(amount)
		things.put(thing)
	}
}