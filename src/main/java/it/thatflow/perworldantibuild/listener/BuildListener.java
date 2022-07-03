package it.thatflow.perworldantibuild.listener;

import it.thatflow.perworldantibuild.service.IConfigService;
import it.thatflow.perworldantibuild.service.IWorldService;
import it.thatflow.perworldantibuild.utils.Utilities;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

@RequiredArgsConstructor
public class BuildListener implements Listener {

    private final IConfigService configService;
    private final IWorldService worldService;

    @EventHandler(priority = EventPriority.LOW)
    private void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if(!worldService.isBlocked(player.getWorld().getName())) return;

        event.setCancelled(true);
        player.sendMessage(Utilities.format(configService.getConfig().getString("worldIsBlocked")));
    }

    @EventHandler(priority = EventPriority.LOW)
    private void onBlockBreak(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        if(!worldService.isBlocked(player.getWorld().getName())) return;

        event.setCancelled(true);
        player.sendMessage(Utilities.format(configService.getConfig().getString("worldIsBlocked")));
    }
}
