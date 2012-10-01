/*
 * Copyright (C) 2011 lichtflut Forschungs- und Entwicklungsgesellschaft mbH
 */
package de.lichtflut.brouker.pages;

import de.lichtflut.rb.application.custom.PerspectivePage;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import de.lichtflut.rb.application.base.RBBasePage;
import org.arastreju.sge.model.ResourceID;
import org.arastreju.sge.model.SimpleResourceID;

/**
 * <p>
 *  The dashboard - welcome and personal page.
 * </p>
 *
 * <p>
 * 	Created May 30, 2011
 * </p>
 *
 * @author Oliver Tigges
 */
public class WelcomePage extends PerspectivePage {

    public static final ResourceID WELCOME_PERSPECTIVE_ID =
            new SimpleResourceID("http://rb.lichtflut.de/brouker/perspectives/welcome");

    // ----------------------------------------------------

	/**
     * Constructor.
	 */
	public WelcomePage() {
		super(WELCOME_PERSPECTIVE_ID);
	}
	
}
