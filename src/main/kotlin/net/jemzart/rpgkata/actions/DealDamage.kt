package net.jemzart.rpgkata.actions

import net.jemzart.rpgkata.domain.Hero

class DealDamage {
	operator fun invoke(attacker: Hero, victim: Hero, amount: Int){
		attacker.damage(victim, amount)
	}
}