package net.jemzart.rpgkata.actions

import net.jemzart.rpgkata.domain.Hero

class ApplyHealing {
	operator fun invoke(hero: Hero, target: Hero, amount: Int){
		hero.heal(target, amount)
	}
}