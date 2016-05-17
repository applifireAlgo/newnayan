package com.app.server.service.organization.contactmanagement;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.organization.contactmanagement.CoreContactsRepository;
import com.app.shared.organization.contactmanagement.CoreContacts;
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
import com.app.shared.organization.contactmanagement.Gender;
import com.app.server.repository.organization.contactmanagement.GenderRepository;
import com.app.shared.organization.locationmanagement.Language;
import com.app.server.repository.organization.locationmanagement.LanguageRepository;
import com.app.shared.organization.locationmanagement.Timezone;
import com.app.server.repository.organization.locationmanagement.TimezoneRepository;
import com.app.shared.organization.contactmanagement.Title;
import com.app.server.repository.organization.contactmanagement.TitleRepository;
import com.app.shared.organization.contactmanagement.CommunicationData;
import com.app.shared.organization.contactmanagement.CommunicationGroup;
import com.app.server.repository.organization.contactmanagement.CommunicationGroupRepository;
import com.app.shared.organization.contactmanagement.CommunicationType;
import com.app.server.repository.organization.contactmanagement.CommunicationTypeRepository;
import com.app.shared.organization.locationmanagement.Address;
import com.app.server.repository.organization.locationmanagement.AddressRepository;
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

    private CoreContacts createCoreContacts(Boolean isSave) throws Exception {
        Gender gender = new Gender();
        gender.setGender("umkG3sbyBieswE4xRgDmPreeZDzk2yVquUcUV8I9iVeIGI11MZ");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Language language = new Language();
        language.setAlpha2("yV");
        language.setAlpha4parentid(4);
        language.setLanguage("G5iQAria2M8HR3MgXUsY87VxqNp2ivZyeRstse2Qi0OLVN6FGV");
        language.setLanguageIcon("qj8ClHrq6SvA5b8A4VACeeLVHfowuFmv59G4ar3BMlPv0Y2jq1");
        language.setLanguageDescription("oNeYketbRQ8SAVgBN5DSpjqz9QZ5HRjS153zz5rTVGPOm13gtR");
        language.setLanguageType("hQHwq1vqyu2FR62O1HPL8Uf64IpY8G5Y");
        language.setAlpha3("919");
        language.setAlpha4("F3Ym");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setCities("Ji873LvOTIaSIkTKwX049aSt9RdMuePmbZ0QSK0S05Rv2a5F6i");
        timezone.setUtcdifference(2);
        timezone.setTimeZoneLabel("0lDCheaVDAMvEyK3dFT2wOHO6g8p70yCXgF77KXRtUFhkxMvHI");
        timezone.setGmtLabel("lyKlsVjxSVzZKdTBH7LdustXECaMAJQnBabNvmX03sSBW1YayG");
        timezone.setCountry("kcVP6LMvA5AKcSWqXh1DuU5ldfNrDTv5w6bxOKBiYOwtC7Zt7W");
        Title title = new Title();
        title.setTitles("6VqEFiqfAUwek6XT4uGx6Qbn30b8w0tQpzcM6AIqd8AX8w5JJ1");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setNativeMiddleName("30Of0DvtvxjnwktMEj2EOy1xgAc6lfIesUY1qqzEoL9lxgS0oF");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setAge(3);
        corecontacts.setNativeLastName("9EgTkraJiRv5X7dUO9xSifLVwjuqcdSC6HbjMS32cO9paudI0p");
        corecontacts.setEmailId("1DakfSOGhoZFaL62ARDDSrbNbFcT36ijHRH4CsF1gjxpaDN0oZ");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1463464635043l));
        corecontacts.setNativeTitle("fGbgjZqE74IfS40P2jUgJXnHKJgwhBvoLECX2XE6OptsQ1d0Y6");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1463464635426l));
        corecontacts.setMiddleName("ok49Ul0knQyKn7qmGRd6U0LkqmlQaCSQ7OFCjMwUEwL6zQjxaa");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setFirstName("8rKZMU6YSxfefYSGnfIwkcUO65EGw8SST6TOsv6T3nGbRke2VR");
        corecontacts.setLastName("VrjVXRhvnN4bujoGm4vSKoXUhFRON75KHgT5TqlKW6aLPWM41W");
        corecontacts.setNativeFirstName("Vo2bzHdpGLbu2DgwaakPE83eK2DDJ3Jo4CWnNmOT9WinNlYdvE");
        corecontacts.setPhoneNumber("cxbgawUp5Qw1lWZOcE4S");
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        communicationdata.setCommData("mWPxnFvrKS");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupName("LccVfr4Ul6icgEda4g5N6DnY0qGKbk7PhVyxMWY1Ntr2aOXWT5");
        communicationgroup.setCommGroupDescription("OtIpGVCnHALip92mfG9vtkCD93uI01fOmlnCDsAlpDFyb4yeOR");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeDescription("Ry5iX2q82xmxaZOFQrukJmNBmLrfZFW8wWhoeiB7LG41oZ5vzh");
        communicationtype.setCommTypeName("vQmOOIUYzTbQpJSQhxBV0uyg8EeqtyhrjWQJplmhau34GDJ1DZ");
        communicationtype.setCommTypeDescription("VtCeWkPWQxZ07OWI1ZyiH3GYBzI7k91e0CQaRBwP4QYmUnUIo2");
        communicationtype.setCommTypeName("uGpaEXrDb5X3bBiQkIImJfftvBf5x128enrP6UKgGUsQBDizLc");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommData("CBM8nDTHZ6");
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setAddress3("zqeJLUXDK7N8FBJmk6wlMyPWYHHJQdDxfYPO4bTadITTNyue7O");
        address.setAddressLabel("7usa2g6MEGI");
        address.setAddress2("rAEVfuCphWpbWPkRh05ZAfdopg7L8GjHfUMJM2EmQu3fNZ2DND");
        address.setZipcode("WAtOAc");
        City city = new City();
        State state = new State();
        state.setStateCodeChar2("q6qf56mZGSRevI1zofrU1oPC0jbMZZ9F");
        state.setStateName("tdEkVhu4hkR0QjznnDeqouQUSZ1LwqqmHdNL5T50elNRZ9amGn");
        state.setStateFlag("JWPBbBe3HX0JuEIAsIo4Fyh4Rn2kdb0q1qCYGZjECoGOhshKSj");
        Country country = new Country();
        country.setCurrencySymbol("KHB9RT1RxvhcJJpFW2519IN1QJYLsu32");
        country.setCurrencyCode("s2h");
        country.setIsoNumeric(294);
        country.setCurrencyName("9QCG3L1Sp706Ecs1LtSmyKuwrUdTwINdLIU6nR9mrdtKEGoffI");
        country.setCapitalLatitude(1);
        country.setCapital("J5WHFmX4SWrpAgWE5wBNRhhI7O9XrJYr");
        country.setCountryCode2("81P");
        country.setCapitalLongitude(5);
        country.setCountryName("lUxCipHU2r8oP4UBJkC5rPbE6tziSGlYE1XmjXxbN3xU9uxG1P");
        country.setCountryCode1("Feu");
        country.setCountryFlag("0T37Id8Bt2vW5QNmXAC6lMgNnY7wmbuqIwL8DiVcZE16iLoMkr");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setStateCodeChar2("9GdEP887BCpW1FlwOCMR07yHpTYfqrJ0");
        state.setStateName("qHx5jqMJPCf3AW9644bGpwHj5SwYRzWhI53vFCZrbhpDKP9a5P");
        state.setStateFlag("yltBjqLu4Ucf2Mk17bsPRJPLOAexjF4WYLw74GUcIEjtQ9ZrS9");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCapitalLatitude(1);
        state.setStateDescription("Y0VPqaM7rCtcxh9pGySjFtzJGaqybOKpQoBWfD3t34rKVBNvjJ");
        state.setStateCapital("l575255okXJQBk2kwwVTXfuXkEkY2l6D8gnsmu8MTS6jwn5Rxn");
        state.setStateCode(1);
        state.setStateCapitalLongitude(1);
        state.setStateCodeChar3("NbpqPGeMsiIUeUDQ5HwhrgtW4EgzVliV");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityFlag("OPfEkeV87EWUswgt3X8vJYO0P6dwbfVkWURIR1NYLeKgFb1CVI");
        city.setCityCode(2);
        city.setCityLatitude(5);
        city.setCityDescription("cEW9TNZGlDYbbPNbKR9W2weTnrwPyrpp2Pkb056iaPNKGNlnxh");
        city.setCityLongitude(5);
        city.setCityCodeChar2("gd6F4YOn0JZ4zWE2co2ffbUfQZeVaTYP");
        city.setCityName("zOhqPHP8MroonRS83Cb4c0NoAEc1KVOMKebqD331PllNPHb6rR");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("rCDxaUekPBgGjPWaNg1wVyEOuZc1eye88lFuicy3D5pJ80ef1F");
        addresstype.setAddressTypeDesc("HkJ8AJhP3tIboOcnfdamQxTJtwhXFQtwCy1tqJbSnNw7IXjDus");
        addresstype.setAddressType("B4JBrd7kTGSXMGeM4L13UgFw5lp7K5KnPEnB2p1fisFQ7IXZXC");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        address.setAddress3("L6l87F0BQ793Ldgf7Aemy5pXgWx0oGfiXiaHAaHU1Et5rVUBSF");
        address.setAddressLabel("L1bJzNp64C0");
        address.setAddress2("1F0SAZPyIVhcjPDQo3oPe3gCOKtKVcbYhO5CWpgMDjzOxgpHpZ");
        address.setZipcode("WJ2Ibk");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("xQek6Aa9DHvAZqWdi0qYgySEZp7FWzM2vpJq4dnXBrVza65a6t");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setStateId((java.lang.String) StateTest._getPrimarykey());
        address.setAddress1("3Rtme12Lk5FEluf7iSco6DdxwY00UAQuO5xNq40NZXmt1DvNIJ");
        address.setLongitude("2s3mStEPiPtxfKv74WWrMZkZNhTUgfqOE6ezf4ITOFXnJAHvZy");
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
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

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
            corecontacts.setNativeMiddleName("fBlV1oCVPPRt3dfjWzZyGdeuvPEioLcRXWvZBSH3wV77fFhGBR");
            corecontacts.setAge(108);
            corecontacts.setNativeLastName("QIaoMkNIMXWNpcI4N0VrMKNkogunA04rW2BeLXKaGet88MXvfS");
            corecontacts.setEmailId("5c998EesZYAQ7WsU7uiQfDCDMIVcdSGVd3WZBSsZWrDI3p3Q8p");
            corecontacts.setDateofbirth(new java.sql.Timestamp(1463464637849l));
            corecontacts.setNativeTitle("bpasXvwwiTQukVWU1h9l9jrlRF3uS61Y0HnVl6Re7k5IwmXoE5");
            corecontacts.setApproximateDOB(new java.sql.Timestamp(1463464638103l));
            corecontacts.setMiddleName("fBzuojI8d0kEFZXhbGxCZMO1lGCv0bkkZPMG9RIHY8p58Onrr7");
            corecontacts.setVersionId(1);
            corecontacts.setFirstName("L6xwTHKLnSJlXdaaflwrL0y4tXkbuSfEmuB62Naa1P6vMd8pjE");
            corecontacts.setLastName("PQi0l7xuK4pwnZLT7hdlCv3kgpNJSTx1xAwbs8bC4WUByIVMnI");
            corecontacts.setNativeFirstName("BvR94NCvhvRenm1QXO2v9rdMsEnnfahN2ezv9k0pKGZsU3K4Ec");
            corecontacts.setPhoneNumber("OL6oWctCsAEypmVcf8fi");
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (java.lang.Exception e) {
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
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
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
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateCoreContacts(EntityTestCriteria contraints, CoreContacts corecontacts) throws Exception {
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "firstName", "gk4o7KYS3gAPafkX5YNl0J7w7VuMnCDZR8VX1NCKD1fUmRQm6uWjuiX3z0Ch0rE19JNX9C6X0DwWsohjTCk0EdNDVstbHzu6SokSM89dN0TSwRCmFRrwc06MfpoVSn6WzFURbrekas49qbaVczfhNplsBGyvPtOuPizoFUUCzdlyn0oTQuuG4NySWrJfF1tmMahsEZiCnyYuVrqMf5gZhYeqKCdP1efEe34mOTvE2ChL3ZeSPMzt5EtsDuGZBvfM8"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "middleName", "tUUkHUQP6qg4sIuiI3eT0qQq7Aqsh7Qf9VlpxAke3zSC9oH8ReSLX3iSZTsC2mlBjpz6dgsT46Bdhndox1RrTVVZeVoYXMTUNrYJbnT1GVymyw5hR218xpYLMbdJJon9C7g4DKXBGAd4dGv2qwiBo45mEuULe54UYwrAdPKBePfwnH9k5FVs9xTttKCORWv9n4oCH1k34lgAwsSoL8JIZRtfvGDPPaVDBkx4DkjOjCu273qmFB0SAvLoGZulfU6mc"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "lastName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "lastName", "MdgPRTClXmtnXafoXK8peSSaRaKV55kW6bThUTaEEmkt4n3yTc8MhZan5YdSemZhgE2juZ0X2XFbhL8L3MlsT8V6vpfOms1G8FtVwh6pTrMKaOZwjRWETln75JsyLzaW24J7Tbzf8MpOBLmfhKNaXoeyfDsBZOX0UWnu7FYnQlAuPKIn9ttrmrYCL0ADD268QIFt0Up8RkNVZ7eSOFwWWL4LRthWdrRc4rPS84MWLkHxCcq6z8eI6URwZPLwz7r2U"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "nativeTitle", "wAYhvqMW7ZoXjwUgKdxiozpvwN7nOc84V39g7tYeMZ48o0QwjHMDXQql1mHsKEffR"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "nativeFirstName", "UsicWGPWLfhUtYyPmGhOz2bfS2Gs5Z1baKwDPRnp01hFsY0z6dG1J33nNKTstyNaCGDsObZO5WX5rOrZDcR9P9f8ij0awJDp2cWU0g0C7us0E9Dopqr78OpXc38ehMqUgJTiBGsKMfaonmj5LnVTxatrJsYN2WWoj01joig1iQQWrRFTvAOV24q4kQDxfjXxwbMm2P4TkBw8lweP8QbCjPOzHmyAOvFNNTHNbOj9vaX2PPcFTBnwL8q7R4mKKvUyn"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "nativeMiddleName", "n4tP5FzzA5c1MTcmCGjLH3SDyPLQrBUeUSIInPvRUfqO0dVBmE9okJ5dVZ2MFbed0yZZvjeLEgjzfC93lwcHTPf5q7qvNJon71C7p9NzPVzYl6rdOTp51UDWZ5PHRw96Iu80J5wDCxRjjbVXMC6gJyAbpz2swEOc926qbn0BEdOAX1mug72msd5s52Yjnv9GYWWdLfG5A6RYC7TR6H8GYTfacmHYxFdrZjCEoDRK0nf2gZFE4Dj9TeAhl4SeS4G1X"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "nativeLastName", "A4QwxOXexGu7wXJKsiJZZNcm7UAyUORJQkhGnivt1tOGEr5xEhmJhpuPY7v3OyZCYpLsT9g6AAbyOQPD15L1idxPSxSiIVG2SLPsXUs6W34cYzZqAUmNLURJqA6e3dLMHeIZ4QseCN2lX30lUkhcNSrORShq2PIXZcWvGiYK88GEeNnrsqniisiteOhq3q4PxGfaqRN2ttzS3d0l98LJLnuSKgsQqBf3XkXE1TaVzB5lHkhgrJzyEtuikyG0Ht5M8"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 10, "age", 168));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 11, "emailId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 12, "emailId", "htwD9htLxTdN4tOw0BZTkhynm59zh65vm8wp29MGmhL937IrzQW7TzUsaD5xj4I7sCCMzqGZMpd1TvchqUyS4sUAHLQGwnB7YDTeFToFgV6DU5RJcPffgnhrrNTzzeuIcq7Xs0D1aAQFJWGRZO3AuBxSCT0SvGIhV0YZ9eAoqh5k6H7Y1UwL5A63EOrzDjHNfPJIPSxvY0IrCr8yU7Mq3zw1JOdcRZB7MZgKlal1S2DwYsBUaR2NZdh6ol2AWkxK5"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 13, "phoneNumber", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 14, "phoneNumber", "UJBKVr3B5OQYsKUVnxuw0"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (failureCount > 0) {
            org.junit.Assert.fail();
        }
    }
}
