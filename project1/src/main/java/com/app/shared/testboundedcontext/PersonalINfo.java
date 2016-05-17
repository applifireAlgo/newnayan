package com.app.shared.testboundedcontext;
import com.athena.server.dataengine.bizService.DTOMapperInterface;
import java.sql.Timestamp;
import com.athena.config.jsonHandler.CustomSqlTimestampJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.athena.config.jsonHandler.CustomSqlTimestampJsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class PersonalINfo implements DTOMapperInterface {

    private String primaryKey1;

    private String fName;

    private Integer age;

    @JsonSerialize(using = CustomSqlTimestampJsonSerializer.class)
    @JsonDeserialize(using = CustomSqlTimestampJsonDeserializer.class)
    private Timestamp dateOfBirth;

    private Double salary;

    private Boolean isEmp;

    private String ruSure;

    public PersonalINfo(Object[] aryObject) {
        if (aryObject != null) {
            primaryKey1 = (java.lang.String) aryObject[0];
            fName = (java.lang.String) aryObject[1];
            age = new Integer(aryObject[2].toString());
            dateOfBirth = (java.sql.Timestamp) aryObject[3];
            salary = (java.lang.Double) aryObject[4];
            isEmp = (java.lang.Boolean) aryObject[5];
            ruSure = (java.lang.String) aryObject[6];
        } else {
            primaryKey1 = null;
            fName = null;
            age = null;
            dateOfBirth = null;
            salary = null;
            isEmp = null;
            ruSure = null;
        }
    }

    public String getPrimaryKey1() {
        return primaryKey1;
    }

    public String getfName() {
        return fName;
    }

    public Integer getAge() {
        return age;
    }

    public Timestamp getDateOfBirth() {
        return dateOfBirth;
    }

    public Double getSalary() {
        return salary;
    }

    public Boolean getIsEmp() {
        return isEmp;
    }

    public String getRuSure() {
        return ruSure;
    }
}
