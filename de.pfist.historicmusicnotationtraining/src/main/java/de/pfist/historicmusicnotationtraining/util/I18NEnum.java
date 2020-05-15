/**
 * 
 */
package de.pfist.historicmusicnotationtraining.util;

import de.pfist.historicmusicnotationtraining.messages.Messages;

/**
 * Interface for enumerations that provide a key for i18n.
 * 
 *
 */
public interface I18NEnum {

	/**
	 * Obtains a key to be used with {@link Messages#getString(String)} to fetch the
	 * localized name of the enum tag that should be displayed on the GUI.
	 * 
	 * @return an I18N key
	 */
	public String getTextKey();
}
