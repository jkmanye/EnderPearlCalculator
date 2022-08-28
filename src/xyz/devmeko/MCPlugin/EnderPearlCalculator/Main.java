package xyz.devmeko.MCPlugin.EnderPearlCalculator;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.devmeko.MCPlugin.EnderPearlCalculator.Commands.CalibrateCommand;
import xyz.devmeko.MCPlugin.EnderPearlCalculator.Listeners.ProjectileHit;

public class Main extends JavaPlugin {

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "EPC Disabled!");
    }

    @Override
    public void onEnable() {
        this.getCommand("calibrate").setExecutor(new CalibrateCommand());
        Bukkit.getPluginManager().registerEvents(new ProjectileHit(), this);

        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "EPC Enabled!");
    }
}
