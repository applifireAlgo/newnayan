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
import com.app.server.repository.defaultcontext.defaultdomain.TestERepository;
import com.app.shared.defaultcontext.defaultdomain.TestE;
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
public class TestETestCase extends EntityTestCriteria {

    @Autowired
    private TestERepository<TestE> testeRepository;

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

    private TestE createTestE(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        TestE teste = new TestE();
        teste.setTestNM("A4Gz7uEZ61Z0Ouc3l2bQEO4UvtB8yEbhMXm9xw0hNpaY3CanzN");
        teste.setTestNo(-1.72983168E9f);
        teste.setEntityValidator(entityValidator);
        return teste;
    }

    @Test
    public void test1Save() {
        try {
            TestE teste = createTestE(true);
            teste.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            teste.isValid();
            testeRepository.save(teste);
            map.put("TestEPrimaryKey", teste._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestEPrimaryKey"));
            TestE teste = testeRepository.findById((java.lang.String) map.get("TestEPrimaryKey"));
            teste.setTestNM("oFjRjyW15Hh0oJCtThERhH5BHjWc44CFJvjCR25sqkQ5lJMADJ");
            teste.setVersionId(1);
            teste.setTestNo(7.9226291E8f);
            teste.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            testeRepository.update(teste);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestEPrimaryKey"));
            testeRepository.findById((java.lang.String) map.get("TestEPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestEPrimaryKey"));
            testeRepository.delete((java.lang.String) map.get("TestEPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateTestE(EntityTestCriteria contraints, TestE teste) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            teste.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            teste.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            teste.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            testeRepository.save(teste);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "testNM", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "testNM", "gud5VvVYGzHn0aDYAX20Q0I3FtcI6OxVYRstFbZWrmNc4mHMtdCAM3ABchP6bhMMbsdc1Ps4MQGhEwl3rEgNuvjru7OHhZRzLSggrz2kVUM2IOsRNogOb4R6MeROI6ZMoSLIHzu8tLFoknJkihKLdaVElM6RzY62ZAq4oHrFFCW8BLHZK82OwVF71OL5erTnqmzOK1RgKCQoFgdnXLQ6y3VCDz101cyZX57J8RlWNIXUsmX8COpvokCQY0M4MXrAu"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "testNo", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "testNo", 3.5577833E9f));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                TestE teste = createTestE(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = teste.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(teste, null);
                        validateTestE(contraints, teste);
                        failureCount++;
                        break;
                    case 2:
                        teste.setTestNM(contraints.getNegativeValue().toString());
                        validateTestE(contraints, teste);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(teste, null);
                        validateTestE(contraints, teste);
                        failureCount++;
                        break;
                    case 4:
                        teste.setTestNo(Float.valueOf(contraints.getNegativeValue().toString()));
                        validateTestE(contraints, teste);
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
