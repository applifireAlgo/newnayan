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
import com.app.server.repository.defaultcontext.defaultdomain.TestARepository;
import com.app.shared.defaultcontext.defaultdomain.TestA;
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
public class TestATestCase extends EntityTestCriteria {

    @Autowired
    private TestARepository<TestA> testaRepository;

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

    private TestA createTestA(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        TestA testa = new TestA();
        testa.setFrndNm("9z2aXFuziIYG99GrBWNRUcDcHlZhkDW4EUCcZ4TrsFBwc4Zjux");
        testa.settNm("HGdQxiyEz3L8LKddy9DEOrYs1svszndRVENl5TCFIMODOtB8Tn");
        testa.setEntityValidator(entityValidator);
        return testa;
    }

    @Test
    public void test1Save() {
        try {
            TestA testa = createTestA(true);
            testa.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            testa.isValid();
            testaRepository.save(testa);
            map.put("TestAPrimaryKey", testa._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestAPrimaryKey"));
            TestA testa = testaRepository.findById((java.lang.String) map.get("TestAPrimaryKey"));
            testa.setFrndNm("Bzbmt7rFr7TcwE28ulMWcMwQsYFsSGnOOBM0dzIRCCmWRGNnmE");
            testa.setVersionId(1);
            testa.settNm("52DakpNq855sBbDcfddX1Yap1APHNNbXk2rUSR56hzzM9toUzn");
            testa.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            testaRepository.update(testa);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestAPrimaryKey"));
            testaRepository.findById((java.lang.String) map.get("TestAPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestAPrimaryKey"));
            testaRepository.delete((java.lang.String) map.get("TestAPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateTestA(EntityTestCriteria contraints, TestA testa) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            testa.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            testa.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            testa.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            testaRepository.save(testa);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "tNm", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "tNm", "ppnXnCVNyXj5nwStepMmvPwGKh2Klptt2WuOqc0z60SUw1Q6BfljMdndmACHyvJiseWyW3o9vu8I2RMXTHU67u47CnWcOjA6boqwZ3ba8lwT94VtaSAZV87mhDtowRw7BVKSRU67mxSABApJVUgWH7rxDluh0wdeDAbagzLFkZPi02kc2eN7J6CfFnK0UKdlx25tzgvBszDZdoEQMJGVDWDrLuye5VnXNr3bd3kf4h3GigJ8SnE4kJjWtxRfPZdLR"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "frndNm", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "frndNm", "Tjko7fOPYIIJ7hUAN2g5fCtzer36kgnsBoGDIwBcdH9lfG6QOTR9qZRDos72WoEhzvhY2DjmY28siKulYI57qzibUlqHf5hDbT5Nyc5j43BIvv5s41kqAiVpfEkBeCdKLRQpo9vLKN15Mt5551t0uwJ9shUUMThmqmFamIEDP7lbZkBJ6ACzeZMX1PXAnpoYbVqnp3rCRIuQKeBvYZX0F55KeiBVjo51NNXJJmnSBj6r03cdFMMULOk8EJT3RqmcI"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                TestA testa = createTestA(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = testa.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(testa, null);
                        validateTestA(contraints, testa);
                        failureCount++;
                        break;
                    case 2:
                        testa.settNm(contraints.getNegativeValue().toString());
                        validateTestA(contraints, testa);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(testa, null);
                        validateTestA(contraints, testa);
                        failureCount++;
                        break;
                    case 4:
                        testa.setFrndNm(contraints.getNegativeValue().toString());
                        validateTestA(contraints, testa);
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
