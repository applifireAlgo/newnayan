package com.app.server.service.sampleboundedcontext.sampledomain;
import com.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import com.app.server.repository.sampleboundedcontext.sampledomain.EmployeeRepository;
import com.app.shared.sampleboundedcontext.sampledomain.Employee;
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
public class EmployeeTestCase extends EntityTestCriteria {

    @Autowired
    private EmployeeRepository<Employee> employeeRepository;

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

    private Employee createEmployee(Boolean isSave) throws Exception {
        Employee employee = new Employee();
        employee.setEmpSal(203712l);
        employee.setEmpName("NC2W3Lhi80zNv2dEKo24tnUzgIm0iV6KzczBaNJ4D7IdVz8Qaz");
        employee.setEntityValidator(entityValidator);
        return employee;
    }

    @Test
    public void test1Save() {
        try {
            Employee employee = createEmployee(true);
            employee.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            employee.isValid();
            employeeRepository.save(employee);
            map.put("EmployeePrimaryKey", employee._getPrimarykey());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("EmployeePrimaryKey"));
            Employee employee = employeeRepository.findById((java.lang.String) map.get("EmployeePrimaryKey"));
            employee.setEmpSal(954181l);
            employee.setVersionId(1);
            employee.setEmpName("xdUkwxK5NTOKBWFSMgB3XViekaUX2U4QneRKZU7cU6BiaVO7vF");
            employee.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            employeeRepository.update(employee);
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("EmployeePrimaryKey"));
            employeeRepository.findById((java.lang.String) map.get("EmployeePrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test6Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("EmployeePrimaryKey"));
            employeeRepository.delete((java.lang.String) map.get("EmployeePrimaryKey"));
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateEmployee(EntityTestCriteria contraints, Employee employee) throws Exception {
        if (contraints.getRuleType() == MIN_MAX) {
            employee.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            employee.isValid();
        } else if (contraints.getRuleType() == REGEX) {
            employee.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            employeeRepository.save(employee);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "empName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "empName", "BafYNFnIVw39oVCT8iuZPUnLHD0z8VEzXEkA3gN7nWeMmMFPA5LOw3lq7ZLd7oUDVAqUMifZBiMWx3yl4FS4IjjhjHqdWzvnwaCl7sIOEHu7ldXd4UjjpDoIYodMlYroztFOokWrGZISDdIO7rA1OnyNJ3Skgux6RhKFecnPwJvBEZTULVHtJzdEnCRIr7JER6S9m15Wf2ibptjiiceISaPTaFHb6JvE7slY4qmla60fXzba3F9hP9iNpeTGFDdrQ"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "empSal", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "empSal", 1172651l));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, Exception {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Employee employee = createEmployee(false);
                java.lang.reflect.Field field = null;
                if (!contraints.getFieldName().equalsIgnoreCase("CombineUniqueKey")) {
                    field = employee.getClass().getDeclaredField(contraints.getFieldName());
                }
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(employee, null);
                        validateEmployee(contraints, employee);
                        failureCount++;
                        break;
                    case 2:
                        employee.setEmpName(contraints.getNegativeValue().toString());
                        validateEmployee(contraints, employee);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(employee, null);
                        validateEmployee(contraints, employee);
                        failureCount++;
                        break;
                    case 4:
                        employee.setEmpSal(Long.valueOf(contraints.getNegativeValue().toString()));
                        validateEmployee(contraints, employee);
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
