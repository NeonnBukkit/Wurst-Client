/*
 * Copyright � 2014 - 2015 | Alexander01998 | All rights reserved.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package tk.wurst_client.options;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import tk.wurst_client.Client;

public class Options
{
	public boolean autoReconnect = false;
	public boolean cleanupFailed = false;
	public boolean cleanupOutdated = true;
	public boolean cleanupRename = true;
	public boolean cleanupUnknown = true;
	public boolean forceOPDontWait = false;
	public boolean middleClickFriends = true;
	public boolean spamFont = false;
	public boolean renameForceOPEvenThoughTheNameIsTechnicallyCorrect = false;
	public boolean WIP = false;

	public int arrayListMode = 0;
	public int autobuildMode = 1;
	public int targetMode = 0;
	public int fastbreakMode = 0;
	public int forceOPDelay = 1000;
	public int nukerMode = 0;
	public int searchID = 116;
	public int serverFinderThreads = 64;
	public int spamDelay = 1000;
	public int throwAmount = 16;

	public String forceOPList = Client.Wurst.fileManager.WurstDir.getPath();

	public ArrayList<String> friends = new ArrayList<String>();

	public void sortFriends()
	{
		Collections.sort(friends, new Comparator<String>()
			{
			@Override
			public int compare(String o1, String o2)
			{
				return o1.compareToIgnoreCase(o2);
			}
			});
	}
}
