package de.pfist.historicmusicnotationtraining.util;

import java.util.prefs.Preferences;

import org.apache.commons.lang3.StringUtils;

import de.pfist.historicmusicnotationtraining.Main;
import de.pfist.historicmusicnotationtraining.domains.MusicDomain;

public class PreferencesUtils {
	private static final String DOMAIN = "domain";
	private static Preferences preferences = Preferences.userNodeForPackage(Main.class);

	public static void setLastUsedDomain(MusicDomain domain) {
		preferences.put(DOMAIN, domain.getId());
	}

	public static MusicDomain getLastUsedDomain(MusicDomain[] domains) {
		String domainId = preferences.get(DOMAIN, "");
		if (!StringUtils.isEmpty(domainId)) {
			for (MusicDomain domain : domains) {
				if (domain.getId().equals(domainId)) {
					return domain;
				}
			}
		}
		return null;
	}
}
