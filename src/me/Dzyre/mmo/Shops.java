package me.Dzyre.mmo;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Shops {

	public static Inventory inv;
	public static Inventory diamondArmor;
	public static Inventory Cancel;
	ItemStack itemz = null;
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]) {

		if (label.equalsIgnoreCase("shop")) {
			Player player = (Player) sender;
			player.openInventory(inv);
			return true;
		}
		return true;

	}

	@EventHandler
	public void onClick(InventoryClickEvent event) {
		if (!((event.getInventory().equals(inv)) || event.getInventory().equals(diamondArmor)
				|| event.getInventory().equals(Cancel)))
			return;
		if (event.getCurrentItem() == null)
			return;
		if (event.getCurrentItem().getItemMeta() == null)
			return;
		if (event.getCurrentItem().getItemMeta().getDisplayName() == null)
			return;
		Player player = (Player) event.getWhoClicked();
		event.setCancelled(true);

		if ((event.getCurrentItem().getType().equals(Material.DIAMOND)) && (event.getCurrentItem().hasItemMeta())
				&& event.getClickedInventory().equals(inv)) {
			player.openInventory(diamondArmor);
		}
		if ((event.getClickedInventory().equals(diamondArmor)) && !(event.getCurrentItem().getType() == null)) {
			itemz = event.getCurrentItem();

			confirm(itemz, diamondArmor, itemz.getItemMeta().getLore());
			player.openInventory(Cancel);

		}
		if ((event.getCurrentItem().getType().equals(Material.RED_WOOL))
				&& event.getCurrentItem().getItemMeta().getDisplayName().contains(ChatColor.RED + "Cancel")) {
			player.closeInventory();
			player.openInventory(diamondArmor);
			return;
		}
		if ((event.getCurrentItem().getType().equals(Material.GREEN_WOOL))
				&& event.getCurrentItem().getItemMeta().getDisplayName().contains(ChatColor.GREEN + "Confirm")) {
			if ((player.getInventory().contains(itemz.getType(),1)) && (player.getLevel() > 30.0)) {
				player.setLevel(player.getLevel() - 30);
			ItemStack giveItem = new ItemStack(itemz.getType());
			player.getInventory().removeItem(giveItem);
			ItemMeta myMeta = giveItem.getItemMeta();
			List<String> lore = itemz.getItemMeta().getLore();
			lore.remove(1);
			myMeta.setLore(lore);
			giveItem.setItemMeta(myMeta);
			player.getInventory().removeItem(giveItem);
			player.getInventory().addItem(giveItem);
			player.closeInventory();
			player.openInventory(diamondArmor);
			return;
			}
			else {
				player.sendMessage(ChatColor.RED + "You do not have the required items or levels");
				player.closeInventory();
				player.openInventory(diamondArmor);
			}
		}
	}

	public void confirm(ItemStack item, Inventory inv, List<String> lore) {
		Cancel = Bukkit.createInventory(null, 9, ChatColor.GREEN + "" + ChatColor.BOLD + "Confirm Purchase");

		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(item.getItemMeta().getDisplayName());
		if (lore.contains("Warrior")) {
			lore.clear();
			lore.add(ChatColor.GOLD + "Warrior");
		}
		meta.setLore(lore);
		item.setItemMeta(meta);
		Cancel.setItem(4, item);

		ItemStack cancelitem = new ItemStack(Material.GREEN_WOOL);
		// Yes
		cancelitem.setType(Material.GREEN_WOOL);
		meta.setDisplayName(ChatColor.GREEN + "Confirm");
		lore.clear();
		meta.setLore(lore);
		cancelitem.setItemMeta(meta);
		Cancel.setItem(2, cancelitem);

		// No
		cancelitem.setType(Material.RED_WOOL);
		meta.setDisplayName(ChatColor.RED + "Cancel and Return");
		lore.clear();
		meta.setLore(lore);
		cancelitem.setItemMeta(meta);
		Cancel.setItem(6, cancelitem);

		return;
	}
	
	public static void createInventory() {
		inv = Bukkit.createInventory(null, 27, ChatColor.GOLD + "" + ChatColor.BOLD + "Shop");
		diamondArmor = Bukkit.createInventory(null, 54, ChatColor.AQUA + "" + ChatColor.BOLD + "Diamond Armor");
		ItemStack item = new ItemStack(Material.DIAMOND);
		ItemMeta meta = item.getItemMeta();

		meta.setDisplayName(ChatColor.GOLD + "Diamond Armor");
		List<String> lore = new ArrayList<String>();
		lore.add("Shop for Diamond Armor with Traits");
		meta.setLore(lore);
		item.setItemMeta(meta);
		inv.setItem(0, item);

		ItemStack armor = new ItemStack(Material.DIAMOND_HELMET);
		ItemMeta aMeta = armor.getItemMeta();
		aMeta.setDisplayName(ChatColor.GOLD + "Diamond Helmet");
		List<String> aLore = new ArrayList<String>();
		aLore.add(ChatColor.GOLD + "Warrior");
		aLore.add(ChatColor.LIGHT_PURPLE + "Costs: " + armor.getType() + " and 30 EXP levels");
		aMeta.setLore(aLore);
		armor.setItemMeta(aMeta);
		diamondArmor.setItem(0, armor);

		// Chestplate
		armor.setType(Material.DIAMOND_CHESTPLATE);
		aMeta.setDisplayName(ChatColor.GOLD + "Diamond Chestplate");
		aLore.clear();
		aLore.add(ChatColor.GOLD + "Warrior");
		aLore.add(ChatColor.LIGHT_PURPLE + "Costs: " + armor.getType() + " and 30 EXP levels");
		aMeta.setLore(aLore);
		armor.setItemMeta(aMeta);
		diamondArmor.setItem(9, armor);
		// Leggings
		armor.setType(Material.DIAMOND_LEGGINGS);
		aMeta.setDisplayName(ChatColor.GOLD + "Diamond Leggings");
		aLore.clear();
		aLore.add(ChatColor.GOLD + "Warrior");
		aLore.add(ChatColor.LIGHT_PURPLE + "Costs: " + armor.getType() + " and 30 EXP levels");
		aMeta.setLore(aLore);
		armor.setItemMeta(aMeta);
		diamondArmor.setItem(18, armor);
		// Boots
		armor.setType(Material.DIAMOND_BOOTS);
		aMeta.setDisplayName(ChatColor.GOLD + "Diamond Boots");
		aLore.clear();
		aLore.add(ChatColor.GOLD + "Warrior");
		aLore.add(ChatColor.LIGHT_PURPLE + "Costs: " + armor.getType() + " and 30 EXP levels");
		aMeta.setLore(aLore);
		armor.setItemMeta(aMeta);
		diamondArmor.setItem(27, armor);
		
		// Assassin
		
		// Helmet
		armor.setType(Material.DIAMOND_HELMET);
		aMeta.setDisplayName(ChatColor.GOLD + "Diamond Helmet");
		aLore.clear();
		aLore.add(ChatColor.GOLD + "Assassin");
		aLore.add(ChatColor.LIGHT_PURPLE + "Costs: " + armor.getType() + " and 30 EXP levels");
		aMeta.setLore(aLore);
		armor.setItemMeta(aMeta);
		diamondArmor.setItem(1, armor);

		// Chestplate
		armor.setType(Material.DIAMOND_CHESTPLATE);
		aMeta.setDisplayName(ChatColor.GOLD + "Diamond Chestplate");
		aLore.clear();
		aLore.add(ChatColor.GOLD + "Assassin");
		aLore.add(ChatColor.LIGHT_PURPLE + "Costs: " + armor.getType() + " and 30 EXP levels");
		aMeta.setLore(aLore);
		armor.setItemMeta(aMeta);
		diamondArmor.setItem(10, armor);
		// Leggings
		armor.setType(Material.DIAMOND_LEGGINGS);
		aMeta.setDisplayName(ChatColor.GOLD + "Diamond Leggings");
		aLore.clear();
		aLore.add(ChatColor.GOLD + "Assassin");
		aLore.add(ChatColor.LIGHT_PURPLE + "Costs: " + armor.getType() + " and 30 EXP levels");
		aMeta.setLore(aLore);
		armor.setItemMeta(aMeta);
		diamondArmor.setItem(19, armor);
		// Boots
		armor.setType(Material.DIAMOND_BOOTS);
		aMeta.setDisplayName(ChatColor.GOLD + "Diamond Boots");
		aLore.clear();
		aLore.add(ChatColor.GOLD + "Assassin");
		aLore.add(ChatColor.LIGHT_PURPLE + "Costs: " + armor.getType() + " and 30 EXP levels");
		aMeta.setLore(aLore);
		armor.setItemMeta(aMeta);
		diamondArmor.setItem(28, armor);
		
		// Tank
		
		// Helmet
				armor.setType(Material.DIAMOND_HELMET);
				aMeta.setDisplayName(ChatColor.GOLD + "Diamond Helmet");
				aLore.clear();
				aLore.add(ChatColor.GOLD + "Tank");
				aLore.add(ChatColor.LIGHT_PURPLE + "Costs: " + armor.getType() + " and 30 EXP levels");
				aMeta.setLore(aLore);
				armor.setItemMeta(aMeta);
				diamondArmor.setItem(2, armor);

				// Chestplate
				armor.setType(Material.DIAMOND_CHESTPLATE);
				aMeta.setDisplayName(ChatColor.GOLD + "Diamond Chestplate");
				aLore.clear();
				aLore.add(ChatColor.GOLD + "Tank");
				aLore.add(ChatColor.LIGHT_PURPLE + "Costs: " + armor.getType() + " and 30 EXP levels");
				aMeta.setLore(aLore);
				armor.setItemMeta(aMeta);
				diamondArmor.setItem(11, armor);
				// Leggings
				armor.setType(Material.DIAMOND_LEGGINGS);
				aMeta.setDisplayName(ChatColor.GOLD + "Diamond Leggings");
				aLore.clear();
				aLore.add(ChatColor.GOLD + "Tank");
				aLore.add(ChatColor.LIGHT_PURPLE + "Costs: " + armor.getType() + " and 30 EXP levels");
				aMeta.setLore(aLore);
				armor.setItemMeta(aMeta);
				diamondArmor.setItem(20, armor);
				// Boots
				armor.setType(Material.DIAMOND_BOOTS);
				aMeta.setDisplayName(ChatColor.GOLD + "Diamond Boots");
				aLore.clear();
				aLore.add(ChatColor.GOLD + "Tank");
				aLore.add(ChatColor.LIGHT_PURPLE + "Costs: " + armor.getType() + " and 30 EXP levels");
				aMeta.setLore(aLore);
				armor.setItemMeta(aMeta);
				diamondArmor.setItem(29, armor);
			
				//IRON ARMOR
				
				// Helmet
				
				armor.setType(Material.IRON_HELMET);
				aMeta.setDisplayName(ChatColor.GOLD + "Iron Helmet");
				aLore.clear();
				aLore.add(ChatColor.GOLD + "Warrior");
				aLore.add(ChatColor.LIGHT_PURPLE + "Costs: " + armor.getType() + " and 30 EXP levels");
				aMeta.setLore(aLore);
				armor.setItemMeta(aMeta);
				diamondArmor.setItem(3, armor);

				// Chestplate
				armor.setType(Material.IRON_CHESTPLATE);
				aMeta.setDisplayName(ChatColor.GOLD + "Iron Chestplate");
				aLore.clear();
				aLore.add(ChatColor.GOLD + "Warrior");
				aLore.add(ChatColor.LIGHT_PURPLE + "Costs: " + armor.getType() + " and 30 EXP levels");
				aMeta.setLore(aLore);
				armor.setItemMeta(aMeta);
				diamondArmor.setItem(12, armor);
				// Leggings
				armor.setType(Material.IRON_LEGGINGS);
				aMeta.setDisplayName(ChatColor.GOLD + "Iron Leggings");
				aLore.clear();
				aLore.add(ChatColor.GOLD + "Warrior");
				aLore.add(ChatColor.LIGHT_PURPLE + "Costs: " + armor.getType() + " and 30 EXP levels");
				aMeta.setLore(aLore);
				armor.setItemMeta(aMeta);
				diamondArmor.setItem(21, armor);
				// Boots
				armor.setType(Material.IRON_BOOTS);
				aMeta.setDisplayName(ChatColor.GOLD + "Iron Boots");
				aLore.clear();
				aLore.add(ChatColor.GOLD + "Warrior");
				aLore.add(ChatColor.LIGHT_PURPLE + "Costs: " + armor.getType() + " and 30 EXP levels");
				aMeta.setLore(aLore);
				armor.setItemMeta(aMeta);
				diamondArmor.setItem(30, armor);
				
				// Assassin
				
				// Helmet
				armor.setType(Material.IRON_HELMET);
				aMeta.setDisplayName(ChatColor.GOLD + "Iron Helmet");
				aLore.clear();
				aLore.add(ChatColor.GOLD + "Assassin");
				aLore.add(ChatColor.LIGHT_PURPLE + "Costs: " + armor.getType() + " and 30 EXP levels");
				aMeta.setLore(aLore);
				armor.setItemMeta(aMeta);
				diamondArmor.setItem(4, armor);

				// Chestplate
				armor.setType(Material.IRON_CHESTPLATE);
				aMeta.setDisplayName(ChatColor.GOLD + "Iron Chestplate");
				aLore.clear();
				aLore.add(ChatColor.GOLD + "Assassin");
				aLore.add(ChatColor.LIGHT_PURPLE + "Costs: " + armor.getType() + " and 30 EXP levels");
				aMeta.setLore(aLore);
				armor.setItemMeta(aMeta);
				diamondArmor.setItem(13, armor);
				// Leggings
				armor.setType(Material.IRON_LEGGINGS);
				aMeta.setDisplayName(ChatColor.GOLD + "Iron Leggings");
				aLore.clear();
				aLore.add(ChatColor.GOLD + "Assassin");
				aLore.add(ChatColor.LIGHT_PURPLE + "Costs: " + armor.getType() + " and 30 EXP levels");
				aMeta.setLore(aLore);
				armor.setItemMeta(aMeta);
				diamondArmor.setItem(22, armor);
				// Boots
				armor.setType(Material.IRON_BOOTS);
				aMeta.setDisplayName(ChatColor.GOLD + "Iron Boots");
				aLore.clear();
				aLore.add(ChatColor.GOLD + "Assassin");
				aLore.add(ChatColor.LIGHT_PURPLE + "Costs: " + armor.getType() + " and 30 EXP levels");
				aMeta.setLore(aLore);
				armor.setItemMeta(aMeta);
				diamondArmor.setItem(31, armor);
				
				// Tank
				
				// Helmet
						armor.setType(Material.IRON_HELMET);
						aMeta.setDisplayName(ChatColor.GOLD + "Iron Helmet");
						aLore.clear();
						aLore.add(ChatColor.GOLD + "Tank");
						aLore.add(ChatColor.LIGHT_PURPLE + "Costs: " + armor.getType() + " and 30 EXP levels");
						aMeta.setLore(aLore);
						armor.setItemMeta(aMeta);
						diamondArmor.setItem(5, armor);

						// Chestplate
						armor.setType(Material.IRON_CHESTPLATE);
						aMeta.setDisplayName(ChatColor.GOLD + "Iron Chestplate");
						aLore.clear();
						aLore.add(ChatColor.GOLD + "Tank");
						aLore.add(ChatColor.LIGHT_PURPLE + "Costs: " + armor.getType() + " and 30 EXP levels");
						aMeta.setLore(aLore);
						armor.setItemMeta(aMeta);
						diamondArmor.setItem(14, armor);
						// Leggings
						armor.setType(Material.IRON_LEGGINGS);
						aMeta.setDisplayName(ChatColor.GOLD + "Iron Leggings");
						aLore.clear();
						aLore.add(ChatColor.GOLD + "Tank");
						aLore.add(ChatColor.LIGHT_PURPLE + "Costs: " + armor.getType() + " and 30 EXP levels");
						aMeta.setLore(aLore);
						armor.setItemMeta(aMeta);
						diamondArmor.setItem(23, armor);
						// Boots
						armor.setType(Material.IRON_BOOTS);
						aMeta.setDisplayName(ChatColor.GOLD + "Iron Boots");
						aLore.clear();
						aLore.add(ChatColor.GOLD + "Tank");
						aLore.add(ChatColor.LIGHT_PURPLE + "Costs: " + armor.getType() + " and 30 EXP levels");
						aMeta.setLore(aLore);
						armor.setItemMeta(aMeta);
						diamondArmor.setItem(32, armor);
			
						return;
	}
	
	
	
}
