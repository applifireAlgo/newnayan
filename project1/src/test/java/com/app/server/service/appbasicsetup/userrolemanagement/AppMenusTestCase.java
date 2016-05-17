package com.app.server.service.appbasicsetup.userrolemanagement;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.appbasicsetup.userrolemanagement.AppMenusRepository;
import com.app.shared.appbasicsetup.userrolemanagement.AppMenus;
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
public class AppMenusTestCase extends EntityTestCriteria {

    @Autowired
    private AppMenusRepository<AppMenus> appmenusRepository;

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

    private AppMenus createAppMenus(Boolean isSave) throws Exception {
        AppMenus appmenus = new AppMenus();
        appmenus.setAutoSave(true);
        appmenus.setMenuHead(true);
        appmenus.setMenuCommands("4kxOzA6MbAgV9YjNU4dQzbpVywVYtAWrw1ulXhBhkAd2tVKNDg");
        appmenus.setAppId("XTaBpmLUo35pur6PPQJsY81JBmOPrxzsRXMUU696KZhfSiCIpk");
        appmenus.setMenuTreeId("hNPnQXT3VSQ5004kutzeFgN5WKcJSOSWCziFXohRIhP1Y2lItR");
        appmenus.setAppType(1);
        appmenus.setRefObjectId("OsovfEXzWFAZDKDsENaOUbVlxqVXLwc4Z0hFYWyc1t5OdANpP0");
        appmenus.setMenuAccessRights(5);
        appmenus.setMenuLabel("hGVtetyXA3krVrkreQ44YWLfc8RhblZjzWpYF6IWOdLJiwJzJN");
        appmenus.setUiType("ySn");
        appmenus.setMenuIcon("aGxqHOat3XXg5jDgXNnUTh3QOKk0KF6Ob8ygGgbm8GfSWDIryD");
        appmenus.setMenuDisplay(true);
        appmenus.setMenuAction("xmFL6ShL27effdOBShKcqa1mwObgRwekSk82QJMtlXg6oC4i5u");
        appmenus.setEntityValidator(entityValidator);
        return appmenus;
    }

