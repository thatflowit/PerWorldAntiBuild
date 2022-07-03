package it.thatflow.perworldantibuild.service.impl;

import it.thatflow.perworldantibuild.PerWorldAntiBuildPlugin;
import it.thatflow.perworldantibuild.service.IConfigService;
import it.thatflow.perworldantibuild.service.IWorldService;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class WorldService implements IWorldService {

    private final IConfigService configService;
    private final List<String> worlds = new ArrayList<>();

    @Override
    public void load() {
        PerWorldAntiBuildPlugin.getPrinter().info("Loading world service...");

        worlds.addAll(configService.getWorld().getStringList("worlds"));
    }

    @Override
    public void unload() {
        PerWorldAntiBuildPlugin.getPrinter().info("Unloading world service...");
    }


    @Override
    public void addWorld(String world) {
        worlds.add(world);

        configService.getWorld().set("worlds", worlds);
        configService.saveConfigs();
    }

    @Override
    public void removeWorld(String world) {
        worlds.remove(world);

        configService.getWorld().set("worlds", worlds);
        configService.saveConfigs();
    }

    @Override
    public boolean isBlocked(String world) {
        return worlds.contains(world);
    }
}
