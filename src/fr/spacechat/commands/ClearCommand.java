package fr.spacechat.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearCommand implements CommandExecutor
{

    @Override
    public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3)
    {
        Player player = (Player) sender;
        
        if(player instanceof Player)
        {
            for(int i = 0; i <= 50; i++)
            {
                player.sendMessage("");
            }
        }  
        return true;
    }
}
