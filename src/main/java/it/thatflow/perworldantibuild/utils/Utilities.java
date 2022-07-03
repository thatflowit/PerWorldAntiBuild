package it.thatflow.perworldantibuild.utils;

import lombok.experimental.UtilityClass;
import org.bukkit.ChatColor;

@UtilityClass
public class Utilities {

    public String format(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
