package xyz.devmeko.MCPlugin.EnderPearlCalculator.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.devmeko.MCPlugin.EnderPearlCalculator.GlobalVars;

import java.util.List;

public class CalibrateCommand implements CommandExecutor {

    public void calibrate(Player player) {

        StringBuilder xArr = new StringBuilder("[");
        StringBuilder yArr = new StringBuilder("[");

        for (int i = 0; i < 180; i++) {
            player.sendMessage(ChatColor.AQUA + "x = " + xArr);
            player.sendMessage(ChatColor.AQUA + "y = " + yArr);
            GlobalVars.continueCalibration = false;
            Location tpLoc = player.getLocation();
            tpLoc.setYaw(90);
            tpLoc.setPitch(i + 1);
            player.launchProjectile(EnderPearl.class);
            while(!GlobalVars.continueCalibration) continue;
            xArr.append(i + 1).append(", ");
            yArr.append((int) GlobalVars.thrownLoc.distance(tpLoc)).append(", ");
        }

        xArr.delete(xArr.length() - 2, xArr.length() - 1);
        xArr.append("]");

        yArr.delete(xArr.length() - 2, xArr.length() - 1);
        yArr.append("]");

        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "x = " + xArr);
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "y = " + yArr);
        player.sendMessage(ChatColor.GREEN + "Done!");
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("calibrate")) {
            if (commandSender instanceof Player) {
                commandSender.sendMessage(ChatColor.RED + "Calibrating...");
                calibrate((Player) commandSender);
            }
        }

        return true;
    }
}
