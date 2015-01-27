package com.orthus.ATChecker;

import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;

import com.mojang.authlib.GameProfile;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class ATLEventHandler {
	
    @SubscribeEvent
    public void playerjoin(PlayerLoggedInEvent event)
   {
   	//OpCheck        
   	GameProfile player = event.player.getGameProfile();
   	Boolean IsOP = MinecraftServer.getServer().getConfigurationManager().func_152607_e(player);
   	if (IsOP == true)
   	{
           if (ATLChecker.CheckResult != true)
           {
        	   if (ATLChecker.LatestVersion != "null")
        	   {
           			event.player.addChatMessage(new ChatComponentText(ATLChecker.OpMessage));
        	   }
        	   else 
        	   {
       				event.player.addChatMessage(new ChatComponentText(ATLChecker.FailureMessage));
        	   }
          }
           else{
        	   //event.player.addChatMessage(new ChatComponentText("test string"));
           }
        
   	}
   }
	
}
