package com.app.server.service.sampleboundedcontext.sampledomain;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.sampleboundedcontext.sampledomain.TestEntRepository;
import com.app.shared.sampleboundedcontext.sampledomain.TestEnt;
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
public class TestEntTestCase extends EntityTestCriteria {

    @Autowired
    private TestEntRepository<TestEnt> testentRepository;

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

    private TestEnt createTestEnt(Boolean isSave) throws Exception {
        TestEnt testent = new TestEnt();
        testent.setTestName("GL7bsl2lU3BLVPz1BxdBGD9zqaLzLZdTcPkkPNgcsJ2PNZ5sQx");
        testent.setDuration(2147483647);
        testent.setEntityValidator(entityValidator);
        return testent;
    }

    @Test
    public void test1Save() {
        try {
            TestEnt testent = createTestEnt(true);
            testent.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            testent.isValid();
            testentRepository.save(testent);
            map.put("TestEntPrimaryKey", testent._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestEntPrimaryKey"));
            TestEnt testent = testentRepository.findById((java.lang.String) map.get("TestEntPrimaryKey"));
            testent.setTestName("gOqdkJHEBsWxpScUXXk61fQz7Wr2x0402KVYPMmWxb22XCSaB1");
            testent.setDuration(2147483647);
            testent.setVersionId(1);
            testent.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            testentRepository.update(testent);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestEntPrimaryKey"));
            testentRepository.findById((java.lang.String) map.get("TestEntPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestEntPrimaryKey"));
            testentRepository.delete((java.lang.String) map.get("TestEntPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateTestEnt(EntityTestCriteria contraints, TestEnt testent) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            testent.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            testent.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            testent.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            testentRepository.save(testent);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "testName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "testName", "id9RzCCjoyk90HBm90UX4Yxmz9JuJyOo9CpmTF5PQsILhFeMOYITjnf0jtIyeNXopokqhKhKiaspoabsdEzCk6YlDauIWkJYKBbDi1mZ8wKoBH0jztYYoySGfmLJEouw14dxMZwmESHqICR49jJmARVLpd0AuqyOpXju2U1HXYluGq2LmHVdnPruGYbRqJMXNb1dHMjPdZU7COSqfpJUlDqKQToBFsgPfjGtt2wwIh3z9Il15DB3KutsxX6X18K2P"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "duration", null));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                TestEnt testent = createTestEnt(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = testent.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(testent, null);
                        validateTestEnt(contraints, testent);
                        failureCount++;
                        break;
                    case 2:
                        testent.setTestName(contraints.getNegativeValue().toString());
                        validateTestEnt(contraints, testent);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(testent, null);
                        validateTestEnt(contraints, testent);
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
