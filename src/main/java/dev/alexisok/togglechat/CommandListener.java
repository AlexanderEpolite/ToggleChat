package dev.alexisok.togglechat;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * @author AlexIsOK
 * @since 1.0
 */
public class CommandListener implements CommandExecutor {
    
    protected static final ArrayList<String> TOGGLED_USERS_BY_UUID = new ArrayList<>();
    
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        if((sender instanceof Player)) {
            try {
                String UUID = ((Player) sender).getPlayer().getUniqueId().toString();
                if(TOGGLED_USERS_BY_UUID.contains(UUID)) {
                    ((Player) sender).getPlayer().sendRawMessage(ToggleChat.LANG.get("toggleOn"));
                    TOGGLED_USERS_BY_UUID.remove(UUID);
                } else {
                    ((Player) sender).getPlayer().sendRawMessage(ToggleChat.LANG.get("toggleOff"));
                    TOGGLED_USERS_BY_UUID.add(UUID);
                }
            } catch(NullPointerException ignored) {}
            return true;
        }
        return false;
    }
}
