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
import com.app.server.repository.defaultcontext.defaultdomain.ParentRepository;
import com.app.shared.defaultcontext.defaultdomain.Parent;
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
public class ParentTestCase extends EntityTestCriteria {

    @Autowired
    private ParentRepository<Parent> parentRepository;

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

    private Parent createParent(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        Parent parent = new Parent();
        parent.setpNo(2147483647);
        parent.setpName("XCz4D2LYCBh2qmyoDHKETDRVQAb0UguEt0K1hT2UXvqPMYUNJG");
        parent.setEntityValidator(entityValidator);
        return parent;
    }

    @Test
    public void test1Save() {
        try {
            Parent parent = createParent(true);
            parent.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            parent.isValid();
            parentRepository.save(parent);
            map.put("ParentPrimaryKey", parent._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("ParentPrimaryKey"));
            Parent parent = parentRepository.findById((java.lang.String) map.get("ParentPrimaryKey"));
            parent.setpNo(2147483647);
            parent.setpName("KMGfTS4moERWiN2UJZaskGEvZnAyICZEs30mXT88uEFeSVtuKm");
            parent.setVersionId(1);
            parent.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            parentRepository.update(parent);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("ParentPrimaryKey"));
            parentRepository.findById((java.lang.String) map.get("ParentPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("ParentPrimaryKey"));
            parentRepository.delete((java.lang.String) map.get("ParentPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateParent(EntityTestCriteria contraints, Parent parent) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            parent.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            parent.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            parent.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            parentRepository.save(parent);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "pName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "pName", "hHV3gogj2iTdQ1sfoPfn5I1jA0omKu9cQqiTS3DBNXNXcIsvI9tpVzaGWNimux0Md8peqRXxlTZladdJosBPFZhGYb1BB443U5WvRNk7oEUBKhrfJlq9FFC4qKTdnv1bHwZbIoqSxaSIGqMppCsuMupj10etpNbmzYsbiGprM1TTieSZkLkL9tQIdPnM6cS9uFqzzyTedDAObaxDOc1zcEAAERLpgfss50bTbKbsqIxXYOPpnmRwyVdg1QEOIDt3W"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "pNo", null));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Parent parent = createParent(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = parent.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(parent, null);
                        validateParent(contraints, parent);
                        failureCount++;
                        break;
                    case 2:
                        parent.setpName(contraints.getNegativeValue().toString());
                        validateParent(contraints, parent);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(parent, null);
                        validateParent(contraints, parent);
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
