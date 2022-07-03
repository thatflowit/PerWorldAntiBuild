package it.thatflow.perworldantibuild.service;

import org.bukkit.configuration.file.FileConfiguration;

public interface IConfigService extends Service {

    void saveConfigs();

    FileConfiguration getConfig();
    FileConfiguration getWorld();
}
