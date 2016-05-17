package com.app.server.service.organizationboundedcontext.contacts;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
import com.app.shared.organizationboundedcontext.contacts.CoreContacts;
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
import com.app.shared.organizationboundedcontext.location.Language;
import com.app.server.repository.organizationboundedcontext.location.LanguageRepository;
import com.app.shared.organizationboundedcontext.location.Timezone;
import com.app.server.repository.organizationboundedcontext.location.TimezoneRepository;
import com.app.shared.organizationboundedcontext.contacts.Title;
import com.app.server.repository.organizationboundedcontext.contacts.TitleRepository;
import com.app.shared.organizationboundedcontext.contacts.Gender;
import com.app.server.repository.organizationboundedcontext.contacts.GenderRepository;
import com.app.shared.organizationboundedcontext.contacts.CommunicationData;
import com.app.shared.organizationboundedcontext.contacts.CommunicationGroup;
import com.app.server.repository.organizationboundedcontext.contacts.CommunicationGroupRepository;
import com.app.shared.organizationboundedcontext.contacts.CommunicationType;
import com.app.server.repository.organizationboundedcontext.contacts.CommunicationTypeRepository;
import com.app.shared.organizationboundedcontext.location.Address;
import com.app.server.repository.organizationboundedcontext.location.AddressRepository;
import com.app.shared.organizationboundedcontext.location.AddressType;
import com.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
import com.app.shared.organizationboundedcontext.location.State;
import com.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.app.shared.organizationboundedcontext.location.Country;
import com.app.server.repository.organizationboundedcontext.location.CountryRepository;
import com.app.shared.organizationboundedcontext.location.City;
import com.app.server.repository.organizationboundedcontext.location.CityRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CoreContactsTestCase extends EntityTestCriteria {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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

    private CoreContacts createCoreContacts(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        Language language = new Language();
        language.setAlpha4parentid(9);
        language.setLanguageType("GOSS0gW9GczOilhb6eLazDVFJsiQ4Pex");
        language.setAlpha3("TEo");
        language.setAlpha4("Xqbs");
        language.setLanguageDescription("jkRbghD2IXFcx2M0H1SW0PwOhxcBxrYfYKD1gORCSar3DXk12Y");
        language.setLanguage("ZZRYVEsxe2emiJmwt5A0cMnr0gcTvQDYZm0YdNTgwLpP8izQH0");
        language.setAlpha2("Rz");
        language.setLanguageIcon("0Edw61916hWPQabYbeSnuWZb367k8dCAuCvsZJRszhZkES6f8P");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setTimeZoneLabel("nzkb89iD7Ks9TwMgANVsjexQ9bRcyzJA3xKMoWIuLtT56ite0B");
        timezone.setCities("07ZaczEuMrg1S6e6YgY1JXZ6xdI8GlnvuhfJLnqnj0PQQRQrrD");
        timezone.setCountry("3CEWs3v6Ub6fzEpPQ35GE9btZA5tGoxEnkbb6UvzYyUyJV66Nl");
        timezone.setGmtLabel("lIfgxHWkqQq3zMXJ7OFrgzL1Ps2wtcoqMYZq1Y7DVcMjpoSyUi");
        timezone.setUtcdifference(6);
        Title title = new Title();
        title.setTitles("GuHbMBGTcizY1XXK8q8ofvBJUkNl4s51sU6otTGQh1yjU6bITU");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Gender gender = new Gender();
        gender.setGender("0rXsiJGLNz4ePE1MzBeWO34iPRWhFW8HPdXEgCXfSUFlfnezUo");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setDateofbirth(new java.sql.Timestamp(1459405512517l));
        corecontacts.setNativeMiddleName("GNBWXcV9UZLxbqjZJ2c3dEcKQyHgSHQzXIMaMWceJ5NLEWPfaZ");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setAge(82);
        corecontacts.setFirstName("7sPFcMUYobnvUl3WhNEGmhYC7ABfX0KJgDR6ND46Al68qoxIis");
        corecontacts.setMiddleName("QKdGmDOEapwusVvFX6eMvs2OKKrizIHo2lEBJoTVgu8Sb4qE3w");
        corecontacts.setLastName("kbjItb9GoAMiiGUKtWxooqswSc1ePgeBEKgv3DwSMCMsvKLOmc");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1459405512590l));
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeLastName("0Z1WrWoDBYqZ5FJOUbwcvYEwzp3csjHzJxTlAuFwbmENiYg1q1");
        corecontacts.setNativeTitle("YMTZP3hEZXQqWyFd9JukwfHOLBqMi8njGOnECAJCXnjuRTG0mX");
        corecontacts.setPhoneNumber("Wpi2dJ7GvPyBUCh34vtw");
        corecontacts.setEmailId("sYrwE88hr5WvRBUHGeWei9gFtze8E0NuDz4iVYjy74kqjCixtr");
        corecontacts.setNativeFirstName("0u3RSswVBIu1mSw1PYrCd6igRx54WSWfN3RrEgNtwdDOoGyOHF");
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("uojBr0N2PlQQsliTfbw6AMuZU7UG5pC2XumKhZwwKSxcXVltG2");
        communicationgroup.setCommGroupName("oc8AUi8iNJboMwuHrm4ELa8fu438Xa5ywMHkDGkiH0EWjdeY3s");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeDescription("9VxmESJKswBWWDC9oPVB1uKS0UTDNZwWi7s7hZCFAK7i59ap6Z");
        communicationtype.setCommTypeName("O5xJlHLgMtMhVJXZSkGaqfVMdTTcuEp5xpqtq8JLDT7rySrwI0");
        communicationtype.setCommTypeDescription("RHCoTYYv2aQ62Iptj5X0o4Abndl7Up1TMVYf6zDTcJh0CVc7Qx");
        communicationtype.setCommTypeName("ddIuWxxsTWlfb6KUIWMjuY2GjvJZ2iD99r7Oo2KhCnykXOKs4D");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommData("");
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setAddressLabel("3VM7sZO4tNK");
        address.setLongitude("VzbNAPnmHDuZG9BKbNxtAHdkcZsZHCM97stLwmIhJFLMUk7AOU");
        AddressType addresstype = new AddressType();
        addresstype.setAddressType("mVKJKBCELi7KgPvTihnU9ZkdIVQ7hj4SuScHk7GYk94TdXFU0q");
        addresstype.setAddressTypeDesc("gp4LzxTqOSRmfZCAspOH4ih3TjqXp825TeSQECrHCwVIORunJM");
        addresstype.setAddressTypeIcon("8Xi3NxRao9y1Ynjm9jdUuPujg7zv6SrGefnEPVFmRWMk6nTPD8");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        State state = new State();
        Country country = new Country();
        country.setCurrencyName("oVDxD416OoUHLvrQ9n68E3QI9hZWx5BH8UcX4oQHBDTftJNOJg");
        country.setCurrencyCode("yiq");
        country.setCountryCode1("Cnt");
        country.setCurrencySymbol("pSvQQ794YZnxw6JTM10zkYabGzRXUmlA");
        country.setCapitalLatitude(11);
        country.setCapital("OtF3JwxPmGxGfpoEtlPYXfyoMsvbPyR4");
        country.setCapitalLongitude(2);
        country.setCountryName("GxdbBdW0rDGrFK1F4Q8pItR6THjbUXMttFxqzzTEqxFQ6Ph6nb");
        country.setCountryCode2("jNt");
        country.setIsoNumeric(874);
        country.setCountryFlag("EEn5vPAFjiFk9XvL0Fm7Gbj3OPJzKs9zaDIHIdLoaqm8HdBRDn");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCapitalLongitude(3);
        state.setStateCode(2);
        state.setStateDescription("8MMomv0QGLQ3vBaz1UodnVaakxPOSGhu1ESyIpDjBrwEEWowfK");
        state.setStateCodeChar2("S9GQz9FZ3Zmf5LdR6S0zJZqMAWL8wFP1");
        state.setStateCapitalLatitude(4);
        state.setStateName("fZHL7P3NUwXkOlbSIPYZKtmQcIgPuqDigHltAhVnDssmOrJ357");
        state.setStateFlag("8lCpt5Uyk4ICKtVYV9agrg5KOlJvG4deZZ9RZaBdx2mGnGnych");
        state.setStateCodeChar3("f3TMuetauMB2UyZhf8IHJZv2W7KhbKsB");
        state.setStateCapital("DPjpedFKiOOTq67aqqmpqqG2ssrCJ8s6ONimjlzhqKBMyZyHF2");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        City city = new City();
        city.setCityLongitude(5);
        city.setCityDescription("RRlb8xqi1ymSeOGumUGwcQnlAcFdMQCLhiItFLoaQfHJWyciNO");
        city.setCityLongitude(10);
        city.setCityDescription("ysqNZNXaE4wP5ToN9m4TXrtJhgxpiA31RfejSav81rFVWSIb2u");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCodeChar2("bJzIr9ysmizRoViHlwltF5eUuumtAp8N");
        city.setCityLatitude(1);
        city.setCityFlag("f1twNADZelWFzlXtbuBzOL0rtSqT33e2eJmpZP7lUX2vnVM4GH");
        city.setCityCode(2);
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityName("e7ZXlAEDGzRTJKiNrxLzoLhE4A0EQgMTVre0oaXCLrPARhqfDJ");
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        address.setAddressLabel("d03AbkcLNxT");
        address.setLongitude("EUgjjRlIaBBkRIjxxugMZZFVtI806k2tu6ZhvSQycPf9PjvO53");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("djy0d6");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress3("aoXPOQ00h9tQSByQgvcYbQrWHkuFK2Gm2yiWo0UIPAhFevc51f");
        address.setAddress1("6u2fDhqV4HudjD4UBcWnI516fbsoS3JbkfzWwhY3HJu1FD4nYL");
        address.setLatitude("zVmsEMepisoPo7SViUXCTKh3A7pTS1iRGsKgstae5S7yxjiWU6");
        address.setCityId((java.lang.String) CityTest._getPrimarykey());
        address.setAddress2("utdSsAamH9DZ34pVpPQGYHkBcGMZKZ66TiiYpsjyJ7bIWxiSLi");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        corecontacts.setEntityValidator(entityValidator);
        return corecontacts;
    }

    @Test
    public void test1Save() {
        try {
            CoreContacts corecontacts = createCoreContacts(true);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setDateofbirth(new java.sql.Timestamp(1459405512854l));
            corecontacts.setNativeMiddleName("Se67vUerA58Vd2L2fBkO1gFNYdoXVHf11iJNvhUgr6a95AzuNW");
            corecontacts.setAge(53);
            corecontacts.setFirstName("j9gMqWio96cKcpn7lrkwtHjKA2I9jkQTW0cxGv1iXrwPtnVKpy");
            corecontacts.setMiddleName("MbJ9QJKM9ZjP3pYd7CHdf0sOR6aDbpdFCJnGs1e0IYqtPmCgSG");
            corecontacts.setLastName("Gl3qKeDNEzD8im73sf8jzq4NGtaOPjPTTEneIVDoi2LqkJ53yI");
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1459405512890l));
            corecontacts.setVersionId(1);
            corecontacts.setNativeLastName("6wwRXLRCmgZFJfQ5xnSk1ucZBpRuQ6yu6e8VlkVtMWWJ3S7wKr");
            corecontacts.setNativeTitle("aRO8fdw7F3CTDSB75UC9DL03yIxydQruNCu2TScrIgsIpHTWpS");
            corecontacts.setPhoneNumber("HXG5iECHK3dL6jBRPIL3");
            corecontacts.setEmailId("3P9jlhRsOuutEy9OwaxgjCs2ybNaYUYoZCYCfz4SW5QPy6OjW2");
            corecontacts.setNativeFirstName("ULRXCVPI3VxqIIGdi5a3P8ZfK4IAEBqVLm9L0XGaBaf8fr3wfb");
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBynativeLanguageCode() {
        try {
            java.util.List<CoreContacts> listofnativeLanguageCode = corecontactsRepository.findByNativeLanguageCode((java.lang.String) map.get("LanguagePrimaryKey"));
            if (listofnativeLanguageCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytitleId() {
        try {
            java.util.List<CoreContacts> listoftitleId = corecontactsRepository.findByTitleId((java.lang.String) map.get("TitlePrimaryKey"));
            if (listoftitleId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBygenderId() {
        try {
            java.util.List<CoreContacts> listofgenderId = corecontactsRepository.findByGenderId((java.lang.String) map.get("GenderPrimaryKey"));
            if (listofgenderId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateCoreContacts(EntityTestCriteria contraints, CoreContacts corecontacts) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            corecontacts.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            corecontactsRepository.save(corecontacts);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "firstName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "firstName", "GXav38hO3dwPnliE0RLmNmw7811Si7jOAO8GuHCDlhEUrifZ1RlkP5tadq4c9iz95z8FzFvOFHbtyeN2aeNkLrzx1ryQ4Wds9q4fKI2yGekpkva5es2rbWPvueiJdYfyepdoN0hXnsce5pUpevQcZWWCTMWOaa3X3pCX0AFozrlzeKmOPvQs74bvFwwSY0ipsBFgRIPSfsTxLrwScSTW9lIs3zJITTWq4FVS3eYPj80bYCwHLQx5gxHiUzQrNVP2g"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "middleName", "4D50vSs2TQtvl4pFmnRM2dRZ6dgQAU7UwhziYdP0LyuQz9kRv2Ada3cNzRI6kzzl6MRBVRM1plG43q8NzcBsO7oKLPhgBbswP37OmuLJwz01dQLWuu5d9Qdlo2qslMWcBbRDYpQdvdlI7jVi8vbnLTR3I8LuY4XCpqETZzrioZ6oxV0ANvjFTXI0Y07auHr1jlbfmYw3D4S20Wsspf8JjYgvNH6kxdK69TwlsgDn5z89Zrz3XQFTzeTk0Z5x5vWP0"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "lastName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "lastName", "gzht5izt7dR6ZC0CBT6wlXvFdcLIPUfnRfmBxvgbDbflBBHypCS0AxbWavmV8mlcT6uCrIYFNbLT7b91goeAdQDsItEC6fd8GupXllQHvh1uhURnkalQwcTy6BJPd9mUDy3yXz7Hi0e6DDO8Mn6KgUzidQMFefAYTYkh60UrskklDgDEbCYHdfvAvFE7xB2pepMY6JYWDOqZIzg8GE7iNrc4bnjxmHghFHMbWqnzfaTaxM6RIJI3Q7tQStGRtXYYJ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "nativeTitle", "egEcYmHblk6peUDxn5UfNksBXYJEb7yAZsAk5gQKdMj66NQNTUo7bTD6JlG6Drvt4"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "nativeFirstName", "QrcaQsLdnRGKKNv4fnPR0YM2gRoLQ7tfmNW8JTeugE78SX3nmiBLCTOF8GyJhHmnDAhxlMoLxW61YnfkMbNDiE4x9f2V7OhrdBuHDwOLwCkuEj3CL4NXOjtMP5iZeArkCtBC2QwPdmYRfVc5bY8zuIShxbgPMVdFkOWy9u3Sqc0F4az6QxFjrlzzMhpeUld2Jf7RvKaFIP0BTJjvvGbrZtRBWb2q2OSNC6GlI2ZBpEQPZAiL6yMloLBvgraI6OVf5"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "nativeMiddleName", "hmL5c5KXF5A0tzNMZSZOvbvYaxQNkOM2rH6SCRvo6lkwPNCYTJdwLGid35xdLOuJruyPPn6SEm44JMD9K9mGK1L7oQNP5UCylxck2AyunbKXb1rGXNsv5M3ZR9YZ2YkS9kKzRBp89uPbcvTrHqIWPsFAJHM2pxR08XTTAs6oLf5TFK4Vqy44qON2QvZXRaOoKspm8C2QGmS4eD7OGnpAaehv6JlIvxqP3bL9I0M8Guonyd0QCrbAehkyuJM0NrPKY"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "nativeLastName", "aBD5Pa3pElvPtyZY2sLLCvv3J0cVPXDQ01qfbG3i9thp9JwuHakN8BHNvfNk2tNpMTBW5xx7ZgZIfAhh6uEIam5moLgrMOVF4xs1Y6K7wws2Xd6aJNM9szUvJSIIsrz1kXLJycjKGOZnMTlDBh2ra71rakIdNTJ53RXMISOsaoVOi8mIqsNjJLiU7xG9NuBlIPV2ZqWKVftTJBO0QzEf2hiGq4XLCybkbZLQZGpMMn4deQKpGNqREI1Wr3MQ3Gg5l"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "age", 171));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 11, "emailId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "emailId", "LMLfdyr9hcz84UaaQCiiEP8PRH4iBWMn0DxYiyEGBibukl7mfZDAwkoiaPtRuhhuoVdyyftvKpgLbpqnfpSQVWd67uMAtvTOGBiIh2yazjhxE7CzAftFoOSkWHG57DGzkcsDKYLsEi2qY3wenoKCAKDk94edwFjxDEBCOxZGsHl3g2ETW9noXYM8iJOYyH0tNykFKtlvkujzhvai3jCsHI7tk9Qg2LTplN6148draO57KThjPmawh8hwMQ2gUhZTm"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 13, "phoneNumber", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 14, "phoneNumber", "A7gg8p6QClQljDpWbgzd7"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                CoreContacts corecontacts = createCoreContacts(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = corecontacts.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 2:
                        corecontacts.setFirstName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 3:
                        corecontacts.setMiddleName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 5:
                        corecontacts.setLastName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 6:
                        corecontacts.setNativeTitle(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 7:
                        corecontacts.setNativeFirstName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 8:
                        corecontacts.setNativeMiddleName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 9:
                        corecontacts.setNativeLastName(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 10:
                        corecontacts.setAge(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 11:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 12:
                        corecontacts.setEmailId(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 13:
                        field.setAccessible(true);
                        field.set(corecontacts, null);
                        validateCoreContacts(contraints, corecontacts);
                        failureCount++;
                        break;
                    case 14:
                        corecontacts.setPhoneNumber(contraints.getNegativeValue().toString());
                        validateCoreContacts(contraints, corecontacts);
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
