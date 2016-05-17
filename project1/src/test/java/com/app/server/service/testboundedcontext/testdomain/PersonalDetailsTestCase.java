package com.app.server.service.testboundedcontext.testdomain;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.testboundedcontext.testdomain.PersonalDetailsRepository;
import com.app.shared.testboundedcontext.testdomain.PersonalDetails;
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
public class PersonalDetailsTestCase extends EntityTestCriteria {

    @Autowired
    private PersonalDetailsRepository<PersonalDetails> personaldetailsRepository;

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

    private PersonalDetails createPersonalDetails(Boolean isSave) throws Exception {
        PersonalDetails personaldetails = new PersonalDetails();
        personaldetails.setSalary(-4700.0d);
        personaldetails.setAge(2147483647);
        personaldetails.setRuSure("vBjA");
        personaldetails.setfName("Hs0vWsmlyuWEcILWT50M4TX6MJdLoFWtP3FJBhM3lFvl2V8zCu");
        personaldetails.setDateOfBirth(new java.sql.Timestamp(1463468601328l));
        personaldetails.setIsEmp(true);
        personaldetails.setEntityValidator(entityValidator);
        return personaldetails;
    }

    @Test
    public void test1Save() {
        try {
            PersonalDetails personaldetails = createPersonalDetails(true);
            personaldetails.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            personaldetails.isValid();
            personaldetailsRepository.save(personaldetails);
            map.put("PersonalDetailsPrimaryKey", personaldetails._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("PersonalDetailsPrimaryKey"));
            PersonalDetails personaldetails = personaldetailsRepository.findById((java.lang.String) map.get("PersonalDetailsPrimaryKey"));
            personaldetails.setVersionId(1);
            personaldetails.setSalary(4800.0d);
            personaldetails.setAge(2147483647);
            personaldetails.setRuSure("99xS");
            personaldetails.setfName("I5RtFgNdI2fCjiflISzLAeloGM0XvsaxJZsyfCDUacZwGPD7h8");
            personaldetails.setDateOfBirth(new java.sql.Timestamp(1463468601426l));
            personaldetails.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            personaldetailsRepository.update(personaldetails);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("PersonalDetailsPrimaryKey"));
            personaldetailsRepository.findById((java.lang.String) map.get("PersonalDetailsPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("PersonalDetailsPrimaryKey"));
            personaldetailsRepository.delete((java.lang.String) map.get("PersonalDetailsPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validatePersonalDetails(EntityTestCriteria contraints, PersonalDetails personaldetails) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            personaldetails.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            personaldetails.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            personaldetails.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            personaldetailsRepository.save(personaldetails);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "fName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "fName", "eFLOqCu5ylqzgKodzODr1tAuzZ4Pw2QwaT9Pm1zJ2gIvjrUOsIDKhv9SRn5wFkB8L"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "age", null));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "dateOfBirth", null));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "salary", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "salary", 1.348876090831262E19d));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 7, "isEmp", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "isEmp", true));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 9, "ruSure", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "ruSure", "EvskS"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                PersonalDetails personaldetails = createPersonalDetails(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = personaldetails.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(personaldetails, null);
                        validatePersonalDetails(contraints, personaldetails);
                        failureCount++;
                        break;
                    case 2:
                        personaldetails.setfName(contraints.getNegativeValue().toString());
                        validatePersonalDetails(contraints, personaldetails);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(personaldetails, null);
                        validatePersonalDetails(contraints, personaldetails);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(personaldetails, null);
                        validatePersonalDetails(contraints, personaldetails);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(personaldetails, null);
                        validatePersonalDetails(contraints, personaldetails);
                        failureCount++;
                        break;
                    case 6:
                        personaldetails.setSalary(Double.valueOf(contraints.getNegativeValue().toString()));
                        validatePersonalDetails(contraints, personaldetails);
                        failureCount++;
                        break;
                    case 7:
                        field.setAccessible(true);
                        field.set(personaldetails, null);
                        validatePersonalDetails(contraints, personaldetails);
                        failureCount++;
                        break;
                    case 8:
                        break;
                    case 9:
                        field.setAccessible(true);
                        field.set(personaldetails, null);
                        validatePersonalDetails(contraints, personaldetails);
                        failureCount++;
                        break;
                    case 10:
                        personaldetails.setRuSure(contraints.getNegativeValue().toString());
                        validatePersonalDetails(contraints, personaldetails);
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
