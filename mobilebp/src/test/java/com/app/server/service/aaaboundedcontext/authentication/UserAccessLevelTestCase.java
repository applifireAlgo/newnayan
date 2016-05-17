package com.app.server.service.aaaboundedcontext.authentication;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.aaaboundedcontext.authentication.UserAccessLevelRepository;
import com.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
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
public class UserAccessLevelTestCase extends EntityTestCriteria {

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

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

    private UserAccessLevel createUserAccessLevel(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelHelp("KDkokbksELeCr6rI8fyE7MGzUTED4t2uyUl7NyZsLJxZQhOiwe");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelName("fNDjKQfqyXcCSXIhLHSnGojoKyW4FifLYaRt7XBskNxnoM9AER");
        useraccesslevel.setLevelDescription("21lAn1fIp3vA5GnyzUlMbMUUFpmfIMoYB21hQbwL79zpuSGefh");
        useraccesslevel.setLevelIcon("I1yNSmokkv9DLWf8pe4XJmbWBTmuPI3gbzp84upfgkrsEHnc7o");
        useraccesslevel.setEntityValidator(entityValidator);
        return useraccesslevel;
    }

    @Test
    public void test1Save() {
        try {
            UserAccessLevel useraccesslevel = createUserAccessLevel(true);
            useraccesslevel.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            useraccesslevel.isValid();
            useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            UserAccessLevel useraccesslevel = useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
            useraccesslevel.setLevelHelp("WOWRZzgo7zHMoQyHd3VhUp6HFbDWN2eLN1KgjGvFekspsHBjaz");
            useraccesslevel.setUserAccessLevel(60914);
            useraccesslevel.setLevelName("HdvmXDe9WNDrwZvhraQmZbJfMRxJ4aTheed9rYmO5EbXBHbnR3");
            useraccesslevel.setVersionId(1);
            useraccesslevel.setLevelDescription("ozXrUwD8euaaGOqmoIvDTFi8Q2CyImCWt8RZGcrN1Wjdcd58yf");
            useraccesslevel.setLevelIcon("WiTrH55aqopb0vTggRym3XcPg1APllY44KDPldD1LXSmP233je");
            useraccesslevel.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            useraccesslevelRepository.update(useraccesslevel);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserAccessLevel(EntityTestCriteria contraints, UserAccessLevel useraccesslevel) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            useraccesslevel.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            useraccesslevelRepository.save(useraccesslevel);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "userAccessLevel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessLevel", 117483));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "levelName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "levelName", "2lH6Ohg4e88lqJ64HiYi8BbtPae1Lx13lnX2TUEirG3Sw6M7LbOw22u4g39gDE5bg770FsHtSfaexHOEMReZ1zzoo0OX0CG8iZvXBcT9WdLq70FLTvJGqcHMfvlsuVmg0LiNrKLSBfxvSfIKDE5hYgW7NtkTSRM8UKyQzHdfgi1Z5YJz9XZccnmBNPqCYpvKywYzGzjKgTHoAFf9FnFwC8Qea69peCDZJz1yaJ5Q93Ozbmhs7mPJqjqePTNwkyNMu"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "levelDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "levelDescription", "Ckpx7c66XoP9eI1UdWTA5F7EXmWIWL14WtdggKOG7GSUDdVRSyNEJcdWLCpv9I7AepBHpfIXuKOUY3SbWA8nBHdQgOF8VuoSTUzkMZRGfjnlBCoLXbM0GbjGHM9pLhDLmZ9ZTe0KpSQDPNY1KmdMlre1PeVvv4Xmk9PwUJn5c7wfghhuwIKxIi56B85ZzXE3vQyubGDCiO1oF31VqbSvXn8AqU7Q1ZyRelXUoY1CIK3CHeJIfG5Ahbol159qFgkaL"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "levelHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "levelIcon", "oFnvOf5Rc8FDv9HJGPmetcJkPsUIjBbJ57k1CmkdZJidZnaYr1a6nITlCgIUDWrzX13iBasAnK0Uqt3rMnktbgL7UXmQhhALcVOGCeTQ2ejBLA5pQ986CQa0L6YcRgazUkXllrXPgglv7DP6N71DB4u7qCqZScOyECDyRBTsGtweyQfD190FYnxQNrmOro3UhB8IOWkXr54Vnqj5gsBoUsWj0f4biESFUOHZz7tubi63GK2nQQhuPYXyea3gQZqpm"));
        entityContraints.add(new EntityTestCriteria(UNIQUE, 9, "CombineUniqueKey", ""));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        UserAccessLevel useraccesslevelUnique = useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                UserAccessLevel useraccesslevel = createUserAccessLevel(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = useraccesslevel.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 2:
                        useraccesslevel.setUserAccessLevel(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 4:
                        useraccesslevel.setLevelName(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(useraccesslevel, null);
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 6:
                        useraccesslevel.setLevelDescription(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 7:
                        useraccesslevel.setLevelHelp(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 8:
                        useraccesslevel.setLevelIcon(contraints.getNegativeValue().toString());
                        validateUserAccessLevel(contraints, useraccesslevel);
                        failureCount++;
                        break;
                    case 9:
                        useraccesslevel.setUserAccessLevel(useraccesslevelUnique.getUserAccessLevel());
                        validateUserAccessLevel(contraints, useraccesslevel);
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
