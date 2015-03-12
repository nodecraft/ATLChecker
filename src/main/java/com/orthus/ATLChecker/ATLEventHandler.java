package com.orthus.ATLChecker;

import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;

import com.mojang.authlib.GameProfile;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class ATLEventHandler {
	@SubscribeEvent
	public void playerjoin(PlayerLoggedInEvent event) {
		GameProfile player = event.player.getGameProfile();
		boolean op = MinecraftServer.getServer().getConfigurationManager().func_152596_g(player);
		if (op && !ATLChecker.CheckResult)
			if (ATLChecker.LatestVersion != "null")
				event.player.addChatMessage(new ChatComponentText(String.format(ATLChecker.OpMessage, ATLChecker.LocalVersion, ATLChecker.LatestVersion)));
			else
				event.player.addChatMessage(new ChatComponentText(ATLChecker.FailureMessage));
	}
}