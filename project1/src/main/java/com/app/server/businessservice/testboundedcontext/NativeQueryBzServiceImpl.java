package com.app.server.businessservice.testboundedcontext;
import org.springframework.stereotype.Component;
import com.athena.server.dataengine.bizService.QueryExecuterService;
import org.springframework.beans.factory.annotation.Autowired;
import com.app.shared.testboundedcontext.NativeQuery;
import java.lang.Override;
import java.util.List;

@Component
public class NativeQueryBzServiceImpl implements NativeQueryBzService {

    @Autowired
    private QueryExecuterService queryExecuterService;

    @Override
    public List<NativeQuery> executeQueryNativeQuery() throws Exception {
        java.util.List<com.app.shared.testboundedcontext.NativeQuery> listDtoInterface = new java.util.ArrayList<com.app.shared.testboundedcontext.NativeQuery>();
        try {
            atg.taglib.json.util.JSONObject queryParams = new atg.taglib.json.util.JSONObject();
            queryParams.put("queryId", "4C79BFFA-2B35-4C2E-8EA6-96488BDC1D2F");
            atg.taglib.json.util.JSONArray jsonArray = new atg.taglib.json.util.JSONArray();
            queryParams.put("queryCriteria", jsonArray);
            listDtoInterface = queryExecuterService.getAllQueryData("com.app.shared.testboundedcontext.NativeQuery", queryParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDtoInterface;
    }
}
