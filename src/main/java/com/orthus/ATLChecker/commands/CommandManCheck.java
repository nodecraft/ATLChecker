package com.orthus.ATLChecker.commands;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import com.orthus.ATLChecker.ATLChecker;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.UserListOps;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class CommandManCheck implements ICommand
{ 
 
	private List aliases;
	  public CommandManCheck()
	  {
	    this.aliases = new ArrayList();
	    this.aliases.add("updatecheck");
	  }

	@Override 
    public int compareTo(Object o)
    { 
        return 0; 
    } 

    @Override 
    public String getCommandName() 
    { 
        return "updatecheck"; 
    } 

    @Override         
    public String getCommandUsage(ICommandSender var1) 
    { 
        return "/updatecheck <displays if modpack is up to date or custom out of date message>"; 
    } 

    @Override 
    public void processCommand(ICommandSender sender, String[] argString)
    { 
            
    	if (ATLChecker.CheckResult != true)
    	{
			sender.addChatMessage(new ChatComponentText(ATLChecker.OpMessage));
    	}
    	else{
			sender.addChatMessage(new ChatComponentText("Pack is up to date!"));
    	}
    } 

    @Override 
    public boolean canCommandSenderUseCommand(ICommandSender var1) 
    { 
        return true;
    } 

    @Override  
    public List addTabCompletionOptions(ICommandSender var1, String[] var2) 
    { 
        return null; 
    } 

    @Override 
    public boolean isUsernameIndex(String[] var1, int var2) 
    { 
        return false;
    }

	@Override
	public List getCommandAliases() {
	    return this.aliases;
	}


}
