package me.zabra.ImageViewer.commands;

import me.zabra.ImageViewer.Main;
import me.zabra.ImageViewer.closestColour;
import me.zabra.ImageViewer.imageTocolour;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class createSheepGrid implements CommandExecutor {
    private Main plugin;

    public createSheepGrid(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("create").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if (p.isOp()) {
            if (args.length == 2) {
                File img = new File(args[0]);

                // Create sheep
                int width = 0;
                int height = 0;
                try {
                    width = ImageIO.read(img).getWidth();
                    height = ImageIO.read(img).getHeight();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                int pixels[][][] = {};
                try {
                    pixels = imageTocolour.main(img);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // Check if we are doing sheep, wool or neither
                if (args[1].toLowerCase().matches("sheep")) {
                    for (int h=0; h<height; h++) {
                        for (int w = 0; w < width; w++) {
                            // Create Sheep
                            Location pos = p.getLocation().add(w, 0, h);
                            Sheep sheep = (Sheep) p.getWorld().spawnEntity(pos, EntityType.SHEEP);

                            sheep.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 999999, 10, false, false));
                            sheep.setCustomNameVisible(false);
                            sheep.setCustomName("Width: " + w + " Height: " + h);

                            // Dye Sheep
                            int r = pixels[h][w][0];
                            int g = pixels[h][w][1];
                            int b = pixels[h][w][2];
                            String hex = String.format("#%02X%02X%02X", r, g, b);

                            sheep.setColor(closestColour.strHexToDyeCol(hex));
                        }
                    }
                } else if (args[1].toLowerCase().matches("wool")) {
                    for (int h=0; h<height; h++) {
                        for (int w = 0; w < width; w++) {
                            // Get Block
                            Location pos = p.getLocation().add(w, 0, h);
                            Block block = p.getWorld().getBlockAt(pos);

                            // Dye Sheep
                            int r = pixels[h][w][0];
                            int g = pixels[h][w][1];
                            int b = pixels[h][w][2];
                            String hex = String.format("#%02X%02X%02X", r, g, b);

                            BlockState state = block.getState();
                            state.setType(closestColour.strHexToWoolMat(hex));
                            state.update(true);
                        }
                    }
                } else {
                    p.sendMessage(ChatColor.RED + "\'sheep\' or \'wool\'");
                }
            } else {
                p.sendMessage(ChatColor.RED + "Do \'/create [FILE DIRECTORY] [sheep OR wool]\'");
                p.sendMessage(ChatColor.RED + "Example: \'/create C:\\Users\\User\\Desktop\\image.png wool\'");
            }
        } else {
            p.sendMessage(ChatColor.RED + "You must have OP to use this command.");
        }
        return false;
    }
}
