package com.app.server.service.organization.locationmanagement;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.organization.locationmanagement.StateRepository;
import com.app.shared.organization.locationmanagement.State;
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
import com.app.shared.organization.locationmanagement.Country;
import com.app.server.repository.organization.locationmanagement.CountryRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class StateTestCase extends EntityTestCriteria {

    @Autowired
    private StateRepository<State> stateRepository;

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

    private State createState(Boolean isSave) throws Exception {
        Country country = new Country();
        country.setCurrencySymbol("cLv3Xpu6sBDlWTTBOdhdHDZovuwc9WSV");
        country.setCurrencyCode("Nwx");
        country.setIsoNumeric(154);
        country.setCurrencyName("XbJlEQaYB3RfuFV0R1HSowAqueDpHoMFAUfPLr7J9Zc2WhpOmj");
        country.setCapitalLatitude(10);
        country.setCapital("u9Y7Sm7t5ASTTjO8KgFFeF3nB9qxjiNK");
        country.setCountryCode2("90S");
        country.setCapitalLongitude(9);
        country.setCountryName("jMYUrl8bt6E8g7QIy8a8iQWCFSX1FFFoEad25fQZLSqxhQLN3O");
        country.setCountryCode1("WLL");
        country.setCountryFlag("0rgPWDo6ZZPOatdXYpaglZbEOAVQjhqXL1b0mx4GEOiUeVv73w");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        State state = new State();
        state.setStateCodeChar2("IbBiyY2mOnygsKBLeax216gYxTvrJRzl");
        state.setStateName("x1I4GsfBMgUHbrMPKJTQcyPYoJLyDrB8d48jQdOzQYk6HHmUzy");
        state.setStateFlag("gKjKqDUkur4KM6mWhuLOggQesKVE4U45CHgzIaUT8mlOIo7KL8");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey());
        state.setStateCapitalLatitude(7);
        state.setStateDescription("0IEANlbNSuQ9QeilUWWoOK8pVRcjT7XhoPG1s92OozJVUZbLAJ");
        state.setStateCapital("oPJ0eNw9O5ien7RHvHuhMJoRkbAlb2clOtDrwg0gy0CWcWRcbK");
        state.setStateCode(1);
        state.setStateCapitalLongitude(8);
        state.setStateCodeChar3("XvRu8VB8qIcmUrwUxufSnS08hNfsYL47");
        state.setEntityValidator(entityValidator);
        return state;
    }

    @Test
    public void test1Save() {
        try {
            State state = createState(true);
            state.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            state.isValid();
            stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            State state = stateRepository.findById((java.lang.String) map.get("StatePrimaryKey"));
            state.setStateCodeChar2("AULb05lzpxtlo7CRRVNgjbB8PGRna8av");
            state.setStateName("szTGLXbMQdsSI3GB4HV6kL9A8QZYiLMC5eB8eHPu9W0VUqQ99r");
            state.setStateFlag("sue4xlieB5TDPZ48ZrLJCFQZkozal6Ctfk3vRI0YaK9lP1hCg1");
            state.setStateCapitalLatitude(6);
            state.setStateDescription("2AqnSzFfDltRG8Dio2q1abuBGJzLlIuLVzXzGu0AJMNVp93zny");
            state.setStateCapital("GhnAGcwoAYf90HLA2QKrYbdrrq5YsHMvthQBq8cf8o7Mu3Jtz2");
            state.setStateCode(1);
            state.setStateCapitalLongitude(3);
            state.setVersionId(1);
            state.setStateCodeChar3("9f6sHSGDdIdt3RTgtrFrf5E8MxTHVGpd");
            state.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            stateRepository.update(state);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<State> listofcountryId = stateRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            stateRepository.findById((java.lang.String) map.get("StatePrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateState(EntityTestCriteria contraints, State state) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            state.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            state.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            state.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            stateRepository.save(state);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "stateName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "stateName", "MCxIMkslcIhiteqrzx9ZFOEcsfvtBPwbzF4LEbewF47fFmik181a5qkW7ZFtIBCH8dQHOnJPanqHxbPen4zUhp41cGGFlmz6g8QaRebp9Q8W2xrFrJ6h9F8OoOZQU0bcaj8XeNRlL4upyDkLG2V1axp7ZiLS9OmDIpZueUECtaMcByck9eBvCKTfSdxNU0xjRSlvi9qFGOLZIMLmUKRjqCXpM7GHe7grwt7y475dcMBfhlXKn1udRVsgH3xgwbQG7"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "stateCode", 3));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "stateCodeChar2", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "stateCodeChar2", "tBpu0gCHB96XS8gpjfmUXgVCGVfc4xgYR"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "stateCodeChar3", "qjS1iDYcSXN4BVRLWrm2I33ixAwknVgID"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "stateDescription", "ocsfplGnb7JakQQOqEfoeCEoxZRHc6mXHgbj77CUoVcOqAk3WgEK5TzG64YtV2Pvym02QRCJI9oVavg0nqbwr2zcvfq4mz8I7FFrK1qTGkoIWMbX0SJdRtDOJCxLmksvwlLqkw1pGOEfzmjtxMUhytOHcHbefhw9WMJIlmWr4RIuQz9ivoz9qXxpAvoYsQz1mJRPe245OjOxbTenTkUrgQa1xvUCTcHgUwMSUJ4EMq5Y7E4k7S16LQ6g9vI4T6u3Y"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "stateFlag", "zB91jGXemXfg6u4vnEOGHDlrLg4jQJ6EA1qEwpJGCi4ZrPKwADfcBu3TvPtfNcAcVCfyHQIPSx1AImbK6DNJhMPVyxc6FJP1CW6IbnJlOqmXYt0i4XOScH4zPkFMsiypm"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "stateCapital", "Dr9M5mWLDxzGFQ6ZfOMJRN1Y1shUo70r0YTBtSJBt8ouLge1RVikQlNMYn9ByPAnndZkB9uucKl69PaxR7vJYB4vHjMZtkQ8iqKIWeLo258wIefLZqP8lke9CcDlVSaxO"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "stateCapitalLatitude", 16));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 11, "stateCapitalLongitude", 20));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                State state = createState(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = state.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(state, null);
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 2:
                        state.setStateName(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 3:
                        state.setStateCode(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(state, null);
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 5:
                        state.setStateCodeChar2(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 6:
                        state.setStateCodeChar3(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 7:
                        state.setStateDescription(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 8:
                        state.setStateFlag(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 9:
                        state.setStateCapital(contraints.getNegativeValue().toString());
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 10:
                        state.setStateCapitalLatitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateState(contraints, state);
                        failureCount++;
                        break;
                    case 11:
                        state.setStateCapitalLongitude(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateState(contraints, state);
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
