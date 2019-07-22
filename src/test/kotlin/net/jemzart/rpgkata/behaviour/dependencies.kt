package net.jemzart.rpgkata.behaviour

import net.jemzart.rpgkata.actions.*
import net.jemzart.rpgkata.domain.character.GameCharacters


const val THE_SHADOW = "the_shadow"
val characters = GameCharacters(THE_SHADOW)
val createCharacter = CreateCharacter(characters)
val dealDamageToCharacter = DealDamageToCharacter(characters)
val applyHealingToCharacter = ApplyHealingToCharacter(characters)
val setCharacterLevel = SetCharacterLevel(characters)
val joinFaction = JoinFaction(characters)
val leaveFaction = LeaveFaction(characters)