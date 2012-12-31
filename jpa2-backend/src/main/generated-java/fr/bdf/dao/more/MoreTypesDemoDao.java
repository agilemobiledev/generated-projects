/*
 * (c) Copyright 2005-2012 JAXIO, http://www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/main/java/project/dao/DAOImpl.e.vm.java
 */
package fr.bdf.dao.more;

import javax.inject.Named;
import javax.inject.Singleton;
import fr.bdf.dao.more.MoreTypesDemoDao;
import fr.bdf.dao.support.GenericDao;
import fr.bdf.domain.more.MoreTypesDemo;

/**
 * JPA 2 Data Access Object for {@link fr.bdf.domain.more.MoreTypesDemo}.
 * Note: do not use @Transactional in the DAO layer.
 */
@Named
@Singleton
public class MoreTypesDemoDao extends GenericDao<MoreTypesDemo, Integer> {
    public MoreTypesDemoDao() {
        super(MoreTypesDemo.class);
    }

}