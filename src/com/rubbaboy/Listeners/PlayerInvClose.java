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
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class PlayerInvClose implements Listener {

    @EventHandler
    public void onInvClose(InventoryCloseEvent event) throws Exception {
        Location loc = event.getPlayer().getLocation();
        Player player = (Player) event.getPlayer();
        Logger logger = new Logger();
        logger.Log(5, "Closed inventory with player coordinates at X:" + loc.getBlockX() + " Y:" + loc.getBlockY() + " Z:" + loc.getBlockZ() + " inventory name being " + event.getInventory().getName() + " players gamemode was " + event.getPlayer().getGameMode().toString() + " player flying is " + player.isFlying(), player);
    }
}
