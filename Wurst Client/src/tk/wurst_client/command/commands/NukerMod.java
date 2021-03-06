/*
 * Copyright � 2014 - 2015 | Alexander01998 | All rights reserved.
 * 
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package tk.wurst_client.command.commands;

import net.minecraft.block.Block;
import tk.wurst_client.Client;
import tk.wurst_client.command.Command;
import tk.wurst_client.module.modules.Nuker;
import tk.wurst_client.utils.MiscUtils;

public class NukerMod extends Command
{
	
	private static String[] commandHelp =
	{
		"Changes the settings of Nuker.",
		".nuker mode <normal | id | flat | smash>",
		".nuker id <block id>",
		".nuker name <block name>"
	};

	public NukerMod()
	{
		super("nuker", commandHelp);
	}

	@Override
	public void onEnable(String input, String[] args)
	{
		if(args == null)
			commandError();
		else if(args[0].toLowerCase().equals("mode"))
		{// 0=normal, 1=id, 2=flat, 3=smash
			if(args[1].toLowerCase().equals("normal"))
			{
				Client.Wurst.options.nukerMode = 0;
				Nuker.id = 0;
			}else if(args[1].toLowerCase().equals("id"))
			{
				Client.Wurst.options.nukerMode = 1;
				Nuker.id = 0;
			}else if(args[1].toLowerCase().equals("flat"))
			{
				Client.Wurst.options.nukerMode = 2;
				Nuker.id = 0;
			}else if(args[1].toLowerCase().equals("smash"))
			{
				Client.Wurst.options.nukerMode = 3;
				Nuker.id = 0;
			}else
			{
				commandError();
				return;
			}
			Client.Wurst.fileManager.saveOptions();
			Client.Wurst.chat.message("Nuker mode set to \"" + args[1] + "\".");
		}else if(args[0].equalsIgnoreCase("id") && MiscUtils.isInteger(args[1]))
		{
			if(Client.Wurst.options.nukerMode != 1)
			{
				Client.Wurst.options.nukerMode = 1;
				Client.Wurst.chat.message("Nuker mode set to \"" + args[0] + "\".");
			}
			Nuker.id = Integer.valueOf(args[1]);
			Client.Wurst.fileManager.saveOptions();
			Client.Wurst.chat.message("Nuker ID set to " + args[1] + ".");
		}else if(args[0].equalsIgnoreCase("name"))
		{
			if(Client.Wurst.options.nukerMode != 1)
			{
				Client.Wurst.options.nukerMode = 1;
				Client.Wurst.chat.message("Nuker mode set to \"" + args[0] + "\".");
			}
			int newID = Block.getIdFromBlock(Block.getBlockFromName(args[1]));
			if(newID == -1)
			{
				Client.Wurst.chat.message("The block \"" + args[1] + "\" could not be found.");
				return;
			}
			Nuker.id = Integer.valueOf(newID);
			Client.Wurst.fileManager.saveOptions();
			Client.Wurst.chat.message("Nuker ID set to " + newID + " (" + args[1] + ").");
		}else
			commandError();
	}
}
