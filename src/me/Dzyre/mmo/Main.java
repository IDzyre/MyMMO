package me.Dzyre.mmo;

import java.io.File;
import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener, CommandExecutor {

	@Override
	public void onEnable() {
		File file = new File("CraftingRestrictions");
		if (!(file.exists())) {
			file.mkdirs();
		}
		getCommand("setl").setExecutor(new CraftRes());
		getCommand("unsetl").setExecutor(new CraftRes());
		getCommand("seti").setExecutor(new CraftRes());
		getCommand("unseti").setExecutor(new CraftRes());
		getCommand("setg").setExecutor(new CraftRes());
		getCommand("unsetg").setExecutor(new CraftRes());
		getCommand("setd").setExecutor(new CraftRes());
		getCommand("unsetd").setExecutor(new CraftRes());
		getCommand("shop").setExecutor(new Shops());
		this.getServer().getPluginManager().registerEvents(this, this);
		this.getServer().getPluginManager().registerEvents(new Mobs(), this);
		this.getServer().getPluginManager().registerEvents(new CraftRes(), this);
		this.getServer().getPluginManager().registerEvents(new craftClasses(), this);
		Shops.createInventory();
//		this.getServer().getPluginManager().disablePlugin(this);
		CraftRes.tred();

	}

	@Override
	public void onDisable() {
		CraftRes.triese();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args3) {
		if (label.equalsIgnoreCase("helpbook")) {
			Player player = (Player) sender;

			ItemStack book = new ItemStack(Material.WRITTEN_BOOK);

			BookMeta bookmeta = (BookMeta) book.getItemMeta();
			bookmeta.setAuthor("Server");
			bookmeta.setTitle(ChatColor.GREEN + "How To");

			ArrayList<String> pages = new ArrayList<String>();

			pages.add(0, ChatColor.GREEN + "" + ChatColor.BOLD + "Welcome to my MMO plugin." + "\n" + ChatColor.RED
					+ "Here is how to progress. Every time you kill a mob, you have a chance to get money. To progress to the first stage (leather)"
					+ " you have to craft a wooden sword.");
					pages.add(1,ChatColor.RED + "To proceed from there on out, you have to collect an increasing amount of money,"
					+ " and wear the entire set of armor from your current level");
			bookmeta.setPages(pages);
			book.setItemMeta(bookmeta);
			player.getInventory().addItem(book);
			return true;
		}
		return false;
	}
}
