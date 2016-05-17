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
import com.app.server.repository.organization.locationmanagement.AddressRepository;
import com.app.shared.organization.locationmanagement.Address;
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
import com.app.shared.organization.locationmanagement.City;
import com.app.server.repository.organization.locationmanagement.CityRepository;
import com.app.shared.organization.locationmanagement.State;
import com.app.server.repository.organization.locationmanagement.StateRepository;
import com.app.shared.organization.locationmanagement.Country;
import com.app.server.repository.organization.locationmanagement.CountryRepository;
import com.app.shared.organization.locationmanagement.AddressType;
import com.app.server.repository.organization.locationmanagement.AddressTypeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AddressTestCase extends EntityTestCriteria {

    @Autowired
    private AddressRepository<Address> addressRepository;

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

    private Address createAddress(Boolean isSave) throws Exception {
        City city = new City();
        State state = new State();
        state.setStateCodeChar2("YJknWrJ49NsnETaZh0107x3e8FBK9BJi");
        state.setStateName("ls9PJ39oSp154xZbkGKZE1w5JKPqGPwTsy6OZt9kw7932rzGXP");
        state.setStateFlag("OLcAniuWhhLWPjWo9MbcaHwGxnRI3FBN6sEzHQ8Pu3i625NP5s");
        Country country = new Country();
        country.setCurrencySymbol("BoVslVyeoqSwIyBz3qkthIRIA282bX8M");
        country.setCurrencyCode("wcA");
        country.setIsoNumeric(190);
        country.setCurrencyName("nQHGNC23KZWjXlNQmsb1NPUv5DVPs4MQ17Y4Kha1tIgrC1qE47");
        country.setCapitalLatitude(4);
        country.setCapital("R67HgNGnKLXq89uUawSjhcBYS0FqMXfN");
        country.setCountryCode2("646");
        country.setCapitalLongitude(9);
        country.setCountryName("YG7nZYjjHwqEAo6TZGFQMzfWhI0FovHjhrcAFMRoRURPzSUagj");
        country.setCountryCode1("w4A");
        country.setCountryFlag("XQEas2sTn7dtQ3s4K46QAyNCkeWulnEMeUq2R0wIYA6Itt1DZR");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setStateCodeChar2("iQRnshY4w0sDi715ysBeRgivTzkvnjG3");
        state.setStateName("N5svMbtQpiyzNk92QXh7MwcB0jdIfTpbLS9Vj2uKaCQKHlqbQB");
        state.setStateFlag("x6vVkHYra8GulCIb0YsbQdqgYoWKvZr4Jzdo7z5mMlUnbbQs5Z");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCapitalLatitude(4);
        state.setStateDescription("YB36xINa2hPP4g3710oAWn4k7VX4x47AO7Kw9zVgr4LWYhwUcw");
        state.setStateCapital("xF0RxW53VNuBgs9TEFXjqfwgIeE6rJc2JpKZlb7G7CU4OLCPdA");
        state.setStateCode(2);
        state.setStateCapitalLongitude(1);
        state.setStateCodeChar3("rMfTSTjkRD21P9xDBr4lCwGcQQFdI5CQ");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityFlag("jLeFfrqztGQSoyfDyPxrnedj6QM4aI8oK3V9wzOj0arU8NgQrM");
        city.setCityCode(2);
        city.setCityLatitude(6);
        city.setCityDescription("JbMn2G4Yjvs2YHMqlQUcM827FzhSPMJSoZOzalgBPIHoGQ5wAG");
        city.setCityLongitude(10);
        city.setCityCodeChar2("1b4V3VvXxw2E2dKW6gwjapaWydOQJ7Ag");
        city.setCityName("YAD0KPZmhMaI6e9izjFSGGGnU1IEqSGhqRYxwclQpRYzgAqwqN");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("kPIpFYjEHnuMTzmZQugvbyo3eGkaOAA9j0zWmUpoGp8EpxG49t");
        addresstype.setAddressTypeDesc("mOUMhHiNQ1sA4MVGagCZIJSj9mGCKSjHrkcGT51MUTJ15IQ5la");
        addresstype.setAddressType("Hj6cwtnmNz3zMF1fo9awqiE2Iikt5BwKDZ2F6ecQvIpmPdeKy9");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        Address address = new Address();
        address.setAddress3("OzXFnW3HK8akMD64O012b6DeDK4IbPdTEp53dKJRIO4ZmmPCaU");
        address.setAddressLabel("ohHbtxVrzU8");
        address.setAddress2("LuEjelm1q1GVpyqbbCuzxfOn87yBCv1mgwPqkTSeF8IRSwWyim");
        address.setZipcode("nfIOrg");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("SbXD0K4fScaeAv0ZAxbO2lMPNwwXhEV79xFq2hcdP7ELsqrvk4");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setStateId((java.lang.String) StateTest._getPrimarykey());
        address.setAddress1("V571FDMu2Yf5QV5NZDjfJbg0392ep5V3XLdKs9gToAdF11wKli");
        address.setLongitude("dcZpxk6uTfadMNBXIbcSH9kY8rNhORfhMlpBfZgUXAvWyrs6OY");
        address.setEntityValidator(entityValidator);
        return address;
    }

    @Test
    public void test1Save() {
        try {
            Address address = createAddress(true);
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.isValid();
            addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setAddress3("GHXtARCmPbm6IYW7XnJ0kb2xTz0KcTEgHBLAH2qZmuprQ8Qq0C");
            address.setAddressLabel("Syz43m8Cudv");
            address.setAddress2("ba2aGOKdGcIPNs7E30nzA2OSJReKxHzU5Xsk35ooMELpWovnu5");
            address.setZipcode("CsuAF5");
            address.setLatitude("dAG6atcQk62ecvxsFUGvNGnPzA5fHjV9IeasZmg0bPHKP6LuRQ");
            address.setVersionId(1);
            address.setAddress1("YGoaglvSXHFaadd8YAwsT78adWOlQpDlWnfHbufE7nzWapb0Ps");
            address.setLongitude("vZhDQy3L1LR0vboKO4u8egJEiv0RX6lbu8al7LdRIxBtK8QFDM");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycityId() {
        try {
            java.util.List<Address> listofcityId = addressRepository.findByCityId((java.lang.String) map.get("CityPrimaryKey"));
            if (listofcityId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByaddressTypeId() {
        try {
            java.util.List<Address> listofaddressTypeId = addressRepository.findByAddressTypeId((java.lang.String) map.get("AddressTypePrimaryKey"));
            if (listofaddressTypeId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Address> listofcountryId = addressRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<Address> listofstateId = addressRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateAddress(EntityTestCriteria contraints, Address address) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            address.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            address.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            address.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            addressRepository.save(address);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 1, "addressLabel", "xOBx9z4uL6O2"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "address1", "GDrhXUUN3bfQWtis1wBOF7jturlKAU7a90FPm2P8MfCMzLi7xdZsTIxaq"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "address2", "pNUuhboPjvvmK1c31TIHpSEaxHHThQrDJQDQFSPo45EGDqVm7eZUeLrCY"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "address3", "KQQnjg6Nn77Om7OYigEJG6vndEWZXgFsWy1hqMe69xU4egyNKahcM73ks"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "zipcode", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "zipcode", "kAUrx7s"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "latitude", "IAWZWa5C4Fz4EM8nEY3RawGPbrFoGubggH1QvI9cpxhxA3De4oaQIZ8QqCXY1ZNTL"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "longitude", "Zl6miLQ3TV5FQcGlOOY9C6DMnswHpRzhrFc1hZs8l9VNLIKjf97qIjAlYh5FkdkIO"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Address address = createAddress(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = address.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        address.setAddressLabel(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 2:
                        address.setAddress1(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 3:
                        address.setAddress2(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 4:
                        address.setAddress3(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(address, null);
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 6:
                        address.setZipcode(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 7:
                        address.setLatitude(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
                        failureCount++;
                        break;
                    case 8:
                        address.setLongitude(contraints.getNegativeValue().toString());
                        validateAddress(contraints, address);
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