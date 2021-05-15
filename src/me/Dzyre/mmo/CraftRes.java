package me.Dzyre.mmo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;

import net.md_5.bungee.api.ChatColor;

public class CraftRes implements Listener, CommandExecutor {

	public static Map<UUID, Integer> craftLeather = new HashMap<UUID, Integer>();
	public static Map<UUID, Integer> craftIron = new HashMap<UUID, Integer>();
	public static Map<UUID, Integer> craftDiamond = new HashMap<UUID, Integer>();
	public static Map<UUID, Integer> craftGold = new HashMap<UUID, Integer>();

	public static void tred() {
		try {
			loadLeather();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		try {
			loadIron();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

		for (OfflinePlayer p : Bukkit.getOfflinePlayers()) {
			if (craftLeather.get(p.getUniqueId()) == null) {
				craftLeather.put(p.getUniqueId(), 1);
			}
			if (craftIron.get(p.getUniqueId()) == null) {
				craftIron.put(p.getUniqueId(), 1);
			}
			if (craftGold.get(p.getUniqueId()) == null) {
				craftGold.put(p.getUniqueId(), 1);
			}
			if (craftDiamond.get(p.getUniqueId()) == null) {
				craftDiamond.put(p.getUniqueId(), 1);
			}

		}
		

	}

	@Override
	public boolean onCommand(CommandSender player, Command cmd, String label, String[] arg3) {
		if (cmd.getName().equals("setl")) {
			craftLeather.put(((Player) player).getUniqueId(), 9);
			player.sendMessage("Set");
			return true;
		}
		if (cmd.getName().equals("unsetl")) {
			craftLeather.put(((Player) player).getUniqueId(), 1);
			player.sendMessage("unset");
			return true;
		}
		if (cmd.getName().equals("seti")) {
			craftIron.put(((Player) player).getUniqueId(), 9);
			player.sendMessage("Set");
			return true;
		}
		if (cmd.getName().equals("unseti")) {
			craftIron.put(((Player) player).getUniqueId(), 1);
			player.sendMessage("unset");
			return true;
		}
		if (cmd.getName().equals("setg")) {
			craftGold.put(((Player) player).getUniqueId(), 9);
			player.sendMessage("Set");
			return true;
		}
		if (cmd.getName().equals("unsetg")) {
			craftGold.put(((Player) player).getUniqueId(), 1);
			player.sendMessage("unset");
			return true;

		}
		if (cmd.getName().equals("setd")) {
			craftDiamond.put(((Player) player).getUniqueId(), 9);
			player.sendMessage("Set");
			return true;
		}
		if (cmd.getName().equals("unsetd")) {
			craftDiamond.put(((Player) player).getUniqueId(), 1);
			player.sendMessage("unset");
			return true;

		}
		return false;
	}

	public static void triese() {
		try {
			saveLeather();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			saveIron();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@EventHandler
	public void craftItemEvent(CraftItemEvent event) {

		if (event.getCurrentItem().getType() == Material.LEATHER_LEGGINGS
				|| event.getCurrentItem().getType() == Material.LEATHER_BOOTS
				|| event.getCurrentItem().getType() == Material.LEATHER_HELMET
				|| event.getCurrentItem().getType() == Material.LEATHER_CHESTPLATE
				|| event.getCurrentItem().getType() == Material.STONE_SWORD
				|| event.getCurrentItem().getType() == Material.STONE_AXE
				|| event.getCurrentItem().getType() == Material.STONE_PICKAXE) {
			if (craftLeather.get(event.getWhoClicked().getUniqueId()) != 9) {
				event.setCancelled(true);
				Player player = (Player) event.getWhoClicked();
				player.sendMessage(ChatColor.RED + "You Do Not Have Access To This Recipe!");
			}
			return;
		}
		if (event.getCurrentItem().getType() == Material.IRON_LEGGINGS
				|| event.getCurrentItem().getType() == Material.IRON_BOOTS
				|| event.getCurrentItem().getType() == Material.IRON_HELMET
				|| event.getCurrentItem().getType() == Material.IRON_CHESTPLATE
				|| event.getCurrentItem().getType() == Material.IRON_SWORD
				|| event.getCurrentItem().getType() == Material.IRON_AXE
				|| event.getCurrentItem().getType() == Material.IRON_PICKAXE) {
			if (craftIron.get(event.getWhoClicked().getUniqueId()) != 9) {
				event.setCancelled(true);
				Player player = (Player) event.getWhoClicked();
				player.sendMessage(ChatColor.RED + "You Do Not Have Access To This Recipe!");
			}
			return;
		}
		if (event.getCurrentItem().getType() == Material.GOLDEN_LEGGINGS
				|| event.getCurrentItem().getType() == Material.GOLDEN_BOOTS
				|| event.getCurrentItem().getType() == Material.GOLDEN_HELMET
				|| event.getCurrentItem().getType() == Material.GOLDEN_CHESTPLATE
				|| event.getCurrentItem().getType() == Material.GOLDEN_SWORD
				|| event.getCurrentItem().getType() == Material.GOLDEN_AXE) {
			if (craftGold.get(event.getWhoClicked().getUniqueId()) != 9) {
				event.setCancelled(true);
				Player player = (Player) event.getWhoClicked();
				player.sendMessage(ChatColor.RED + "You Do Not Have Access To This Recipe!");
			}
			return;
		}
		if (event.getCurrentItem().getType() == Material.DIAMOND_LEGGINGS
				|| event.getCurrentItem().getType() == Material.DIAMOND_BOOTS
				|| event.getCurrentItem().getType() == Material.DIAMOND_HELMET
				|| event.getCurrentItem().getType() == Material.DIAMOND_CHESTPLATE
				|| event.getCurrentItem().getType() == Material.DIAMOND_SWORD
				|| event.getCurrentItem().getType() == Material.DIAMOND_AXE) {
			if (craftDiamond.get(event.getWhoClicked().getUniqueId()) != 9) {
				event.setCancelled(true);
				Player player = (Player) event.getWhoClicked();
				player.sendMessage(ChatColor.RED + "You Do Not Have Access To This Recipe!");
			}
			return;
		}
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void getLeather(CraftItemEvent event) {
		if (craftLeather.get(event.getWhoClicked().getUniqueId()) != 9) {
			if (event.getCurrentItem().getType().equals(Material.WOODEN_SWORD)) {
				Player player = (Player) event.getWhoClicked();
				player.sendTitle(" ", ChatColor.RED + "" + ChatColor.BOLD + "You now have access to " + ChatColor.GOLD
						+ "LEATHER" + ChatColor.RED + " equipment!!");
				craftLeather.put(player.getUniqueId(), 9);
			}
			return;
		}
		return;
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void getAccess(InventoryClickEvent event) {
		if (craftGold.get(event.getWhoClicked().getUniqueId()) != 9) {
			Player player = (Player) event.getWhoClicked();
			int count = 0;
			if (player.getInventory().getBoots() != null) {
				if (player.getInventory().getBoots().getType().equals(Material.LEATHER_BOOTS)) {
						count++;
				}
			}
			if (player.getInventory().getHelmet() != null) {
				if (player.getInventory().getHelmet().getType().equals(Material.LEATHER_HELMET)) {
						count++;
				}
			}
			if (player.getInventory().getChestplate() != null) {
				if (player.getInventory().getChestplate().getType().equals(Material.LEATHER_CHESTPLATE)) {
						count++;
				}
			}
			if (player.getInventory().getLeggings() != null) {
				if (player.getInventory().getLeggings().getType().equals(Material.LEATHER_LEGGINGS)) {
					count++;
				}
			}
				if (count == 4) {
				player.sendTitle(" ", ChatColor.RED + "" + ChatColor.BOLD + "You now have access to " + ChatColor.GOLD
						+ "GOLD" + ChatColor.RED + " equipment!!");
				craftGold.put(player.getUniqueId(), 9);
				return;
			}
			return;
		}
		if (craftIron.get(event.getWhoClicked().getUniqueId()) != 9) {
			Player player = (Player) event.getWhoClicked();
			int count = 0;
			if (player.getInventory().getBoots() != null) {
				if (player.getInventory().getBoots().getType().equals(Material.GOLDEN_BOOTS)) {
						count++;
				}
			}
			if (player.getInventory().getHelmet() != null) {
				if (player.getInventory().getHelmet().getType().equals(Material.GOLDEN_HELMET)) {
						count++;
				}
			}
			if (player.getInventory().getChestplate() != null) {
				if (player.getInventory().getChestplate().getType().equals(Material.GOLDEN_CHESTPLATE)) {
						count++;
				}
			}
			if (player.getInventory().getLeggings() != null) {
				if (player.getInventory().getLeggings().getType().equals(Material.GOLDEN_LEGGINGS)) {
					count++;
				}
			}
				if (count == 4) {
				player.sendTitle(" ", ChatColor.RED + "" + ChatColor.BOLD + "You now have access to " + ChatColor.GOLD
						+ "IRON" + ChatColor.RED + " equipment!!");
				craftIron.put(player.getUniqueId(), 9);
				return;
			}
			return;
		}
		if (craftDiamond.get(event.getWhoClicked().getUniqueId()) != 9) {
			Player player = (Player) event.getWhoClicked();
			int count = 0;
			if (player.getInventory().getBoots() != null) {
				if (player.getInventory().getBoots().getType().equals(Material.IRON_BOOTS)) {
						count++;
				}
			}
			if (player.getInventory().getHelmet() != null) {
				if (player.getInventory().getHelmet().getType().equals(Material.IRON_HELMET)) {
						count++;
				}
			}
			if (player.getInventory().getChestplate() != null) {
				if (player.getInventory().getChestplate().getType().equals(Material.IRON_CHESTPLATE)) {
						count++;
				}
			}
			if (player.getInventory().getLeggings() != null) {
				if (player.getInventory().getLeggings().getType().equals(Material.IRON_LEGGINGS)) {
					count++;
				}
			}
				if (count == 4) {
				player.sendTitle(" ", ChatColor.RED + "" + ChatColor.BOLD + "You now have access to " + ChatColor.GOLD
						+ "DIAMOND" + ChatColor.RED + " equipment!!");
				craftDiamond.put(player.getUniqueId(), 9);
				return;
			}
			return;
		}
		
		return;
		}
		

	@SuppressWarnings("unchecked")
	public static void loadLeather() throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = new File("CraftingRestrictions/Leather.dat");
		if (file != null) {
			ObjectInputStream input9 = new ObjectInputStream(new GZIPInputStream(new FileInputStream(file)));
			Object readObject2 = input9.readObject();
			input9.close();

			if (!(readObject2 instanceof HashMap))
				throw new IOException("Data is not Hash Map");
			craftLeather = (HashMap<UUID, Integer>) readObject2;
			for (UUID key : craftLeather.keySet()) {
				craftLeather.put(key, craftLeather.get(key));
			}

		}
	}

	@SuppressWarnings("unchecked")
	public static void loadIron() throws FileNotFoundException, IOException, ClassNotFoundException {
		File file = new File("CraftingRestrictions/Iron.dat");
		if (file != null) {
			ObjectInputStream input9 = new ObjectInputStream(new GZIPInputStream(new FileInputStream(file)));
			Object readObject2 = input9.readObject();
			input9.close();

			if (!(readObject2 instanceof HashMap))
				throw new IOException("Data is not Hash Map");
			craftIron = (HashMap<UUID, Integer>) readObject2;
			for (UUID key : craftIron.keySet()) {
				craftIron.put(key, craftIron.get(key));
			}

		}
	}

	public static void saveLeather() throws FileNotFoundException, IOException {
		File file = new File("CraftingRestrictions/Leather.dat");
		for (OfflinePlayer p : Bukkit.getOfflinePlayers()) {

			ObjectOutputStream output = new ObjectOutputStream(new GZIPOutputStream(new FileOutputStream(file)));

			if (craftLeather.get(p.getUniqueId()) != null) {
				craftLeather.put(p.getUniqueId(), craftLeather.get(p.getUniqueId()));
			}
			try {
				output.writeObject(craftLeather);
				output.flush();
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void saveIron() throws FileNotFoundException, IOException {
		File file = new File("CraftingRestrictions/Iron.dat");
		for (OfflinePlayer p : Bukkit.getOfflinePlayers()) {

			ObjectOutputStream output = new ObjectOutputStream(new GZIPOutputStream(new FileOutputStream(file)));

			if (craftIron.get(p.getUniqueId()) != null) {
				craftIron.put(p.getUniqueId(), craftIron.get(p.getUniqueId()));
			}
			try {
				output.writeObject(craftIron);
				output.flush();
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
