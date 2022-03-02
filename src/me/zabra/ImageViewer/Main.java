package me.zabra.ImageViewer;

import me.zabra.ImageViewer.commands.ButcherCommand;
import me.zabra.ImageViewer.commands.createSheepGrid;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        new createSheepGrid(this);
        new ButcherCommand(this);
    }
}
