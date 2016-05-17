package com.app.shared.testboundedcontext;
import com.athena.server.dataengine.bizService.DTOMapperInterface;
import java.sql.Timestamp;
import com.athena.config.jsonHandler.CustomSqlTimestampJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.athena.config.jsonHandler.CustomSqlTimestampJsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class NativeQuery implements DTOMapperInterface {

    private String pRIMARYKEY1;

    private String fNAME;

    private Integer aGE;

    @JsonSerialize(using = CustomSqlTimestampJsonSerializer.class)
    @JsonDeserialize(using = CustomSqlTimestampJsonDeserializer.class)
    private Timestamp dATEOFBIRTH;

    private Double sALARY;

    private String iSEMP;

    private String rUSURE;

    private String cREATEDBY;

    @JsonSerialize(using = CustomSqlTimestampJsonSerializer.class)
    @JsonDeserialize(using = CustomSqlTimestampJsonDeserializer.class)
    private Timestamp cREATEDDATE;

    private String uPDATEDBY;

    @JsonSerialize(using = CustomSqlTimestampJsonSerializer.class)
    @JsonDeserialize(using = CustomSqlTimestampJsonDeserializer.class)
    private Timestamp uPDATEDDATE;

    private Integer vERSIONID;

    private Integer aCTIVESTATUS;

    private Integer tXNACCESSCODE;

    public NativeQuery(Object[] aryObject) {
        if (aryObject != null) {
            pRIMARYKEY1 = (java.lang.String) aryObject[0];
            fNAME = (java.lang.String) aryObject[1];
            aGE = new Integer(aryObject[2].toString());
            dATEOFBIRTH = (java.sql.Timestamp) aryObject[3];
            sALARY = (java.lang.Double) aryObject[4];
            iSEMP = (java.lang.String) aryObject[5];
            rUSURE = (java.lang.String) aryObject[6];
            cREATEDBY = (java.lang.String) aryObject[7];
            cREATEDDATE = (java.sql.Timestamp) aryObject[8];
            uPDATEDBY = (java.lang.String) aryObject[9];
            uPDATEDDATE = (java.sql.Timestamp) aryObject[10];
            vERSIONID = new Integer(aryObject[11].toString());
            aCTIVESTATUS = new Integer(aryObject[12].toString());
            tXNACCESSCODE = new Integer(aryObject[13].toString());
        } else {
            pRIMARYKEY1 = null;
            fNAME = null;
            aGE = null;
            dATEOFBIRTH = null;
            sALARY = null;
            iSEMP = null;
            rUSURE = null;
            cREATEDBY = null;
            cREATEDDATE = null;
            uPDATEDBY = null;
            uPDATEDDATE = null;
            vERSIONID = null;
            aCTIVESTATUS = null;
            tXNACCESSCODE = null;
        }
    }

    public String getpRIMARYKEY1() {
        return pRIMARYKEY1;
    }

    public String getfNAME() {
        return fNAME;
    }

    public Integer getaGE() {
        return aGE;
    }

    public Timestamp getdATEOFBIRTH() {
        return dATEOFBIRTH;
    }

    public Double getsALARY() {
        return sALARY;
    }

    public String getiSEMP() {
        return iSEMP;
    }

    public String getrUSURE() {
        return rUSURE;
    }

    public String getcREATEDBY() {
        return cREATEDBY;
    }

    public Timestamp getcREATEDDATE() {
        return cREATEDDATE;
    }

    public String getuPDATEDBY() {
        return uPDATEDBY;
    }

    public Timestamp getuPDATEDDATE() {
        return uPDATEDDATE;
    }

    public Integer getvERSIONID() {
        return vERSIONID;
    }

    public Integer getaCTIVESTATUS() {
        return aCTIVESTATUS;
    }

    public Integer gettXNACCESSCODE() {
        return tXNACCESSCODE;
    }
}
