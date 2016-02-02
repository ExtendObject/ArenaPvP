package me.JavaExcption.ArenaPvP;

import me.JavaExcption.ArenaPvP.updater.UpdateChecker;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

/**
 * Created by Henry on 2/2/2016.
 */
public class ArenaPvP extends JavaPlugin {

    private ArenaPvP plugin;
    protected Logger logger;
    private UpdateChecker updateChecker;

    @Override
    public void onEnable() {

        plugin = this;
        this.logger = this.getLogger();

        this.updateChecker = new UpdateChecker(this, "insert spigot url");

        if(this.updateChecker.updateNeeded()) {
            this.logger.info("[ArenaPvP] A new version is available: " + this.updateChecker.getVersion());
            this.logger.info("[ArenaPvP] Get it from: " + this.updateChecker.getLink());
        }

        registerCommands();
        registerEvents();
    }

    @Override
    public void onDisable() {

    }

    protected void registerCommands() {

    }

    protected void registerEvents() {
        PluginManager pm = Bukkit.getPluginManager();
    }

    public ArenaPvP getPlugin() {
        return plugin;
    }
}
