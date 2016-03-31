package com.app.server.service.defaultcontext.defaultdomain;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.defaultcontext.defaultdomain.TestDateRepository;
import com.app.shared.defaultcontext.defaultdomain.TestDate;
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
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class TestDateTestCase extends EntityTestCriteria {

    @Autowired
    private TestDateRepository<TestDate> testdateRepository;

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

    private TestDate createTestDate(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        TestDate testdate = new TestDate();
        testdate.setTday("UghZSl0I74yH44dORkihp82IpxFhac2aipCRJAlwo1Mys1aG4t");
        testdate.setToday(new java.sql.Timestamp(1459232548439l));
        testdate.setIsHoliday(true);
        testdate.setEntityValidator(entityValidator);
        return testdate;
    }

    @Test
    public void test1Save() {
        try {
            TestDate testdate = createTestDate(true);
            testdate.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            testdate.isValid();
            testdateRepository.save(testdate);
            map.put("TestDatePrimaryKey", testdate._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestDatePrimaryKey"));
            TestDate testdate = testdateRepository.findById((java.lang.String) map.get("TestDatePrimaryKey"));
            testdate.setVersionId(1);
            testdate.setTday("VS6n8BHw4Pq3gNVU9kfLd8FZsiBDOjrvDxl440Cq02zm0wFtAT");
            testdate.setToday(new java.sql.Timestamp(1459232548465l));
            testdate.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            testdateRepository.update(testdate);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestDatePrimaryKey"));
            testdateRepository.findById((java.lang.String) map.get("TestDatePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestDatePrimaryKey"));
            testdateRepository.delete((java.lang.String) map.get("TestDatePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateTestDate(EntityTestCriteria contraints, TestDate testdate) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            testdate.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            testdate.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            testdate.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            testdateRepository.save(testdate);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "today", null));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 2, "tday", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "tday", "N92di7YIHJPDQIybFGnpHqoMMGWvVyM9nWl8q5ZYhRpNFWkWLEpZisbNDyxUsvPO6RIPdc9yIjGfvPcEPBdbUTCqqNdVUKqMftzlNT8rTk9LwKaReXCnBcfuTtN3lVwOpbcEVIAorKAAOkHulIXP7VN7OoBCbjn7WIDwjUJGKLFkzL8gkbFUUtDmJzJzzgApYZCIypAuC4tE6mGCUiiY2i7ROp2ArXMgbBMFIdpBs9r31J9qiAt5yMuptlFldUuZ1"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "isHoliday", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "isHoliday", true));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                TestDate testdate = createTestDate(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = testdate.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(testdate, null);
                        validateTestDate(contraints, testdate);
                        failureCount++;
                        break;
                    case 2:
                        field.setAccessible(true);
                        field.set(testdate, null);
                        validateTestDate(contraints, testdate);
                        failureCount++;
                        break;
                    case 3:
                        testdate.setTday(contraints.getNegativeValue().toString());
                        validateTestDate(contraints, testdate);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(testdate, null);
                        validateTestDate(contraints, testdate);
                        failureCount++;
                        break;
                    case 5:
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
