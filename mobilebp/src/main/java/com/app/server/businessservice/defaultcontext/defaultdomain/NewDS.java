package com.app.server.businessservice.defaultcontext.defaultdomain;
import com.app.server.businessservice.defaultcontext.RRBzService;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.spartan.shield.sessionService.SessionDataMgtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.app.shared.defaultcontext.RR;
import com.athena.framework.server.exception.biz.SpartanDataNotFoundException;
import java.util.List;

@Component
public class NewDS {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private RRBzService rRBzService;

    @Autowired
    private SessionDataMgtService sessionService;

    public List<RR> proNewDS() throws SpartanDataNotFoundException, Exception {
        java.lang.String userIdFromSession = (java.lang.String) sessionService.getSessionData("userId");
        if (userIdFromSession == null) {
            throw new com.athena.framework.server.exception.biz.SpartanDataNotFoundException("Data not found in session");
        }
        java.util.List<com.app.shared.defaultcontext.RR> rRList = rRBzService.executeQueryRR(userIdFromSession);
        return rRList;
    }
}
