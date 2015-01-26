package com.orthus.ATChecker;

import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;

import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.entity.player.PlayerEvent;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

import com.mojang.authlib.GameProfile;
import com.orthus.ATChecker.*;
import com.orthus.ATChecker.Json.JsonReader;
import com.orthus.ATChecker.Json.VersionCompare;
import com.orthus.ATChecker.commands.CommandConsoleMessageToggle;
import com.orthus.ATChecker.commands.CommandManCheck;
import com.orthus.ATChecker.commands.CommandOperatorMessageToggle;

@Mod(modid = "ATChecker", version = "0.0.1", acceptedMinecraftVersions = "*", acceptableRemoteVersions = "*")
public class ATChecker
{
	public static String LocalVersion;
	public static String PackName;
	public static String OpMessage;
	public static String ConsoleMessage;
	public static String LatestVersion;
	public static String FailureMessage;
	public static Boolean ConsoleOut;
	public static Boolean OperatorOut;
	public static Boolean CheckResult;
	public static Boolean OpStatus;
	
	//Forge Methods
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	Configuration config = new Configuration(event.getSuggestedConfigurationFile());

    	config.load();
    	
    	PackName = config.get(config.CATEGORY_GENERAL  ,"Pack", "Default" ).getString();
    	LocalVersion = config.get(config.CATEGORY_GENERAL  ,"Current Version", "0.0.3" ).getString();
    	OpMessage = config.get(config.CATEGORY_GENERAL  ,"Operator Message", "Server out of date." ).getString();
    	ConsoleMessage = config.get(config.CATEGORY_GENERAL  ,"Console Message", "Server out of date." ).getString();
    	FailureMessage = config.get(config.CATEGORY_GENERAL  ,"API Failure Message", "Invalid Json" ).getString();
    	ConsoleOut = config.get(config.CATEGORY_GENERAL, "Console Output", true).getBoolean();
    	OperatorOut = config.get(config.CATEGORY_GENERAL, "Operator Output", true).getBoolean();
    	config.save();
    	peformCheck();
        
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
    }
    @Mod.EventHandler
    public void serverstart(FMLServerStartingEvent event)
    {
    	event.registerServerCommand(new CommandManCheck());
    	event.registerServerCommand(new CommandConsoleMessageToggle());
    	event.registerServerCommand(new CommandOperatorMessageToggle());
    }
    @Mod.EventHandler
    public void postInit(FMLServerStartedEvent event){
    	StartOutput();
	}
    @Mod.EventHandler
     //Too be added for chat message to Operator on server join
     public void playerjoin(PlayerLoggedInEvent event)
    {
    	//OpCheck();        
    	System.out.println(event.player.getDisplayName() + " logged In!");
    	GameProfile player = event.player.getGameProfile();
    	Boolean IsOP = MinecraftServer.getServer().getConfigurationManager().func_152607_e(player);
    	if (IsOP == true)
    	{
            if (CheckResult == true)
            {
            	if (OperatorOut == true)
            	{
        		// outputs [FML] ConsoleMessage
            	    if (LatestVersion != "null")
        			{
            			event.player.addChatMessage(new ChatComponentText(OpMessage));
            			FMLLog.info(String.format(ConsoleMessage));
        			}
        			else 
        			{
        				event.player.addChatMessage(new ChatComponentText(FailureMessage));
        			}
        		}
        	}
    	}
    }
    

    // Custom Methods/functions
    
    //--------------------------------------------------------------
    
    
    public static void peformCheck()
    {
    	// get Json
    	LatestVersion = JsonReader.main(PackName);
    	CheckResult = VersionCompare.main(LatestVersion , LocalVersion);
    }
    
    /*public static void OpCheck()
    {
		OpStatus = PlayerTracker.main();
		
	}*/

    public static void StartOutput()
    {
    	// should be != only have it as == for testing output
    	if (CheckResult != true)
    	{
    		if (ConsoleOut == true)
    		{
			// outputs [FML] ConsoleMessage
    			if (LatestVersion != "null")
    			{
        			FMLLog.info(String.format(ConsoleMessage));
    			}
    			else 
    			{
    				FMLLog.info(String.format(FailureMessage));

    			}
    		}

    	}
    }    
}