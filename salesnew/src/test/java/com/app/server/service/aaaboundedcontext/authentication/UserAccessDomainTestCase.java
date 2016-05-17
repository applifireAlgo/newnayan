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
import com.app.server.repository.aaaboundedcontext.authentication.UserAccessDomainRepository;
import com.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
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

    private UserAccessDomain createUserAccessDomain(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainIcon("bCyD2fmiJOsfYa8QkaOJIl418iFJaKnkXBlsFOCUFKZSgeH9ZU");
        useraccessdomain.setDomainName("FQy1hQbii8GTLu6igyAz34oorln6U3hgnSbcyDdkae7BXGQbFp");
        useraccessdomain.setDomainDescription("1NN4IBdKLVOlQYO54D075r4jgiAr4ftHL2LienFu7o4r60jlHo");
        useraccessdomain.setDomainHelp("9pTTKCuXuh2HwuPOFRMETbURU9VQssvUP16Y6q5Yk5URSy9QRQ");
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
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            UserAccessDomain useraccessdomain = useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
            useraccessdomain.setUserAccessDomain(98673);
            useraccessdomain.setDomainIcon("qNca5wF9hrUmRCXKJpJaqFHD0xIBaFlP62ouDU4zFkRqIweLBh");
            useraccessdomain.setDomainName("HNtYHiplqm0k7Ui7ThziEOOZVMfIIRn4EVipRCr2MJBFjeLNlc");
            useraccessdomain.setDomainDescription("CZAPukO3H9McvwTYYoU46LgRxEFfTzVNaXg1RqC5ccNGw1KccC");
            useraccessdomain.setVersionId(1);
            useraccessdomain.setDomainHelp("CFEeNkW0ivUJooAoRMLCy9ZTKme0NGwO2uXbjdraP9EfBzvoJv");
            useraccessdomain.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            useraccessdomainRepository.update(useraccessdomain);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserAccessDomain(EntityTestCriteria contraints, UserAccessDomain useraccessdomain) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessDomain", 109473));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "domainName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "domainName", "r9R5znOP7o5hizVUqNwYOKLFnKiZQaVczGH04ftY0fq1gPDc9rzIU2qOvaNamkyagCWbaXvafvM3Tyh7qXwK6ZdSOoIHhCUho5EqeVn2Xlajqco4rZwALqHQ1mWOuOqA3yLHiKdLR4m5li5AQeTKQtn83ukWMNva1j0Ox39nNSGMkPMZhyNkDfb3rjxn0FsC6qxZogB6zxHGTWiZo5AyHB3YnMjtXdxiVhTOtdmbQnXyFcUlCq6wVX3yoJECPZd0G"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "domainDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "domainDescription", "v0FJZtMKhwKJdWX99aSIv2C2uWIv8VbxB0M2dbGhUi07vdOJhB1JwMDBK3ZaZ94wn0Hqw0B5s8ajeMp313imT34dXINZU2Bu2ibLCVus1ImgXreHzARC8epm5JwTGFo9G24Vp17UimbOHtqBbafuOqkmRqEzJKmCbUJFAK74r5LkvFJpjpGtoooW8GD91yUkcocZGRxsM33VB7Y7oEREOcJIybNOReDcDpKqW5s46GNhl0mrN5kLq7RGV8LvCKXZx"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "domainHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "domainIcon", "y03nkEizVLbzsOiPqln8fVrVBlEWxhXaNMiPaeTrZGNsh5xdViGJRNljbcl1IFRkKQ6VIZThnPZ8oHPvRgwRycyZ338rDZPdAKpjZG0NfJs0mkcgi9bWtiGQcHWc7XD4VBGgm9seUkiRcsiQ4HVbBhvS4fOPXWOi1OGALWNMWnAOB7IC5ZR4E1sDegZNPgrfaYHZbDc6pzn7tOvXL3PrWY68WVdOLk8Dy8v6AXM0HJTwHJz9e0YWm73JCCYRaBL7j"));
        entityContraints.add(new EntityTestCriteria(UNIQUE, 9, "CombineUniqueKey", ""));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
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
