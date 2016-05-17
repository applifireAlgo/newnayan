package com.app.shared.defaultcontext;
import com.athena.server.bizService.DTOMapperInterface;

public class RR implements DTOMapperInterface {

    private String userId;

    private String firstName;

    public RR(Object[] aryObject) {
        if (aryObject != null) {
            userId = (java.lang.String) aryObject[0];
            firstName = (java.lang.String) aryObject[1];
        } else {
            userId = null;
            firstName = null;
        }
    }

    public String getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }
}
