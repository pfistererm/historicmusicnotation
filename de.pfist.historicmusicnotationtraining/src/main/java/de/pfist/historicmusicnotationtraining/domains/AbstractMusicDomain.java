package de.pfist.historicmusicnotationtraining.domains;

import java.awt.event.KeyEvent;

import de.pfist.historicmusicnotationtraining.messages.Messages;

/**
 * @param <S> the type of the domain specific state
 *
 */
public abstract class AbstractMusicDomain<S extends DomainSpecificState> implements MusicDomain {

	private final String NAME = getMessageString("domainTitle"); //$NON-NLS-1$
	private final String TOOLTIP = getMessageString("domainTooltip"); //$NON-NLS-1$
	private final int MNEMONIC = getMnemonicFromProperties();

	private S domainSpecificState;

	protected final String getPropertyBaseName() {
		return getClass().getSimpleName();
	};

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getId() {
		return getClass().getSimpleName();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getName() {
		return NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final String getToolTip() {
		return TOOLTIP;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final int getTabMnemonic() {
		return MNEMONIC;
	}

	protected void init() {
		domainSpecificState = createDomainSpecificState();
	}

	protected abstract S createDomainSpecificState();

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final S getStateObject() {
		return domainSpecificState;
	}

	protected String getMessageString(String propertyName) {
		return Messages.getString(getPropertyBaseName() + "." + propertyName); // $NON-NLS-1$
	}

	protected int getMnemonicFromProperties() {
		String s = getMessageString("domainMnemonic");
		char c = s.charAt(0);
		return KeyEvent.getExtendedKeyCodeForChar(c);
	}

}
