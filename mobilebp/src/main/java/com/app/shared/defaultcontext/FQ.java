package com.app.shared.defaultcontext;
import com.athena.server.bizService.DTOMapperInterface;

public class FQ implements DTOMapperInterface {

    private String frndNm;

    public FQ(Object obj) {
        if (obj != null) {
            frndNm = (java.lang.String) obj;
        } else {
            frndNm = null;
        }
    }

    public String getFrndNm() {
        return frndNm;
    }
}
