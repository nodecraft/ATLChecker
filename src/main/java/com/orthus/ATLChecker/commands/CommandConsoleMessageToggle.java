package com.orthus.ATLChecker.commands;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

import com.orthus.ATLChecker.ATLChecker;

public class CommandConsoleMessageToggle implements ICommand {
	private List aliases = new ArrayList();

	public CommandConsoleMessageToggle() {
		aliases.add("atct");
	}

	@Override
	public int compareTo(Object o) {
		return 0;
	}

	@Override
	public String getCommandName() {
		return "atct";
	}

	@Override
	public String getCommandUsage(ICommandSender var1) {
		return "/atct <toggles console notification for ATLChecker>";
	}

	@Override
	public void processCommand(ICommandSender sender, String[] argString) {
		if (ATLChecker.ConsoleOut) {
			ATLChecker.ConsoleOut = false;
			sender.addChatMessage(new ChatComponentText("Console message disabled"));
			ATLChecker.logger.info(sender.getCommandSenderName() + " has disabled console notifications for ATLChecker");
		} else {
			ATLChecker.ConsoleOut = false;
			sender.addChatMessage(new ChatComponentText("Console message enabled"));
			ATLChecker.logger.info(String.format(sender.getCommandSenderName() + " has enabled console notifications for ATLChecker"));
		}
	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender var1) {
		return true;
	}

	@Override
	public List addTabCompletionOptions(ICommandSender var1, String[] var2) {
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] var1, int var2) {
		return false;
	}

	@Override
	public List getCommandAliases() {
		return aliases;
	}
}