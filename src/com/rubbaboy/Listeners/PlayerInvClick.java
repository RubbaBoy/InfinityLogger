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
import org.bukkit.event.inventory.InventoryClickEvent;

public class PlayerInvClick implements Listener {

    @EventHandler
    public void onInvClick(InventoryClickEvent event) throws Exception {
        Location loc = event.getWhoClicked().getLocation();
        Player player = (Player) event.getWhoClicked();
        Logger logger = new Logger();
        if(event.isShiftClick()){
        if (event.isLeftClick()) {
            logger.Log(5, "Shift left clicked item in inventory with player coordinates at X:" + loc.getBlockX() + " Y:" + loc.getBlockY() + " Z:" + loc.getBlockZ() + " with item type " + event.getCurrentItem().getType().toString() + " slot number " + event.getSlot() + " inventory name being " + event.getClickedInventory().getName() + " players gamemode was " + event.getWhoClicked().getGameMode().toString() + " player flying is " + player.isFlying(), player);
        } else if (event.isRightClick()) {
            logger.Log(5, "Shift right clicked item in inventory with player coordinates at X:" + loc.getBlockX() + " Y:" + loc.getBlockY() + " Z:" + loc.getBlockZ() + " with item type " + event.getCurrentItem().getType().toString() + " slot number " + event.getSlot() + " inventory name being " + event.getClickedInventory().getName()+ " players gamemode was " + event.getWhoClicked().getGameMode().toString() + " player flying is " + player.isFlying(), player);
        }
        } else {
            if (event.isLeftClick()) {
                logger.Log(5, "Left clicked item in inventory with player coordinates at X:" + loc.getBlockX() + " Y:" + loc.getBlockY() + " Z:" + loc.getBlockZ() + " with item type " + event.getCurrentItem().getType().toString() + " slot number " + event.getSlot() + " inventory name being " + event.getClickedInventory().getName()+ " players gamemode was " + event.getWhoClicked().getGameMode().toString() + " player flying is " + player.isFlying(), player);
            } else if (event.isRightClick()) {
                logger.Log(5, "Right clicked item in inventory with player coordinates at X:" + loc.getBlockX() + " Y:" + loc.getBlockY() + " Z:" + loc.getBlockZ() + " with item type " + event.getCurrentItem().getType().toString() + " slot number " + event.getSlot() + " inventory name being " + event.getClickedInventory().getName()+ " players gamemode was " + event.getWhoClicked().getGameMode().toString() + " player flying is " + player.isFlying(), player);
            }
        }
    }
}
