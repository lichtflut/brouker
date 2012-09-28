/*
 * Copyright 2012 by lichtflut Forschungs- und Entwicklungsgesellschaft mbH
 */
package de.lichtflut.brouker.conf;

import de.lichtflut.rb.core.messaging.EmailConfiguration;

/**
 * <p>
 * Implementation of {@link EmailConfiguration}.
 * </p>
 * 
 * <p>
 * Created Feb 13, 2012
 * </p>
 * 
 * @author Ravi Knox
 */
public class BroukerEmailConfiguration implements EmailConfiguration {

	private static final String SMTP_SERVER = "goldfinger.lichtflut.de";

	private static final String SMTP_USER = "noreply";

	private static final String SMTP_PASSWORD = "MI821rfc";

	private static final String APPLICATION_NAME = "Brouker";

	private static final String APPLICATION_EMAIL = "noreply@glasnost.lichtflut.de";

	private static final String APPLICATION_SUPPORT_NAME = "Glasnost Support Team";

	private static final String APPLICATION_SUPPORT_EMAIL = "webck@lichtflut.de";

	private static EmailConfiguration INSTANCE;

	// ---------------- Constructor -------------------------

	/**
	 * Hide Constructor.
	 */
	private BroukerEmailConfiguration() {
	}

	// ------------------------------------------------------

	/**
	 * @return
	 */
	@Deprecated
	public static EmailConfiguration getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new BroukerEmailConfiguration();
		}
		return INSTANCE;
	}

	/**
	 * @return the smtpServer
	 */
	@Override
	public String getSmtpServer() {
		return SMTP_SERVER;
	}

	/**
	 * @return the smtpUser
	 */
	@Override
	public String getSmtpUser() {
		return SMTP_USER;
	}

	/**
	 * @return the smtpPassword
	 */
	@Override
	public String getSmtpPassword() {
		return SMTP_PASSWORD;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getApplicationSupportName() {
		return APPLICATION_SUPPORT_NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getApplicationSupportEmail() {
		return APPLICATION_SUPPORT_EMAIL;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getApplicationName() {
		return APPLICATION_NAME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getApplicationEmail() {
		return APPLICATION_EMAIL;
	}

}
