package com.app.shared.defaultcontext;
import com.athena.server.bizService.DTOMapperInterface;

public class TestUserQ implements DTOMapperInterface {

    private String firstName;

    public TestUserQ(Object obj) {
        if (obj != null) {
            firstName = (java.lang.String) obj;
        } else {
            firstName = null;
        }
    }

    public String getFirstName() {
        return firstName;
    }
}
