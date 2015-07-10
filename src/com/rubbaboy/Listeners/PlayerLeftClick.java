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

package com.rubbaboy.Listeners;

import com.rubbaboy.log.Logger;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerLeftClick implements Listener {

    @EventHandler
    public void onPlayerLeftClick(PlayerInteractEvent event) throws Exception {
        if(event.getAction() == Action.LEFT_CLICK_AIR){
            Location loc = event.getPlayer().getLocation();
            Logger logger = new Logger();
            logger.Log(6, "Left clicked air with player coordinates at " + loc.getBlockX() + ", " + loc.getBlockY() + ", " + loc.getBlockZ() + " With " + event.getMaterial().toString() + " in hand.", event.getPlayer());
        }
        if(event.getAction() == Action.LEFT_CLICK_BLOCK){
            Location loc = event.getPlayer().getLocation();
            Logger logger = new Logger();
            logger.Log(6, "Left clicked block type " + event.getClickedBlock().getType() + " and clicked block coordinates at X:" + event.getClickedBlock().getLocation().getBlockX() + " Y:" + event.getClickedBlock().getLocation().getBlockY() + " Z:" + event.getClickedBlock().getLocation().getBlockZ() + " with player coordinates at " + loc.getBlockX() + ", " + loc.getBlockY() + ", " + loc.getBlockZ() + " With " + event.getMaterial().toString() + " in hand.", event.getPlayer());
        }
    }
}
