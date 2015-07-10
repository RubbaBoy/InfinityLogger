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

public class CommandShowLogging implements CommandExecutor {
    Main plugin;

    public CommandShowLogging(Main passedPlugin)
    {
        this.plugin = passedPlugin;
    }
    public Player player;
    public int count;
    static private boolean[] Logging = Main.Logging;
    String[] WhatsLogging = {
                ChatColor.GOLD + "All things being logged/not logged from InfinityLogger",
                ChatColor.GOLD + "Chat " + ChatColor.RED + Main.Logging[0],
                ChatColor.GOLD + "Hashtags " + ChatColor.RED + Main.Logging[1],
                ChatColor.GOLD + "Commands " + ChatColor.RED + Main.Logging[2],
                ChatColor.GOLD + "Destroy " + ChatColor.RED + Main.Logging[3],
                ChatColor.GOLD + "Inventory Click " + ChatColor.RED + Main.Logging[4],
                ChatColor.GOLD + "Inventory Close " + ChatColor.RED + Main.Logging[5],
                ChatColor.GOLD + "Inventory Drag " + ChatColor.RED + Main.Logging[6],
                ChatColor.GOLD + "Inventory Open " + ChatColor.RED + Main.Logging[7],
                ChatColor.GOLD + "Pickup Item " + ChatColor.RED + Main.Logging[8],
                ChatColor.GOLD + "Left Click " + ChatColor.RED + Main.Logging[9],
                ChatColor.GOLD + "Player Move " + ChatColor.RED + Main.Logging[10],
                ChatColor.GOLD + "Right Click (Includes Placing) " + ChatColor.RED + Main.Logging[11]
    };

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            player = (Player) sender;
            if(cmd.getName().equalsIgnoreCase("ShowLogging")) {
                if(player.hasPermission("InfinityLogger.ShowLogging")) {
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
                if(count < WhatsLogging.length) {
                    player.sendMessage(WhatsLogging[count]);
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

