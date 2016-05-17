package com.app.server.service.testboundedcontext.testdomain;
import com.app.server.businessservice.testboundedcontext.testdomain.DomainServiceToCallPerInfo;
import com.athena.server.pluggable.utils.bean.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@RequestMapping("/DomainServiceToCallPerInfoWS")
public class DomainServiceToCallPerInfoWS {

    @Autowired
    private DomainServiceToCallPerInfo domainservicetocallperinfo;

    @RequestMapping(value = "/getEntityData", consumes = "application/json", method = RequestMethod.POST)
    public HttpEntity<ResponseBean> getEntityData() throws Exception {
        com.athena.server.pluggable.utils.bean.ResponseBean responseBean = new com.athena.server.pluggable.utils.bean.ResponseBean();
        org.springframework.http.HttpStatus httpStatus = org.springframework.http.HttpStatus.CREATED;
        java.util.List<com.app.shared.testboundedcontext.NativeQuery> _ruleOutput = domainservicetocallperinfo.getEntityData();
        responseBean.add("success", true);
        responseBean.add("message", "Successfully executed ");
        responseBean.add("data", _ruleOutput);
        return new org.springframework.http.ResponseEntity<com.athena.server.pluggable.utils.bean.ResponseBean>(responseBean, httpStatus);
    }
}
