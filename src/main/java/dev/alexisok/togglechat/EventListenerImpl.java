package dev.alexisok.togglechat;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.jetbrains.annotations.NotNull;

import static dev.alexisok.togglechat.CommandListener.TOGGLED_USERS_BY_UUID;

/**
 * @author AlexIsOK
 * @since 1.0
 */
public class EventListenerImpl implements Listener {
    
    
    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerJoin(@NotNull PlayerJoinEvent e) {
        if(TOGGLED_USERS_BY_UUID.contains(e.getPlayer().getUniqueId().toString()))
            e.getPlayer().sendRawMessage(ToggleChat.LANG.get("chatOffForYou"));
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerChat(@NotNull AsyncPlayerChatEvent e) {
        e.getRecipients().removeIf(p -> TOGGLED_USERS_BY_UUID.contains(p.getUniqueId().toString()));
    }
}
