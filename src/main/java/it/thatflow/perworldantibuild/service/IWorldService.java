package it.thatflow.perworldantibuild.service;

public interface IWorldService extends Service {

    void addWorld(String world);
    void removeWorld(String world);
    boolean isBlocked(String world);
}
