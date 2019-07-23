package net.jemzart.rpgkata.behaviour

import net.jemzart.rpgkata.actions.characters.CreateCharacter
import net.jemzart.rpgkata.actions.characters.SetCharacterLevel
import net.jemzart.rpgkata.actions.characters.SetCharacterRangeType
import net.jemzart.rpgkata.actions.healing.ApplyHealingToCharacter
import net.jemzart.rpgkata.actions.damage.DealDamageToCharacter
import net.jemzart.rpgkata.actions.distance.DistanceCharacters
import net.jemzart.rpgkata.actions.factions.JoinFaction
import net.jemzart.rpgkata.actions.factions.LeaveFaction
import net.jemzart.rpgkata.domain.character.GameCharacters


const val THE_SHADOW = "the_shadow"
val characters = GameCharacters(THE_SHADOW)
val createCharacter = CreateCharacter(characters)
val dealDamageToCharacter = DealDamageToCharacter(characters)
val applyHealingToCharacter = ApplyHealingToCharacter(characters)
val setCharacterLevel = SetCharacterLevel(characters)
val joinFaction = JoinFaction(characters)
val leaveFaction = LeaveFaction(characters)
val setCharacterRangeType = SetCharacterRangeType(characters)
val distanceCharacters = DistanceCharacters(characters)