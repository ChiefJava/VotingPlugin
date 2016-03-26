package com.Ben12345rocks.VotingPlugin.Commands.TabCompleter;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import com.Ben12345rocks.VotingPlugin.Utils;

public class VoteNextTabCompleter implements TabCompleter {

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd,
			String alias, String[] args) {

		if (cmd.getName().equalsIgnoreCase("votenext")
				|| cmd.getName().equalsIgnoreCase("vnext")) {

			List<String> tab = new ArrayList<String>();

			if (args.length == 1) {

				List<String> cmds = new ArrayList<String>();

				for (Object playerOb : Bukkit.getOnlinePlayers().toArray()) {
					Player player = (Player) playerOb;
					cmds.add(player.getName());
				}

				for (int i = 0; i < cmds.size(); i++) {
					if (Utils.getInstance().startsWithIgnoreCase(cmds.get(i),
							args[0])) {
						tab.add(cmds.get(i));
					}
				}

				return tab;

			}

		}

		return null;
	}

}
