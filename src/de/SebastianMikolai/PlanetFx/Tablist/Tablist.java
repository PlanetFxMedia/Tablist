package de.SebastianMikolai.PlanetFx.Tablist;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;

import com.comphenix.protocol.ProtocolLibrary;

public class Tablist extends JavaPlugin {

	public static Tablist instance;
	public Scoreboard sb;
	public String server;
	
	public static Tablist getInstance() {
		return instance;
	}
	
	@Override
	public void onEnable() {
		instance = this;
		sb = Bukkit.getScoreboardManager().getMainScoreboard();
		sb.registerNewTeam("000Leitung");
		sb.registerNewTeam("001Admin");
		sb.registerNewTeam("002SMod");
		sb.registerNewTeam("003Mod");
		sb.registerNewTeam("004Team");
		sb.registerNewTeam("005Vip");
		sb.registerNewTeam("006Player");
		sb.getTeam("000Leitung").setPrefix(ChatColor.DARK_RED + "Leitung" + ChatColor.DARK_GRAY + " | " + ChatColor.DARK_RED);
		sb.getTeam("001Admin").setPrefix(ChatColor.RED + "Admin" + ChatColor.DARK_GRAY + " | " + ChatColor.RED);
		sb.getTeam("002SMod").setPrefix(ChatColor.BLUE + "SMod" + ChatColor.DARK_GRAY + " | " + ChatColor.BLUE);
		sb.getTeam("003Mod").setPrefix(ChatColor.BLUE + "Mod" + ChatColor.DARK_GRAY + " | " + ChatColor.BLUE);
		sb.getTeam("004Team").setPrefix(ChatColor.DARK_GREEN + "Team" + ChatColor.DARK_GRAY + " | " + ChatColor.DARK_GREEN);
		sb.getTeam("005Vip").setPrefix(ChatColor.AQUA + "Vip" + ChatColor.DARK_GRAY + " | " + ChatColor.WHITE);
		sb.getTeam("006Player").setPrefix(ChatColor.DARK_GRAY + "");
		Bukkit.getPluginManager().registerEvents(new EventListener(ProtocolLibrary.getProtocolManager()),  this);
		server = Bukkit.getServerName();
	}
}