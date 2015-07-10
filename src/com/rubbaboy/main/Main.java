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

package com.rubbaboy.main;

import com.rubbaboy.Listeners.*;
import com.rubbaboy.commands.CommandDeleteLog;
import com.rubbaboy.commands.CommandLog;
import com.rubbaboy.commands.CommandLogs;
import com.rubbaboy.commands.CommandShowLogging;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Main extends JavaPlugin {

    public static Plugin plugin;

    PluginManager pm = Bukkit.getServer().getPluginManager();

    static public boolean[] Logging = {false, false, false, false, false, false, false, false, false, false, false, false};

    @Override
    public void onEnable(){

        plugin = this;
        getConfig().options().copyDefaults(true);
        saveConfig();
        try{
            getLog();
        }catch (Exception e){
            e.printStackTrace();
        }
        if(getConfig().getBoolean("LogChat")){pm.registerEvents(new PlayerChat(), this); Logging[0] = true;}
        if(getConfig().getBoolean("LogHashtags")){pm.registerEvents(new PlayerChatHashtag(), this); Logging[1] = true;}
        if(getConfig().getBoolean("LogCommands")){pm.registerEvents(new PlayerCommand(), this); Logging[2] = true;}
        if(getConfig().getBoolean("LogBlockDestroy")){pm.registerEvents(new PlayerDestroy(), this); Logging[3] = true;}
        if(getConfig().getBoolean("LogInventoryClick")){pm.registerEvents(new PlayerInvClick(), this); Logging[4] = true;}
        if(getConfig().getBoolean("LogInventoryClose")){pm.registerEvents(new PlayerInvClose(), this); Logging[5] = true;}
//        if(getConfig().getBoolean("LogInventoryDrag")){pm.registerEvents(new PlayerInvDrag(), this); Logging[6] = true;}
        if(getConfig().getBoolean("LogInventoryOpen")){pm.registerEvents(new PlayerInvOpen(), this); Logging[7] = true;}
        if(getConfig().getBoolean("LogPlayerPickupItem")){pm.registerEvents(new PlayerInvPickupItem(), this); Logging[8] = true;}
        if(getConfig().getBoolean("LogLeftClick")){pm.registerEvents(new PlayerLeftClick(), this); Logging[9] = true;}
        if(getConfig().getBoolean("LogMove")){pm.registerEvents(new PlayerMove(), this); Logging[10] = true;}
        if(getConfig().getBoolean("LogRightClick")){pm.registerEvents(new PlayerRightClick(), this); Logging[11] = true;}
        this.getCommand("Logs").setExecutor(new CommandLogs(this));
        this.getCommand("Log").setExecutor(new CommandLog(this));
        this.getCommand("ShowLogging").setExecutor(new CommandShowLogging(this));
        this.getCommand("DeleteLog").setExecutor(new CommandDeleteLog(this));
        System.out.println("InfinityLogger  Copyright (C) 2015  AdamYarris");
        System.out.println("Under the GNU GLPv3 license");
    }
    @Override
    public void onDisable() {}

    boolean foo = false;
    public static int number = 1;

    public static int getNumber(){
        return number;
    }

    public File getLog() throws Exception {
        if(!foo) {
            for (int i = 0; i < number; i++) {
                File file1 = new File("plugins/InfinityLogger/Log" + number + ".yml");
                if (file1.exists()) {
                    number++;
                } else {
                    File file2 = new File("plugins/InfinityLogger/Log" + number + ".yml");
                    file2.createNewFile();
                    return file2;
                }
            }
            return null;
        } else {
            return new File("plugins/InfinityLogger/Log" + number + ".yml");
        }
    }
    public static String getChatFormatter(){
        return getPlugin().getConfig().getString("ChatFormat");
    }

    public static int getSpeedByNum(){
        return getPlugin().getConfig().getInt("SpeedEvery");
    }

    public static int getSpeedMultiplier(){
        return getPlugin().getConfig().getInt("SpeedMultiplier");
    }

    public static boolean showNotFound(){
        return getPlugin().getConfig().getBoolean("ShowFilesNotFound");
    }

    public static Plugin getPlugin() {
        return plugin;
    }
}
