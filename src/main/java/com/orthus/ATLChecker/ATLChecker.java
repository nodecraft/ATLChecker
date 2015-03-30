package com.orthus.ATLChecker;

import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.orthus.ATLChecker.Json.JsonReader;
import com.orthus.ATLChecker.commands.CommandConsoleMessageToggle;
import com.orthus.ATLChecker.commands.CommandManCheck;
import com.orthus.ATLChecker.commands.CommandOperatorMessageToggle;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

@Mod(modid = ATLChecker.modid, version = ATLChecker.version, acceptedMinecraftVersions = "*", acceptableRemoteVersions = "*")
public class ATLChecker {
	public static String LocalVersion, PackName, OpMessage, ConsoleMessage, LatestVersion, FailureMessage;
	public static boolean ConsoleOut, OperatorOut, CheckResult, OpStatus;

	public static final String modid = "ATLChecker", version = "1.0.2";

	public static Logger logger = LogManager.getLogger(modid);

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());

		config.load();

		PackName = config.get(config.CATEGORY_GENERAL, "Pack", "Default").getString();
		LocalVersion = config.get(config.CATEGORY_GENERAL, "Current Version", "0.0.0").getString();
		OpMessage = config.get(config.CATEGORY_GENERAL, "Operator Message", "Server out of date.").getString();
		ConsoleMessage = config.get(config.CATEGORY_GENERAL, "Console Message", "Server out of date.").getString();
		FailureMessage = config.get(config.CATEGORY_GENERAL, "API Failure Message", "Version returned as " + LatestVersion).getString();
		ConsoleOut = config.get(config.CATEGORY_GENERAL, "Console Output", true).getBoolean();
		OperatorOut = config.get(config.CATEGORY_GENERAL, "Operator Output", true).getBoolean();
		config.save();

		if (PackName != "Default") {
			LatestVersion = JsonReader.main(PackName);
		}
		else {
			LatestVersion = LocalVersion;
		}
		CheckResult = LatestVersion.equals(LocalVersion);

		FMLCommonHandler.instance().bus().register(new ATLEventHandler());
	}

	@EventHandler
	public void serverStart(FMLServerStartingEvent event) {
		event.registerServerCommand(new CommandManCheck());
		event.registerServerCommand(new CommandConsoleMessageToggle());
		event.registerServerCommand(new CommandOperatorMessageToggle());
	}

	@EventHandler
	public void postInit(FMLServerStartedEvent event) {
            if (!CheckResult && ConsoleOut)
			    if (LatestVersion != "null")
				    FMLLog.info(String.format(ConsoleMessage, LocalVersion, LatestVersion));
			    else
				    FMLLog.info(String.format(FailureMessage));
    }
}