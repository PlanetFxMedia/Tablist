package de.SebastianMikolai.PlanetFx.Tablist;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.WrappedChatComponent;

import net.md_5.bungee.api.ChatColor;

public class EventListener implements Listener {
	
	private ProtocolManager protocolManager;
	
	public EventListener(ProtocolManager _protocolManager) {
		protocolManager = _protocolManager;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if (p.hasPermission("pfx.tablist.leitung")) {
			Tablist.getInstance().sb.getTeam("000Leitung").addEntry(p.getName());
			p.setDisplayName(Tablist.getInstance().sb.getTeam("000Leitung").getPrefix() + p.getName());
		} else if (p.hasPermission("pfx.tablist.admin")) {
			Tablist.getInstance().sb.getTeam("001Admin").addEntry(p.getName());
			p.setDisplayName(Tablist.getInstance().sb.getTeam("001Admin").getPrefix() + p.getName());
		} else if (p.hasPermission("pfx.tablist.smod")) {
			Tablist.getInstance().sb.getTeam("002SMod").addEntry(p.getName());
			p.setDisplayName(Tablist.getInstance().sb.getTeam("002SMod").getPrefix() + p.getName());
		} else if (p.hasPermission("pfx.tablist.mod")) {
			Tablist.getInstance().sb.getTeam("003Mod").addEntry(p.getName());
			p.setDisplayName(Tablist.getInstance().sb.getTeam("003Mod").getPrefix() + p.getName());
		} else if (p.hasPermission("pfx.tablist.team")) {
			Tablist.getInstance().sb.getTeam("004Team").addEntry(p.getName());
			p.setDisplayName(Tablist.getInstance().sb.getTeam("004Team").getPrefix() + p.getName());
		} else if (p.hasPermission("pfx.tablist.vip")) {
			Tablist.getInstance().sb.getTeam("005Vip").addEntry(p.getName());
			p.setDisplayName(Tablist.getInstance().sb.getTeam("005Vip").getPrefix() + p.getName());
		} else {
			Tablist.getInstance().sb.getTeam("006Player").addEntry(p.getName());
			p.setDisplayName(Tablist.getInstance().sb.getTeam("006Player").getPrefix() + p.getName());
		}
		PacketContainer pc = this.protocolManager.createPacket(PacketType.Play.Server.PLAYER_LIST_HEADER_FOOTER);
		pc.getChatComponents().write(0, WrappedChatComponent.fromText(ChatColor.translateAlternateColorCodes('&', "&2Akonia Gameserver\n&e" + Bukkit.getServerName())))
		.write(1, WrappedChatComponent.fromText(ChatColor.translateAlternateColorCodes('&', "&a»»»»» &6mc.akonia.de &a«««««")));
		try {
			this.protocolManager.sendServerPacket(p, pc);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		for (Player player : Bukkit.getOnlinePlayers()) {
			player.setScoreboard(Tablist.getInstance().sb);
		}
	}
}