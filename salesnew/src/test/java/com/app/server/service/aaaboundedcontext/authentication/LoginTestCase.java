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
import com.app.server.repository.aaaboundedcontext.authentication.LoginRepository;
import com.app.shared.aaaboundedcontext.authentication.Login;
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
import com.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
import com.app.server.repository.aaaboundedcontext.authentication.UserAccessDomainRepository;
import com.app.shared.aaaboundedcontext.authentication.UserAccessLevel;
import com.app.server.repository.aaaboundedcontext.authentication.UserAccessLevelRepository;
import com.app.shared.aaaboundedcontext.authentication.PassRecovery;
import com.app.shared.aaaboundedcontext.authentication.Question;
import com.app.server.repository.aaaboundedcontext.authentication.QuestionRepository;
import com.app.shared.aaaboundedcontext.authentication.UserData;
import com.app.shared.organizationboundedcontext.contacts.CoreContacts;
import com.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
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

    private Login createLogin(Boolean isSave) throws SpartanPersistenceException, SpartanConstraintViolationException {
        User user = new User();
        user.setPasswordAlgo("CBSylsHB2lpR4Z2jdfSlSXYaKU3M2FOrnbtqFMR32NaFttkKC8");
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainIcon("HLTPYAP7pKBQTpmDOVAbCQ19QL8st623DKYBK0QhBRdOiCeZXw");
        useraccessdomain.setDomainName("NyAXNe9yeh1ICEGgUGY24AhHqcOxMCazXMxfG2JCYtKpd1Lrju");
        useraccessdomain.setDomainDescription("vFte7VzmS7xyJHOG1RfKhiYrbzOBHbRUbFwqKsxcWIp8pH4owt");
        useraccessdomain.setDomainHelp("vvM5mIXEYKN1eXPLH5HGwKFGvQ12mc9J6bAO9BZOggVagmvYap");
        UserAccessDomain UserAccessDomainTest = new UserAccessDomain();
        if (isSave) {
            UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        }
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelIcon("3sHhFsIjCTidOBTOKw78tzmPzBSepMbbKcYGo0dGGTTL5VFjzE");
        useraccesslevel.setLevelDescription("wYvD9xduGSglMDjBlFofh50PcjdHXvbZKep9y2y8ICuLWhhZ70");
        useraccesslevel.setLevelName("JHwX1sseKHIWHYj1WFsNUAYaf4lDORYliqFmhPU301d4NM67gS");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelHelp("sNp3egNLafrgxnFiYOgXyPxF9mUo14LUmOEF1GUtenVtDTLwVn");
        UserAccessLevel UserAccessLevelTest = new UserAccessLevel();
        if (isSave) {
            UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        }
        user.setPasswordAlgo("WeU62tm2phUxkZZBGoUCFLGPKDAJj35gaGRERgWaOCtb2RWb6p");
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setMultiFactorAuthEnabled(1);
        user.setGenTempOneTimePassword(1);
        user.setUserAccessCode(24511);
        user.setIsLocked(1);
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setIsDeleted(1);
        user.setSessionTimeout(2112);
        user.setAllowMultipleLogin(1);
        user.setPasswordExpiryDate(new java.sql.Timestamp(1459405518401l));
        user.setChangePasswordNextLogin(1);
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1459405518401l));
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        Question question = new Question();
        question.setQuestionDetails("T5HJEBcj6F");
        question.setLevelid(3);
        question.setQuestionIcon("OuSdl2AKpYhugKRD2Fs8QxibN1YbfjZVffzq8xaRQ6brHvVjIO");
        question.setQuestion("qJ84Xm4ByaprR3S247aZpxY3iZtH3WIMa4h7CW8jE6TmRjozad");
        Question QuestionTest = new Question();
        if (isSave) {
            QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
        }
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey()); /* ******Adding refrenced table data */
        passrecovery.setAnswer("moDnz3o8biGHs9IHVlBkBZWKIMsgdhrjt3syy0p1cKZRukcpJv");
        passrecovery.setUser(user);
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1459405518498l));
        userdata.setOneTimePassword("qeGzEgaYNa5wnl1Ydl7Zxu999rqR0l6b");
        userdata.setPassword("k3ZJtb88GA0CBvJ21DwuNshGpAs1EnSp8yqQO9j46D4SBriWD8");
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1459405518508l));
        userdata.setOneTimePassword("9f3Dkm7bsU5xOMwOaw6KOWBWQ0JB5eIQ");
        userdata.setPassword("MUFYzkMLzemTrcvEMdH4QMkioVZpL3K4WjErnrFc54XbomRNiv");
        userdata.setUser(user);
        userdata.setOneTimePasswordExpiry(9);
        userdata.setLast5Passwords("dEroaq0GmX66qKzQYOJNM9qfGccNvC9T03s5Df0lDed1zZ34Qn");
        user.setUserData(userdata);
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setDateofbirth(new java.sql.Timestamp(1459405518562l));
        corecontacts.setNativeMiddleName("DcrG6obOVc4qMhYI95zwTO3qeOG1iM8AukcLb2squKeOjW9afH");
        Language language = new Language();
        language.setAlpha4parentid(8);
        language.setLanguageType("8JrLhCe473npMDVldHe6THxfTbOttknb");
        language.setAlpha3("cAY");
        language.setAlpha4("zf18");
        language.setLanguageDescription("Jd89Od8467K4hA8ASAoFeVUjVq2pnD99Wxb1hoSzL9QP33BsJd");
        language.setLanguage("KWVAsYqDudli7X6EQgvS8qk87BVOBLxe5kPrxstWctRzBhdq24");
        language.setAlpha2("yD");
        language.setLanguageIcon("8Bt8Z5fsHTIuuAGG0LivXb6Zk4nd5A6udm7mChZhtYBSWWjIe9");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setTimeZoneLabel("Vg7gPWVFzdkvkH9ZpPG3gJF29KVtPc9rwD0xhT9lcarGVV113W");
        timezone.setCities("J2hZYb6bX6UHaHSghLYtlAqvk9E5S8RPZQ6qwCe2KUjoNbYGqv");
        timezone.setCountry("I2Cb1j31NMjcBM4sWAaJHcoC0HX30iO2YcXMdquCW2X0MbwouS");
        timezone.setGmtLabel("l6gHBp1kIB8axbrc3Pz6Fcku5hbB5qK5j7Z7vRimZHw6FGEaxZ");
        timezone.setUtcdifference(1);
        Title title = new Title();
        title.setTitles("Qxcjk32BaIP9swdWXo2FlEkwH4mwx2qpwlpWTf8v9s9fzPHyhr");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Gender gender = new Gender();
        gender.setGender("VdoqbLsMYek72LzeKybbZU95fIn5eFTn20wOLqrYCvcwsjTP0L");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        corecontacts.setDateofbirth(new java.sql.Timestamp(1459405518571l));
        corecontacts.setNativeMiddleName("YvIW6wNvJRYbWTzEzbj340GOM307dvCKQfILkfihxEwMMkDbCF");
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        if (isSave) {
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        }
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setAge(21);
        corecontacts.setFirstName("0IqLB442ZsAWjBsnYdT3qbRQr1oTuJGYy52o3pHFwMaYqcejAq");
        corecontacts.setMiddleName("wOe7Q0eHJvvNj3l7gFFC6XW1UWEuS7veJhFYEojazbZ6JDDOlk");
        corecontacts.setLastName("6U2iaPA4j6P4WuiQXKLZURbiNcmYxjbqX3kJwW4o28VsbqqPR4");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1459405518619l));
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeLastName("GTq0dI5Aq0eQGnOzQsyYzUJyoDyUnjIPjgpYbfZ83zvQkYocsz");
        corecontacts.setNativeTitle("LM1Gl64aPpnojT0wJDIKqW5IhfEzPxgYSa7I0KkKWRclySt9jf");
        corecontacts.setPhoneNumber("ReBIeflgH2I2Qmwd6DIm");
        corecontacts.setEmailId("qVkl2xV8CCTiJmwN0M70YxykIIz8cjYYIUdvuQWGwqlFH8TkFJ");
        corecontacts.setNativeFirstName("2A6048UiVmEfLow8TacYgkKpwlQrd1zRtYuX23HPgVcuTRsBsL");
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("rN6BapP0R2y0Q7QFrkSvyiQWFzSyQ8dkrHmnBWAnZpgPSv4oum");
        communicationgroup.setCommGroupName("3r3Flmk7z0MevKPxc2elahvPWmJLR9gTS4nlq7MsCt8Cp4Wpwf");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeDescription("LjATkiJa1y57FDtM21ki7ZZ1sLZgB5HCPEKCJP55faBHMy8FZE");
        communicationtype.setCommTypeName("AeN8vEjFvPGlsJgoGYK5Q8KcYPpyYzuZkPfnJwxp16fEXAAOpZ");
        communicationtype.setCommTypeDescription("G599sZrMZet6EDQYA5TG11dByswg4KKWJLi4UtuDMQV1rVFYVo");
        communicationtype.setCommTypeName("Jzxn3vxtODU5bUw09tglzDbYXD7RGP9FETMPwFLTJjfatkH0Wi");
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
        address.setAddressLabel("eKgstykGQax");
        address.setLongitude("muKLQkD4CPCjV5py3xJBddjRa9y6V4BkqI3OYYg0CuTkNwRzl3");
        AddressType addresstype = new AddressType();
        addresstype.setAddressType("qxDRqM32L7qhpVINC0TXYl81NZGXjSITSMnIVu7umyTCTB82tW");
        addresstype.setAddressTypeDesc("Rwmu28BJnbm9XJwBD7gifeG2nVc3XP04X78G9PB1VqS6rZzyco");
        addresstype.setAddressTypeIcon("ZFPJZ6pZO2i79JJgrvJd14rN59OtZ1JRVKnsVV54GwDn2qC4fh");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        State state = new State();
        Country country = new Country();
        country.setCurrencyName("biiEh445WJZjrKN5JNdTIVdpU1pKRv42xKQfD7TQEZQdcBgiLM");
        country.setCurrencyCode("aca");
        country.setCountryCode1("Nt3");
        country.setCurrencySymbol("2b5r2p02JLOWiujCenGgQSNpev96EKss");
        country.setCapitalLatitude(6);
        country.setCapital("MBgyB9Sx9dhUTZSlBkGS44llZGQflByy");
        country.setCapitalLongitude(1);
        country.setCountryName("Bw5F78The92hAWk9hucTFWwsYmsnzPaV3qHSE0Ovdnrv7tMAYb");
        country.setCountryCode2("BgL");
        country.setIsoNumeric(547);
        country.setCountryFlag("bxJLriYLP3jK5GU6Myns5F17AMZ8nf7ZORTRRk3IY193GvALRb");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCapitalLongitude(11);
        state.setStateCode(2);
        state.setStateDescription("v1lBsX7NcuZpvxvDnhLm2UOyXpJg0ejdVmrT8MCqx5F8K1rZIF");
        state.setStateCodeChar2("HAucsvx8kR44bndwChLG5a45zQqvHhCT");
        state.setStateCapitalLatitude(4);
        state.setStateName("noo6zbMwE0PIWPCONBVrlOjESCsHLOOUpeMattjphFpXz3a6S3");
        state.setStateFlag("Xmr9JLYn6Bo7EcIKF7mBiChYGbA4v2ziuuFeqwLxLmdXu1xSeM");
        state.setStateCodeChar3("BUGAAjDqE6HDg3Adu08hAoXkW32sX4WB");
        state.setStateCapital("yoPTtmAiUwSSP8dDW6bwpilYG0IUUbIVz52vefkk23nP5o1woH");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        City city = new City();
        city.setCityLongitude(2);
        city.setCityDescription("XgCZfUK5HlfUdoSjXNcnT3P33F0BCoqAKNaDJtxxX5FZqNE6L2");
        city.setCityLongitude(1);
        city.setCityDescription("hcVm68sypTopW7iGXKWwBB6gLT78wORwUhAFoQtqEvdghHx9H0");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCodeChar2("JG1eBpASBb7reXvWSxyKEmqRBOsCrO8l");
        city.setCityLatitude(7);
        city.setCityFlag("u5hf7io1Ka8IJkW4QqedLgBDsvQZfKKAbBkqy5LwCxqDNe4NNE");
        city.setCityCode(1);
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityName("SaqvWh4v1dVegS20JhArIfwlAwK8tVePzzElLWQi46h5E1DqLP");
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        address.setAddressLabel("NU6pjoxz7zp");
        address.setLongitude("xTyN22hBZ4jsjh8KQNphIy5yFDA8RvCh9ZsuC0dgnQ9l5uP4TW");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("uiDXvK");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress3("pV0tgjQrrlL93XwIx9hw3xLeAIbURWl2W2aoqjSyrhz9q1PZzj");
        address.setAddress1("nveSGFNlk6odmKZLdyWZBT4VeTBCo21XGygnD2ijA988PWmtrN");
        address.setLatitude("JsAlGZqiFYXgXfultSRUf7Lp9fF2d9kOOslohghCtOHMvVocSz");
        address.setCityId((java.lang.String) CityTest._getPrimarykey());
        address.setAddress2("mPdPyi2F07CWZONyprV8YvqRgxGzhAHXm8lgWldYf0UykBLeZJ");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        Login login = new Login();
        login.setIsAuthenticated(true);
        user.setUserId(null);
        login.setUser(user);
        login.setServerAuthText("gYCOgR5zEhgupsER");
        login.setLoginId("UJ10UOdTvCBLI5u4AI26F46oxVuMCWyAYdoewPU6JiW5QD0dIc");
        login.setServerAuthImage("ObyfowRJ0vSI1jhKcG5zH8AQV9nqfIRr");
        login.setFailedLoginAttempts(2);
        corecontacts.setContactId(null);
        login.setCoreContacts(corecontacts);
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
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Autowired
    private QuestionRepository<Question> questionRepository;

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

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
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setVersionId(1);
            login.setServerAuthText("pHATzQfhIbr62zCV");
            login.setLoginId("BnvwM1cQwFLNLRB6ZQjESZ5vksx5rdixUS1bY5DMpWH8JO8E5u");
            login.setServerAuthImage("58hEcyNuPZaSh3bP0nuhMXddiWLu2oi7");
            login.setFailedLoginAttempts(3);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
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
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateLogin(EntityTestCriteria contraints, Login login) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "loginId", "9eantsPH5oODU5MJByNSQ8fKqGqheCcBB1Y09MMYTxGXwRkXsjxuiu9jAm6CTvl2JpAWGlkV06qoZezNdAD3FPavYr6zwgBhfx8Gp6TaGYtQS6bnPF2EGkEv8NHiAG01ZOvtZOi4VDNUMTEy0QhZlZ4jrbKCRK2iYKUnpa5Vm60DFvMKaY1NrNGc7nNspD3kFWiSZ7vqL"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "serverAuthImage", "tNpojw0J9ctX8NqeHNV3cY8EmwCx0ji4o"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "serverAuthText", "Zu2zsQMob1d7gBfj7"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "failedLoginAttempts", 19));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "isAuthenticated", true));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception, SpartanPersistenceException {
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
