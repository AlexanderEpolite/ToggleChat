package dev.alexisok.togglechat;

import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

/**
 * Plugin that allows people to toggle the chat.
 * 
 * @author AlexIsOK
 * @since 1.0
 */
public class ToggleChat extends JavaPlugin implements Listener, CommandExecutor {
    
    public static final String VERSION = "1.0";
    
    protected static final HashMap<String, String> LANG = new HashMap<>();
    
    @Override
    public void onEnable() {
        System.out.printf("Starting ToggleChat plugin by AlexIsOK, version %s%n", VERSION);
        
        this.getServer().getPluginManager().registerEvents(new EventListenerImpl(), this);
        
        this.getCommand("togglechat").setExecutor(new CommandListener());
        
        //config type stuff
        this.getConfig().addDefault("chatOffForYou", "Chat is off for you.  Use /togglechat to enable it.");
        this.getConfig().addDefault("toggleOn", "Chat is now on for you.");
        this.getConfig().addDefault("toggleOff", "Chat is now off for you.");
        this.getConfig().options().copyDefaults(true);
        saveConfig();
        
        //add language stuff
        LANG.put("chatOffForYou", this.getConfig().getString("chatOffForYou"));
        LANG.put("toggleOn", this.getConfig().getString("toggleOn"));
        LANG.put("toggleOff", this.getConfig().getString("toggleOff"));
    }
    
    @Override
    public void onDisable() {
        getLogger().info("Disabled ToggleChat plugin.  Hope you enjoyed it!");
    }

}
