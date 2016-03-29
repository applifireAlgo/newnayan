package com.app.server.service.aaaboundedcontext.authorization;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.aaaboundedcontext.authorization.RolesRepository;
import com.app.shared.aaaboundedcontext.authorization.Roles;
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
import com.app.shared.aaaboundedcontext.authorization.RoleMenuBridge;
import com.app.shared.aaaboundedcontext.authorization.AppMenus;
import com.app.server.repository.aaaboundedcontext.authorization.AppMenusRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class RolesTestCase extends EntityTestCriteria {

    @Autowired
    private RolesRepository<Roles> rolesRepository;

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

    private Roles createRoles(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        Roles roles = new Roles();
        roles.setRoleName("HNCpkk6toFagONjdLWymYGedzRKxLcHUvwBEyemfGz3axg1Yy9");
        roles.setRoleDescription("uNViWUlPyRMR2bUkeBDMN3l9voPdJiTMYUkWIFkc4nM3vBpnHR");
        roles.setRoleIcon("LrtztFcfnK45Jq0jkBd8FMW9I7im69SvPwCWHIpTsQRaTrKhSO");
        roles.setRoleHelp("pIq5c33FWm1PLiYxdKM59dCYXhFrelAs1n1N4PJq1xPcMzKNf5");
        java.util.List<RoleMenuBridge> listOfRoleMenuBridge = new java.util.ArrayList<RoleMenuBridge>();
        RoleMenuBridge rolemenubridge = new RoleMenuBridge();
        AppMenus appmenus = new AppMenus();
        appmenus.setRefObjectId("7aeyxi1ZvqZmKj9jzmIzHTAj2uK4lKcn3d2DKXAm1Qo7xC4U3X");
        appmenus.setMenuCommands("SBEyk5SOAUZhkmDgcjesjNScbLqOKyB5cgqO6JbrgAGXaiDZxI");
        appmenus.setMenuAccessRights(8);
        appmenus.setMenuIcon("xdtf9X7bnDFI5mwhpQsPbk7ViV7OYdXDsRqCqlJvI0WCI8qe8q");
        appmenus.setUiType("uNQ");
        appmenus.setAppId("dBi4GceumjMyLxUrOTQEuDmAFCR6DvzPeC3RQLaRz2jJTS4UEe");
        appmenus.setMenuLabel("tIbKIaxRdbumb8jDDzbTDNYYu3g25MBqp6kM6YtfmF5AOd7GZU");
        appmenus.setMenuTreeId("4MkZtmpBv5N00PSNyAdgS7T392gQjwojQzbK5UZgt63sI1dQVC");
        appmenus.setMenuDisplay(true);
        appmenus.setMenuAction("dXs1TWJQhaSrJ1yGbwx5eMWLZAdaCx4DMnhwaJEuBa0PdX36kq");
        appmenus.setMenuHead(true);
        appmenus.setAppType(1);
        appmenus.setAutoSave(true);
        AppMenus AppMenusTest = new AppMenus();
        if (isSave) {
            AppMenusTest = appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
        }
        rolemenubridge.setMenuId((java.lang.String) AppMenusTest._getPrimarykey());
        rolemenubridge.setIsWrite(true);
        rolemenubridge.setIsRead(true);
        rolemenubridge.setIsExecute(true);
        rolemenubridge.setRoles(roles);
        listOfRoleMenuBridge.add(rolemenubridge);
        roles.addAllRoleMenuBridge(listOfRoleMenuBridge);
        roles.setEntityValidator(entityValidator);
        return roles;
    }

    @Test
    public void test1Save() {
        try {
            Roles roles = createRoles(true);
            roles.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            roles.isValid();
            rolesRepository.save(roles);
            map.put("RolesPrimaryKey", roles._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AppMenusRepository<AppMenus> appmenusRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            Roles roles = rolesRepository.findById((java.lang.String) map.get("RolesPrimaryKey"));
            roles.setRoleName("05zVE6GRN8VI2Ry3lwhu6poescF914sSbpfsTqOuAXWURDv1Yn");
            roles.setRoleDescription("UFfc9DJ05jHlUMJVEk09eLC1uIu0jvl9BDlCmJPlCw122HVPjK");
            roles.setVersionId(1);
            roles.setRoleIcon("9V5uQijnGtXBYmNxpdR401ZlcQHjgXSw6prXEwuvYW5pziXKbM");
            roles.setRoleHelp("izy3wIP2UzVFDu20u5IVxmYORexXT4J9rOxnYRaNetYHdzOuhN");
            roles.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            rolesRepository.update(roles);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            rolesRepository.findById((java.lang.String) map.get("RolesPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            rolesRepository.delete((java.lang.String) map.get("RolesPrimaryKey")); /* Deleting refrenced data */
            appmenusRepository.delete((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateRoles(EntityTestCriteria contraints, Roles roles) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            roles.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            roles.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            roles.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            rolesRepository.save(roles);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "RoleName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "roleName", "ndjXEsILOXyrefhYqa4ZVO6FV9XWvXybbHlOK5tT6w3aR62ETkbPWqYX8bjLmwPlKXlAx5Y9c6H0xB1lBRasjgdjrPm8XjMqtqYeTUktwt5n3v3KYowoXoR82M5dCeRK4GzwwVxlCeqLxddCyt057vqDnevO8uIzf8bDRa30zc2Nd0ktO7yIeVozZOvHwBDtdMFcnB523BCYAx2J2RnyJ9SqGMgVRclYmo9pbO9bKytyQ9uu83WIKv2167GXMZUOK"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "RoleDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "roleDescription", "IEIUTKWJHae1r4iYpkSZ0jryJKM5EOKGfjQMZjT06OjBU1VqFkM8ZKHiD1mboikKiHWUuoY5dttBoHldDy8vhsMcYGvvzNS2stG6WRhXJeKmO7no7dxeg2z7YGxvnfAAwkThKXukEsvt8MX5vwO1IGXRJxtoNntJav9kiSNqLs9Qnkh0ZsWfS9nkPwQnmPkmeYeBPgWXcVyYXvcfBeEqzHszaHRWJCzqkEMC3XcKbRholXEmoWUqb6GGyeqetU7F1"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "roleIcon", "oTx17c5KbXofWlO1LgeyouBRnV86YQkSOHYjCZ8w9MlHhqygQs1DiYD3mUm5JYOlr"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "roleHelp", "SsQLwUfp4a6iADqKRYHy0W4m7LIvMR5BqiF8ypQlCvGtK5xc6XpcXixniG4wADkePv7TPTrl7ZPnZmoukp1wShnsuLy9neu0eTX0iBisJvqQZm7phFiYnuqwkVtpTem51pQffvCQcreN6ifuN1k7uLPXCdDEC4AUtMhJwLBmBayRqdCkm0ULQ80ygpP77jTrbf1cUWcrVt7Opqo26jOSz0hMvSq5RtxP1KTiz6mtLV9mG93rNHxqTnlKiB740naT5"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Roles roles = createRoles(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = roles.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(roles, null);
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 2:
                        roles.setRoleName(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(roles, null);
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 4:
                        roles.setRoleDescription(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 5:
                        roles.setRoleIcon(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
                        failureCount++;
                        break;
                    case 6:
                        roles.setRoleHelp(contraints.getNegativeValue().toString());
                        validateRoles(contraints, roles);
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
