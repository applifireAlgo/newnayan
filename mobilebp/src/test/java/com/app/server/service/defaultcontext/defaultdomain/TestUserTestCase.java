package com.app.server.service.defaultcontext.defaultdomain;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.defaultcontext.defaultdomain.TestUserRepository;
import com.app.shared.defaultcontext.defaultdomain.TestUser;
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
import com.app.shared.aaaboundedcontext.authentication.User;
import com.app.server.repository.aaaboundedcontext.authentication.UserRepository;
import com.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
import com.app.server.repository.aaaboundedcontext.authentication.UserAccessLevelRepository;
import com.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
import com.app.server.repository.aaaboundedcontext.authentication.UserAccessDomainRepository;
import com.app.shared.aaaboundedcontext.authentication.PassRecovery;
import com.app.shared.aaaboundedcontext.authentication.Question;
import com.app.server.repository.aaaboundedcontext.authentication.QuestionRepository;
import com.app.shared.aaaboundedcontext.authentication.UserData;
import com.app.shared.organizationboundedcontext.contacts.CoreContacts;
import com.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
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
public class TestUserTestCase extends EntityTestCriteria {

    @Autowired
    private TestUserRepository<TestUser> testuserRepository;

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

    private TestUser createTestUser(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        User user = new User();
        user.setAllowMultipleLogin(1);
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1459233297833l));
        user.setPasswordAlgo("2d1oyaxTEyKJooaTQnUDtAPuRJWL2OOM1ejeejNbNdBsYlOE3u");
        user.setPasswordExpiryDate(new java.sql.Timestamp(1459233297833l));
        user.setSessionTimeout(979);
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelHelp("mvD9WcPgZs22lfdzQAivVYtgQ9D6Ko6pqxT7bt0ZbzIogbt2EV");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelName("DXhhWkGgS6tqF2VoHhNfORgs39gptJLDhyWj8wXp0BYHoXZDHh");
        useraccesslevel.setLevelDescription("CeDOHkMxmbqemvIZyenBs3o63HZbIxjEfmHddR2N3pcvz17VTU");
        useraccesslevel.setLevelIcon("ThsQ0MylkTc0daQTMg6PGV5WzKpBw6cA1L2Rbc3ff1hfJhQ2wk");
        UserAccessLevel UserAccessLevelTest = new UserAccessLevel();
        if (isSave) {
            UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        }
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainHelp("fBqE2hSWfUAilSl1tN36C0thEiRGKYIVdebUyIzeIbgGwUF5XY");
        useraccessdomain.setDomainIcon("HwJ8oRBiLphDPvTsmqxLaHNQmneUYdfoavkx0z9EU82LVasmFV");
        useraccessdomain.setDomainDescription("QXNyxpTs62s16WCzmqcxH6XUZ1G507cGNmvHcvO92Oh7ZjXpJs");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainName("4XWsamFQQfobgKM8cybLGbJT5pzHFjptCfrBm18UVIlEJqtqeb");
        UserAccessDomain UserAccessDomainTest = new UserAccessDomain();
        if (isSave) {
            UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        }
        user.setAllowMultipleLogin(1);
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1459233297842l));
        user.setPasswordAlgo("vGyisEK8rnyWUbpGAmMoHEQxgvdojqj273efJN6vKrH1WwKRwq");
        user.setPasswordExpiryDate(new java.sql.Timestamp(1459233297842l));
        user.setSessionTimeout(2225);
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setGenTempOneTimePassword(1);
        user.setMultiFactorAuthEnabled(1);
        user.setIsDeleted(1);
        user.setIsLocked(1);
        user.setUserAccessCode(43585);
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setChangePasswordNextLogin(1);
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        Question question = new Question();
        question.setLevelid(3);
        question.setQuestionDetails("X85y9phLJR");
        question.setQuestionIcon("oSrT71duBg6LeqOVjLRr2l7MgpXQjfT6swBvTagz8t0RaQKLQ1");
        question.setQuestion("m7qHQx4y1Mt3EAdMeLCg5bqs43kHPWGWrY7BIi5OG869rRB16Q");
        Question QuestionTest = new Question();
        if (isSave) {
            QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
        }
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey()); /* ******Adding refrenced table data */
        passrecovery.setUser(user);
        passrecovery.setAnswer("twFtCktWclurTF7xNiCU8St78pu2SedgaeWJJ9K24M2zTUdK86");
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setPassword("9CopafD9fuGBvrDpoNlXT7yMYuoL446JKCnUpBUEpH5SxIKt0C");
        userdata.setLast5Passwords("qJCYvaRA3lsyzOQ6iYWxHEujzxpMeyk9X7iz2GAUUoOuOH0fEM");
        userdata.setPassword("jpS8XfjW4hvu5aNiz60MSPzXk09lM1vndoUytCveoTJj8WBd3W");
        userdata.setLast5Passwords("D11JVhGqjwVRgWYQNTmFnsXfRz1NQB061PmE9P1J24eqkFs2p5");
        userdata.setUser(user);
        userdata.setOneTimePasswordExpiry(5);
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1459233298103l));
        userdata.setOneTimePassword("1SWTqRlSXtmi8wEbgJLTN3anmKDXgxm2");
        user.setUserData(userdata);
        User UserTest = new User();
        if (isSave) {
            UserTest = userRepository.save(user);
            map.put("UserPrimaryKey", user._getPrimarykey());
        }
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setEmailId("E7XufxbeBo32jydzPxiZdialk6CEeHP65kMcS6o12mMilDgXeN");
        Gender gender = new Gender();
        gender.setGender("W2rednautNh9qzzVbJgGY004rOPoHczUxh4Sh2ja3Qm9BghNea");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Language language = new Language();
        language.setLanguageType("v407SDkMMiIroI2t11lu4RCMC92VpNT7");
        language.setLanguage("FXe4IWqiJnXIHYU4KAqqFTtxtT05aVidcdYsf1J6stP2G5bsxP");
        language.setLanguageDescription("5EY1efuXRW5yzpVxlupRtUv6B3kB9aRFSPsw8x7MkknnaQaLsK");
        language.setAlpha3("Uxq");
        language.setLanguageIcon("a81YZApjbZOemORLR6imRRVj392aFhUYt7Nkfj0KtOZv3zaOB2");
        language.setAlpha4parentid(6);
        language.setAlpha2("KS");
        language.setAlpha4("0XQC");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Title title = new Title();
        title.setTitles("vKlfnjVUThjY0xz2k9FtOoXgllDrFksAdSltmPgBvzIJ94aGVY");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setCountry("ZNzFhyubFlovkw6RhzKZfrqmuaAHbta6gR0G9G3eANdyzDpyuH");
        timezone.setUtcdifference(1);
        timezone.setGmtLabel("V1nNdj3NkLDIUWKBmA2V43v3T3rDDqzZjIQ2ABRpwbti28x6ti");
        timezone.setTimeZoneLabel("9JWixGvIhlnezmIo9tXqOxpyGhn8DtVk0oOcanzeGh92UBaz0u");
        timezone.setCities("Lc7mGP8UqvuISf3e037sG0D0Z1Zbehr9w0MkfgU1FzXEVGHRUm");
        corecontacts.setEmailId("ZIE2kSMeW9rmTg6n8ht5UPlLrJTLTv3LJ1gN0hHL8C6WxnZQyg");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setFirstName("aPtipFVthjS8IOtkKEg7Saij3BeZU9nOSeCV6prtcth3wTTs5d");
        corecontacts.setNativeLastName("5ZyP8NRqNhA8x7VmqESYpJXt2CUxoe0D2McoxzXxhRfCvVdAm1");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setDateofbirth(new java.sql.Timestamp(1459233298296l));
        corecontacts.setNativeMiddleName("BfQfE36zHUEMKTSGYni3CaUIap735X0Dh8Za4d6dUYsQB5qdqf");
        corecontacts.setNativeTitle("7wN4rCKDPnYs3umY0erqysjwLhMgJG36EKYi1SpCQjdgMufKZy");
        corecontacts.setAge(125);
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        corecontacts.setLastName("eCwbpfGA0plvJWM4YZeeN20PjsVt0jEo0QdbWDVVzYzRXKOvVg");
        corecontacts.setPhoneNumber("oukTzjIO9FBarkHCzRWb");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1459233298321l));
        corecontacts.setMiddleName("auVibv6ZQpxNQQVeex5ERbeP4Uftmc3zjNA8F4zsTegDO7hMIk");
        corecontacts.setNativeFirstName("ezjEGUx6WLUD7sdMPpV7gO812Hx23ZHPXZaklrSn4LqsRAH4Sb");
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeDescription("dO34JlVbeYUN9rX3xOEj2TJjlP8Xv3YzvCpBEDPmHJ6W3TS2XJ");
        communicationtype.setCommTypeName("6UWMLfg4XXfodiToTvBYgJg5xqCQlL8nuzOtAG5HqPKvzlFnuT");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupName("cxJGvt7hVNwAAAQiRuxFOxts48PO1WcoT2PUCnQKajD4XlhlKo");
        communicationgroup.setCommGroupDescription("pwNsEIqE3wUxgqmZ6Zwr3zHRMGctMLjkjzVI2tNBjpDHEkB3fD");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        communicationtype.setCommTypeDescription("JD4B0JUeU16KaJtRwyaQIreLSSkNXNODVPndOVm47BD4Clcs0Z");
        communicationtype.setCommTypeName("rAVFfR10U55AOzxIJeKrHkC505xU6udATwNn4J8bngK0iw5k4l");
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
        address.setLatitude("yZNAjXKEwnwBHrisSaysZfcdoR5WTQDEYteRuVToiD9j1apSVJ");
        City city = new City();
        city.setCityName("tGLc2W1R85LIUkhAv2jgdeDQUYUbPqare7lP60vcsNUDEqvqyw");
        State state = new State();
        state.setStateCodeChar2("KW5Sr2FLh2QDd8FdguV8hfWDFho21Sjf");
        state.setStateCapitalLatitude(9);
        state.setStateDescription("FVp5mLBSv9GtsDUUOPdYsxo7EolZDRnJ8ijWf1ejymOB8d9GV9");
        Country country = new Country();
        country.setCapitalLatitude(8);
        country.setCountryCode1("3tw");
        country.setCapital("JBGqBDUVehjrf7Oi7XN3mpkhO7eaDLC6");
        country.setCapitalLongitude(4);
        country.setIsoNumeric(29);
        country.setCurrencySymbol("ZRxEMdhWGbkxv8VwXGNAa45aXIiwOqXJ");
        country.setCurrencyName("QMqS9iYHyHYYakqhcqty226PMyaAjtbnmLK4n8yCWDdhnnYLok");
        country.setCountryFlag("mIkDtpsd6cRiiT2keWhvCCmR48L7rkq9CJ9ebfRgJPMdiNOF1r");
        country.setCountryCode2("C2Q");
        country.setCurrencyCode("bKq");
        country.setCountryName("hiqzoHChFDvyhuzz1J8L0qmM8Fc8H127c34As7uOvn39rOZNQn");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setStateCodeChar2("7bcryf7SgiPeIMLn3MhWnOs8kCWn8V6Z");
        state.setStateCapitalLatitude(9);
        state.setStateDescription("BQcj8qmzILMA9JphyKjd8QMDyVtBWbU9lynS887lDwui7qhk9Q");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCodeChar3("9XUtOp0nyB67C4T98iIwnbtYixGEYs5p");
        state.setStateCapital("xvtBsSi9a2h0HbvEAxXBsBjsgpVT4YyW5WxB5PYDmt1wnpueJG");
        state.setStateCode(1);
        state.setStateCapitalLongitude(1);
        state.setStateName("BMNh5Wcoow80LgzxcAfgmkWYRjQ3MwmE1vvYCOhkcbCx1ROchF");
        state.setStateFlag("g1XAipjoOoKIpShREfCYGR01L7mHxK3IeIQBlYkj9pmNpsG94g");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityName("sD7bT7orpvhxtxeF6v3Lxe5PFnWPo2tPnYPG9nFnvJ7C0TuX1w");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityFlag("6OuI5GVwWY93QcPr7TnnzCu5kKTWneclMFUcBDpJoMTRxxInjP");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityDescription("3qTsDYDtsrUXC605RkPtuYif5ivGLyRkszwVkEHZxugfFtefDa");
        city.setCityLongitude(2);
        city.setCityCodeChar2("WTyYyxYwc3bkMM3atkPy42XL27y2wVx2");
        city.setCityCode(1);
        city.setCityLatitude(3);
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressType("iEHPM6uSZdFI1Nyc0Vv3EzbYLqozNzjw7hwt28iK5XEbTrcOan");
        addresstype.setAddressTypeIcon("iLe7TgvWV7gEyjMm2gNIVwLoLTJtcoKIOaKaCh8CLiC03WDvRA");
        addresstype.setAddressTypeDesc("EnvZe5KrzcqxF5PRXsQxG6YPQ9MrbeDnmmNdUmRyY9DaXwL57W");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        address.setLatitude("fuyzv61IJtdFvkQtVrTeCsljuCikTUpRPvZMfFbRrfPtRFZQyn");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress2("cKHNI9xf9NT2ytYSNXUNxUthzmwDfjA3kXAX75PQXCWdzVunSB");
        address.setAddress1("MWUVzqZtSxZiz6ZbNNL6dCb2npVebeFWFmhN4wbpqov0zexkCW");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("40pZP4");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLongitude("98ky6HciGkFY92zAz1B7pXnZdo2Y3pYN0PXiwTFtXSQpbNTyN3");
        address.setAddressLabel("vsSQ2Ts1NCf");
        address.setAddress3("fCaZNjemv6ZnApPtI9vZAKxkOyPmpUZZgnEfQ7SId6lQFCkqJ1");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        CoreContacts CoreContactsTest = new CoreContacts();
        if (isSave) {
            CoreContactsTest = corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        }
        TestUser testuser = new TestUser();
        testuser.setNewuser((java.lang.String) UserTest._getPrimarykey()); /* ******Adding refrenced table data */
        testuser.setfName((java.lang.String) CoreContactsTest._getPrimarykey());
        testuser.setEntityValidator(entityValidator);
        return testuser;
    }

    @Test
    public void test1Save() {
        try {
            TestUser testuser = createTestUser(true);
            testuser.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            testuser.isValid();
            testuserRepository.save(testuser);
            map.put("TestUserPrimaryKey", testuser._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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
            org.junit.Assert.assertNotNull(map.get("TestUserPrimaryKey"));
            TestUser testuser = testuserRepository.findById((java.lang.String) map.get("TestUserPrimaryKey"));
            testuser.setVersionId(1);
            testuser.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            testuserRepository.update(testuser);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBynewuser() {
        try {
            java.util.List<TestUser> listofnewuser = testuserRepository.findByNewuser((java.lang.String) map.get("UserPrimaryKey"));
            if (listofnewuser.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByfName() {
        try {
            java.util.List<TestUser> listoffName = testuserRepository.findByFName((java.lang.String) map.get("CoreContactsPrimaryKey"));
            if (listoffName.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestUserPrimaryKey"));
            testuserRepository.findById((java.lang.String) map.get("TestUserPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("TestUserPrimaryKey"));
            testuserRepository.delete((java.lang.String) map.get("TestUserPrimaryKey")); /* Deleting refrenced data */
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
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            userRepository.delete((java.lang.String) map.get("UserPrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateTestUser(EntityTestCriteria contraints, TestUser testuser) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            testuser.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            testuser.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            testuser.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            testuserRepository.save(testuser);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
    }
}
