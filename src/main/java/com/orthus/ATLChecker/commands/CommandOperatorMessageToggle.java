package com.orthus.ATLChecker.commands;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

import com.orthus.ATLChecker.ATLChecker;

public class CommandOperatorMessageToggle implements ICommand {
	private List aliases = new ArrayList();

	public CommandOperatorMessageToggle() {
		aliases.add("atot");
	}

	@Override
	public int compareTo(Object o) {
		return 0;
	}

	@Override
	public String getCommandName() {
		return "atot";
	}

	@Override
	public String getCommandUsage(ICommandSender var1) {
		return "/atot <toggles operator join notificaton for ATLChecker>";
	}

	@Override
	public void processCommand(ICommandSender sender, String[] argString) {
		if (ATLChecker.OperatorOut) {
			ATLChecker.OperatorOut = false;
			sender.addChatMessage(new ChatComponentText("Operator message disabled"));
			ATLChecker.logger.info(String.format(sender.getCommandSenderName() + " has disabled operator notifications for ATLChecker"));
		} else {
			ATLChecker.OperatorOut = false;
			sender.addChatMessage(new ChatComponentText("Operator message enabled"));
			ATLChecker.logger.info(String.format(sender.getCommandSenderName() + " has enabled operator notifications for ATLChecker"));
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