package com.orthus.ATLChecker.commands;

import java.lang.reflect.Array;
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
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

	public class CommandConsoleMessageToggle implements ICommand
	{ 
	 
	    @Override 
	    public int compareTo(Object o)
	    { 
	        return 0; 
	    } 

	    @Override 
	    public String getCommandName() 
	    { 
	        return "atct"; 
	    } 

	    @Override         
	    public String getCommandUsage(ICommandSender var1) 
	    { 
	        return "/atct <toggles console notification for ATLChecker>"; 
	    } 

	    @Override 
	    public void processCommand(ICommandSender sender, String[] argString)
	    { 
	    	if (ATLChecker.ConsoleOut == true){
	    		ATLChecker.ConsoleOut = false;
	    		sender.addChatMessage(new ChatComponentText("Console message disabled"));
	    	}
	    	else{
	    		ATLChecker.ConsoleOut = false;
	    		sender.addChatMessage(new ChatComponentText("Console message enabled"));;
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
	        // TODO Auto-generated method stub 
	        return null; 
	    } 

	    @Override 
	    public boolean isUsernameIndex(String[] var1, int var2) 
	    { 
	        // TODO Auto-generated method stub 
	        return false;
	    }

		@Override
		public List getCommandAliases() {
			// TODO Auto-generated method stub
			return null;
		} 
}
