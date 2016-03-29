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
        user.setAllowMultipleLogin(1);
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1459231584071l));
        user.setPasswordAlgo("seqSZpyPtaJIP2yKSjPdYIO3V8Zlnyu3yvze7SfoC2gXISGdW1");
        user.setPasswordExpiryDate(new java.sql.Timestamp(1459231584071l));
        user.setSessionTimeout(959);
        UserAccessLevel useraccesslevel = new UserAccessLevel();
        useraccesslevel.setLevelHelp("kkgEg26DRpMs5nesmkgdTPdCjFUv6pYnCyHHcUlB6aXgPDr0W5");
        useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
        useraccesslevel.setLevelName("ykZAD4ExjkqbmadYG9N09JgjNU8xo5HnD61MyRZhcTuIKUp45r");
        useraccesslevel.setLevelDescription("ra7NIHqheJw3HQ5n2mHjt6nzX8dvgI4P7duvMYWBQHv9K3rZCS");
        useraccesslevel.setLevelIcon("USlviEcd2kqZnOAKre2jTMEtyqGU65LpIshczfz1AwXUhqDFJr");
        UserAccessLevel UserAccessLevelTest = new UserAccessLevel();
        if (isSave) {
            UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
        }
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainHelp("6G3zE7noZUYDDqapuz96sS9lL2A9jVx8fAst9Hg51pK0SFvRh9");
        useraccessdomain.setDomainIcon("d1ICGyyi6QV41hGSrdx3JUusSAF7StqgLpl4QsmbFt4dWbeJWk");
        useraccessdomain.setDomainDescription("skmeEmRtKKXLQmRMKzO7ftbdRm3N3S7DxEEPr2FKqCjg0uN93P");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainName("T5LXbWzcO782DOiaZbXxPJ3SXZKKfRg7yvBdbAdZ4cUyABdgCD");
        UserAccessDomain UserAccessDomainTest = new UserAccessDomain();
        if (isSave) {
            UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        }
        user.setAllowMultipleLogin(1);
        user.setLastPasswordChangeDate(new java.sql.Timestamp(1459231584095l));
        user.setPasswordAlgo("CZjYq60dK385lP8IzvHKRhBMYY1A4tY9wmHjbyAo3sDe4mBQLP");
        user.setPasswordExpiryDate(new java.sql.Timestamp(1459231584096l));
        user.setSessionTimeout(3385);
        user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setGenTempOneTimePassword(1);
        user.setMultiFactorAuthEnabled(1);
        user.setIsDeleted(1);
        user.setIsLocked(1);
        user.setUserAccessCode(8831);
        user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
        user.setChangePasswordNextLogin(1);
        java.util.List<PassRecovery> listOfPassRecovery = new java.util.ArrayList<PassRecovery>();
        PassRecovery passrecovery = new PassRecovery();
        Question question = new Question();
        question.setLevelid(6);
        question.setQuestionDetails("SIQjd2U8p7");
        question.setQuestionIcon("aOSvUEYcBdWpfpepkVVvS0PsOJCHvK68aGjNbWIELhT0luuqvN");
        question.setQuestion("mv5X3PrrW1HYLGl3PoW7AEzpJEvxGpf4gDqUK0u1Qy0w1x3iiY");
        Question QuestionTest = new Question();
        if (isSave) {
            QuestionTest = questionRepository.save(question);
            map.put("QuestionPrimaryKey", question._getPrimarykey());
        }
        passrecovery.setQuestionId((java.lang.String) QuestionTest._getPrimarykey()); /* ******Adding refrenced table data */
        passrecovery.setUser(user);
        passrecovery.setAnswer("24GJy80bMlUz4dFyXn5RfRnClIJrKusShCDGajE3K7YkK5OWSX");
        listOfPassRecovery.add(passrecovery);
        user.addAllPassRecovery(listOfPassRecovery);
        UserData userdata = new UserData();
        userdata.setPassword("6jbSThbNKNPhMWyLkMm0EOZ3Jb0MdNXn0HXJW8JqG8uDfCs2SS");
        userdata.setLast5Passwords("DY0GDoSWKK0bYegvce4bOZGpjcnQQgfxoxXhpdJseQUmsihyhj");
        userdata.setPassword("Xhus5p07aCVdqEjzVsqEpj0JpUjv0WowYcIivg5vKO0uWcjtEP");
        userdata.setLast5Passwords("QFiYiLeJw2tbwmFKPwZu9YJngPXLC6ovLHTXHi3Gm08WzWH2Sn");
        userdata.setUser(user);
        userdata.setOneTimePasswordExpiry(5);
        userdata.setOneTimePasswordGenDate(new java.sql.Timestamp(1459231584406l));
        userdata.setOneTimePassword("q2CwuLryqsfudAOpl39likgTAIB00U2z");
        user.setUserData(userdata);
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setEmailId("Yd62FjYvsxXd091vTvqqz9txm0KKerGQOqRza5UOwHkkEAFgUi");
        Gender gender = new Gender();
        gender.setGender("Ne3BqzXV1s5KzBeXlFMqxigvYH0CzhtUfSbtVSWeikGzUJrl0C");
        Gender GenderTest = new Gender();
        if (isSave) {
            GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
        }
        Language language = new Language();
        language.setLanguageType("FcRmkeaxSNKeqC5op2VaoMKE5JeNRxB3");
        language.setLanguage("H5jtKG73gfmALL0JkWAdluKc3LkZJoeqY51A2fBjsRWYCXl3tb");
        language.setLanguageDescription("Qsjwe25PvKgeEtViNuHBWFdkDW5kgLvvAwBPpMmM5uo3ZO5xmV");
        language.setAlpha3("b9p");
        language.setLanguageIcon("nq9nzdRIW89BIvWrUQy5T8mNPdDcYQE2MsNjKo9qwH2MHr1sz4");
        language.setAlpha4parentid(5);
        language.setAlpha2("va");
        language.setAlpha4("gQwW");
        Language LanguageTest = new Language();
        if (isSave) {
            LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
        }
        Title title = new Title();
        title.setTitles("Vn98kYF0RosalBkVX8o2DzJDu70ZOumFRSIEk8Oq934bjMN6xx");
        Title TitleTest = new Title();
        if (isSave) {
            TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
        }
        Timezone timezone = new Timezone();
        timezone.setCountry("4ycK74RBkZ7hgmP2ePsvvjYmkegStA1AMn9fIqWuBKPeVzo6Lv");
        timezone.setUtcdifference(9);
        timezone.setGmtLabel("qn5DldYhMfUbrNq5zqMp3sjr4a4CkQn7WK23aZdPuOJfJ3e5dE");
        timezone.setTimeZoneLabel("BnHavC3Oml5FCFPM3wzluyMPxOI7SuIpXKMMdiDbua9TFEo3i3");
        timezone.setCities("8aMWpPJoQq1g54rCUzDOGPhlSfUNagbIyM1c78pB4ZswkZQAPm");
        corecontacts.setEmailId("s92a37lVkTWGqNprL3WDmNoARXnarZitHRaetkqm646jZ7bZwq");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setFirstName("UwYLzisfHc1KOeiuRTVbCJkd63hWLpTrV091BJtOiePfAPuxpN");
        corecontacts.setNativeLastName("4pyuBbJcyE3aB8KoLeI6WGYPPmQx5SiK5toiXBr4OzxBrnp7sG");
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setDateofbirth(new java.sql.Timestamp(1459231584569l));
        corecontacts.setNativeMiddleName("C5R8DJBXcwr8SBbt8WB2X8NMV3SSqXlSfRC022n7dkK4LYuegC");
        corecontacts.setNativeTitle("FOVZ8J7IPQOwTCnf0W7IprTOuinmFr4Cu5AKRL5xvSzQ67qO39");
        corecontacts.setAge(33);
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(isSave ? timezoneRepository.save(timezone) : timezone);
        map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        corecontacts.setLastName("eSjpR7QceXDH5FFCjUGw7ESoTzijUHWKVlKBU26PcWrxQYcE9c");
        corecontacts.setPhoneNumber("N1jHd0V9lxOSQKzColA0");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1459231584592l));
        corecontacts.setMiddleName("E94taJT5td8n1zKmVuXZoVQZ33kEVnxILCdFAc3htJskspr0It");
        corecontacts.setNativeFirstName("vYbtQpJ7YmOUBqxpJQYnyeAKb4Rs0IG87VPuTVvxAMia6o0fxU");
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeDescription("xOSpPnEiSK5zIVyRNIFBK6hy6lhODZagkMP8UoCoMOjT6Fj4Iz");
        communicationtype.setCommTypeName("HZgnF5Vrchmwx8yb2FXVPA6rGdTTyYv356M6GhKcxJAj9MkXLH");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupName("Vuq5xFMizSqInu1VumBMg5YBEuD8hDBCh5Y65xfprrt5DRzWuv");
        communicationgroup.setCommGroupDescription("XRdata7i7bpxUpEBZZLD4JPCfus4aF88UnaT5ldLkOmL6YYKXY");
        CommunicationGroup CommunicationGroupTest = new CommunicationGroup();
        if (isSave) {
            CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        }
        communicationtype.setCommTypeDescription("UXavR3wEdY0aN45b98roTH1Os40YuascXPMyHTf4v7LVROO2tJ");
        communicationtype.setCommTypeName("1wkyDFYCk0n1R6PDxgbejut52SyhVbXFgoprhQ3AbpaaAB4Ul0");
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
        address.setLatitude("F5Nx2OWnWiOXblNK9HPptGksWUotx94wxAgRTQDn8xMXplaeof");
        City city = new City();
        city.setCityName("G3lFoIVnfur56DktjoErEEe3IyuGsZL4gNV6w97uo2VZcsBaVa");
        State state = new State();
        state.setStateCodeChar2("XU6ZgT38KOGPKalabKoCzyM7OUtibyvp");
        state.setStateCapitalLatitude(11);
        state.setStateDescription("fqPS1llpHZTbRP4eYZtkVydFhg77Nl0rJ9ASYAGM94W22YS72T");
        Country country = new Country();
        country.setCapitalLatitude(5);
        country.setCountryCode1("RQJ");
        country.setCapital("QQBisMyKDXueYi91sYVVhJZW34FDBGVR");
        country.setCapitalLongitude(5);
        country.setIsoNumeric(9);
        country.setCurrencySymbol("4eY12LlxvRaVlxL3y22Oirfj1OPUlQtE");
        country.setCurrencyName("DrVIMmbLwzdphHZuBj94Xh6BiEbfLOQCnbLKj0ecgZMsb792l7");
        country.setCountryFlag("QjZoknsHomAxfjdeZWpU2N7tqzyWIZg6B9rOyvwTwfl5gJ0mlB");
        country.setCountryCode2("bj7");
        country.setCurrencyCode("hux");
        country.setCountryName("I7iVkqaC3bvrOXOkUF7BdZYVetqMjuVrjIx157mrc5lszqm8tZ");
        Country CountryTest = new Country();
        if (isSave) {
            CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
        }
        state.setStateCodeChar2("fkAMKc0NdLiaEH37mzC4jHQvyKJvMbmX");
        state.setStateCapitalLatitude(7);
        state.setStateDescription("qq330FdsXQNnzZ1n7OUKwIGPphzMA5wuAxV3tzXX7n7cMdhdHn");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateCodeChar3("wN2cv9lwcMDmiHRJNpXZcTbcvDy7pdw4");
        state.setStateCapital("FqvxlrwnFaPS2h1Vny6M6QCGglF29HtM52YpMp2TUPTwLZSsVb");
        state.setStateCode(2);
        state.setStateCapitalLongitude(10);
        state.setStateName("LEtplyA8K9Gy1BWCz0biG3FWU6pvH3hlioGOr3peCp4WMGlwL2");
        state.setStateFlag("iCJHIy7ThzumezumkwOfckRkbZ2wXisAKHe7lSmKXZYJFsWff1");
        State StateTest = new State();
        if (isSave) {
            StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        }
        city.setCityName("9xUSFE1gU2jOz5hmVl2wQWU8nbPio7K5cVfcx9v1FhiU8tJd5k");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityFlag("LtiyGBOe9leTUO7SkOSgEpFpX6t0JOE2alqCmKs2mBnMcG5DaN");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityDescription("5vLCmNbPBKiTmn2n6PQLZxblZW313HiQ01KwIckcRiB09PEmZ0");
        city.setCityLongitude(8);
        city.setCityCodeChar2("NDRGwiYuBK5ZBpT9Xb36rwQvZTYN4tCI");
        city.setCityCode(2);
        city.setCityLatitude(4);
        City CityTest = new City();
        if (isSave) {
            CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        }
        AddressType addresstype = new AddressType();
        addresstype.setAddressType("KVTg8duDK8CLHOrv7Ux93zsvargxHWqaKsaqIBF7TRr0q0A0H6");
        addresstype.setAddressTypeIcon("Uw3WP7ZNo5hgFDlpr9QtmH8UhWQwmyXm6fBU712M4waktWYh6E");
        addresstype.setAddressTypeDesc("Fxx1ibRwUk1NGhxvRhWllBUCGoHll0IbK8mbS30ZUppHEc11zA");
        AddressType AddressTypeTest = new AddressType();
        if (isSave) {
            AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        }
        address.setLatitude("tWrXmDJlFrCokJfso94uUW4MJbLoJwqU1Df5AHBkRraRg1LQCj");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddress2("DhghG0rBRHzbYVs59kBck2zte1mVvlXkbnufqgbk78ppwlVef3");
        address.setAddress1("a38BKBIhCbsOxOzDqWMnpb7DS325iCXi9hH7lyyHa9iwLvpk6D");
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("CftIHW");
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey());
        address.setLongitude("DVl2MrU3ajdYyrueYJjkKlKhSoX0faMMl6rFaV6CbylzZ5CMok");
        address.setAddressLabel("uMlAuLGrlrz");
        address.setAddress3("O9shz6MRcT5on1KusfrzHLx9rDOh1wimiyXJY658iUjJEWiUVY");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        Login login = new Login();
        login.setIsAuthenticated(true);
        user.setUserId(null);
        login.setUser(user);
        corecontacts.setContactId(null);
        login.setCoreContacts(corecontacts);
        login.setServerAuthText("VEdWy3c5tVHn84d7");
        login.setServerAuthImage("64K5GG8PtI4Q5Ie8RhIfUMXopihH3x1Y");
        login.setLoginId("q1drg7D1jXQfxIbJHyoaDLv28EQnFTmvcbP8DuLxrF8ZVTRpoH");
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
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setServerAuthText("GUuBCzlp9KKuqcrL");
            login.setVersionId(1);
            login.setServerAuthImage("LFqWoDz4EppELREqTwxVP9EQPGzP5pYp");
            login.setLoginId("eBj4fm1JN86UrqMcyzBD7ESLNzqw1iEeuFDBNd4RRzGMSduXCT");
            login.setFailedLoginAttempts(4);
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
            questionRepository.delete((java.lang.String) map.get("QuestionPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey"));
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "loginId", "CQE1pOyJMM7tciJp0SVoXtYkNBWdNvkMVbXEc4scN28Sf7On4gLoL2n9POGkeSoQGnX5upzevbwl03r7r5F83ILQAdhp6ASo7HMBOy9VQ2Zhvh4uIY4vAgo58jRHqMSwS14596jmL5XUfLa9uQT2gYUtbt9Y1KgYfgm0sz4t65ICGZGDnl3DCOedsn3KSm6jmVFIMnPGO"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "serverAuthImage", "jOcpZaQt4QKl5mHhuZoSQIJVbJ0UFlq1c"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "serverAuthText", "QBCbOYqHM68Jdrbby"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "failedLoginAttempts", 15));
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
