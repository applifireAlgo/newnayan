package com.app.server.service.sampleboundedcontext.sampledomain;
import com.app.config.annotation.Complexity;
import com.app.config.annotation.SourceCodeAuthorClass;
import com.athena.server.pluggable.utils.bean.ResponseBean;
import org.springframework.http.HttpEntity;
import com.app.shared.sampleboundedcontext.sampledomain.TestEnt;
import java.util.List;
import com.athena.server.pluggable.utils.bean.FindByBean;

@SourceCodeAuthorClass(createdBy = "nayan.chaudhari@algorhythm.co.in", updatedBy = "", versionNumber = "1", comments = "Service for TestEnt Master table Entity", complexity = Complexity.LOW)
public abstract class TestEntService {

    public HttpEntity<ResponseBean> findAll() throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(TestEnt entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> save(List<TestEnt> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> delete(String id) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(TestEnt entity) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> update(List<TestEnt> entity, boolean isArray) throws Exception {
        return null;
    }

    public HttpEntity<ResponseBean> findById(FindByBean findByBean) throws Exception {
        return null;
    }
}
