package com.app.server.repository.testboundedcontext.testdomain;
import com.app.server.repository.core.SearchInterface;
import com.app.config.annotation.Complexity;
import com.app.config.annotation.SourceCodeAuthorClass;
import java.util.List;

@SourceCodeAuthorClass(createdBy = "nayan.chaudhari@algorhythm.co.in", updatedBy = "", versionNumber = "1", comments = "Repository for PersonalDetails Master table Entity", complexity = Complexity.LOW)
public interface PersonalDetailsRepository<T> extends SearchInterface {

    public List<T> findAll() throws Exception;

    public T save(T entity) throws Exception;

    public List<T> save(List<T> entity) throws Exception;

    public void delete(String id) throws Exception;

    public void update(T entity) throws Exception;

    public void update(List<T> entity) throws Exception;

    public T findById(String primaryKey1) throws Exception;
}