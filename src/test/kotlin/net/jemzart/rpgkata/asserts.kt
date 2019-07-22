package net.jemzart.rpgkata

fun assertTrue(actual: Boolean) =
	assert(actual) { "expected: 'true', found: '$actual'"}
fun <T>assertEquals(expected: T, actual: T) =
	assert(expected == actual) { "expected: '$expected', found: '$actual'"}
fun <T>assertIsContained(contained: T, container: List<T>) =
	assert(contained in container) { "expected '$contained' to be contained in  '[${container.joinToString(",")}]'" }
fun <T>assertIsNotContained(contained: T, container: List<T>) =
	assert(contained !in container) { "expected '$contained' not to be contained in  '[${container.joinToString(",")}]'" }