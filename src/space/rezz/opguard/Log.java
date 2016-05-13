package space.rezz.opguard;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Log
{
    private File file;
    private FileConfiguration config;
    
    public Log(JavaPlugin plugin, String name)
    {
        this.file = new File(plugin.getDataFolder() + "/" + name + ".log");
        this.config = plugin.getConfig();
        
        if (!this.file.exists())
        {
            try
            {
                this.file.createNewFile();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }
    
    private String now()
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss (aa)");
        return "[" + LocalDateTime.now().format(formatter) + "]";
    }
    
    public void append(String type, String message)
    {
        if (!config.getBoolean("log." + type) || !config.getBoolean("log.enabled"))
        {
            return;
        }
        message = now() + " " + message;
        byte[] msg = message.getBytes();
        
        try
        {
            Files.write(this.file.toPath(), msg, StandardOpenOption.APPEND);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
