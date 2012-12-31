/*
 * (c) Copyright 2005-2012 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-spring:src/main/java/util/PrimeFacesUtil.p.vm.java
 */
package com.jaxio.web.util;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.primefaces.context.RequestContext;

import com.jaxio.domain.Identifiable;

/**
 * Use this bean to execute JavaScript on client side.
 */
public class PrimeFacesUtil {
    /**
     * Controls the 'ask for save' primefaces dialog on the client side from the server side if the entity manager is dirty or the entity is new
     */
    static public boolean showAskForSaveDialog(EntityManager entityManager, Identifiable<?> entity) {
        RequestContext rc = RequestContext.getCurrentInstance();
        if ((entity != null && !entity.isIdSet()) || ((Session) entityManager.getDelegate()).isDirty()) {
            rc.execute("askForSaveDialog.show(); APP.focusAskForSaveDialog()");
            return true;
        }
        return false;
    }

    /**
     * Tells the client to update the search results region with the passed text.
     */
    static public void updateSearchResultsRegion(String text) {
        if (RequestContext.getCurrentInstance() != null) {
            RequestContext.getCurrentInstance().execute("APP.updateSearchResultsRegion(\"" + text + "\")");
        }
    }
}