package com.app.server.businessservice.testboundedcontext.testdomain;
import com.app.server.businessservice.testboundedcontext.NativeQueryBzService;
import com.athena.server.pluggable.utils.helper.RuntimeLogInfoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.app.shared.testboundedcontext.NativeQuery;
import java.util.List;

@Component
public class DomainServiceToCallPerInfo {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private NativeQueryBzService nativeQueryBzService;

    public List<NativeQuery> getEntityData() throws Exception {
        java.util.List<com.app.shared.testboundedcontext.NativeQuery> nativeQueryList = nativeQueryBzService.executeQueryNativeQuery();
        return nativeQueryList;
    }
}
