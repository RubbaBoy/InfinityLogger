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

import java.io.File;
import java.io.IOException;

public class CommandDeleteLog implements CommandExecutor {
    Main plugin;

    public CommandDeleteLog(Main passedPlugin)
    {
        this.plugin = passedPlugin;
    }
    public Player player;
    public int count;
    public int args0;
    public boolean PlaceHolder;
    String[] DeleteLogMessages = {
            ChatColor.GOLD + "Deleting file: §c%N",
            ChatColor.GOLD + "Sucessfully deleted file §c%N§6!",
            ChatColor.GOLD + "Creating empty placeholder file with name §c%N §6to keep count in tune.",
            ChatColor.GOLD + "Sucessfully created empty placeholder with name §c%N",
            ChatColor.GOLD + "An error has occured while creating placeholder file §c%N§6!",
            ChatColor.GOLD + "An error has occured while deleting file §c%N§6!",
            ChatColor.GOLD + "Make sure the file is in existant with /Logs"
    };

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            player = (Player) sender;
            if(cmd.getName().equalsIgnoreCase("DeleteLog")) {
                if(player.hasPermission("InfinityLogger.DeleteLog")) {
                    if(args.length == 1) {
                        try {
                            args0 = Integer.parseInt(args[0]);
                            sendMessage(args0);
                        } catch (NumberFormatException e) {
                            player.sendMessage(CommandEnum.INCORRECT_SYNTAX.getMessage());
                        }
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

    public void sendMessage(final int LogNumber) {
        count = 0;
        PlaceHolder = true;
        new BukkitRunnable() {
            public void run() {
                if(count < 4) {
                if (count == 0) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('§', DeleteLogMessages[0].replace("%N", "Log" + LogNumber)));
                        player.playSound(player.getLocation(), Sound.PISTON_EXTEND, 1, 100);
                        count++;
                } else if (count == 1) {
                        File file = new File("plugins/InfinityLogger/Log" + LogNumber + ".yml");
                        if (file.exists()) {
                            file.delete();
                            player.sendMessage(ChatColor.translateAlternateColorCodes('§', DeleteLogMessages[1].replace("%N", "Log" + LogNumber)));
                            player.playSound(player.getLocation(), Sound.PISTON_EXTEND, 1, 100);
                            count++;
                        } else {
                            PlaceHolder = false;
                            player.sendMessage(ChatColor.translateAlternateColorCodes('§', DeleteLogMessages[5].replace("%N", "Log" + LogNumber)));
                            player.playSound(player.getLocation(), Sound.PISTON_EXTEND, 1, 100);
                            player.sendMessage(ChatColor.translateAlternateColorCodes('§', DeleteLogMessages[6].replace("%N", "Log" + LogNumber)));
                            player.playSound(player.getLocation(), Sound.PISTON_EXTEND, 1, 100);
                            this.cancel();
                        }
                } else if(count == 2){
                    player.sendMessage(ChatColor.translateAlternateColorCodes('§', DeleteLogMessages[count].replace("%N", "Log" + LogNumber)));
                    player.playSound(player.getLocation(), Sound.PISTON_EXTEND, 1, 100);
                    count++;
                } else if(count == 3){
                    if(PlaceHolder) {
                        File file = new File("plugins/InfinityLogger/Log" + LogNumber + ".yml");
                        try {
                            file.createNewFile();
                            player.sendMessage(ChatColor.translateAlternateColorCodes('§', DeleteLogMessages[3].replace("%N", "Log" + LogNumber)));
                            player.playSound(player.getLocation(), Sound.PISTON_EXTEND, 1, 100);
                            count++;
                        } catch (IOException e) {
                            player.sendMessage(ChatColor.translateAlternateColorCodes('§', DeleteLogMessages[4].replace("%N", "Log" + LogNumber)));
                            player.playSound(player.getLocation(), Sound.PISTON_EXTEND, 1, 100);
                            count++;
                        }
                    }
                }
                } else {
                    count = 0;
                    this.cancel();
                    player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1, 100);
                }
            }
        }.runTaskTimer(Main.getPlugin(), 15, 15);

    }
}
