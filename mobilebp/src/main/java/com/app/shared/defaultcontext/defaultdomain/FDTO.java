package com.app.shared.defaultcontext.defaultdomain;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FDTO {

    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String _userId) {
        this.userId = _userId;
    }
}
