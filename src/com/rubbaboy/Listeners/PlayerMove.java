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
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMove implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) throws Exception {
        if(event.getFrom().getBlockX() == event.getTo().getBlockX() && event.getFrom().getBlockY() == event.getTo().getBlockY() && event.getFrom().getBlockZ() == event.getTo().getBlockZ()) {
            Location locTo = event.getTo();
            Location locFrom = event.getFrom();
            Logger logger = new Logger();
            logger.Log(4, "Changed viewing direction from Pitch:" + locFrom.getPitch() + " and Yaw:" + locFrom.getYaw() + " to Pitch:" + locTo.getPitch() + " and Yaw:" + locTo.getYaw() + " players gamemode was " + event.getPlayer().getGameMode().toString() + " player flying is " + event.getPlayer().isFlying(), event.getPlayer());
        } else {
            Location locTo = event.getTo();
            Location locFrom = event.getFrom();
            Logger logger = new Logger();
            logger.Log(4, "Moved from X:" + locFrom.getBlockX() + " Y:" + locFrom.getBlockY() + " Z:" + locFrom.getBlockZ() + " to " + locTo.getBlockX() + " Y:" + locTo.getBlockY() + " Z:" + locTo.getBlockZ() + " players gamemode was " + event.getPlayer().getGameMode().toString() + " player flying is " + event.getPlayer().isFlying(), event.getPlayer());
        }
    }
}
