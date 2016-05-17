package com.app.server.businessservice.defaultcontext;
import org.springframework.stereotype.Component;
import com.athena.server.bizService.QueryExecuterService;
import org.springframework.beans.factory.annotation.Autowired;
import com.app.shared.defaultcontext.RR;
import java.lang.Override;
import java.util.List;

@Component
public class RRBzServiceImpl implements RRBzService {

    @Autowired
    private QueryExecuterService queryExecuterService;

    @Override
    public List<RR> executeQueryRR(String userId11) throws Exception {
        java.util.List<com.app.shared.defaultcontext.RR> listDtoInterface = new java.util.ArrayList<com.app.shared.defaultcontext.RR>();
        try {
            atg.taglib.json.util.JSONObject queryParams = new atg.taglib.json.util.JSONObject();
            queryParams.put("queryId", "8D7D8F51-DDAB-4974-B3D8-3054FD21A2C2");
            atg.taglib.json.util.JSONArray jsonArray = new atg.taglib.json.util.JSONArray();
            atg.taglib.json.util.JSONObject jsonObjectUserId11 = new atg.taglib.json.util.JSONObject();
            jsonObjectUserId11.put("name", "userId1");
            jsonObjectUserId11.put("value", userId11);
            jsonObjectUserId11.put("datatype", "VARCHAR");
            jsonObjectUserId11.put("index", 1);
            jsonArray.add(jsonObjectUserId11);
            queryParams.put("queryCriteria", jsonArray);
            listDtoInterface = queryExecuterService.getAllQueryData("com.app.shared.defaultcontext.RR", queryParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDtoInterface;
    }
}
