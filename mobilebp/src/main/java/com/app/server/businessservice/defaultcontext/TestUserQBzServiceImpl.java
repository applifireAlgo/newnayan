package com.app.server.businessservice.defaultcontext;
import org.springframework.stereotype.Component;
import com.athena.server.bizService.QueryExecuterService;
import org.springframework.beans.factory.annotation.Autowired;
import com.app.shared.defaultcontext.TestUserQ;
import java.lang.Override;
import java.util.List;

@Component
public class TestUserQBzServiceImpl implements TestUserQBzService {

    @Autowired
    private QueryExecuterService queryExecuterService;

    @Override
    public List<TestUserQ> executeQueryTestUserQ(String alias11) throws Exception {
        java.util.List<com.app.shared.defaultcontext.TestUserQ> listDtoInterface = new java.util.ArrayList<com.app.shared.defaultcontext.TestUserQ>();
        try {
            atg.taglib.json.util.JSONObject queryParams = new atg.taglib.json.util.JSONObject();
            queryParams.put("queryId", "3E80506B-4D53-4B9C-A1F4-0889B82C6665");
            atg.taglib.json.util.JSONArray jsonArray = new atg.taglib.json.util.JSONArray();
            atg.taglib.json.util.JSONObject jsonObjectAlias11 = new atg.taglib.json.util.JSONObject();
            jsonObjectAlias11.put("name", "alias1");
            jsonObjectAlias11.put("value", alias11);
            jsonObjectAlias11.put("datatype", "VARCHAR");
            jsonObjectAlias11.put("index", 1);
            jsonArray.add(jsonObjectAlias11);
            queryParams.put("queryCriteria", jsonArray);
            listDtoInterface = queryExecuterService.getAllQueryData("com.app.shared.defaultcontext.TestUserQ", queryParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDtoInterface;
    }
}
