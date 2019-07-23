package net.jemzart.rpgkata.behaviour

import net.jemzart.rpgkata.actions.characters.CreateCharacter
import net.jemzart.rpgkata.actions.characters.SetCharacterLevel
import net.jemzart.rpgkata.actions.characters.SetCharacterRangeType
import net.jemzart.rpgkata.actions.damage.DealDamageToCharacter
import net.jemzart.rpgkata.actions.damage.DealDamageToThing
import net.jemzart.rpgkata.actions.terrain.PlaceCharacterAt
import net.jemzart.rpgkata.actions.factions.JoinFaction
import net.jemzart.rpgkata.actions.factions.LeaveFaction
import net.jemzart.rpgkata.actions.healing.ApplyHealingToCharacter
import net.jemzart.rpgkata.actions.things.CreateThing
import net.jemzart.rpgkata.domain.character.GameCharacters
import net.jemzart.rpgkata.domain.terrain.Terrain
import net.jemzart.rpgkata.domain.thing.Things

val terrain = Terrain()
val characters = GameCharacters()
val things = Things()
val createCharacter = CreateCharacter(characters, terrain)
val createThing = CreateThing(things)
val dealDamageToCharacter = DealDamageToCharacter(characters, terrain)
val applyHealingToCharacter = ApplyHealingToCharacter(characters)
val setCharacterLevel = SetCharacterLevel(characters)
val joinFaction = JoinFaction(characters)
val leaveFaction = LeaveFaction(characters)
val setCharacterRangeType = SetCharacterRangeType(characters)
val placeCharacterAt = PlaceCharacterAt(characters, terrain)
val dealDamageToThing = DealDamageToThing(characters, things)