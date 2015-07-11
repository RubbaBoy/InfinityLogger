/*
Copyright (C) 2015  Adam Yarris

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package com.rubbaboy.commands;

import com.rubbaboy.main.Main;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class CommandLog implements CommandExecutor {
    Main plugin;

    public CommandLog(Main passedPlugin)
    {
        this.plugin = passedPlugin;
    }
    public Player player;
    public int count;
    String[] HelpMessages = {
            ChatColor.GOLD + "InfinityLogger plugin made by " + ChatColor.RED + Main.getPlugin().getDescription().getAuthors().toString().substring(1, Main.getPlugin().getDescription().getAuthors().toString().length() - 1),
            ChatColor.GOLD + "To download and get help information go to " + ChatColor.RED + Main.getPlugin().getDescription().getWebsite(),
            ChatColor.GOLD + "InfinityLogger Copyright (C) 2015 Adam Yarris",
            ChatColor.GOLD + "See <http://www.gnu.org/licenses/> for licensing information",
            ChatColor.GOLD + "Version " + ChatColor.RED + Main.getPlugin().getDescription().getVersion(),
            ChatColor.GOLD + "Commands:",
            ChatColor.GOLD + "/Log " + ChatColor.RED + "Shows InfinityLogger help.",
            ChatColor.GOLD + "/ShowLogging " + ChatColor.RED + "Shows what is being logged.",
            ChatColor.GOLD + "/Logs " + ChatColor.RED + "Shows how many logs are saved.",
            ChatColor.GOLD + "/DeleteLog " + ChatColor.RED + "Deletes a log."
    };

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            player = (Player) sender;
            if(cmd.getName().equalsIgnoreCase("Log")) {
                if(player.hasPermission("InfinityLogger.Log")) {
                    if(args.length == 0) {
                        sendMessage();
                    } else {
                        player.sendMessage(CommandEnum.INCORRECT_SYNTAX.getMessage());
                    }
                } else {
                    player.sendMessage(CommandEnum.INCORRECT_PERM.getMessage());
                }
            }
        } else {
            sender.sendMessage(CommandEnum.PLAYERS_ONLY.getMessage());
        }
        return true;
    }

    public void sendMessage(){
        count = 0;
        new BukkitRunnable() {
            public void run() {
                if(count < HelpMessages.length) {
                    player.sendMessage(HelpMessages[count]);
                    player.playSound(player.getLocation(), Sound.PISTON_EXTEND, 1, 100);
                    count++;
                } else {
                    count = 0;
                    this.cancel();
                    player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1, 100);
                }
            }
        }.runTaskTimer(Main.getPlugin(), 15, 15);
    }
}
