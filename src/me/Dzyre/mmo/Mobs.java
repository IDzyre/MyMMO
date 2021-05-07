package me.Dzyre.mmo;

import org.bukkit.entity.EntityType;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class Mobs implements Listener {
	
	public void zombieDeath(EntityDeathEvent event) {
		
		if (event.getEntityType() != EntityType.ZOMBIE ){
			return;
		}
		
		
	}
}
