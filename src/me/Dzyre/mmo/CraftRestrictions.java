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
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class CraftRestrictions extends JavaPlugin implements Listener{
	
	public static Map<UUID, Boolean> craftLeather = new HashMap<UUID, Boolean>();
	public static Map<UUID, Boolean> craftIron = new HashMap<UUID, Boolean>();
	public static Map<UUID, Boolean> craftDiamond = new HashMap<UUID, Boolean>();
	public static Map<UUID, Boolean> craftGold = new HashMap<UUID, Boolean>();
	
	public void tred() {
		getServer().broadcastMessage("Tess");
		try {
			loadLeather();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
			File file = new File("CraftingRestrictions/Leather.dat");
			if(!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		
	}
	
	public void triese() {
		getServer().getConsoleSender().sendMessage(ChatColor.RED + " \n\nTest Plugin had been Disabled\n\n ");
		try {
			saveLeather();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@EventHandler
	public void craftItemEvent(CraftItemEvent event) {
		craftLeather.put(event.getWhoClicked().getUniqueId(), false);
		if(craftLeather.get(event.getWhoClicked().getUniqueId()) != true) {
			event.setCancelled(true);
			Player player = (Player) event.getWhoClicked();
			player.sendMessage(ChatColor.RED + "You Do Not Have Access To This Recipe!");
		}
	}
	
	
	
	@SuppressWarnings("unchecked")
	public void loadLeather() throws FileNotFoundException, IOException, ClassNotFoundException {
		
		File file = new File("CraftingRestrictions/Leather.dat");
		if (file != null) {
			ObjectInputStream input1 = new ObjectInputStream(new GZIPInputStream(new FileInputStream(file)));
			Object readObject2 = input1.readObject();
			input1.close();

			if (!(readObject2 instanceof HashMap))
				throw new IOException("Data is not Hash Map");
			craftLeather = (HashMap<UUID, Boolean>) readObject2;
			for (UUID key : craftLeather.keySet()) {
				craftLeather.put(key, craftLeather.get(key));
			}

		}
	}
	
	public void saveLeather() throws FileNotFoundException, IOException {
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
	
	
}