    @Test
    public void test1Save() {
        try {
            AppMenus appmenus = createAppMenus(true);
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            appmenus.isValid();
            appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            AppMenus appmenus = appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
            appmenus.setMenuCommands("HthI3WpYht3fAXbiYiLszKpVCbOP4nwY0Be9TWXofSrWVwJbo4");
            appmenus.setAppId("GLXAMiAEhFAanaT9FzQS6bHwLrXN9iPxOj2yzasqH3RBwEM1tE");
            appmenus.setMenuTreeId("U9SfRda2QKBk3QvpHlVtQUgOJONKpGDex7OspYbcJFRnVC8ZTf");
            appmenus.setAppType(2);
            appmenus.setRefObjectId("bhimm0DaOdK6vnWZaDXRMYARtzCFcuRTwNctLzalDvJI9AXOSI");
            appmenus.setMenuAccessRights(2);
            appmenus.setMenuLabel("sqB47ctUWcv3sLXElbegNhUDy3ryynPX96lFIMiQtI5Q910xOk");
            appmenus.setVersionId(1);
            appmenus.setUiType("j32");
            appmenus.setMenuIcon("8aT7vzojXFpujftjfuKbQVeDkRm10d2qImjsbvml8aguMTVlx2");
            appmenus.setMenuAction("GSTuMHWHVv1Bje57dTWOfYfFoYBGwwNUY1rKMupXGfQhuH1OB0");
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            appmenusRepository.update(appmenus);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.delete((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateAppMenus(EntityTestCriteria contraints, AppMenus appmenus) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            appmenus.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            appmenusRepository.save(appmenus);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "menuTreeId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "menuTreeId", "bZOIKPUEBr90Z69pTi7gtzyJxUh8dsGNjwbWjC2xXUJMhNp8gxukQ1fcv6yKVf5oGHbX0eKv1tE7xCjfxxLAuCZAxJJK3GMyLFD0WAGWQDO5DHflZuBFBWpD45UvgnlNO5IaVZJ039iFO0HgThvDmXBXpsdgswucBI4eAX1mRrP1lCYNAbdPfuJCKUsyR4LtAyh7qQcYjEUH290A8mCVA41zuol2vrTvVJLEahZfXr6qUNn34aFPuH00S3uBE2Qg5"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "menuIcon", "mDWrs8PYKrtc73uPAN2tXdzxKZa0mfMUWfjVd5qOLhvA8KH99mp4DPKQLlHX6axxFzwtrHIH5zbNQBAncRDYV4Utca5OxzR3RubRlIQ3F1qiBvFHzprHKed7bkGjKXEVJdhHhAu2bpH5pWANSuWvIDpzb0Tw1wKpOnEAN6t1F7l05YJ1Ah3n3OMyNtC7S8pwh43aU2t8y1xa4Va5sE2fgeoBgHeCBLDYyHpIycMEbjQgs1fwS47ZWK86W90SE6enf"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "menuAction", "dxhXj7eeXbMfNKY5BXf3SEi5YHvZxOR7GS5sRuhaQ8jK1HeoFzt3S9SdPW9wSCHDhJMEgEeUrML2Tox8ci1vOE52fKm2OPBNtFfN9G7Wlziv2Gi4TCBTA1MME4cBnlVD7NqD2aRh50Hr47MlXemTRJBgKLI3zLoFX4Jlzjr9dhkQy4H2PVG0BjDPWwkz8BF9JX4dw67ExnthYb4O9UjPMXYjKK3hLV4lc75wxX0u76UdeTKhFhoArveQUMw3pLnmI"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "menuCommands", "xijDkYV74lsUqUbSRODlh1pSi6PrSrhDEexx10fLYFMmMveYm5DmLdL1YvHlKEIH2"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "menuDisplay", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "menuDisplay", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 8, "menuHead", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "menuHead", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 10, "menuLabel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "menuLabel", "nhJw8zhpvUJfzn17GS9Brt2hqJZy8TCsZ4PQCsewjhC1nzpHZUXVxv6DNcrmec6cOfFUPUAuMvzOGzsoZSRWUdRZkQCWytVxQzpovZDUcQ3WLEukWFlvBSg2D7nE1sOjW96bVVSp2M7ZXxlOxDdqAl6endb3dUePYB2KV2UTkmibVV5mDgX8QuXgkBu5vMWWcYf5qgAatZClefgAOPk1XnWGhECZKiXLwiEVtKOFIVRMID03aFsCm9etO8TRqWDPi"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "uiType", "7DAU"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 13, "refObjectId", "lF4VG7YhmTFk4xHRjrwpYxbu7YLI6ZyANMmGvjkLb1dD2YdeNisL0BWVG4UTmiwAglHGA2zVgzpBsBMAcAs3sUSucntNdsUhDrqJfZpjvuaRe8AjBrszdn6cVa90f8j4vzDtnGBsXE8tKT9fOwsudAqsJeLgjgz7L4Jq9Ad1Zm0yBLBnGe9ht9Pd1D67h4GRxkhuLcxbcmDMlLWQBRFEm4vnSYmEhQ6wVrm5nuxnexmMYY44rQ44KMu3WvSpGiDwI"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 14, "menuAccessRights", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 15, "menuAccessRights", 14));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 16, "appType", 4));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 17, "appId", "0bigyD8zaITgYf3YozfZWE2V5Omb1m5htFn1Kj2eUEvti3hMhW6nHtoyj9BUq5dWaHcky3yQxBAZt2fHGQjNJDAkE56ZSD5QFOtzjP9Zke9NF9Yw2PuhEis0fd6LG4nVLHAFER9Nq08fYU4ECv0s4yYmw6bE18uvzfa6hfx1J0rNTMBdzlPB2lBy3nmUOifEYP1OH1tW8F65MdcR7rbXmyadr8IMK6hC47b81T3qwH3O9IzfOhYd0Qpqj3wpF5RPI"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 18, "autoSave", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 19, "autoSave", true));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                AppMenus appmenus = createAppMenus(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = appmenus.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 2:
                        appmenus.setMenuTreeId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 3:
                        appmenus.setMenuIcon(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 4:
                        appmenus.setMenuAction(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 5:
                        appmenus.setMenuCommands(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 6:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 7:
                        break;
                    case 8:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 9:
                        break;
                    case 10:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 11:
                        appmenus.setMenuLabel(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 12:
                        appmenus.setUiType(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 13:
                        appmenus.setRefObjectId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 14:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 15:
                        appmenus.setMenuAccessRights(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 16:
                        appmenus.setAppType(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 17:
                        appmenus.setAppId(contraints.getNegativeValue().toString());
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 18:
                        field.setAccessible(true);
                        field.set(appmenus, null);
                        validateAppMenus(contraints, appmenus);
                        failureCount++;
                        break;
                    case 19:
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
