package com.app.server.service.salesboundedcontext.sales;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.salesboundedcontext.sales.RetailerRepository;
import com.app.shared.salesboundedcontext.sales.Retailer;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import java.util.List;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import com.app.shared.salesboundedcontext.sales.Distributor;
import com.app.server.repository.salesboundedcontext.sales.DistributorRepository;
import com.app.shared.salesboundedcontext.sales.SalesRegion;
import com.app.server.repository.salesboundedcontext.sales.SalesRegionRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class RetailerTestCase extends EntityTestCriteria {

    @Autowired
    private RetailerRepository<Retailer> retailerRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    private static List<EntityTestCriteria> entityContraint;

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo(1, "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
        entityContraint = addingListOfFieldForNegativeTesting();
    }

    private Retailer createRetailer(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        Distributor distributor = new Distributor();
        distributor.setLongitude(2100.0d);
        SalesRegion salesregion = new SalesRegion();
        salesregion.setRegionname("v7R1auzBsTKhUNQohx3MA5RsCasKtGHxqhoX5rnVT4KaaiWYBc");
        SalesRegion SalesRegionTest = new SalesRegion();
        if (isSave) {
            SalesRegionTest = salesregionRepository.save(salesregion);
        }
        map.put("SalesRegionPrimaryKey", salesregion._getPrimarykey());
        distributor.setLongitude(5800.0d);
        distributor.setRegioncode((java.lang.String) SalesRegionTest._getPrimarykey()); /* ******Adding refrenced table data */
        distributor.setLattitude(7800.0d);
        distributor.setDistributorname("axakmF4lkk30SlTMsaJXkZtDdtCunpmTFAjsmK3Px0Q8li1BzT");
        Distributor DistributorTest = new Distributor();
        if (isSave) {
            DistributorTest = distributorRepository.save(distributor);
        }
        map.put("DistributorPrimaryKey", distributor._getPrimarykey());
        Retailer retailer = new Retailer();
        retailer.setRetailername("UcgAyp5BNCHLv9qUQyuVQz5jzkGKKd0JmECsoFAtLfXkKlZGsj");
        retailer.setDistributorcode((java.lang.String) DistributorTest._getPrimarykey());
        retailer.setEntityValidator(entityValidator);
        return retailer;
    }

    @Test
    public void test1Save() {
        try {
            Retailer retailer = createRetailer(true);
            retailer.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            retailer.isValid();
            retailerRepository.save(retailer);
            map.put("RetailerPrimaryKey", retailer._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private DistributorRepository<Distributor> distributorRepository;

    @Autowired
    private SalesRegionRepository<SalesRegion> salesregionRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("RetailerPrimaryKey"));
            Retailer retailer = retailerRepository.findById((java.lang.String) map.get("RetailerPrimaryKey"));
            retailer.setRetailername("PaHWtDt6OUqL9rZYVrwFU3pL7jXORgRb8fRdjljwKBMNjq45yK");
            retailer.setVersionId(1);
            retailer.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            retailerRepository.update(retailer);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("RetailerPrimaryKey"));
            retailerRepository.findById((java.lang.String) map.get("RetailerPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBydistributorcode() {
        try {
            java.util.List<Retailer> listofdistributorcode = retailerRepository.findByDistributorcode((java.lang.String) map.get("DistributorPrimaryKey"));
            if (listofdistributorcode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("RetailerPrimaryKey"));
            retailerRepository.delete((java.lang.String) map.get("RetailerPrimaryKey")); /* Deleting refrenced data */
            distributorRepository.delete((java.lang.String) map.get("DistributorPrimaryKey")); /* Deleting refrenced data */
            salesregionRepository.delete((java.lang.String) map.get("SalesRegionPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateRetailer(EntityTestCriteria contraints, Retailer retailer) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            retailer.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            retailer.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            retailer.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            retailerRepository.save(retailer);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "retailername", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "retailername", "cbRr9nMc64ZvaFM75yD91mulUiCSIbCCLLGLDnVhn2vaY5rKGMkVeqRXHEenFql4zbwoZ5VzYYRjsaMbPJMoOi1h69sVjoj7SLuCUVP1pyaJIzohVJMay372DQYV04Bx7lkCIb2nRbcS2M5o9qxC19m1IHakaCPHuk0wGRosMz1U4GpJhvlypZwmK058nDQUHy3fWatZGeLsdJot4Q2OaKcKv5iz3y3qZ4HkMaCheMAk1S4Vufm14XuUgUdBmrmnP"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Retailer retailer = createRetailer(false);
                java.lang.reflect.Field field = retailer.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(retailer, null);
                        validateRetailer(contraints, retailer);
                        failureCount++;
                        break;
                    case 2:
                        retailer.setRetailername(contraints.getNegativeValue().toString());
                        validateRetailer(contraints, retailer);
                        failureCount++;
                        break;
                }
            } catch (SpartanIncorrectDataException e) {
                e.printStackTrace();
            } catch (SpartanConstraintViolationException e) {
                e.printStackTrace();
            } catch (SpartanPersistenceException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (failureCount > 0) {
            org.junit.Assert.fail();
        }
    }
}
