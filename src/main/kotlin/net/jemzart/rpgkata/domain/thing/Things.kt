package net.jemzart.rpgkata.domain.thing

class Things {
	private val things = mutableMapOf<String, Thing>()
	fun put(thing: Thing) {
		things[thing.name] = thing
	}

	fun search(name: String): Thing {
		return things.getValue(name)
	}

	fun clear() {
		things.clear()
	}
}