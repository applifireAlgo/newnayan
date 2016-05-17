package com.app.server.businessservice.testboundedcontext;
import org.springframework.stereotype.Component;
import com.athena.server.dataengine.bizService.QueryExecuterService;
import org.springframework.beans.factory.annotation.Autowired;
import com.app.shared.testboundedcontext.PersonalINfo;
import java.lang.Override;
import java.util.List;

@Component
public class PersonalINfoBzServiceImpl implements PersonalINfoBzService {

    @Autowired
    private QueryExecuterService queryExecuterService;

    @Override
    public List<PersonalINfo> executeQueryPersonalINfo() throws Exception {
        java.util.List<com.app.shared.testboundedcontext.PersonalINfo> listDtoInterface = new java.util.ArrayList<com.app.shared.testboundedcontext.PersonalINfo>();
        try {
            atg.taglib.json.util.JSONObject queryParams = new atg.taglib.json.util.JSONObject();
            queryParams.put("queryId", "B1E81FCA-C2E6-4A4A-960E-36DDF452F634");
            atg.taglib.json.util.JSONArray jsonArray = new atg.taglib.json.util.JSONArray();
            queryParams.put("queryCriteria", jsonArray);
            listDtoInterface = queryExecuterService.getAllQueryData("com.app.shared.testboundedcontext.PersonalINfo", queryParams);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDtoInterface;
    }
}
