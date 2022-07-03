package it.thatflow.perworldantibuild.service.impl;

import it.thatflow.perworldantibuild.PerWorldAntiBuildPlugin;
import it.thatflow.perworldantibuild.service.IConfigService;
import lombok.Getter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

public class ConfigService implements IConfigService {

    private final PerWorldAntiBuildPlugin plugin;

    private final File configFile;
    @Getter private FileConfiguration config;

    private final File worldFile;
    @Getter private FileConfiguration world;

    public ConfigService(PerWorldAntiBuildPlugin plugin) {
        this.plugin = plugin;

        this.configFile = new File(plugin.getDataFolder(), "config.yml");
        this.worldFile = new File(plugin.getDataFolder(), "worlds.yml");
    }

    @Override
    public void load() {
        PerWorldAntiBuildPlugin.getPrinter().info("Loading config service...");
        loadConfigs();
    }

    @Override
    public void unload() {
        PerWorldAntiBuildPlugin.getPrinter().info("Unloading config service...");
        saveConfigs();
    }

    @Override
    public void saveConfigs() {
        try {
            config.save(configFile);
            world.save(worldFile);
        } catch (IOException e) {
            PerWorldAntiBuildPlugin.getPrinter().log(Level.WARNING, "Can not save config!", e);
        }
    }

    private void loadConfigs() {
        if(!configFile.exists()) plugin.saveResource("config.yml", false);
        config = YamlConfiguration.loadConfiguration(configFile);

        if(!worldFile.exists()) plugin.saveResource("worlds.yml", false);
        world = YamlConfiguration.loadConfiguration(worldFile);
    }
}
