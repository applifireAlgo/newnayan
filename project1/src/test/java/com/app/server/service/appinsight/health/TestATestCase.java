package com.app.server.service.appinsight.health;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.appinsight.health.TestARepository;
import com.app.shared.appinsight.health.TestA;
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

    private TestA createTestA(Boolean isSave) throws Exception {
        TestA testa = new TestA();
        testa.setTestNo("X1AQ6nMbCxghZhIyUGKcUhPcokdVSY4XRSgIhzMVnGGraqc71e");
        testa.setTestNm("s6zc4VmOe2E0c4M4BqJCzr6QkjAGvGt5wZDumOg8CB0MNz8UIK");
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
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestAPrimaryKey"));
            TestA testa = testaRepository.findById((java.lang.String) map.get("TestAPrimaryKey"));
            testa.setVersionId(1);
            testa.setTestNo("GazzYv6kVyux7jetfF1sGMALnLdWCnFIhQWcSxZaLCU9gccz9g");
            testa.setTestNm("wtE4kMqCGXW99zieVgXFqHKLnd9EQPVynSHpV4GJVshaXDbkeA");
            testa.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            testaRepository.update(testa);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestAPrimaryKey"));
            testaRepository.findById((java.lang.String) map.get("TestAPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestAPrimaryKey"));
            testaRepository.delete((java.lang.String) map.get("TestAPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateTestA(EntityTestCriteria contraints, TestA testa) throws Exception {
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
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "testNm", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "testNm", "1yX4NPvXu7LqNVgkSn4IjiIp0zhUOAV2LXmRem314xVzlpCtn7xXGKeGVPS7LqH4sJsGOnGyu3GbGlN1yLBQxpX3hpjuXCkqN4ZyPLa3XM1jcChG85CsYBzjrzHAkYvWng7rFSvWgIPwZGTQBf9IDFDlkbYVAdSmYPeEHi7ZXfW91NrZjCxN5YHBFqdcbsPm3G2sQsueTZv9ojhzpWQw6U3GjBHrKUQyrCbcOQ6gxMXtXFsWNbyOTLBxPGqtZQ12B"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "testNo", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "testNo", "M5YEhVlUoFLyaKuqtA7N0Za7VdRZDoui02w0j8shwcyhAhYQr0Ybd2wYTvWDhVRBcKVVIDZAJqMKHfV0mKLAV7XL3cBYRtboceWjXP1evTufOxnVZDzkPSZ3OHdRBdDwIbC55m0DYsahVnhRsCYWh98pWtrEx51CMXq0YI8PuWNhWRlNJh1WHagz7IcsAtSwj7VyidBQhIHhqkZznxeG7F2KYxtlgSgUrdCVodZYBP4R2u2r7VvOUFmDEXtvCSY5J"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
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
                        testa.setTestNm(contraints.getNegativeValue().toString());
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
                        testa.setTestNo(contraints.getNegativeValue().toString());
                        validateTestA(contraints, testa);
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
