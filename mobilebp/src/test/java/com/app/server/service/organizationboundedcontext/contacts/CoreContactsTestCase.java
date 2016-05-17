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
import com.app.shared.organizationboundedcontext.contacts.Gender;
import com.app.server.repository.organizationboundedcontext.contacts.GenderRepository;
import com.app.shared.organizationboundedcontext.location.Language;
import com.app.server.repository.organizationboundedcontext.location.LanguageRepository;
import com.app.shared.organizationboundedcontext.contacts.Title;
import com.app.server.repository.organizationboundedcontext.contacts.TitleRepository;
import com.app.shared.organizationboundedcontext.location.Timezone;
import com.app.server.repository.organizationboundedcontext.location.TimezoneRepository;
import com.app.shared.organizationboundedcontext.contacts.CommunicationData;
import com.app.shared.organizationboundedcontext.contacts.CommunicationType;
import com.app.server.repository.organizationboundedcontext.contacts.CommunicationTypeRepository;
import com.app.shared.organizationboundedcontext.contacts.CommunicationGroup;
import com.app.server.repository.organizationboundedcontext.contacts.CommunicationGroupRepository;
import com.app.shared.organizationboundedcontext.location.Address;
import com.app.server.repository.organizationboundedcontext.location.AddressRepository;
import com.app.shared.organizationboundedcontext.location.City;
import com.app.server.repository.organizationboundedcontext.location.CityRepository;
import com.app.shared.organizationboundedcontext.location.State;
import com.app.server.repository.organizationboundedcontext.location.StateRepository;
import com.app.shared.organizationboundedcontext.location.Country;
import com.app.server.repository.organizationboundedcontext.location.CountryRepository;
import com.app.shared.organizationboundedcontext.location.AddressType;
import com.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
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
        Gender gender = new Gender();
        gender.setGender("kFrnFg5T9iNiTcn9cBsQsHJmUqdAQlWm1Ee56QY6AsmECH7BxC");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Language language = new Language();
        language.setLanguageType("SNbf1nBQRrIMRO2gZ5gOuBc9RYyRXyIl");
        language.setLanguage("qT94khmWMMvgxFQIF07Egs21M3HEFmMOkRA55wOh1PEHwoFoLb");
        language.setLanguageDescription("kXjRJDW2t5yR9lGTBGPK2j8Vbc8NOIMTIAabFPQiUrUxykuaLe");
        language.setAlpha3("3G2");
        language.setLanguageIcon("WUflK4PTRYUXdiug3KOMU3gydxNZgVm7jS2P4l6C5B9k7j8jST");
        language.setAlpha4parentid(5);
        language.setAlpha2("2R");
        language.setAlpha4("tYFx");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Title title = new Title();
        title.setTitles("zfjtyUQ71cD8q4d2jkVihgNMB2eZZuhFfPq2nOd61zOzGa1rs5");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setCountry("9p0Z22C78HHpoIdkYMRtWFjkCobwQQRSFpZQCaqMz5bnph45wt");
        timezone.setUtcdifference(11);
        timezone.setGmtLabel("eu7eoq1DPOigblk5Jx9zcsKx7CkYGdY2LUSqpAyGkcPtlM7A0o");
        timezone.setTimeZoneLabel("yerjnbbviPL051aqFIVc1ccVSpPX6pnkoTnjvqTUpOk2589ziy");
        timezone.setCities("e6axoXg3ApHa54aO8I67Y8WsHlv8NQx6oKhRRYLLsUj3lFOqQ4");
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setEmailId("ougm2RM1DTCevGmzrYat7ml9SmV9q3HLWCx3YRwvW6SiLuC7l6");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setFirstName("jN45An2dsKd1O0LMwvLnpCfHMx5pz3uTRFJTVkrcvpCr9ZxiOh");
        corecontacts.setNativeLastName("PqzVtaP0WRoghSlf1v6hz5MvwU4dX4Sbkj6FPMGRNld1v17F23");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setDateofbirth(new java.sql.Timestamp(1459231576902l));
        corecontacts.setNativeMiddleName("PgEy2D2CVeNQX0DVoS9TmKDGADnAc6YKZgiBvYvT8WGIaATZvG");
        corecontacts.setNativeTitle("LrWqiKpMPYLRy73NTtKxL5NdYF1EUm8Ux4rCyovLkONGJRgnZk");
        corecontacts.setAge(53);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        corecontacts.setLastName("XJrBabGggMT0PfymvDVvA7pq85GHd3OdxxtAxxZ9JCumkOM2wG");
        corecontacts.setPhoneNumber("TqZNyaxZm6ZAAQNhhS39");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1459231576969l));
        corecontacts.setMiddleName("zpLPCE4LSOt5oBocviIHVraBU4qdjUEg2PTU8ZjC5O9wITIDol");
        corecontacts.setNativeFirstName("eCEP6uVdsJHTc6c7B5JR5whDBvUETsYcExY3zOzsA4aoqdmwOd");
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeDescription("rT0TsjYPBlICL5UceKjooJpqzsYqCNJYdLTOiB6Xc02pbmxnlP");
        communicationtype.setCommTypeName("7QunuEFeW9PYB4isophwUthxiNpXK73nXAgOcC5dcVvj9bIJxQ");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupName("1GprctwAdYmZmwkReGqLiZZLRWGwEiqKsfv28ynLS96bfvfgmi");
        communicationgroup.setCommGroupDescription("kBo59SFBgHQY49okNv5r1RKzpc1QzRUCpExZRC7ZZniTQO78hc");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        communicationtype.setCommTypeDescription("UWZPPLvzBi0ZGmrRfxXvzVUqkU5XepOKs2KHpK7mtbipfcABc4");
        communicationtype.setCommTypeName("mKC7tgWHkcrKBSzhc9R8doDYjB0KhVDh4nvbvUpCTvOEhcXXNb");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommData("");
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setLatitude("04zQAb6Jpj7GicYTRTuvJubWzVVLRFUIx69gbfNGSQAdJ4XyUu");
        City city = new City();
        city.setCityName("XXVZj6jgnvx9UCPdo5i8EHFKVBfiBrDqGp7gng10BiqxcYFpx7");
        State state = new State();
        state.setStateCodeChar2("7c6o99ThTz7YMa7iVF3alWoQTqLUDZNB");
        state.setStateCapitalLatitude(5);
        state.setStateDescription("dXqr2KSWuy1kx076SmganO7ZtTAjrX2xTbJVls6V6KdHUy4mGt");
        Country country = new Country();
        country.setCapitalLatitude(1);
        country.setCountryCode1("kkX");
        country.setCapital("ciC6CZgEq5QKW82Q06VumSQTblqtYNH9");
        country.setCapitalLongitude(5);
        country.setIsoNumeric(57);
        country.setCurrencySymbol("orAk0B6hAJlTH2JuGJbB5XQFjpS7T4Bd");
        country.setCurrencyName("SVdq4MHdeBehs92xcQQFbWlTFdFVmrbR2M9yYl2dqS7KbIcPBh");
        country.setCountryFlag("KJic7X5SlcWOHJ64gBN96MSC82EjuD2ZD6lrdvbgkaOceAIsqw");
        country.setCountryCode2("bsa");
        country.setCurrencyCode("lhJ");
        country.setCountryName("LJRuLUZ6E3R7paInSMN0MmFSMQkfFqPRMGY62uM4548RxK4I8J");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setStateCodeChar2("410vUCCdGYF30O28ZopyBWNLeCNFGstI");
        state.setStateCapitalLatitude(1);
        state.setStateDescription("OOP85UIugE01PjBnbj4aRZYXtrnajABbdLMsrMXmVRZ7ggpfwz");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCodeChar3("Wbg3MTOOMfKSanzhSKIuuolSlScFYX5S");
        state.setStateCapital("9i3LxdHVNwx3jUA0TXZL8eO7ml9R7WLuSHU8fEDUjJZ5dRWoeg");
        state.setStateCode(1);
        state.setStateCapitalLongitude(7);
        state.setStateName("aJKQbDfK7e2Wnrp2Yji7BRxPkKyIrA4lln6dM0POVK0dg0xCia");
        state.setStateFlag("ISp9c8nDwMUQDkDe4D5wXiAN61qOyDLJaZrR5RAsRopunWcErI");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityName("BC5MTcdlyKZ7FlIFzO8HkjrHZvftioecranZI9f2DHnUQACigg");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityFlag("6CGotIvfIUjrSaMuzc6VK4k2P4TvpBShaOuJbRKzK5K6ihfsVz");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityDescription("Z4YywG4ZqRd7l2qjtKVMEZ6BOvJibdnGAHFxjrLkW2fO6lqEd6");
        city.setCityLongitude(7);
        city.setCityCodeChar2("52zesfcZ4hmLxKEp26vMJ7Y5zlPwQXqN");
        city.setCityCode(2);
        city.setCityLatitude(3);
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressType("K8zvtOufdtRFYKnYPntUCk6LPdhllA0tE3XW8pa8gTmcu9vZ1z");
        addresstype.setAddressTypeIcon("P3XNMf5XMDWzCrSR1Wsj2BWzXwKiLaAd6qBSr7TzPPgeUKg77Q");
        addresstype.setAddressTypeDesc("1LsC88fLDV8IcW58xmwiATtvZKZ8gKaSeRZTAH9Oe4GlNAqCgm");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        address.setLatitude("dpkXg79a2xkeaeqj4K1S9XM3pmYzw8g7RKeTjlar3P6TxASULz");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress2("8e0MaAUfTH9hVgUHcVlOE4htfE9iXpMKayhLyRtvxMNHTHr30b");
        address.setAddress1("RQ6l9TsVzd61q2STsXI9hc6CeH92WDxOXLtJODBs3l9QAZgpKh");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("zYYAGZ");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey());
        address.setLongitude("VipHEoB50EgOT840pRZcPC7a4HLv1LOlFb8q7wfWqkJZHGc0n6");
        address.setAddressLabel("31DReTYzUQk");
        address.setAddress3("7bxSKlxzURnVwQq4qTpQGHM1VJy03QP5AD7zl5OJcLfYZCi09n");
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
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

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
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setEmailId("hXZmMcRMQ3hIqvROFH5EGDmC7otGCzWWqA3a5UWlXRlD8mC7DQ");
            corecontacts.setVersionId(1);
            corecontacts.setFirstName("qIZcCIeDuwMJwaZ4WwTsDccvFNX4PR8KAobyl0EvhWEA6K2UGw");
            corecontacts.setNativeLastName("MKZBeOoAjnYNf2jcENTpqTwWKK0evxLSccFFPLOxVhIVSSOABJ");
            corecontacts.setDateofbirth(new java.sql.Timestamp(1459231577534l));
            corecontacts.setNativeMiddleName("zt5nnfj1FZ2Qh1ISMaUZZSrg9NUfXk4n4z9dyGRzgOQWPrv4wt");
            corecontacts.setNativeTitle("NLF2begtrVcqVIvdRizBgIhPqyT3FU4BBiubXmn88rrxnbT6RA");
            corecontacts.setAge(96);
            corecontacts.setLastName("q2B0D5XPnnaUbGrNNDp2QLQ36SwnaFUwb9W1rt7ucZwSqQoT3T");
            corecontacts.setPhoneNumber("oHbJqqiKHQDL1PZfb44V");
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1459231577625l));
            corecontacts.setMiddleName("FQNkfsWCtCOYZXZsm3ciu8Tr1kYZstXbAagzmedP6CXGgjYARD");
            corecontacts.setNativeFirstName("KGLzWrTiCfqFFQ0Yy2z1CELuT77pVJK8NIq6jl9MxRLk3QsDR5");
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
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "firstName", "EV2X3Qg2QQRF3UU1Zy8fcftAHjxsvJ018R3I4SL7PRjSn4HNtDYkZYvdjUcfFFJ2jBWKw6xMpUzrLRjmIg7OygLAdZh3HNDh8ELsl5S2LYIFr7ppVLtcrKPLE2lPeEZ9f0zgWPs2zsFwswTg2SPo3hLyc7N18HZHoQ20eCRQlS3aLDVRNMH3IiScFiH46V3tbLQ2Wp7OJm7QmvXL5hGkMMemTJeNHXkHsHO2iXjFHwmfOrHZmG0dZxsCAiFMme7du"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "middleName", "gyCPDbeWCPOYfiOE3xNOE9uHJp5Z5Sh2APBsYXMuzkTxkclvMeEIxgbT0ND0jaOW3z8PPLaBwmwJIth2jtZqFCgobdx9fMaPHldpryLGrQcd9JzjwbOw2PRCHUF18K6sQg4XtyJVVEy6Y7C0AudHh86P2VqOh1gAAmmjEWSkIXKax5pkrzQ4f31RLRLkRzqHlgsMkxW4jlOYmAPJulGp5KVPCxUiV7PLuzfLgkvD0Gnrqt4PdsCfip7Hg5PtfUXOu"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "lastName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "lastName", "ElSuup7CAUlCDJXs1fHXBPWLIbmO9DB5YqQh7QhRpdvR5UVrjaqtg9u9lbAegc7885eh0TxBEdUOj3nbt1MJXuV2drzPwuNN8HK5FyTo5fMG8rqW23rSNQ38bX9oJbNWTU1RuBkmz7S8m88xlGFT9zKX0W73xbqI6dmZNlS9nyzIJJJt3P3xojVrb3Y2wnhvAIYclGHFYS1LRv18UpTCoAPAo5NSIMU4ilBwuae2ZDxNttxSHsXZME2uWs5wiWTz4"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "nativeTitle", "8mnYzFcob6FVGIdN3omGhsxWKYZQpQutVgcVB6HcANRUFZNYOfQgRTxKpxGaTxd4k"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "nativeFirstName", "jUbOhfeiE8VS6i9SdLZYdahTLmqTVSyf213DimNMAARpNo0I4IneB2e68YaG8NgEIVL0cqO32sjOQBBTbavv9d0dJu7IlQlBNRL9qybHou11wnjufY6OaacwdEbR6QfLaFRz2oDAr3wwW59VCiCzkttaav8yNjziELXUg5Ubvo6vVC5qLG5U5D4Q5dEKVa67hg7e0wGBZCtfq0frv3MoC9zgDaf3yVpRySDU67JjQAkqD81BNczo7NZYYTrhOmVmi"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "nativeMiddleName", "2YzFHdfjHLoAMRWd9cWI7NBXu9IlgqwUWSbij9Pd4raBJp1SajudVMcZk99ERPquKtaddnG4XNKm5YSwsEuxSXbwwfbVivTrBOrCRq79Kei9xxOwyDNgFqnbLh48Q1VJV8pDrJ65IbOCfuw9N9uWVsXnqBsAVobb0lqqBCyyVAwsfEA3LqnE5q1UWkeVBAKGZUEYgU3oV84358RANJm8ZRPZG8H7WYm0ntKPziUGRH9YvIXidBoG9qyFDbRd0dtZ9"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "nativeLastName", "y4nGlU43NFxHUBxcx4aHn3TqDofTUOfIu8556IukUIQNDXRgzQJAZYGmqotXWGg47Flay5uXIm7rFruoBMCPHuuAIsapB5S43sr4ODhpaiylKlaHRatssSdyyjuo225SAdalu06LqtmyGYlarhEWTkgemRzqxFXNYa8NBQOquhuwaVXCfwZZesazQ6BCQEE09BzVKO7tmv4OatcklhCZmnwz57dnHfloHtO388SJYJm2n5YjO8poJmL7aynlEyILh"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "age", 174));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 11, "emailId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "emailId", "hrE0vE3RB42kT9uuinoPrpgVlDTqZFmB3OmiEaUzSe5MMkE1rheGDOIF9UrjiXkdmet7n0388JXmeGC9Jl2gl7o294nW1HIYkR3GQ0Vq2zmCaz5ufFnklV8K9nygcnH8vZgtmgNPr78xLqN5u74KB7Jq1yojAM8mYtk9UQH9h5QuTf1eeOBtYa2cEroI77n3rdLakP6xifrSLp37noBCTw0hBQ01CdCFM3pPnk6RUEL2R5A2aFo5KKi0gwgWushKC"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 13, "phoneNumber", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 14, "phoneNumber", "9FKG5GREwsYeOItIMKJxv"));
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
