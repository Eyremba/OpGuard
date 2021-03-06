package com.rezzedup.opguard.util;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Config
{
    public static void load(JavaPlugin plugin)
    {
        FileConfiguration config = plugin.getConfig();
        
        config.options().copyDefaults(true);
        
        /*
         * 
         *  OPTIONS
         * 
         */
        
        config.addDefault("inspection-interval", 4L);
        config.addDefault("save-interval", 1200L);
        config.addDefault("only-op-if-online", true);
        config.addDefault("shutdown-on-disable", false);
        config.addDefault("metrics", true);
        
        /*
         * 
         *  LOGGING
         * 
         */
        
        config.addDefault("log.enabled", true);
        config.addDefault("log.status", true);
        config.addDefault("log.plugin-attempt", true);
        config.addDefault("log.console-attempt", true);
        config.addDefault("log.player-attempt", true);
        
        /*
         * 
         *  WARNINGS
         * 
         */
        
        config.addDefault("warn.status", true);
        config.addDefault("warn.plugin-attempt", true);
        config.addDefault("warn.console-attempt", true);
        config.addDefault("warn.player-attempt", true);
        config.addDefault("warn.security-risk", true);
        
        /*
         * 
         *  PUNISHMENTS
         * 
         */
        
        config.addDefault("punish.plugin-attempt", true);
        config.addDefault("punish.console-attempt", true);
        config.addDefault("punish.player-attempt", false);
        config.addDefault("punish.command", "ban %player% Attempting to gain op");
        
        /*
         * 
         *  MANAGEMENT
         * 
         */
        
        config.addDefault("manage.password-in-game", true);
        
        /*
         * 
         *  PASSWORD
         * 
         */
        
        config.addDefault("password.info", " --- ");
        config.set
        (
            "password.info", "[WARNING]\n" +
            "Editing this section manually could break your password (if set).\n" +
            "Managing the password should be done in-game via commands."
        );
        
        plugin.saveConfig();
    }
}
