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

public class PlayerRightClick implements Listener {

    @EventHandler
    public void onPlayerRightClick(PlayerInteractEvent event) throws Exception {
        if(event.getAction() == Action.RIGHT_CLICK_AIR){
            Location loc = event.getPlayer().getLocation();
            Logger logger = new Logger();
            logger.Log(6, "Right clicked air with player coordinates at " + loc.getBlockX() + ", " + loc.getBlockY() + ", " + loc.getBlockZ() + " With " + event.getMaterial().toString() + " in hand.", event.getPlayer());
        }
        if(event.getAction() == Action.RIGHT_CLICK_BLOCK){
            if(event.isBlockInHand()){
                Location loc = event.getPlayer().getLocation();
                Logger logger = new Logger();
                logger.Log(8, "Placed block type " + event.getMaterial().toString() + " against block " + event.getClickedBlock().getType().toString() + " on face " + event.getClickedBlock().getFace(event.getClickedBlock()) + " and clicked block coordinates at X:" + event.getClickedBlock().getLocation().getBlockX() + " Y:" + event.getClickedBlock().getLocation().getBlockY() + " Z:" + event.getClickedBlock().getLocation().getBlockZ() + " with player coordinates at X:" + loc.getBlockX() + " Y:" + loc.getBlockY() + " Z:" + loc.getBlockZ(), event.getPlayer());
            } else {
                Location loc = event.getPlayer().getLocation();
                Logger logger = new Logger();
                logger.Log(6, "Right clicked block type " + event.getClickedBlock().getType().toString() + " and clicked block coordinates at X:" + event.getClickedBlock().getLocation().getBlockX() + " Y:" + event.getClickedBlock().getLocation().getBlockY() + " Z:" + event.getClickedBlock().getLocation().getBlockZ() + " with player coordinates at X:" + loc.getBlockX() + " Y:" + loc.getBlockY() + " :" + loc.getBlockZ() + " With " + event.getMaterial().toString() + " in hand.", event.getPlayer());
            }
        }
    }
}
