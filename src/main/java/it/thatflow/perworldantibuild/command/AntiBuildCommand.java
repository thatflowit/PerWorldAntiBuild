package it.thatflow.perworldantibuild.command;

import it.thatflow.perworldantibuild.service.IConfigService;
import it.thatflow.perworldantibuild.service.IWorldService;
import it.thatflow.perworldantibuild.utils.Utilities;
import lombok.RequiredArgsConstructor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

@RequiredArgsConstructor
public class AntiBuildCommand implements CommandExecutor {

    private final IConfigService configService;
    private final IWorldService worldService;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(args.length == 1) {
            String worldName = args[0];

            if (worldService.isBlocked(worldName)) {
                worldService.removeWorld(worldName);
                sender.sendMessage(Utilities.format(configService.getConfig().getString("worldUnblocked")));
            } else {
                worldService.addWorld(worldName);
                sender.sendMessage(Utilities.format(configService.getConfig().getString("worldBlocked")));
            }
            return true;
        }
        sender.sendMessage(Utilities.format(configService.getConfig().getString("cmdUsage")));
        return true;
    }
}
