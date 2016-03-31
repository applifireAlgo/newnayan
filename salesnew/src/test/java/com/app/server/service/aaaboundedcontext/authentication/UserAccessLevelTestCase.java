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
        useraccesslevel.setLevelIcon("UryGrkkFSHISDzfqAG6zVClKxUcnex4S8TrpxRoE3uv0oESCyo");
        useraccesslevel.setLevelDescription("BAt8gKhlZ8BX1to2jwLglr5wkoEBXYXj74jQB6VHDxr9WOKTpN");
        useraccesslevel.setLevelName("lbhL0jm4qRMjMaKxsjsAjCRg6x8MEZY2YdnXCEbhVfsH04Cj2i");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelHelp("gBNQDipYpC4F7vZnMKqhLf2UwtU7fRu10rqB5bJrQt1aL9UWEZ");
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
            useraccesslevel.setLevelIcon("m85ifISFKjdazS1pKG9lPA2O1jnaRMgrAWINNbl6brNUT2uutb");
            useraccesslevel.setLevelDescription("cje05Z0pbFUJt8Uhpabb1H3pkX3mlpLMtFZKc7i11UVVW78zpY");
            useraccesslevel.setVersionId(1);
            useraccesslevel.setLevelName("O4nRGzGjdYGfqKxusKwotqYt87LYRbN2lOb53qFpyoqpFMkPsr");
            useraccesslevel.setUserAccessLevel(42226);
            useraccesslevel.setLevelHelp("RpdNk1yCYEBe2kJ6fE2JhxEEwcCMUKk94EKeZivzQtY0eg8VV5");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessLevel", 187447));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "levelName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "levelName", "6i8hRETBnezl7Omqh5cPi9WyijjIJf0n4VDkyUYJUE8OCaZ8eEn3UEBunQqN7m7ze5W4zBNcqjGLr1eLtCWgsKokGAJ6Hb5RCOpSLQHJFocOfLIqNg41rr5019JcoPKIv1piCHBau5iHr3Ra0ftb2WBsg9wye7mkpm4GrytW6Gu2scGsYS7g3O5jlb6MUXyIEXRK3t2dmEqZB8aF7kV4DGbymdyiZLW4uHyacMvo56wPoNyahlvT3tWFVJKuQoU3h"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "levelDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "levelDescription", "q9Ghfg1d81FedpGaWflVpdm3Gg3ALuI5XTmFhUXLojBqoBucJKxj0qI4b8JogC2tbO6BXMgHiAU1ESh4sKsgms2oc45G98p7au3c5mztTV280pWqK1kIoeFJHXf7TIPxSDroXZNTiUMhhnt4UdIKXenPSKwKN4rjdzVUiGJmnGMVvB92qdnvIDRzm52V5WK5ox9QLP6wkfZD4E0OGqpr90ttOwdPcKyOoqegH1FY6P7AlO5t5DjTOwq3AxNcfsbwv"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "levelHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "levelIcon", "toKb90X0EtmX2i6KNvPrlVDCHqCN9WHJ6PAOPVXJcnDC6Jyat6nTfNuOdt73HX7diS0VcIdwfTDkKtujpYQPyr9niWhnXsxm0H9QscaUXZuqt0SJdL6srYC1EStJBstDxQbxAzaI2OO54db9HS5TloLpZ3j5inKDjup5WQFZaDdt84nIPxgD3joLfKWD84dfcChTrEU1pQlbeVbUVoc4IYSIszRUynAbgG7qJPTWk2E6xkrLTd1jjw2qI0A8WETqJ"));
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
