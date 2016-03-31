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
import com.app.server.repository.aaaboundedcontext.authorization.AppMenusRepository;
import com.app.shared.aaaboundedcontext.authorization.AppMenus;
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

    private AppMenus createAppMenus(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        AppMenus appmenus = new AppMenus();
        appmenus.setRefObjectId("iAzGBzSyrft5v5dMwJ803zIJULwooZCACWi9yv8PsDr4Bbv7Ku");
        appmenus.setMenuCommands("PkF7Ahx7qsb46gtesLIIDNCAERiilCoOR8MvZVgoUPFvbua3W7");
        appmenus.setMenuAccessRights(9);
        appmenus.setMenuIcon("bjhGt8eM4Ri1MkzvKAP1QSijCHpp6172h5MYXZR3O449TQxrQc");
        appmenus.setUiType("Ez9");
        appmenus.setAppId("N1x1oaY5NMzgAUo5pDJy2JTLGbI0Q64oD0eZC4j1Yf0JwP8NEr");
        appmenus.setMenuLabel("VdIfHOIXb0homQu6IO0NS7M3FGU24IILGkbMhn3JRjYhNKUSE3");
        appmenus.setMenuTreeId("rfGpGHhrMj9wzgKR63CGDcPEKv7kzEofOj5dvahlUGk0J1dH4c");
        appmenus.setMenuDisplay(true);
        appmenus.setMenuAction("xl9MRu4EkklNzQDZbYRjiBzNNDoQ210Nel9Evrf22I44vHdz1I");
        appmenus.setMenuHead(true);
        appmenus.setAppType(1);
        appmenus.setAutoSave(true);
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
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            AppMenus appmenus = appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
            appmenus.setRefObjectId("Clg21saCNMK0di16a3aQqNufYUHdnVEtvcRQbyKPyROeIrvYOi");
            appmenus.setMenuCommands("ZQkyI5KgADuB6dNp0Eqnf2qp2SYH092osXx1gk4sEqWiREq7m7");
            appmenus.setMenuAccessRights(2);
            appmenus.setMenuIcon("j57eLYCDmKukI9pcJEWn7D6elavpUmhPXIFNQezVG8GkoWWupl");
            appmenus.setUiType("5AH");
            appmenus.setAppId("I4l2BjlvHDZre6dtWwf3906ScrF38Wxfo2mYPKSeMFWyqeDrQ1");
            appmenus.setMenuLabel("AbncECCQ6Z2zf3YjsmqeyVU8V3c7zXvyuvUaA3HWu8P5MoiO4r");
            appmenus.setMenuTreeId("fXZJtAshiSHnIcQXFwudlWzc7kMrTSbx6mHArSCL6dRD6wp8Sg");
            appmenus.setMenuAction("vPrJYu2mqGklTKWA35dRdoQxDxqchp3niiApmTgKA9cx03w9BS");
            appmenus.setAppType(1);
            appmenus.setVersionId(1);
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            appmenusRepository.update(appmenus);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.delete((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateAppMenus(EntityTestCriteria contraints, AppMenus appmenus) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "menuTreeId", "RNMraSa7cDdH6hUmLqgsGz4qg8JZbjHZOgQzgyphngqDZU9zhu4wMXOltkANhkQ2ERfwDWgLgnP0tbHV4QHusWtBS5rVvLsPCFhlRXPXYUQfMGKCjpALkVWpdUm4bDEiboUQszobCW0XIJyOn4fmq6eX1ZkkVYotPZk0JUbCAm4xDkWjPzjIcX9anzk0B0OGvzlTrXHNRC4En7WBKMnq2HwztxDayWjL04NqEYTecxHZsqcOkRdPB1agezFZOiu0d"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "menuIcon", "QAMLw48sOLbpvPQ4Ai1FfTggsnmgWeJ5okcCFWl8dDdWYJL5J3Ryn1l7k6kIRSqElVpi1xsCCIZRt7eAvKxd9IY2rCuccfSdzFCPrVlxs3ODAxHgfmecWi1MHCZlpabhyOGSTT9fKvkdD3bejIiBhGBnyLuMQ76b7xQkWqGE6OfjzAsRRxQ6ilQQKDmnukYI7ETvTLiePlOcQSprQLCRDfuEgvi7UwvFx96LguVJsufOuLa7ho8APdjILicUWz6L1"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "menuAction", "Jgn51HWfO0XSdfGxkTldA5tv0VNcCcW7ztF22e3IICaLgWc8m7vlX8CiM3ApNvPKHYZ8dibkouLbh3Q0yeKJ2uFijZYVwJxfgXt4DZZIbn9eJeeuyDwJNx1RQ7W6GCkvhf3GD5XkKMt18B6prZzkW6zdgIslLsfAje9ejjEWUQ6McSURYIFvkf2hfWMl930M9DbMnZyhhUTDvpuQWWtOf7NoDWdw0TmgXF8J5MnA8MoBxIDts0rhB4729YRidQxrH"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "menuCommands", "rIyFo7xO4IxlLtxAAbnzWo30lm9WYdT4txvWwqLvz5lbirWO0RDrohhdIQqZAt89x"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "menuDisplay", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "menuDisplay", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 8, "menuHead", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "menuHead", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 10, "menuLabel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "menuLabel", "JJ8W5FCrRRhhYFdlL1vWjI0QLYN4vPz2sg9pULwQs6mR9V4NCFMCUw2oJra3rv5trCkE2ezv5Yqm5kSjaN8yqCaJeP0haA1WiO1BMeC0suAtOs0v5GX5E3I41JjdRPUnzQWHnvuUoUKzniyBt7EMI5tLQA8d0BFFOnwFiVRwiQU0PpHQEeDDZAAUByalZ64XyRfHfGWfDli7xRy6theEY7ScDxMPgIFSrMjbtc6a0KUz2F1RaqLfLplLHDEeis7ii"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "uiType", "x5cX"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 13, "refObjectId", "uaox3RUayNabCvo7fGbFB280Doq6Dlz87Qi704icMrmwq3WGBr3sy2MMJKAQGJ87Pmxiqh7tz961u4uczdnAWJnAnV3fMmDMmy0o5a5ymR7wDeyL2hmIh23bCdhnQAIcsjUmoDSWwWPuBExR7lJM4UvZk0f74hMOXL087akQpGmhkvYHk5JThBp1RWu7u8bRhU1Vqq8SIcTrhhNz5LtYifZOez73d30Y5322Wp71uwuG2idMXZItfOvu2BJhIMrLE"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 14, "menuAccessRights", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 15, "menuAccessRights", 16));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 16, "appType", 3));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 17, "appId", "rlN3w9sP2dSi2KtDLMCsSNAzDz4LNH72rfYu9bNNNlohf0F3vV9V4mnPMsmefEizYiw865W7wI4rYPxuPxkUD26nkVEeyQQu0AjZBuQSTPYVO7X75YGLpgm0MfPQ8D50xcV5Eov4DNWqzueOx3dwGpABUPce093oCOc8mwOXxRM2gAtmxjjpOTl61eiUSwBKZoUxuAS2vS2nM5Z3tPtkbddH64HkUA92EtbX0cKiWDF8Ad9Vm9ViueVr80Kb3hazl"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 18, "autoSave", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 19, "autoSave", true));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
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
