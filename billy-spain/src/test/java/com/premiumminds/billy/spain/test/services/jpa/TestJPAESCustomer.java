/**
 * Copyright (C) 2017 Premium Minds.
 *
 * This file is part of billy spain (ES Pack).
 *
 * billy spain (ES Pack) is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 *
 * billy spain (ES Pack) is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with billy spain (ES Pack). If not, see <http://www.gnu.org/licenses/>.
 */
package com.premiumminds.billy.spain.test.services.jpa;

import org.junit.Before;
import org.junit.Test;

import com.premiumminds.billy.core.persistence.dao.TransactionWrapper;
import com.premiumminds.billy.spain.persistence.dao.DAOESCustomer;
import com.premiumminds.billy.spain.persistence.dao.DAOESInvoice;
import com.premiumminds.billy.spain.persistence.entities.ESCustomerEntity;
import com.premiumminds.billy.spain.test.ESAbstractTest;
import com.premiumminds.billy.spain.test.util.ESCustomerTestUtil;

public class TestJPAESCustomer extends ESJPAAbstractTest {

    private TransactionWrapper<Void> transaction;

    @Before
    public void setUp() {
        this.transaction = new TransactionWrapper<Void>(ESAbstractTest.injector.getInstance(DAOESInvoice.class)) {

            @Override
            public Void runTransaction() throws Exception {
                final ESCustomerTestUtil customer = new ESCustomerTestUtil(ESAbstractTest.injector);
                DAOESCustomer daoESCustomer = ESAbstractTest.injector.getInstance(DAOESCustomer.class);

                ESCustomerEntity newCustomer = customer.getCustomerEntity();

                daoESCustomer.create(newCustomer);

                return null;
            }

        };
    }

    @Test
    public void testSimpleCustomerCreate() throws Exception {
        ESJPAAbstractTest.execute(ESAbstractTest.injector, this.transaction);
    }

}
