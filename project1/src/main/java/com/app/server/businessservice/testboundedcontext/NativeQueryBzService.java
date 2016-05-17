package com.app.server.businessservice.testboundedcontext;
import com.app.shared.testboundedcontext.NativeQuery;
import java.util.List;

public interface NativeQueryBzService {

    public List<NativeQuery> executeQueryNativeQuery() throws Exception;
}
