package com.app.server.service.appbasicsetup.usermanagement;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.appbasicsetup.usermanagement.UserAccessLevelRepository;
import com.app.shared.appbasicsetup.usermanagement.UserAccessLevel;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import com.athena.server.pluggable.utils.helper.EntityValidatorHelper;
import com.app.server.service.RandomValueGenerator;
import java.util.HashMap;
import java.util.List;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.After;
import org.springframework.mock.web.MockServletContext;
import com.spartan.pluggable.logger.api.LogManagerFactory;
import com.athena.server.pluggable.utils.AppLoggerConstant;
import com.spartan.pluggable.logger.api.LogManager;
import com.spartan.pluggable.logger.event.RequestHeaderBean;
import com.spartan.pluggable.logger.api.RuntimeLogUserInfoBean;
import com.athena.server.pluggable.interfaces.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;

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

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        MockServletContext mockServletContext = new MockServletContext("file:src/main/webapp");
        try {
            String _path = mockServletContext.getRealPath("/WEB-INF/conf/");
            LogManagerFactory.createLogManager(_path, AppLoggerConstant.LOGGER_ID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
        runtimeLogInfoHelper.createRuntimeLogUserInfo("customer", "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
        entityContraint = addingListOfFieldForNegativeTesting();
        runtimeLogInfoHelper.setRequestHeaderBean(new RequestHeaderBean(new RuntimeLogUserInfoBean("AAAA", "AAAA", request.getRemoteHost(), 0, 0, 0), "", methodCallStack.getRequestId()));
    }

    private UserAccessLevel createUserAccessLevel(Boolean isSave) throws Exception {
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelName("saDalfZo8cwjbzzDSYldiltwbX6yKs2kyUVO3vYLjhcdNVtQJ9");
        useraccesslevel.setLevelHelp("gyFHnZww5xq4Y34yvaN3Payr6l69c3GyWIcwT8Ue5LdB4QJb9X");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelDescription("pqTIMPGha5FfCRnHXujCnbyWcOS3htBLSZjNu5jWalVmGRJ4AU");
        useraccesslevel.setLevelIcon("3hQFgc7Gfr9jb5lWRf768jccR5FonzxGYIx5l517o2MOCCk4hV");
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
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            UserAccessLevel useraccesslevel = useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
            useraccesslevel.setLevelName("U73y1Lz5gfvZFoDsLDkUAcbBX7pBFrcqIcuvZSJWcXWEFl0b8V");
            useraccesslevel.setVersionId(1);
            useraccesslevel.setLevelHelp("qTFGi7m5AUiJFtAzYkfhKdg2qSvpG4SvX4TaPediBxPiaPeCzb");
            useraccesslevel.setUserAccessLevel(59218);
            useraccesslevel.setLevelDescription("r2rr1RbNNro8QVLgwpQIvtS5uE0Ub1WF3CoVZ14BoxOWZEhjyP");
            useraccesslevel.setLevelIcon("rHyGkwzGhxh3F27UL31wIbHjoYes31xFFjG56AtSyXp6qKB8tu");
            useraccesslevel.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            useraccesslevelRepository.update(useraccesslevel);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            useraccesslevelRepository.findById((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessLevelPrimaryKey"));
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserAccessLevel(EntityTestCriteria contraints, UserAccessLevel useraccesslevel) throws Exception {
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessLevel", 123693));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "levelName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "levelName", "F05IsQZBUXfdBIxv1uoH3duGHSoUvwxPUG1YlM2U0H5ZCLTIZHhH7ANh4P0r9Ryws9Paa01bfIDt0x5Th7tYGdNg8qQc5XACcNPNkaFPlHfo7VdUVsKm9tXgT5UdrT3unltu9SlUCSLuFRLOVYvc0CwgAPd3rC0OeXK1ccbNPauZloxY0tm9GuIkPNDtAIqhaelq33L76cTdyr4HoRWuLKMwYagJuG3eSYebzdgJwZJ50qGrOj707nUAk1PJs5AOf"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "levelDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "levelDescription", "0f5yVBEZvflevu88DfjWHvGCELdkYslqDZNYwkWU9uVsRlQ7TZ7g2kyUoc9bgJJoFtYjpg4ljMKuApC1Di6KmZ7ej0ePkp4WiuQHq4K5aQUPnTmbFGeg3OvdH22Jc519R5Cawwlrt6FDjVq2gHXVrkE1UGoKnsK3j1DwTmyk0w8dpdBFoopud0vQ526SHkxFaylrtbp54lp3Rv4pGxJ5Z8PBWT8VipdBNasb2i1lk94bkVtvjXZvCfIa0wfBAKrYT"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "levelHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "levelIcon", "HUyJ5nnkZ6mGvMqBNn1vYTE0z1GoezJn0se38MGf0wdGzyHFCvyQ4pSCCM5XLE6ybzQ9QhbpFISspE1pKUAoh6gIOCimeCU4agJn4fFgiWs6sACFlkpoa6Zg6j84ptr8IzWZF5m2ikDH5XzuuGizyjBg48g7Tdr4B1KcFrGKIYsrfiZdf47geCCGmGr893oKvBKIPCvCVg8dDUYiAbc6HYoDDRhp02Qbb7MMsOxwN9smPdnPEgL5tS7fv4ZopzoTx"));
        entityContraints.add(new EntityTestCriteria(UNIQUE, 9, "CombineUniqueKey", ""));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (failureCount > 0) {
            org.junit.Assert.fail();
        }
    }
}
