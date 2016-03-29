package com.app.shared.defaultcontext.defaultdomain;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class NewDto {

    private String tNm;

    public String gettNm() {
        return tNm;
    }

    public void settNm(String _tNm) {
        this.tNm = _tNm;
    }
}
