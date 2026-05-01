package me.server.blocker;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.EventPriority;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerCommandPreprocessEvent;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;

import java.util.Arrays;
import java.util.List;

public class Main extends PluginBase implements Listener {

    private final List<String> blockedCommands = Arrays.asList("/about", "/ver", "/version");

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
        this.getLogger().info(TextFormat.GREEN + "cmd Blocker Enabled");
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onCommand(PlayerCommandPreprocessEvent event) {
        String message = event.getMessage().toLowerCase();
        String command = message.split(" ")[0];

        if (blockedCommands.contains(command)) {
            event.setCancelled(true);
            
            // Sends a 2-line message to the player
            event.getPlayer().sendMessage(
                TextFormat.GRAY + "Server Information:\n" + 
                TextFormat.AQUA + "This server is running " + TextFormat.GOLD + TextFormat.BOLD + "67kkit"
            );
        }
    }
}
