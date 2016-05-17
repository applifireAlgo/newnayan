package com.app.server.repository.sampleboundedcontext.sampledomain;
import com.app.server.repository.core.SearchInterfaceImpl;
import com.app.shared.sampleboundedcontext.sampledomain.TestEnt;
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
@SourceCodeAuthorClass(createdBy = "nayan.chaudhari@algorhythm.co.in", updatedBy = "", versionNumber = "1", comments = "Repository for TestEnt Master table Entity", complexity = Complexity.LOW)
public class TestEntRepositoryImpl extends SearchInterfaceImpl implements TestEntRepository<TestEnt> {

    @Autowired
    private ResourceFactoryManagerHelper emfResource;

    private LogManager Log = LogManagerFactory.getInstance(AppLoggerConstant.LOGGER_ID);

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Override
    @Transactional
    public List<TestEnt> findAll() throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        java.util.List<com.app.shared.sampleboundedcontext.sampledomain.TestEnt> query = emanager.createQuery("select u from TestEnt u where u.systemInfo.activeStatus=1").getResultList();
        Log.out.println("GGTHH324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "TestEntRepositoryImpl", "findAll", "Total Records Fetched = " + query.size());
        return query;
    }

    @Override
    @Transactional
    public TestEnt save(TestEnt entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.persist(entity);
        Log.out.println("GGTHH322100200", runtimeLogInfoHelper.getRequestHeaderBean(), "TestEntRepositoryImpl", "save", entity);
        return entity;
    }

    @Override
    @Transactional
    public List<TestEnt> save(List<TestEnt> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.app.shared.sampleboundedcontext.sampledomain.TestEnt obj = entity.get(i);
            emanager.persist(obj);
        }
        Log.out.println("GGTHH322100200", runtimeLogInfoHelper.getRequestHeaderBean(), "TestEntRepositoryImpl", "saveAll", "Total Records saved = " + entity.size());
        return entity;
    }

    @Transactional
    @Override
    public void delete(String id) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        com.app.shared.sampleboundedcontext.sampledomain.TestEnt s = emanager.find(com.app.shared.sampleboundedcontext.sampledomain.TestEnt.class, id);
        emanager.remove(s);
        Log.out.println("GGTHH328100200", runtimeLogInfoHelper.getRequestHeaderBean(), "TestEntRepositoryImpl", "delete", "Record Deleted");
    }

    @Override
    @Transactional
    public void update(TestEnt entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        emanager.merge(entity);
        Log.out.println("GGTHH321100200", runtimeLogInfoHelper.getRequestHeaderBean(), "TestEntRepositoryImpl", "update", entity);
    }

    @Override
    @Transactional
    public void update(List<TestEnt> entity) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        for (int i = 0; i < entity.size(); i++) {
            com.app.shared.sampleboundedcontext.sampledomain.TestEnt obj = entity.get(i);
            emanager.merge(obj);
        }
        Log.out.println("GGTHH321100200", runtimeLogInfoHelper.getRequestHeaderBean(), "TestEntRepositoryImpl", "updateAll", "Total Records updated = " + entity.size());
    }

    @Transactional
    public TestEnt findById(String testId) throws Exception {
        javax.persistence.EntityManager emanager = emfResource.getResource();
        javax.persistence.Query query = emanager.createNamedQuery("TestEnt.findById");
        query.setParameter("testId", testId);
        com.app.shared.sampleboundedcontext.sampledomain.TestEnt listOfTestEnt = (com.app.shared.sampleboundedcontext.sampledomain.TestEnt) query.getSingleResult();
        Log.out.println("GGTHH324100200", runtimeLogInfoHelper.getRequestHeaderBean(), "TestEntRepositoryImpl", "findById", "Total Records Fetched = " + listOfTestEnt);
        return listOfTestEnt;
    }
}
