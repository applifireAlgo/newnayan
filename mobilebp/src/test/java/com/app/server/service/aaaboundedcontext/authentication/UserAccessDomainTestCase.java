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
        useraccessdomain.setDomainHelp("01YccI6FaPoRPWAW4jMp5NGn3VzHYchbgGbC4fPGPay68zZ166");
        useraccessdomain.setDomainIcon("gJkUA8kXifPIVVfYRXMtpZ0GZnzZjTNMNYhdEj2liiVOUE74YZ");
        useraccessdomain.setDomainDescription("MchOUtXcWdr264Hg7oKkGa1HEwh9P1iqca2hyUl4ZfOWFCqM1n");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainName("X4H5ac4dy7kkCLIxcGal4P0ArG0Pxf7iEWEaxXaDvcvWmLJECz");
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
            useraccessdomain.setDomainHelp("FaSqHKwRHmMj6y8gstKtG3ZTR0SGhGdQaydQf88QIulIJvBjfr");
            useraccessdomain.setDomainIcon("phorUxwUEi3vYIZvWSLMAhNWW8osiDV7BTkQZc8dagvEwDL2mv");
            useraccessdomain.setDomainDescription("9TNocTnCtbumMSMNpaAWk9tith0oj73UJdowtAlvsTwbUrYQhL");
            useraccessdomain.setVersionId(1);
            useraccessdomain.setUserAccessDomain(90583);
            useraccessdomain.setDomainName("49H2rC61Ha3Pm7dA3EaeopTuHx8vdjKzkVQLKrVulJaqDirM34");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "userAccessDomain", 186058));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "domainName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "domainName", "zcoeHXabX5NUhUGOa4iEt9FODh78KjVwvaxg0h43r9RFOyrP5JNHH42Qnl8EmPEHPpxQnW5pZd6oBBoE4Dt6KDStjX7QnSB0XD4n4XKWtWgOZJ6uav6mx4yFLqVy2qUdABjTrhMtWcmggoU07izG3N9dFvoC3R6h8TkhF4bnfS5miMF0FHqIPO0Lgfq7HvCRsu3HegoutoN6mzGdvHLifdC8l5E8KPdTz2AHuRlklrNSYFvFr9lPdi4llMU9U72Ny"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "domainDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "domainDescription", "uFYPve69bXt0dLEJtrpNZ1YQziYasbsvKjC5Dkg3HIWCzLWB9TE1ofQpNWwxUthTjam7iSlWwHX7KhpZkQHvNznnggX0uJkbMEQq8uKxv9uCHOdRqoYtZYmmvAFUOUOlq3qEGsX9dCGWCoDnrOJi23W1WaUkZHzyMH1bkEzF7fWN24g58yAMN3hPCH4fGk2r77yp9hkFuqwDcQF7HLBBje5Zvt199q88Kh9ud6P4trWQikCz5AYEgfVbOCzmg0fid"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "domainHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "domainIcon", "2JCLdhxr4SyzQLfiTh22LtyxLTg0hL0NmVE9gEzp1merV9oTu0LPTeWQzALdU1HdFk4xaSsiW6KXnFPE2ks2pZlJEiCDYqo3usm4GyEB77Y13TPrYFYLAL4GC7RlGvNX09cz72YlCvKzSmhjzHN7qX4BA7O5CLLUMJ6BrHkccKEamOY4ZmJmzV56IRjKiM0S49AiBEbQhy2eVrnEED2raA19qzbHbRNn0ZK5LHPidn5a1gNhOKMjsrrYJXRg6ZAcM"));
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
