package xyz.devmeko.MCPlugin.EnderPearlCalculator.Listeners;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import xyz.devmeko.MCPlugin.EnderPearlCalculator.GlobalVars;

public class ProjectileHit implements Listener {

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent event) {
        if (event.getEntity().getType().equals(EntityType.ENDER_PEARL)) {
            GlobalVars.thrownLoc =  event.getHitBlock().getLocation();
            GlobalVars.continueCalibration = true;
        }
    }
}
