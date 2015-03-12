package com.orthus.ATLChecker.commands;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

public class CommandHelper implements ICommand {
	private List aliases = new ArrayList();

	public CommandHelper() {
		aliases.add("atlhelp");
	}

	@Override
	public int compareTo(Object o) {
		return 0;
	}

	@Override
	public List addTabCompletionOptions(ICommandSender arg0, String[] arg1) {
		return null;
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender arg0) {
		return true;
	}

	@Override
	public List getCommandAliases() {
		return aliases;
	}

	@Override
	public String getCommandName() {
		return "atlhelp";
	}

	@Override
	public String getCommandUsage(ICommandSender arg0) {
		return "/atlhelp outputs all ATLChecker commands and usages";
	}

	@Override
	public boolean isUsernameIndex(String[] arg0, int arg1) {
		return false;
	}

	@Override
	public void processCommand(ICommandSender sender, String[] arg1) {
		sender.addChatMessage(new ChatComponentText("/updatecheck <displays operator notification>"));
		sender.addChatMessage(new ChatComponentText("/atct <toggles console notification for ATLChecker>"));
		sender.addChatMessage(new ChatComponentText("/atot <toggles operator join notificaton for ATLChecker>"));
	}
}