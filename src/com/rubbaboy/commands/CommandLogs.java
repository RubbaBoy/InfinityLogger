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
along with this program. r. If not, see <http://www.gnu.org/licenses/>.
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

public class CommandLogs implements CommandExecutor {
    Main plugin;

    public CommandLogs(Main passedPlugin)
    {
        this.plugin = passedPlugin;
    }
    public Player player;
    public int count;
    public int numCountdown;
//    public int num;
    public int SpeedEvery = Main.getSpeedByNum();
    public int SpeedMultiplier = Main.getSpeedMultiplier();
    public int FinalSpeed = 1;
//    private final int BaseSpeed = 15;
    String[] LogMessages = {
            ChatColor.GOLD + "Showing all current Log files:",
            ChatColor.GOLD + "Files marked with " + CommandEnum.FILE_NOT_FOUND.getMessage() + " " + ChatColor.GOLD + "are empty/have nothing written to it.",
            ChatColor.GOLD + "(Log files ordered from newest to oldest)"
    };

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            player = (Player) sender;
            if(cmd.getName().equalsIgnoreCase("Logs")) {
                if(player.hasPermission("InfinityLogger.Logs")) {
                    if(args.length == 0) {
                        try {
                            sendMessage();
                        } catch (Exception ignored) {}
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

    public void sendMessage() {
//        int foo = Main.getNumber() / SpeedEvery;
//        FinalSpeed = foo * SpeedMultiplier;
        count = 0;
//        num = 0;
        numCountdown = Main.getNumber();
        new BukkitRunnable() {
            public void run() {
                if (count < LogMessages.length + Main.getNumber()) {
                    if (count < LogMessages.length) {
                        player.sendMessage(LogMessages[count]);
                        player.playSound(player.getLocation(), Sound.PISTON_EXTEND, 1, 100);
                        count++;
                    } else {
                        File file1 = new File("plugins/InfinityLogger/Log" + numCountdown + ".yml");
                        if (file1.length() != 0) {
                            String B = String.valueOf(file1.length());
                            player.sendMessage(ChatColor.GOLD + "Log" + numCountdown + ChatColor.RED + " - " + B + "B");
                            numCountdown--;
                            count++;
                        } else {
                            if (Main.showNotFound()) {
                                String B = String.valueOf(file1.length());
                                player.sendMessage(ChatColor.GOLD + "Log" + numCountdown + CommandEnum.FILE_NOT_FOUND.getMessage() + ChatColor.RED + " - " + B + "B");
                            }
                            numCountdown--;
                            count++;
                        }
                    }
                } else {
                    count = 0;
                    this.cancel();
                    player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1, 100);
                }
            }
//        }.runTaskTimer(Main.getPlugin(), BaseSpeed / FinalSpeed, BaseSpeed / FinalSpeed);
        }.runTaskTimer(Main.getPlugin(), 15, 15);

    }
}
