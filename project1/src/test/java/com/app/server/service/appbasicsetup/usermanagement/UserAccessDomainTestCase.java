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
import com.app.server.repository.appbasicsetup.usermanagement.UserAccessDomainRepository;
import com.app.shared.appbasicsetup.usermanagement.UserAccessDomain;
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
public class UserAccessDomainTestCase extends EntityTestCriteria {

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

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

    private UserAccessDomain createUserAccessDomain(Boolean isSave) throws Exception {
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainIcon("kzmFCCogeS4SfRToi1ISZT0ENaWpGcwSDiXPe1vQXyeZ0W3ZvR");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainHelp("fdJBTdqp5W3KUxuGX95XTQXSgChBr6LpxgNDNtjuhjS2HixpM8");
        useraccessdomain.setDomainName("k49kcE4DIDEGvT95kf9ngWCJ6ebXUiWQml2UzFogaP3Bggliho");
        useraccessdomain.setDomainDescription("nEr7ZEBDzh1nv8mEVkdUH3KKlQRoEeNrE9DzX1SS1YnGhfq3iM");
        useraccessdomain.setEntityValidator(entityValidator);
        return useraccessdomain;
    }

    @Test
    public void test1Save() {
        try {
            UserAccessDomain useraccessdomain = createUserAccessDomain(true);
            useraccessdomain.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            useraccessdomain.isValid();
            useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            UserAccessDomain useraccessdomain = useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
            useraccessdomain.setDomainIcon("2rlxOd7N39K1jY3023ezIE9irE3OAiwfxjF2z026hsKchqP0dR");
            useraccessdomain.setUserAccessDomain(47950);
            useraccessdomain.setDomainHelp("UTTUe7ZJFu77LtGRR1z7uvKDEDXexjwLx60GPbSNi2w4kWrk5j");
            useraccessdomain.setDomainName("bf0EVudrbyYdhISghp7bmBN6lNlitgZdsCQuK8khQXrtfi7U2I");
            useraccessdomain.setDomainDescription("FGL4qva6t4idYGm4LHeFxttEDFdD7vN9EKwrBIKNA4P3C235PS");
            useraccessdomain.setVersionId(1);
            useraccessdomain.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            useraccessdomainRepository.update(useraccessdomain);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserAccessDomain(EntityTestCriteria contraints, UserAccessDomain useraccessdomain) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            useraccessdomainRepository.save(useraccessdomain);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "userAccessDomain", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessDomain", 174047));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "domainName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "domainName", "bRlEvp3qRkucW8jt7HG2e4fKo5M2YUZ83zvPIXWLPfN0zKorX3meKVGoFTL7SYG4bNBDi7tDCqAHNPP5mU4M7lm2xVLErGlsf5HhSM0v2OxoL7f9cRzz0y2gmEyiM42OkLFitSiL0Vgul4UIksEyLMPkpcCz0PnP1QRiadzMI9l8fP1Uv5bS62GnV9HG9Gr66mO2ViMSucSt97GhpAIKAxktCC9Wdhxkt9XAor1Pjz7d5FsoyDdQOHwSax0cDNZ40"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "domainDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "domainDescription", "8AYSOpHvQMFxPj6b5XnCtf7Z4GbsrXyydSkSZcGfVVAIYwZYKTmnWEAcyN8QFUr8HUbKe1rKJmZOtW806DaWvd42ZTFY8vHIA6yotS2mQZLYyaJPG8INfVqT1m3QJVIuyHkrY0dJyi9V26r5A6eOwuAPkbn7oi7QD9ysPMcfOyEjgCyDp7FAybSlVE1W6dSljyRKcLpf83MTR8PDpNCQa8lbWa1BOG1ApsahTyRqE6TwvgBmSEWSJSd5vd8WgEu5x"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "domainHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "domainIcon", "M7IKueVXKO7ivkIBmDI3i2zYTjcOpTyn4lOI0BDQZHeYR11gTQwJmyOVu5x7MHYwihbr3qwmx46arowm2zRpYWIIsrZpXCFbJoignRpzwiWs9k5NduvoQjXRaEZ9NgW4Yhl4QmKD33QzHxE1zkp9N3iUSgpqqB7eVg6msvRyBPHxXtCTJO7lWEaDvuZjGtcPBinGokpcIRC7h1ELhOxF1wuUOp4X5GDjfyhVLiq7heoHxkV86nPU2g1rUT1NNRjqC"));
        entityContraints.add(new EntityTestCriteria(UNIQUE, 9, "CombineUniqueKey", ""));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        UserAccessDomain useraccessdomainUnique = useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                UserAccessDomain useraccessdomain = createUserAccessDomain(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = useraccessdomain.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 2:
                        useraccessdomain.setUserAccessDomain(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 4:
                        useraccessdomain.setDomainName(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 6:
                        useraccessdomain.setDomainDescription(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 7:
                        useraccessdomain.setDomainHelp(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 8:
                        useraccessdomain.setDomainIcon(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 9:
                        useraccessdomain.setUserAccessDomain(useraccessdomainUnique.getUserAccessDomain());
                        validateUserAccessDomain(contraints, useraccessdomain);
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
