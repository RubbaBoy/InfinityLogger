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

import org.bukkit.ChatColor;

public enum CommandEnum {
    INCORRECT_PERM(ChatColor.RED + "You do not have permission to do this."),
    INCORRECT_SYNTAX(ChatColor.RED + "Incorrect syntax!"),
    PLAYERS_ONLY(ChatColor.RED + "Command is only to be used by players."),
    MORE_THAN_SPEED_UP(ChatColor.RED + "More than %N Logs, speeding up &Tx"),
    FILE_NOT_FOUND(ChatColor.RED + "" + ChatColor.BOLD + " [NOT FOUND]" + ChatColor.RESET);


    private String message;

    CommandEnum(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
