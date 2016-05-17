package com.app.server.repository.sampleboundedcontext.sampledomain;
import com.app.server.repository.core.SearchInterfaceImpl;
import com.app.shared.sampleboundedcontext.sampledomain.Employee;
import org.springframework.stereotype.Repository;
import com.app.config.annotation.Complexity;
import com.app.config.annotation.SourceCodeAuthorClass;
import com.athena.server.pluggable.utils.helper.ResourceFactoryManagerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.spartan.pluggable.logger.alarms.AppAlarm;
import com.spartan.pluggable.logger.api.LogManagerFactory;
import com.athena.server.pluggable.utils.AppLoggerConstant;
import com.spartan.pluggable.logger.api.LogManager;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import java.lang.Override;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Repository
@SourceCodeAuthorClass(createdBy = "nayan.chaudhari@algorhythm.co.in", updatedBy = "nayan.chaudhari@algorhythm.co.in", versionNumber = "4", comments = "Repository for Employee Master table Entity", complexity = Complexity.LOW)
public class EmployeeRepositoryImpl extends SearchInterfaceImpl implements EmployeeRepository<Employee> {

    @Autowired
    private ResourceFactoryManagerHelper emfResource;

    private LogManager Log = LogManagerFactory.getInstance(AppLoggerConstant.LOGGER_ID);

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Override
    @Transactional
    public List<Employee> findAll() throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        java.util.List<com.app.shared.sampleboundedcontext.sampledomain.Employee> query = emanager.createQuery("select u from Employee u where u.systemInfo.activeStatus=1").getResultList();
        Log.out.println("GGTHH324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "EmployeeRepositoryImpl", "findAll", "Total Records Fetched = " + query.size());
        return query;
    }

    @Override
    @Transactional
    public Employee save(Employee entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.persist(entity);
        Log.out.println("GGTHH322100200", runtimeLogInfoHelper.getRequestHeaderBean(), "EmployeeRepositoryImpl", "save", entity);
        return entity;
    }

    @Override
    @Transactional
    public List<Employee> save(List<Employee> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.app.shared.sampleboundedcontext.sampledomain.Employee obj = entity.get(i);
            emanager.persist(obj);
        }
        Log.out.println("GGTHH322100200", runtimeLogInfoHelper.getRequestHeaderBean(), "EmployeeRepositoryImpl", "saveAll", "Total Records saved = " + entity.size());
        return entity;
    }

    @Transactional
    @Override
    public void delete(String id) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        com.app.shared.sampleboundedcontext.sampledomain.Employee s = emanager.find(com.app.shared.sampleboundedcontext.sampledomain.Employee.class, id);
        emanager.remove(s);
        Log.out.println("GGTHH328100200", runtimeLogInfoHelper.getRequestHeaderBean(), "EmployeeRepositoryImpl", "delete", "Record Deleted");
    }

    @Override
    @Transactional
    public void update(Employee entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.merge(entity);
        Log.out.println("GGTHH321100200", runtimeLogInfoHelper.getRequestHeaderBean(), "EmployeeRepositoryImpl", "update", entity);
    }

    @Override
    @Transactional
    public void update(List<Employee> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.app.shared.sampleboundedcontext.sampledomain.Employee obj = entity.get(i);
            emanager.merge(obj);
        }
        Log.out.println("GGTHH321100200", runtimeLogInfoHelper.getRequestHeaderBean(), "EmployeeRepositoryImpl", "updateAll", "Total Records updated = " + entity.size());
    }

    @Transactional
    public Employee findById(String empId) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("Employee.findById");
        query.setParameter("empId", empId);
        com.app.shared.sampleboundedcontext.sampledomain.Employee listOfEmployee = (com.app.shared.sampleboundedcontext.sampledomain.Employee) query.getSingleResult();
        Log.out.println("GGTHH324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "EmployeeRepositoryImpl", "findById", "Total Records Fetched = " + listOfEmployee);
        return listOfEmployee;
    }
}
