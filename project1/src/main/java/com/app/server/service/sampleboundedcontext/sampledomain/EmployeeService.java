package com.app.server.service.sampleboundedcontext.sampledomain;
import com.app.config.annotation.Complexity;
import com.app.config.annotation.SourceCodeAuthorClass;
import com.athena.server.pluggable.utils.bean.ResponseBean;
import org.springframework.http.HttpEntity;
import com.app.shared.sampleboundedcontext.sampledomain.Employee;
import java.util.List;
import com.athena.server.pluggable.utils.bean.FindByBean;

@SourceCodeAuthorClass(createdBy = "nayan.chaudhari@algorhythm.co.in", updatedBy = "nayan.chaudhari@algorhythm.co.in", versionNumber = "4", comments = "Service for Employee Master table Entity", complexity = Complexity.LOW)
public abstract class EmployeeService {

    public HttpEntity<ResponseBean> findAll() throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(Employee entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(List<Employee> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> delete(String id) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(Employee entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(List<Employee> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findById(FindByBean findByBean) throws Exception {
        return null;
    }
}
