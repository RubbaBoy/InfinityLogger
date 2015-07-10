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
import org.bukkit.event.block.BlockBreakEvent;

public class PlayerDestroy implements Listener {

    @EventHandler
    public void onBlockDestroy(BlockBreakEvent event) throws Exception {
        Logger logger = new Logger();
        Location loc = event.getPlayer().getLocation();
        logger.Log(8, "Destroyed block type " + event.getBlock().getType().toString() + " with block coordinates at X:" + event.getBlock().getLocation().getBlockX() + " Y:" + event.getBlock().getLocation().getBlockY() + " Z:" + event.getBlock().getLocation().getBlockZ() + " with player coordinates at " + loc.getBlockX() + ", " + loc.getBlockY() + ", " + loc.getBlockZ() + " With " + event.getPlayer().getItemInHand().getType().toString() + " in hand. Players gamemode was " + event.getPlayer().getGameMode().toString() + " player flying is " + event.getPlayer().isFlying(), event.getPlayer());
    }
}
