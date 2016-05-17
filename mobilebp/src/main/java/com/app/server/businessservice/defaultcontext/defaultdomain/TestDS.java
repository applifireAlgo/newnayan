package com.app.server.businessservice.defaultcontext.defaultdomain;
import com.app.server.businessservice.defaultcontext.TestUserQBzService;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.spartan.shield.sessionService.SessionDataMgtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.app.shared.defaultcontext.TestUserQ;
import com.athena.framework.server.exception.biz.SpartanDataNotFoundException;
import java.util.List;

@Component
public class TestDS {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private TestUserQBzService testUserQBzService;

    @Autowired
    private SessionDataMgtService sessionService;

    public List<TestUserQ> proTestDS() throws SpartanDataNotFoundException, Exception {
        java.lang.String userIdFromSession = (java.lang.String) sessionService.getSessionData("userId");
        if (userIdFromSession == null) {
            throw new com.athena.framework.server.exception.biz.SpartanDataNotFoundException("Data not found in session");
        }
        java.util.List<com.app.shared.defaultcontext.TestUserQ> testUserQList = testUserQBzService.executeQueryTestUserQ(userIdFromSession);
        return testUserQList;
    }
}
