package fr.spacechat;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import fr.spacechat.commands.ClearCommand;

public class Main extends JavaPlugin
{
    public static Main instance;
    
    @Override
    public void onEnable()
    {
        getCommand("clearchat").setExecutor(new ClearCommand());
        
        getConfig().options().copyDefaults(true);
        saveConfig();
        
        instance = this;
        
        getAndSendBroadCast();
    }
    
    @Override
    public void onDisable()
    {
        
    }
    
    public void getAndSendBroadCast()
    {
        int time = Main.instance.getConfig().getInt("autoBroadcast.Time");
        
        new BukkitRunnable()
        {   
            @Override
            public void run()
            {
                Random rand = new Random();
                
                int nb = Main.instance.getConfig().getInt("autoBroadcast.NbMsg");
                int i = rand.nextInt(nb);
                
                String msg = Main.instance.getConfig().getString("autoBroadcast.msg" + i);
                
                Bukkit.broadcastMessage(msg);
            }
            
        }.runTaskTimer(this, 0, time);
    }
}
