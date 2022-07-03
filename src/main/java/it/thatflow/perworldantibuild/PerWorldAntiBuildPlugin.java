package it.thatflow.perworldantibuild;

import it.thatflow.perworldantibuild.command.AntiBuildCommand;
import it.thatflow.perworldantibuild.listener.BuildListener;
import it.thatflow.perworldantibuild.service.IConfigService;
import it.thatflow.perworldantibuild.service.IWorldService;
import it.thatflow.perworldantibuild.service.impl.ConfigService;
import it.thatflow.perworldantibuild.service.impl.WorldService;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class PerWorldAntiBuildPlugin extends JavaPlugin {

    private final IConfigService configService = new ConfigService(this);
    private final IWorldService worldService = new WorldService(configService);

    private static Logger logger;

    @Override
    public void onEnable() {
        logger = getLogger();

        configService.load();
        worldService.load();

        getCommand("antibuild").setExecutor(new AntiBuildCommand(configService, worldService));
        getServer().getPluginManager().registerEvents(new BuildListener(configService, worldService), this);
    }

    @Override
    public void onDisable() {
        configService.load();
        worldService.load();
    }

    public static Logger getPrinter() {
        return logger;
    }
}
