package com.caldabeast.example;

import com.caldabeast.commander.Commander;
import com.caldabeast.commander.Subcommand;
import com.caldabeast.commander.TabComplete;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;

/**
 * @author CalDaBeast
 */
public class ExampleCommander extends Commander {

	@Override
	public void ifNoPermission(CommandSender cs, String label, String[] args) {
		cs.sendMessage(ChatColor.GRAY + "You do not have permission to use " + ChatColor.ITALIC + "/ex " + label);
	}

	@Override
	public void ifNotSubcommand(CommandSender cs, String label, String[] args) {
		cs.sendMessage(ChatColor.DARK_GRAY + "/test usage:");
		cs.sendMessage(ChatColor.GRAY + "/test internal");
		cs.sendMessage(ChatColor.GRAY + "/test external");
	}

	@Subcommand(
			name = "internal",
			alias = {"i", "int"},
			permission = "command.admin"
	)
	public void internalSubcommand(CommandSender cs, String label, String[] args) {
		if (!(cs instanceof Player)) {
			cs.sendMessage("You must be in-game to use this command.");
			return;
		}
		Player p = (Player) cs;
		if (args.length > 0) p = Bukkit.getPlayerExact(args[0]);
		if (p == null) {
			cs.sendMessage(ChatColor.GRAY + "That player is not online.");
			return;
		}
		p.teleport(p.getLocation().add(0, 5, 0), PlayerTeleportEvent.TeleportCause.PLUGIN);
		cs.sendMessage(ChatColor.GREEN + "WhooRP!");
	}

	@TabComplete(
			name = "internal"
	)
	public List<String> internalTabComplete(CommandSender cs, String[] args) {
		ArrayList<String> names = new ArrayList<String>();
		for (Player p : Bukkit.getServer().getOnlinePlayers()) {
			names.add(p.getName());
		}
		return names;
	}

}
