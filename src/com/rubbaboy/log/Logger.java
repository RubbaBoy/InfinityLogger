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

package com.rubbaboy.log;

import com.rubbaboy.main.Main;
import org.bukkit.entity.Player;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    private File foo() throws Exception {
        return new File("plugins/InfinityLogger/Log" + Main.getNumber() + ".yml");
    }

    public void Log(int type, String Message, Player player) throws Exception {
            String ChatFormat = Main.getChatFormatter();

            FileWriter fstream = new FileWriter(foo(), true);
            BufferedWriter out = new BufferedWriter(fstream);

            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            Date date = new Date();

            if (type == 0) {
                out.newLine();
                String message = ChatFormat;
                message = message.replace("%message%", Message);
                message = message.replace("%type%", "WARN");
                message = message.replace("%name%", player.getName());
                message = message.replace("%uuid%", player.getUniqueId().toString());
                message = message.replace("%ip%", player.getAddress().getHostString());
                out.append("[" + dateFormat.format(date) + "] " + message);
                out.close();
            } else if (type == 1) {
                out.newLine();
                String message = ChatFormat;
                message = message.replace("%message%", Message);
                message = message.replace("%type%", "INFO");
                message = message.replace("%name%", player.getName());
                message = message.replace("%uuid%", player.getUniqueId().toString());
                message = message.replace("%ip%", player.getAddress().getHostString());
                out.append("[" + dateFormat.format(date) + "] " + message);
                out.close();
            } else if (type == 2) {
                out.newLine();
                String message = ChatFormat;
                message = message.replace("%message%", Message);
                message = message.replace("%type%", "CHAT");
                message = message.replace("%name%", player.getName());
                message = message.replace("%uuid%", player.getUniqueId().toString());
                message = message.replace("%ip%", player.getAddress().getHostString());
                out.append("[" + dateFormat.format(date) + "] " + message);
                out.close();
            } else if (type == 3) {
                out.newLine();
                String message = ChatFormat;
                message = message.replace("%message%", Message);
                message = message.replace("%type%", "COMMAND");
                message = message.replace("%name%", player.getName());
                message = message.replace("%uuid%", player.getUniqueId().toString());
                message = message.replace("%ip%", player.getAddress().getHostString());
                out.append("[" + dateFormat.format(date) + "] " + message);
                out.close();
            } else if (type == 4) {
                out.newLine();
                String message = ChatFormat;
                message = message.replace("%message%", Message);
                message = message.replace("%type%", "MOVE");
                message = message.replace("%name%", player.getName());
                message = message.replace("%uuid%", player.getUniqueId().toString());
                message = message.replace("%ip%", player.getAddress().getHostString());
                out.append("[" + dateFormat.format(date) + "] " + message);
                out.close();
            } else if (type == 5) {
                out.newLine();
                String message = ChatFormat;
                message = message.replace("%message%", Message);
                message = message.replace("%type%", "INV");
                message = message.replace("%name%", player.getName());
                message = message.replace("%uuid%", player.getUniqueId().toString());
                message = message.replace("%ip%", player.getAddress().getHostString());
                out.append("[" + dateFormat.format(date) + "] " + message);
                out.close();
            } else if (type == 6) {
                out.newLine();
                String message = ChatFormat;
                message = message.replace("%message%", Message);
                message = message.replace("%type%", "CLICK");
                message = message.replace("%name%", player.getName());
                message = message.replace("%uuid%", player.getUniqueId().toString());
                message = message.replace("%ip%", player.getAddress().getHostString());
                out.append("[" + dateFormat.format(date) + "] " + message);
                out.close();
            } else if (type == 7) {
                out.newLine();
                String message = ChatFormat;
                message = message.replace("%message%", Message);
                message = message.replace("%type%", "HASHTAG");
                message = message.replace("%name%", player.getName());
                message = message.replace("%uuid%", player.getUniqueId().toString());
                message = message.replace("%ip%", player.getAddress().getHostString());
                out.append("[" + dateFormat.format(date) + "] " + message);
                out.close();
            } else if (type == 8) {
                out.newLine();
                String message = ChatFormat;
                message = message.replace("%message%", Message);
                message = message.replace("%type%", "BLOCK");
                message = message.replace("%name%", player.getName());
                message = message.replace("%uuid%", player.getUniqueId().toString());
                message = message.replace("%ip%", player.getAddress().getHostString());
                out.append("[" + dateFormat.format(date) + "] " + message);
                out.close();
            } else if (type == 9) {
                out.newLine();
                String message = ChatFormat;
                message = message.replace("%message%", Message);
                message = message.replace("%type%", "DIRECTION");
                message = message.replace("%name%", player.getName());
                message = message.replace("%uuid%", player.getUniqueId().toString());
                message = message.replace("%ip%", player.getAddress().getHostString());
                out.append("[" + dateFormat.format(date) + "] " + message);
                out.close();
            }
    }
}
