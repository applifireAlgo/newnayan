package com.app.server.businessservice.defaultcontext.defaultdomain;
import com.app.server.businessservice.defaultcontext.TestUserQBzService;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.app.shared.defaultcontext.defaultdomain.FDTO;

@Component
public class UserTest {

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private TestUserQBzService testUserQBzService;

    public void proUserTest(FDTO dto) throws Exception {
        java.util.List<com.app.shared.defaultcontext.TestUserQ> testUserQList = testUserQBzService.executeQueryTestUserQ(dto.getUserId());
    }
}
