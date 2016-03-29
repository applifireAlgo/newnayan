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
import com.app.server.repository.defaultcontext.defaultdomain.ChildRepository;
import com.app.shared.defaultcontext.defaultdomain.Child;
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
public class ChildTestCase extends EntityTestCriteria {

    @Autowired
    private ChildRepository<Child> childRepository;

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

    private Child createChild(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        Child child = new Child();
        child.setcNo(2147483647);
        child.setcName("0EeyMUIANCL5MSMmVxe3K4fwMjQk6wS6IZEIdCrx0sZHojNVcL");
        child.setEntityValidator(entityValidator);
        return child;
    }

    @Test
    public void test1Save() {
        try {
            Child child = createChild(true);
            child.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            child.isValid();
            childRepository.save(child);
            map.put("ChildPrimaryKey", child._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("ChildPrimaryKey"));
            Child child = childRepository.findById((java.lang.String) map.get("ChildPrimaryKey"));
            child.setcNo(2147483647);
            child.setcName("XAu4olpbb6AibAx9Xm9dYnET3mgbLd6yHo2Be2STU4SS3OnMW3");
            child.setVersionId(1);
            child.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            childRepository.update(child);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("ChildPrimaryKey"));
            childRepository.findById((java.lang.String) map.get("ChildPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("ChildPrimaryKey"));
            childRepository.delete((java.lang.String) map.get("ChildPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateChild(EntityTestCriteria contraints, Child child) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            child.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            child.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            child.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            childRepository.save(child);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "cName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "cName", "mnxFatoSfISmF0qZbf5lecY8IbUoGDYgyC6XxAEqKx3LMaTes6mawANZeOdUdDTYDyiRgyxm7Jx1039rIFLFP59Zg8fV6iYouTBtxtiDIcfIqNO0dwyU0OZkOfPLio8VLWvzzFwYoc7mBfQOiKzNpwdFVCfjTOsdt1VnXNBYnu4tBo7shI5u34d4Hf453lqnoyntEQQ8KoCprStBgAM1iwvsWA9Hfh5Tc6JGDi8jS0gqTxdOrIC6CyORky0FrrInG"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "cNo", null));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Child child = createChild(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = child.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(child, null);
                        validateChild(contraints, child);
                        failureCount++;
                        break;
                    case 2:
                        child.setcName(contraints.getNegativeValue().toString());
                        validateChild(contraints, child);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(child, null);
                        validateChild(contraints, child);
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
