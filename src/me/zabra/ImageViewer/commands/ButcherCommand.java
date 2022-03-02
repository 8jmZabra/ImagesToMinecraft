package me.zabra.ImageViewer.commands;

import me.zabra.ImageViewer.Main;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class ButcherCommand implements CommandExecutor {
    private Main plugin;

    public ButcherCommand(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("butchersheep").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (p.isOp()) {
            World w = p.getWorld();

            p.sendMessage("Butchered " + w.getEntities().size() + " sheep");

            for (LivingEntity e : w.getLivingEntities()) {
                if (e.getType() == EntityType.SHEEP) {
                    e.remove();
                }
            }
        } else {
            p.sendMessage(ChatColor.RED + "You must have OP to use this command.");
        }
        return false;
    }
}
