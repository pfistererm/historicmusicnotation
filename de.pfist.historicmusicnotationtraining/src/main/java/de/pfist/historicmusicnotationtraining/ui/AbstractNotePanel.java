package de.pfist.historicmusicnotationtraining.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;

import de.pfist.historicmusicnotationtraining.Controller;
import de.pfist.historicmusicnotationtraining.domains.AbstractRandomResult;
import de.pfist.historicmusicnotationtraining.domains.DomainRandomResult;
import de.pfist.historicmusicnotationtraining.domains.DomainSpecificState;

// TODO: find a new base name ..DisplayPanel..PaintingPanel... DrawingPanel
public abstract class AbstractNotePanel<D extends DomainSpecificState, O> extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5639322492906295423L;

	private static final String SMUFL_FONT_NAME = "Bravura"; //$NON-NLS-1$

	private static Font unscaledSmuflFont = null;

	private final Controller controller;

	protected O domainObject;
	private boolean initialized = false;
	protected float fontSize;

	protected AbstractNotePanel(final Controller controller) {
		this.controller = controller;
		setBackground(Color.WHITE);
		this.addMouseListener(new MouseAdapter() {

			/** {@inheritDoc} */
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.doNext(false);
			}
		});
	}

	/**
	 * @return the controller
	 */
	protected final Controller getController() {
		return controller;
	}

	/**
	 * @return the initialized
	 */
	protected final boolean isInitialized() {
		return initialized;
	}

	@SuppressWarnings("unchecked")
	protected D getDomainSpecificState() {
		return (D) getController().getCurrentDomainSpecificState();
	}

	@SuppressWarnings("unchecked")
	protected D getDomainSpecificState(final Class<?> domainSpecificStateClass) {
		return (D) getController().getDomainSpecificState(domainSpecificStateClass);
	}

	/**
	 * @return the domainObject
	 */
	protected final O getDomainObject() {
		return domainObject;
	}

	/**
	 * @return the fontSize
	 */
	protected final float getFontSize() {
		return fontSize;
	}

	/** {@inheritDoc} */
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(100, 200);
	}

	/**
	 * <p>If you override this method make sure to call super.</p>
	 * <p>Note: cannot be made generic because of call in an event handler in Controller.</p>
	 * @param domainRandomResult
	 */
	public void setRandomResult(DomainRandomResult domainRandomResult) {
		@SuppressWarnings("unchecked")
		final AbstractRandomResult<O> randomResult = (AbstractRandomResult<O>) domainRandomResult;
		this.domainObject = randomResult.getDomainObject();
		initialized = true;
	}

	/**
	 * Loads a truetype font from the resources directory.
	 * 
	 * @param fontName
	 * @return
	 */
	protected static Font loadFont(final String fontName) {
		try {
			return Font.createFont(Font.TRUETYPE_FONT, new File("src/main/resources/fonts/" + fontName + ".otf")); //$NON-NLS-1$ //$NON-NLS-2$
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Obtains a SMUFL (Standard music font layout) font.
	 * 
	 * @return an unscaled font
	 */
	protected static Font getUnscaledSmuflFont() {
		if (unscaledSmuflFont == null) {
			unscaledSmuflFont = loadFont(SMUFL_FONT_NAME);
			// scale once for performance
			unscaledSmuflFont.deriveFont(20.0f);
		}
		return unscaledSmuflFont;
	}

}