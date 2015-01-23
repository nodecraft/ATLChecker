package com.orthus.ATChecker;

import net.minecraft.init.Blocks;

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
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

import com.orthus.ATChecker.*;

@Mod(modid = "ATChecker", version = "0.0.1")
public class ATChecker
{
	public static String LocalVersion;
	public static String PackName;
	public static String OpMessage;
	public static String ConsoleMessage;
	public static String LatestVersion;
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
    	ConsoleMessage =config.get(config.CATEGORY_GENERAL  ,"Console Message", "Server out of date." ).getString();
    	ConsoleOut = config.get(config.CATEGORY_GENERAL, "Console Output", true).getBoolean();
    	OperatorOut = config.get(config.CATEGORY_GENERAL, "Operator Output", true).getBoolean();
    	config.save();
    	//MountConfig();
    	peformCheck();
        
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
    }
    @Mod.EventHandler
    public void postInit(FMLServerStartedEvent event){
    	StartOutput();
	}
    @SubscribeEvent
    /* Too be added for chat message to Operator on server join
     * public void playerjoin(PlayerLoggedInEvent event){
    	OpCheck();
    	
    }*/ 

    // Custom Methods/functions
    
    //--------------------------------------------------------------
    
    
   /** public static void MountConfig()
    {
    	Configuration config = new Configuration(event.getSuggestedConfigurationFile());

    	config.load();
    	
    	PackName = config.get(config.CATEGORY_GENERAL  ,"Pack", "Default" ).getString();
    	LocalVersion = config.get(config.CATEGORY_GENERAL  ,"Current Version", "0.0.3" ).getString();
    	OpMessage = config.get(config.CATEGORY_GENERAL  ,"Operator Message", "Server out of date." ).getString();
    	ConsoleMessage =config.get(config.CATEGORY_GENERAL  ,"Console Message", "Server out of date." ).getString();
    	ConsoleOut = config.get(config.CATEGORY_GENERAL, "Console Output", true).getBoolean();
    	OperatorOut = config.get(config.CATEGORY_GENERAL, "Operator Output", true).getBoolean();
    	config.save();
	
    }*/
    public static void peformCheck()
    {
    	// get json
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
    	if (CheckResult == true)
    	{
    		if (ConsoleOut == true)
    		{
			// outputs [FML] ConsoleMessage
			FMLLog.info(String.format(ConsoleMessage));
    		}

    	}
    }
   /* public static void OpOutput(String player)
    {
        // should be != only have it as == for testing output
        if (CheckResult == true)
        {
        	if (OperatorOut == true)
        	{
    		// outputs [FML] ConsoleMessage
        		player.sendChatToPlayer(String.format(OpMessage));
        	}
        }
    }*/
}