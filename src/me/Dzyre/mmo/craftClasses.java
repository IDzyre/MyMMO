package me.Dzyre.mmo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class craftClasses implements Listener {
	
	boolean hasAssassin = false;
	boolean hasWarrior = false;
	boolean hasTank = false;
	@EventHandler
	public void craftItem(CraftItemEvent event) {
		Random rand = new Random();
		int upperbound = 30;
		int int_random = rand.nextInt(upperbound);
//		Player player = (Player) event.getWhoClicked();
		ItemStack item = event.getRecipe().getResult();
		if (!((item.getType() == (Material.DIAMOND_BOOTS) || (item.getType().equals(Material.DIAMOND_LEGGINGS))
				|| (item.getType().equals(Material.DIAMOND_CHESTPLATE))
				|| (item.getType().equals(Material.DIAMOND_HELMET)) || (item.getType().equals(Material.NETHERITE_BOOTS))
				|| (item.getType().equals(Material.NETHERITE_LEGGINGS))
				|| (item.getType().equals(Material.NETHERITE_CHESTPLATE))
				|| (item.getType().equals(Material.NETHERITE_HELMET)) || (item.getType().equals(Material.IRON_BOOTS))
				|| (item.getType().equals(Material.IRON_LEGGINGS)) || (item.getType().equals(Material.IRON_CHESTPLATE))
				|| (item.getType().equals(Material.IRON_HELMET)) || (item.getType().equals(Material.GOLDEN_BOOTS))
				|| (item.getType().equals(Material.GOLDEN_LEGGINGS))
				|| (item.getType().equals(Material.GOLDEN_CHESTPLATE))
				|| (item.getType().equals(Material.GOLDEN_HELMET)) || (item.getType().equals(Material.LEATHER_BOOTS))
				|| (item.getType().equals(Material.LEATHER_LEGGINGS))
				|| (item.getType().equals(Material.DIAMOND_CHESTPLATE))
				|| (item.getType().equals(Material.LEATHER_HELMET)) || (item.getType().equals(Material.TURTLE_HELMET))
				|| (item.getType().equals(Material.CARVED_PUMPKIN))))) {
			return;
		}
		ItemStack items = event.getCurrentItem();
		ItemMeta meta = items.getItemMeta();
		if (items.hasItemMeta()) {
			if (meta.hasLore()) {
				return;
			}
		}
		List<String> lore = new ArrayList<String>();
		switch (int_random) {
		case 0:
			lore.add(ChatColor.GOLD + "Warrior");
			meta.setLore(lore);
			items.setItemMeta(meta);
			return;
		case 1:
			lore.add(ChatColor.GOLD + "Assassin");
			meta.setLore(lore);
			items.setItemMeta(meta);
			return;
		case 2:
			lore.add(ChatColor.GOLD + "Tank");
			meta.setLore(lore);
			items.setItemMeta(meta);
			return;
		}
		return;
	}

	@EventHandler
	public void craftSwordItem(CraftItemEvent event) {
		Random rand = new Random();
		int upperbound = 8;
		int int_random = rand.nextInt(upperbound);
//		Player player = (Player) event.getWhoClicked();
		ItemStack item = event.getRecipe().getResult();
		if (!((item.getType() == (Material.DIAMOND_AXE) || (item.getType().equals(Material.DIAMOND_SWORD))
				|| (item.getType().equals(Material.IRON_SWORD)) || (item.getType().equals(Material.IRON_AXE))
				|| (item.getType().equals(Material.GOLDEN_SWORD)) || (item.getType().equals(Material.GOLDEN_AXE))
				|| (item.getType().equals(Material.STONE_SWORD)) || (item.getType().equals(Material.STONE_AXE))
				|| (item.getType().equals(Material.NETHERITE_SWORD)) || (item.getType().equals(Material.NETHERITE_AXE))
				|| (item.getType().equals(Material.WOODEN_AXE)) || (item.getType().equals(Material.WOODEN_SWORD))))) {
			return;
		}
		ItemStack items = event.getCurrentItem();
		ItemMeta meta = items.getItemMeta();
		if (items.hasItemMeta()) {
			if (meta.hasLore()) {
				return;
			}
		}
		List<String> lore = new ArrayList<String>();
		switch (int_random) {
		case 0:
			lore.add(ChatColor.GOLD + "Warrior");
			meta.setLore(lore);
			items.setItemMeta(meta);
			return;
		case 1:
			lore.add(ChatColor.GOLD + "Assassin");
			meta.setLore(lore);
			items.setItemMeta(meta);
			return;
		case 2:
			lore.add(ChatColor.GOLD + "Tank");
			meta.setLore(lore);
			items.setItemMeta(meta);
			return;
		}
		return;
	}

	@EventHandler
	public void warrior(InventoryClickEvent e) {
		if (hasAssassin == true)
			return;
		if (hasTank == true)
			return;
		Player player = (Player) e.getWhoClicked();
		int count = 0;
		if (player.getInventory().getBoots() != null) {
			if (player.getInventory().getBoots().getItemMeta().hasLore()) {
				if (player.getInventory().getBoots().getItemMeta().getLore().contains(ChatColor.GOLD + "Warrior")) {
					count++;
				}
			}
		}
		if (player.getInventory().getHelmet() != null) {
			if (player.getInventory().getHelmet().getItemMeta().hasLore()) {
				if (player.getInventory().getHelmet().getItemMeta().getLore().contains(ChatColor.GOLD + "Warrior")) {
					count++;
				}
			}
		}
		if (player.getInventory().getChestplate() != null) {
			if (player.getInventory().getChestplate().getItemMeta().hasLore()) {
				if (player.getInventory().getChestplate().getItemMeta().getLore()
						.contains(ChatColor.GOLD + "Warrior")) {
					count++;
				}
			}
		}
		if (player.getInventory().getLeggings() != null) {
			if (player.getInventory().getLeggings().getItemMeta().hasLore()) {
				if (player.getInventory().getLeggings().getItemMeta().getLore().contains(ChatColor.GOLD + "Warrior")) {
					count++;
				}
			}
		}
		if (count < 4) {
			player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
			player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
			hasWarrior = false;
			return;
		}
		if (count > 4)
			count = 4;
		if (player.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)) {
			if (player.getPotionEffect(PotionEffectType.INCREASE_DAMAGE).getAmplifier() == 0)
				return;
		}
		player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 0));
		player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 0));
		player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, Integer.MAX_VALUE, 0));
		hasWarrior = true;
		return;

	}

	@EventHandler
	public void assassin(InventoryClickEvent e) {
		if (hasWarrior == true)
			return;
		if (hasTank == true)
			return;
		Player player = (Player) e.getWhoClicked();
		int count = 0;
		if (player.getInventory().getBoots() != null) {
			if (player.getInventory().getBoots().getItemMeta().hasLore()) {
				if (player.getInventory().getBoots().getItemMeta().getLore().contains(ChatColor.GOLD + "Assassin")) {
					count++;
				}
			}
		}
		if (player.getInventory().getHelmet() != null) {
			if (player.getInventory().getHelmet().getItemMeta().hasLore()) {
				if (player.getInventory().getHelmet().getItemMeta().getLore().contains(ChatColor.GOLD + "Assassin")) {
					count++;
				}
			}
		}
		if (player.getInventory().getChestplate() != null) {
			if (player.getInventory().getChestplate().getItemMeta().hasLore()) {
				if (player.getInventory().getChestplate().getItemMeta().getLore()
						.contains(ChatColor.GOLD + "Assassin")) {
					count++;
				}
			}
		}
		if (player.getInventory().getLeggings() != null) {
			if (player.getInventory().getLeggings().getItemMeta().hasLore()) {
				if (player.getInventory().getLeggings().getItemMeta().getLore().contains(ChatColor.GOLD + "Assassin")) {
					count++;
				}
			}
		}
		if (count < 4) {
			player.removePotionEffect(PotionEffectType.SPEED);
			player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
			hasAssassin = false;
			return;
		}
		if (count > 4)
			count = 4;
		if (player.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)) {
			if (player.getPotionEffect(PotionEffectType.INCREASE_DAMAGE).getAmplifier() == 0)
				return;
		}
		player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 2));
		player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Integer.MAX_VALUE, 0));
		hasAssassin = true;
		return;

	}

	@EventHandler
	public void tank(InventoryClickEvent e) {
		if (hasWarrior == true)
			return;
		if (hasAssassin == true)
			return;
		Player player = (Player) e.getWhoClicked();
		int count = 0;
		if (player.getInventory().getBoots() != null) {
			if (player.getInventory().getBoots().getItemMeta().hasLore()) {
				if (player.getInventory().getBoots().getItemMeta().getLore().contains(ChatColor.GOLD + "Tank")) {
					count++;
				}
			}
		}
		if (player.getInventory().getHelmet() != null) {
			if (player.getInventory().getHelmet().getItemMeta().hasLore()) {
				if (player.getInventory().getHelmet().getItemMeta().getLore().contains(ChatColor.GOLD + "Tank")) {
					count++;
				}
			}
		}
		if (player.getInventory().getChestplate() != null) {
			if (player.getInventory().getChestplate().getItemMeta().hasLore()) {
				if (player.getInventory().getChestplate().getItemMeta().getLore().contains(ChatColor.GOLD + "Tank")) {
					count++;
				}
			}
		}
		if (player.getInventory().getLeggings() != null) {
			if (player.getInventory().getLeggings().getItemMeta().hasLore()) {
				if (player.getInventory().getLeggings().getItemMeta().getLore().contains(ChatColor.GOLD + "Tank")) {
					count++;
				}
			}
		}
		if (count < 4) {
			player.removePotionEffect(PotionEffectType.SLOW);
			player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
			hasTank = false;
			return;
		}
		if (count > 4)
			count = 4;
		if (player.hasPotionEffect(PotionEffectType.SLOW)) {
			if (player.getPotionEffect(PotionEffectType.SLOW).getAmplifier() == 1)
				return;
		}
		player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 1));
		player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, Integer.MAX_VALUE, 2));
		hasTank = true;
		return;

	}
	
	
	@EventHandler
	public void assassinDamage(EntityDamageByEntityEvent event) {
		if(!(event.getDamager() instanceof Player))
			return;
		if(!(event.getEntity() instanceof Player))
			return;
		Player player = (Player) event.getEntity();
		int count = 0;
		int count1 = 0;
		Player player2 = (Player) event.getDamager();
		if (player.getInventory().getBoots() != null) {
			if (player.getInventory().getBoots().getItemMeta().hasLore()) {
				if (player.getInventory().getBoots().getItemMeta().getLore().contains(ChatColor.GOLD + "Warrior")) {
					count++;
				}
			}
		}
		if (player.getInventory().getLeggings() != null) {
			if (player.getInventory().getLeggings().getItemMeta().hasLore()) {
				if (player.getInventory().getLeggings().getItemMeta().getLore().contains(ChatColor.GOLD + "Warrior")) {
					count++;
				}
			}
		}
		if (player.getInventory().getHelmet() != null) {
			if (player.getInventory().getHelmet().getItemMeta().hasLore()) {
				if (player.getInventory().getHelmet().getItemMeta().getLore().contains(ChatColor.GOLD + "Warrior")) {
					count++;
				}
			}
		}
		if (player.getInventory().getChestplate() != null) {
			if (player.getInventory().getChestplate().getItemMeta().hasLore()) {
				if (player.getInventory().getChestplate().getItemMeta().getLore()
						.contains(ChatColor.GOLD + "Warrior")) {
					count++;
				}
			}
		}
		// Damager
		if (player2.getInventory().getLeggings() != null) {
			if (player2.getInventory().getLeggings().getItemMeta().hasLore()) {
				if (player2.getInventory().getLeggings().getItemMeta().getLore().contains(ChatColor.GOLD + "Assassin")) {
					count1++;
				}
			}
		}
		if (player2.getInventory().getBoots() != null) {
			if (player2.getInventory().getBoots().getItemMeta().hasLore()) {
				if (player2.getInventory().getBoots().getItemMeta().getLore().contains(ChatColor.GOLD + "Assassin")) {
					count1++;
				}
			}
		}
		if (player2.getInventory().getHelmet() != null) {
			if (player2.getInventory().getHelmet().getItemMeta().hasLore()) {
				if (player2.getInventory().getHelmet().getItemMeta().getLore().contains(ChatColor.GOLD + "Assassin")) {
					count1++;
				}
			}
		}
		if (player2.getInventory().getChestplate() != null) {
			if (player2.getInventory().getChestplate().getItemMeta().hasLore()) {
				if (player2.getInventory().getChestplate().getItemMeta().getLore()
						.contains(ChatColor.GOLD + "Assassin")) {
					count1++;
				}
			}
		
		}
		
		if(count == 4 && count1 == 4) {
			if(player2.getInventory().getItemInMainHand() != null) {
			if (player2.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
				if (player2.getInventory().getItemInMainHand().getItemMeta().getLore()
						.contains(ChatColor.GOLD + "Assassin")) {
					event.setDamage(event.getDamage() + 4);
				}
			}
		}
		}
		return;
	}
}
