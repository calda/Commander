
package com.caldabeast.example;

import com.caldabeast.commander.Subcommand;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

/**
 * @author CalDaBeast
 */
public class ExampleExternalSubcommand {

	@Subcommand(
			name = "external",
			alias = {"e", "ext"}
			//note the lack of a permission setting
			//any player can use /test external
	)
	public void internalSubcommand(CommandSender cs, String label, String[] args) {
		cs.sendMessage(ChatColor.GRAY + "CommandCommander" + ChatColor.DARK_GRAY + " by CalDaBeast");
		cs.sendMessage(ChatColor.GOLD + "Command those commands!");
	}
	
}
