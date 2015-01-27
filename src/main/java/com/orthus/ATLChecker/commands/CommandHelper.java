package com.orthus.ATLChecker.commands;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

public class CommandHelper implements ICommand {

	private List aliases;
	public CommandHelper()
	{
    this.aliases = new ArrayList();
    this.aliases.add("atlhelp");
	}
	
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List addTabCompletionOptions(ICommandSender arg0, String[] arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender arg0) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List getCommandAliases() {
		// TODO Auto-generated method stub
		return this.aliases;
	}

	@Override
	public String getCommandName() {
		// TODO Auto-generated method stub
		return "atlhelp";
	}

	@Override
	public String getCommandUsage(ICommandSender arg0) {
		// TODO Auto-generated method stub
		return "/atlhelp outputs all ATLChecker commands and usages";
	}

	@Override
	public boolean isUsernameIndex(String[] arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void processCommand(ICommandSender sender, String[] arg1) {
		sender.addChatMessage(new ChatComponentText("/updatecheck <displays operator notification>"));
		sender.addChatMessage(new ChatComponentText("/atct <toggles console notification for ATLChecker>"));
		sender.addChatMessage(new ChatComponentText("/atot <toggles operator join notificaton for ATLChecker>"));
	}
	
}
