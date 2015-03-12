package com.orthus.ATLChecker.commands;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

import com.orthus.ATLChecker.ATLChecker;

public class CommandManCheck implements ICommand {
	private List aliases = new ArrayList();

	public CommandManCheck() {
		aliases.add("updatecheck");
	}

	@Override
	public int compareTo(Object o) {
		return 0;
	}

	@Override
	public String getCommandName() {
		return "updatecheck";
	}

	@Override
	public String getCommandUsage(ICommandSender var1) {
		return "/updatecheck <displays operator notification>";
	}

	@Override
	public void processCommand(ICommandSender sender, String[] argString) {
		if (ATLChecker.CheckResult) {
			sender.addChatMessage(new ChatComponentText("Pack is up to date. " + ATLChecker.LatestVersion));
			ATLChecker.logger.info(String.format("Pack is up to date. " + ATLChecker.LatestVersion));
		} else {
			sender.addChatMessage(new ChatComponentText(String.format(ATLChecker.OpMessage, ATLChecker.LocalVersion, ATLChecker.LatestVersion)));
			ATLChecker.logger.info(String.format(ATLChecker.ConsoleMessage, ATLChecker.LocalVersion, ATLChecker.LatestVersion));
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