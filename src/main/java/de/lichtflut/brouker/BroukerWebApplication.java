/*
 * Copyright (C) 2011 lichtflut Forschungs- und Entwicklungsgesellschaft mbH
 */
package de.lichtflut.brouker;

import de.lichtflut.rb.application.base.LoginPage;
import de.lichtflut.rb.application.layout.Layout;
import de.lichtflut.rb.application.styles.Style;
import org.apache.wicket.Application;
import org.apache.wicket.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import de.lichtflut.brouker.pages.WelcomePage;
import de.lichtflut.rb.application.RBApplication;
import de.lichtflut.rb.application.admin.AdminBasePage;
import de.lichtflut.rb.application.admin.identitymanagment.IdentityManagementPage;
import de.lichtflut.rb.application.admin.infomgmt.InformationManagementPage;
import de.lichtflut.rb.application.admin.typesystem.TypeSystemPage;
import de.lichtflut.rb.application.base.LogoutPage;
import de.lichtflut.rb.application.base.errorpages.DefaultErrorPage;
import de.lichtflut.rb.application.base.errorpages.ExpiredErrorPage;
import de.lichtflut.rb.application.graphvis.FlowChartInfoVisPage;
import de.lichtflut.rb.application.graphvis.HierarchyInfoVisPage;
import de.lichtflut.rb.application.graphvis.PeripheryViewPage;
import de.lichtflut.rb.application.resourceview.EntityDetailPage;
import de.lichtflut.rb.core.RBConfig;

/**
 * <p>
 *  Application class for Glasnost Information Server.
 * </p>
 *
 * <p>
 * 	Created May 30, 2011
 * </p>
 *
 * @author Oliver Tigges
 */
public class BroukerWebApplication extends RBApplication {
	
	private final Logger logger = LoggerFactory.getLogger(BroukerWebApplication.class);
	
	// -----------------------------------------------------

    public static BroukerWebApplication get() {
        return (BroukerWebApplication) Application.get();
    }

    // ----------------------------------------------------
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Class<? extends Page> getHomePage() {
		return WelcomePage.class;
	}

    @Override
    public Class<? extends Page> getLoginPage() {
        return LoginPage.class;
    }

    // ----------------------------------------------------
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void init() {
        super.init();

        getRequestCycleListeners().add(new BroukerRequestCycleListener());

        getApplicationSettings().setPageExpiredErrorPage(ExpiredErrorPage.class);
        getApplicationSettings().setAccessDeniedPage(DefaultErrorPage.class);
        getApplicationSettings().setInternalErrorPage(DefaultErrorPage.class);
        
        // Front end Area
        mountPage("welcome", WelcomePage.class);
        mountPage("profile", getUserProfilePage());
        mountPage("perspective", getPerspectivePage());
        mountPage("entity", EntityDetailPage.class);
        mountPage("browse", getBrowseAndSearchPage());
        mountPage("treeview", HierarchyInfoVisPage.class);
        mountPage("periphery", PeripheryViewPage.class);
        mountPage("flowchart", FlowChartInfoVisPage.class);
        
        // Admin Area
        mountPage("admin-area", AdminBasePage.class);
        mountPage("type-system", TypeSystemPage.class);
        mountPage("redesigned-type-system", TypeSystemPage.class);
        mountPage("info-management", InformationManagementPage.class);
        mountPage("identity-management", IdentityManagementPage.class);
        
        // Special pages
        mountPage("login", LoginPage.class);
        mountPage("logout", LogoutPage.class);
    }
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onDestroy() {
		super.onDestroy();
		
		logger.info("Application is beeing destroyed. Free all resources.");
		
		final WebApplicationContext wac = 
			WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		
		final RBConfig rbc = (RBConfig) wac.getBean("rbConfig");
		rbc.getArastrejuConfiguration().close();
	}

}
