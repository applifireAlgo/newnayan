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
        appmenus.setUiType("1zs");
        appmenus.setMenuIcon("BH7e0VzannWr5UC3sjjZUj4BN19lFhvwN8XuUyBe6iTJt1dnP3");
        appmenus.setMenuHead(true);
        appmenus.setRefObjectId("Cwb61MZ719wllYpIbnZsBvNTm9LSDWNJuI6PEP9IU1qZ6gkRZE");
        appmenus.setMenuTreeId("0kwH9eeVBTk8UTVEXLF0NSabSRjuhFX2zeMtvxC8HbeHPb4XDe");
        appmenus.setMenuDisplay(true);
        appmenus.setAppId("kY4yyOu0wMTrKIGetZGlMjS6MfbhAQKkQFvuVwxHgAgghZNloy");
        appmenus.setMenuLabel("yfLPQNQE2iH36iNkCR5D7EMnDH7rqxvi0JmtlkkVt7C0Ih5ZEG");
        appmenus.setMenuAccessRights(4);
        appmenus.setAppType(1);
        appmenus.setAutoSave(true);
        appmenus.setMenuCommands("fuW13zjG3JHKaY3wDytRZX4nuYvtkB710xYphjpnNxcj2q9WRX");
        appmenus.setMenuAction("a9LakMNcHsMTOhCHXGedoboACDlsusFp1fWtr8q41b79pA2mAL");
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
            appmenus.setVersionId(1);
            appmenus.setUiType("2S6");
            appmenus.setMenuIcon("pDivMVsRTpRY7JKTy8gjeRZ6qPNv8imYTi0N0B7c3iUvHCFvA6");
            appmenus.setRefObjectId("nZyNDs3BQ6tsMvNHtvsJqS5TTGeZAHBiE2RwzVjH2y1C9q9RQs");
            appmenus.setMenuTreeId("3RpenWGfItcEEbCSNJh14G4iDv5WPsGOvLOyNCqJg6pKzeFvt8");
            appmenus.setAppId("rDFzl6pFkx1I6o2uSJUmJAEmUyr9GNY1Fe3y0H1UaCgRlWVeUV");
            appmenus.setMenuLabel("5dOakFTFURlAgk5iahK3I17gXFC1ONI8NLJ5rKol0nxGjlqtGS");
            appmenus.setMenuAccessRights(10);
            appmenus.setAppType(1);
            appmenus.setMenuCommands("oaAcd4osE7Z8VwMzF12VBdMPybqXVqNaHGXhwn9ICnNXSFIm2u");
            appmenus.setMenuAction("fO1q5SDk5wwn3tW8izWDNdFC77Jko6gBmasDophTdo6gIN1Yys");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "menuTreeId", "rjzfis78Xp1Ocg0xfddUh8OIvjXVTGja62Wo6RXguvuXKbjR8mUUujyKcZyeuyPpilCmvs1tpDRnYSvvnPVuLZ8Np0Onfod4rtfNKEwd2mILUxxrhkwGrwpVHNApoxSXax05nlRDarRIGL29CZVhpEZQA5KwSjbyVmaqCk8bNajcneuEpe30yBOd0DpKhp1eeqhP6bZirok63sjw4dqDFBBEFNQSFEHZcaWAZZP8UW6b2jeJAFxpdHgVVA1XhDFjt"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "menuIcon", "37P7oT50Fx3p7TNv4J5IyXUO6oGZxrZcRmr3B5Ud2gvPueffb2QNQPX2Jaq7AjhFHHB6BhVFV5UbhgXqrHDSwzBvZmlUZFRwHWCLulGIJf9nuAv0MGkKezb16CA5CZspd7OXigpb1CKqfUCfb9BdR9QnVsM6ZbieZZ2jEBbC0tYV6gg1imzq71SLwr39hKhftrT4AmWsrHcHZxSquDXth8RwyOEL92gugyT84PMdA00w91OQzcgQAdZOwSAEbhDSO"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "menuAction", "27MIPMCKRx06V6GhOpSLOigx93AcYC9w960YnqzmgL4QsWz1u8trWkk5PemAaWa1YqH2NiVjBbXjdeJHXd7kZfNtNSksN1DUvKrqhRDu5uUzj5jR79olvK4T67NKfXhG7Hb7Z1VfLNUbjNT8ohcMpFLt3I39Q2mvRxjRGiEfmFGPmPKTXq6nxcunweBuj6zuj7MqlRfMiIJtLZgISbaIA25eDTn3v65WIw8TIuoCb9fVFv8jGy4fETIQ4A6OkBGWs"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "menuCommands", "jGDxln5JxC5cCc0cUR7HLj4qiPqahxVCk5WgCGv8qROza2K68QCeD6CEtvisOrfAu"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "menuDisplay", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "menuDisplay", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 8, "menuHead", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "menuHead", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 10, "menuLabel", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "menuLabel", "a5UcRTogWorjQGdEs6Ivboj4JyfIyjfWWQkj9v6e6xJDgU1hr9VZutqKgRvtAyCokmurpCCO7lXHU6OWAXDWKPh0bkYctTzfrVBZFv9eaIvFC5ZRWDlK6nGFRDqG3bp86ylP6ceIFuRrqb9d8HDzqF5NnZUSNZWto0y6m8zdBXJeoRpx4Dmk5NV2DOZok7IhthnwUNdETu807mJ34jORvHXFwtXS4eE3gleTuVWUa7GHvkNwrbvStW4F8rKG0F7DN"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "uiType", "VEJ5"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 13, "refObjectId", "BQlzyWgl2hZArivpOs7u5o9ZwImP6rUdKbkLsaBJFdsCAnj0otQyDoIJJl1SKbne2jA5XyEQOzeqYHuIfLQ1uvgDxGvR29eUtU6SoJQq2S4E7XcR0uHkGnjbYrcGrOwfXbwxlFrUiMtoNdUdJ68kjr9VdEORdoR5ZBkIoxv1tuZZINmwvSsjT7ozvbxH3PLqcUOfr5A7FXmsDfcAKwmtkrl6fLMRvSxMyaMfntr9RJqmWWFZaFBb3gaq3GFU41xfH"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 14, "menuAccessRights", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 15, "menuAccessRights", 21));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 16, "appType", 4));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 17, "appId", "pZQonvMOrsJdNRxxEdwOajK8XcBUBdTbziI1NzaedMcW6acLN9xzsvMSFuj3uVErUH5ELHTmlwR3BDjrBCXIjuELc0hqeKoSxdOfTQEQ1PcriCYbkWwTAGn1ypjls4RKxatpF5iYTgOQQF4CFoG7kHZzOUDstb69GbYeNaLSVOB8k6NbbFCWu8VlbnmpzAFvARaYFL5qyI75q6k1vhr2lzdLGCFQeRz1FRqlzMUZFChTSa9VO36zYY5eDK5r5mT6B"));
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
