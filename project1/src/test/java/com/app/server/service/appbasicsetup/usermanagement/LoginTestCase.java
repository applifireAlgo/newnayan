package com.app.server.service.appbasicsetup.usermanagement;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.appbasicsetup.usermanagement.LoginRepository;
import com.app.shared.appbasicsetup.usermanagement.Login;
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
import com.app.shared.organization.contactmanagement.CoreContacts;
import com.app.server.repository.organization.contactmanagement.CoreContactsRepository;
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
import com.app.shared.appbasicsetup.usermanagement.User;
import com.app.server.repository.appbasicsetup.usermanagement.UserRepository;
import com.app.shared.appbasicsetup.usermanagement.UserAccessLevel;
import com.app.server.repository.appbasicsetup.usermanagement.UserAccessLevelRepository;
import com.app.shared.appbasicsetup.usermanagement.UserAccessDomain;
import com.app.server.repository.appbasicsetup.usermanagement.UserAccessDomainRepository;
import com.app.shared.appbasicsetup.usermanagement.PassRecovery;
import com.app.shared.appbasicsetup.usermanagement.Question;
import com.app.server.repository.appbasicsetup.usermanagement.QuestionRepository;
import com.app.shared.appbasicsetup.usermanagement.UserData;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class LoginTestCase extends EntityTestCriteria {

    @Autowired
    private LoginRepository<Login> loginRepository;

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

    private Login createLogin(Boolean isSave) throws Exception {
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setNativeMiddleName("1YboLR4DGoqoMUDqQ39i05v1jn6s16lOREr1YXEhF0ao2FF4ZA");
        Gender gender = new Gender();
        gender.setGender("vHX6m8vbEtNFPubQYjFqG1Tg0WxFOsIpC5wEjPbbD3D9SNEHN5");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Language language = new Language();
        language.setAlpha2("18");
        language.setAlpha4parentid(4);
        language.setLanguage("Pcwj1fuGgkstpmBRDISRntLrnxEgGcKv6dmuEATJDojBcxtDXI");
        language.setLanguageIcon("69RTyVPzF5OvcxEIQXWZztvJxvkjWXsXllI5HOjY83ZWvT5n22");
        language.setLanguageDescription("jjIYfoPdEkkuryeqagK5S52UvP3tZFBXGmaF81NZq29dbqWL2Y");
        language.setLanguageType("DNAy8GQYH5nM99jSw0tF3ljMI0G3Wlxl");
        language.setAlpha3("sHC");
        language.setAlpha4("1fQP");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setCities("Q1acEtBQ1bPqjoeZ8FIHy24ZBJWsR4oJiGKoqLbpKPE3aaQG9t");
        timezone.setUtcdifference(8);
        timezone.setTimeZoneLabel("qwajKN9weqFY2aWyU9B4UuTyTxfd93HmQorzTpzO6c8z2oiIuD");
        timezone.setGmtLabel("0fk5oEvxgkjzMd9GcJjXpBfCjuAAQiVy2BjHKeCfaEGCzO30iw");
        timezone.setCountry("8SMAgyWJju41GCnRGiPizBHOfCI6CpDsOE4l2Zq9vMNGJY1KPY");
        Title title = new Title();
        title.setTitles("AyifWsr0jtqqTGnrsnjg2Vmi4CvIp4EN2zcV9xanqcB8fmtjAi");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        corecontacts.setNativeMiddleName("XH2hyGcq0slwKRh4CGM6bpbZA70D0FrV4Lx67ieGVef9RPDeBt");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setAge(10);
        corecontacts.setNativeLastName("LgN4QvWnThMfzPTWDwUIIXDCkC5NJflh2FUOAYhRHC953EtN9Y");
        corecontacts.setEmailId("Of3Ne86gz8PnMU8IBHXKpviRWWw6SWYPLWfausKynq6vJjx66j");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1463464681087l));
        corecontacts.setNativeTitle("sROhwXheWH1HEkYZU6b0VbzNXHnGkdoHtmOmWYmNMpc2wvSWaD");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1463464681448l));
        corecontacts.setMiddleName("55752Vawt8DtYiTIInlGxeUnyNRglvlGTLThwOHSgMVsKA4ua8");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setFirstName("ORgKJQbzEBglljuNVrIyP0DlRRl4ibgvaQTIdwVroseLmAf2RO");
        corecontacts.setLastName("LIkfpvOwAMeX7ki5qIva7f8E5d24NNMFyx2iw3pIkQ1387etuh");
        corecontacts.setNativeFirstName("RSiIkI3m4dvjiFdtf7nJ9YjB3loqDOuaFT1evTMUv9OFE3OgPk");
        corecontacts.setPhoneNumber("iNKqRH6ZGDObvSXWBPSO");
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        communicationdata.setCommData("enyw1fR0TS");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupName("qEBOhgQrIBFS7tt4pfEr2ef1UBqCcVhljqFz505NnAT2Pzqj8v");
        communicationgroup.setCommGroupDescription("NPgbzKyM8iCkYbw89BRtfCjauM34ghNZzgHqQ90dUMIFaHZIRQ");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeDescription("79mROGx75KRzxj1CHyYDb3c5Krzt0kGyd68yuANp5touTOW0dR");
        communicationtype.setCommTypeName("j6cFcWSPUAmpxmg7tIW75nhOzI246OBrUEoj4WMBLIbi1Pcrsd");
        communicationtype.setCommTypeDescription("cEajJ9Mub85XLHlsOQoOvx02My2f0icJ51QCEkiKnlzuZts2kF");
        communicationtype.setCommTypeName("GDH6iPeR8WbsWgMZAcMN3meTTd5lKxbML6gd5pjLPJMmC2rlc6");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        CommunicationType CommunicationTypeTest = new CommunicationType();
        if (isSave) {
            CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        }
        communicationdata.setCommData("v4Jue9UCVH");
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        address.setAddress3("lmLVbdlPF2FrARtEeoXz8BeOsIanDnXqFaSFl8VWB2rKCJoADn");
        address.setAddressLabel("WmDYJfxuEXl");
        address.setAddress2("BMDdcAz688REvHiYjfcN5xCauYNOpXasUfg5LYxDNhPcLbMqpz");
        address.setZipcode("jLqwRj");
        City city = new City();
        State state = new State();
        state.setStateCodeChar2("iK8BfSpRKZg8LlcDdfUJMTJVhDVTc6Ei");
        state.setStateName("x2wLRhAaYr6EQ2GfI8PgdZyF0OeEH1R5oOjLEz0wBuyhmgPh4s");
        state.setStateFlag("EuHAqlF0pO7MY9X2CHT7RYSZxumCXy1o2bFxd5IExO201GgBmI");
        Country country = new Country();
        country.setCurrencySymbol("mNXNKvx5IScEbNtohvPFd8benOtVQliQ");
        country.setCurrencyCode("1Es");
        country.setIsoNumeric(673);
        country.setCurrencyName("HXjfkFP9QFlCgZkkk1tnLBxNZ1uZaNhXRTnRQ1gTr8NzDsacHP");
        country.setCapitalLatitude(11);
        country.setCapital("XRTNyTGx5fdKQ3Dy3kqib3q3Mf2ifRJM");
        country.setCountryCode2("jJq");
        country.setCapitalLongitude(3);
        country.setCountryName("AReczToyEyNvN8mDjQg6qnyXHZyKDYdN6aRhu6IKRlMhRQH7NK");
        country.setCountryCode1("sqn");
        country.setCountryFlag("vAQekE0SrnQLclByHRPc7clLuC8aoJe4DDhhM6wozL7woJkU1D");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setStateCodeChar2("AyX97cLvzFNOZwR4aCBzg6tR1p3zrKQP");
        state.setStateName("ax4pZej2OE3lTj74KaCpJyE5rYGjDT7SGPtwm9gvdOZ0lANYAX");
        state.setStateFlag("9dBLIwcFiIhyERdvsdVKVksgVhqDWOrQc5XtEj9dhkLDhHDkPP");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCapitalLatitude(3);
        state.setStateDescription("FtKo73GzFXABgqqjUQRh9U1S7FSI8VAuRibHgYlmqLpvgDFnts");
        state.setStateCapital("CEDO60Rg9hHPx2DqCAnpf7ufCUF14rGtUj5x25nkgUljuCV9P2");
        state.setStateCode(2);
        state.setStateCapitalLongitude(8);
        state.setStateCodeChar3("8V1UlVVAkXmvGL1RQagxXJJaY2EKZ9Yq");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityFlag("58QlbxX9syHVC82fqHqUhD7S50aanrBHVIr8ttwKXXyLLhwYZv");
        city.setCityCode(3);
        city.setCityLatitude(6);
        city.setCityDescription("TLMxAqa8Xx3txbnJbtqi8tTzV8UFpLwvD23zg1cF0V7DkxYp5t");
        city.setCityLongitude(1);
        city.setCityCodeChar2("2HxJGEF9UlOaWNtLYrjx0Njql4h0Wi4x");
        city.setCityName("VTl7qKcIpNvgdcEMr2RH8HUuxMR23IgmQQMrx0lmWYwI9FbdLi");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("NMgMwyP62EpwvGxyAk7WUPzGbAXaQKlFZYedMVyuW775P5HINF");
        addresstype.setAddressTypeDesc("ttC6K4jz0ASCYVtNP8t0px0pb1r0QElmlKlBk8RE46EB6kbqmZ");
        addresstype.setAddressType("qnEe56Y62t0C7BMrgIJbSspKWv9ReyAKn59A9rTwxQvEn76MYk");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        address.setAddress3("JYg5M58bHZG4M7tm00jnMNShMyjJwDdEkCdKfuFz4rmLDUdh8M");
        address.setAddressLabel("0zg5Rwbz53A");
        address.setAddress2("h60yboMGlFxJuhoi4luFotc43RWIVzlnS0jSNaDmWmfHio9Kil");
        address.setZipcode("ntfBvo");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLatitude("I18YcZXZqSkgVYFrOyKCOw11WNBjSU9x29xOvZ7lNroA0cCTRv");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress1("7nJ68KyFJsMBKvmYKT5VwWOqEbRHH9tu7xsuWtJTra8gq26tkK");
        address.setLongitude("FUHIB8bfStkZZIMudGatWCBS3W3agQFTfVFKxAP7HKjieiCj33");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        User user = new User();
        user.setChangePasswordNextLogin(1);
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelName("7SzSySmX3dA5Ss99DAzUlXSwUWNM4DVqUHPbvlAG11QP1ijyYz");
        useraccesslevel.setLevelHelp("X4D4UW2TlWvOZ8yN6c4h9OTCfYsaPxMhpSolYWetKXBvpQKekx");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelDescription("ysVH6PRq8qgfSr7DLikeQ58KvNt8DDco6BqEMMppjOZRzcyaCy");
        useraccesslevel.setLevelIcon("Q6ipU3rVxpqeU7G9Tei3ZKwCfVoyhOVUDRdWhWgMvhYRToM2Gx");
        UserAccessLevel UserAccessLevelTest = new UserAccessLevel();
        if (isSave) {
            UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        }
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainIcon("2eYiD4P4Cg4LAK6ldyitN6SDyocKwdzWA8OVMuDCXuIuGRUt47");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainHelp("UwkXcgaVJisBsZ29qOtx93x6yWe8EDD1hdcljTQBACiRIMlLu4");
        useraccessdomain.setDomainName("6RtdygNbrGfKRpf56O6qGJhH9TjmfRAtH0UOeMKXSgKy8lNzis");
        useraccessdomain.setDomainDescription("SNdBnsx5esoK6oOwqAODxkBJayl3Qbo3Kn9vfjMrJ2JJAaQ5Yw");
        UserAccessDomain UserAccessDomainTest = new UserAccessDomain();
        if (isSave) {
            UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        }
        user.setChangePasswordNextLogin(1);
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setGenTempOneTimePassword(1);
        user.setMultiFactorAuthEnabled(1);
        user.setSessionTimeout(413);
        user.setUserAccessCode(38620);
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1463464683903l));
        user.setPasswordAlgo("WETfYXCChRKOeRe8F19f0SWHmr7u8EmKhzi0hiirgGJT3mrK27");
        user.setPasswordExpiryDate(new java.sql.Timestamp(1463464683903l));
        user.setAllowMultipleLogin(1);
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setIsDeleted(1);
        user.setIsLocked(1);
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        passrecovery.setAnswer("WA5vLT8S8YqN4JY4s3hF5njhm0zgyBRC7E7tsYINF0X22w66Fo");
        Question question = new Question();
        question.setLevelid(9);
        question.setQuestionDetails("b5pp6ZbgZH");
        question.setQuestion("556r9zHBPCdQVtTHqFDMSwGbTwFFoDIwJXpoYnXh5mG05tSpHb");
        question.setQuestionIcon("gVd65sXS93G5hzJRbrdfZPHGrWWdIfAaE1P5qiQ7S5WreWgNPw");
        Question QuestionTest = new Question();
        if (isSave) {
            QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
        }
        passrecovery.setAnswer("8K7VTa7URHEOgAhvBGr7fWv1RkA8FbwOUmRlOnaevza0OmeVoO");
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey());
        passrecovery.setUser(user);
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setOneTimePasswordExpiry(4);
        userdata.setOneTimePasswordExpiry(10);
        userdata.setUser(user);
        userdata.setPassword("TJAPYa1KqrftCsOFycRzolSMoPUuu3cFeSmhptFLY9xReFWXQb");
        userdata.setOneTimePassword("HmJEBwarUcQrQxs3B5d7U9du36bSGVNP");
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1463464685404l));
        userdata.setLast5Passwords("teC6274D1I3vLvhXTLXLJHrCiTJu4hBpSSzJKcapbBecsrBhxK");
        user.setUserData(userdata);
        Login login = new Login();
        login.setServerAuthText("dey0LEWqmOnGlPaR");
        corecontacts.setContactId(null);
        login.setCoreContacts(corecontacts);
        user.setUserId(null);
        login.setUser(user);
        login.setIsAuthenticated(true);
        login.setServerAuthImage("RXLhuUIcZdbvsaQ7Kc3FUI6WAabWKjpE");
        login.setLoginId("my8HgJxOLu60Q7FBozTOsMBayFLXLSkpkR82PyAUAXn53P0HUZ");
        login.setFailedLoginAttempts(2);
        login.setEntityValidator(entityValidator);
        return login;
    }

    @Test
    public void test1Save() {
        try {
            Login login = createLogin(true);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setServerAuthText("CqK416VgYvyvyyMs");
            login.setVersionId(1);
            login.setServerAuthImage("M8vuk7slIQln4M23zZw1mKAMwdadayab");
            login.setLoginId("B7oNCY8IhpunwqQM91Uyo0khSi7H5JHJRfeaWHTb9MzIyMhaE3");
            login.setFailedLoginAttempts(7);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
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

    private void validateLogin(EntityTestCriteria contraints, Login login) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            login.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            login.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            login.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            loginRepository.save(login);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "loginId", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "loginId", "AKUnu0F1xpJ2AY4YJCOkmHvvKBKf5ZiNA9Zu7xzIjsVmi2rJ4Xt2P5pxMif9mJ69s4VQvSWDl8pIy1ytqgKC4c5yUSAFtafP0U56R4V2kZ3ZL576XZv7qgyUQTJiQwdvNzwAHzOH3XabEsj4A5QGGmVSfT6eMvGHPqeQkOgjyKncmmFXBsd9Sk0EsBmQR3EXXfbtECNrv"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "serverAuthImage", "tV7Q2d7XOeDMil9TS6RUTmuBTKX2nVCKG"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "serverAuthText", "w6PmLDIUV53KXPesA"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "failedLoginAttempts", 19));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "isAuthenticated", true));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Login login = createLogin(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = login.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(login, null);
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 2:
                        login.setLoginId(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 3:
                        login.setServerAuthImage(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 4:
                        login.setServerAuthText(contraints.getNegativeValue().toString());
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 5:
                        login.setFailedLoginAttempts(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateLogin(contraints, login);
                        failureCount++;
                        break;
                    case 6:
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
