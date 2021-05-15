package me.Dzyre.mmo;

import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Mobs implements Listener {
	
	@EventHandler
	public void zombieDeath(EntityDamageByEntityEvent event) {
		if (!(event.getEntity() instanceof Zombie)){
			return;
		}
		if (!(event.getDamager() instanceof Player)) {
			return;
		}
		int i = 0;
		Zombie zombie = (Zombie)event.getEntity();
		if (zombie.hasPotionEffect(PotionEffectType.DAMAGE_RESISTANCE)) {
			int z = zombie.getPotionEffect(PotionEffectType.DAMAGE_RESISTANCE).getAmplifier();
			i += z;
			if (i > 2) {
				i = 3;
			}
		}
		zombie.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE,i)); 
		zombie.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE,i+1)); 
		zombie.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE,i)); 
	}
}
