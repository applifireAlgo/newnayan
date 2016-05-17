package com.app.shared.testboundedcontext.testdomain;
import com.app.config.annotation.Complexity;
import com.app.config.annotation.SourceCodeAuthorClass;
import com.athena.server.pluggable.interfaces.CommonEntityInterface;
import java.io.Serializable;
import java.util.Comparator;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheType;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import java.sql.Timestamp;
import com.athena.config.jsonHandler.CustomSqlTimestampJsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.athena.config.jsonHandler.CustomSqlTimestampJsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import javax.persistence.Transient;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.athena.server.pluggable.utils.helper.EntityValidatorHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Version;
import com.app.shared.EntityAudit;
import javax.persistence.Embedded;
import com.app.shared.SystemInfo;
import java.lang.Override;
import javax.persistence.NamedQueries;

@Table(name = "ast_PersonalDetails_M")
@Entity
@Cache(type = CacheType.CACHE)
@SourceCodeAuthorClass(createdBy = "nayan.chaudhari@algorhythm.co.in", updatedBy = "", versionNumber = "1", comments = "PersonalDetails", complexity = Complexity.LOW)
@NamedQueries({ @javax.persistence.NamedQuery(name = "PersonalDetails.DefaultFinders", query = "select e from PersonalDetails e where e.systemInfo.activeStatus=1 and e.fName LIKE :fName"), @javax.persistence.NamedQuery(name = "PersonalDetails.findById", query = "select e from PersonalDetails e where e.systemInfo.activeStatus=1 and e.primaryKey1 =:primaryKey1") })
public class PersonalDetails implements Serializable, CommonEntityInterface, Comparator<PersonalDetails> {

    @Column(name = "fName")
    @JsonProperty("fName")
    @NotNull
    @Size(min = 1, max = 64)
    private String fName;

    @Column(name = "age")
    @JsonProperty("age")
    @NotNull
    @Min(-2147483648L)
    @Max(2147483647)
    private Integer age;

    @Column(name = "dateOfBirth")
    @JsonProperty("dateOfBirth")
    @NotNull
    @JsonSerialize(using = CustomSqlTimestampJsonSerializer.class)
    @JsonDeserialize(using = CustomSqlTimestampJsonDeserializer.class)
    private Timestamp dateOfBirth;

    @Column(name = "salary")
    @JsonProperty("salary")
    @NotNull
    @Min(-9223372000000000000L)
    @Max(9223372000000000000L)
    private Double salary;

    @Column(name = "isEmp")
    @JsonProperty("isEmp")
    @NotNull
    private Boolean isEmp;

    @Column(name = "ruSure")
    @JsonProperty("ruSure")
    @NotNull
    @Size(min = 0, max = 4)
    private String ruSure;

    @Transient
    private String primaryKey;

    @Id
    @Column(name = "primaryKey1")
    @JsonProperty("primaryKey1")
    @GeneratedValue(generator = "UUIDGenerator")
    private String primaryKey1;

    @Transient
    @JsonIgnore
    private EntityValidatorHelper<Object> entityValidator;

    @Version
    @Column(name = "versionId")
    @JsonProperty("versionId")
    private int versionId;

    @Embedded
    @JsonIgnore
    private EntityAudit entityAudit = new EntityAudit();

    @Embedded
    private SystemInfo systemInfo = new SystemInfo();

    @Transient
    private String primaryDisplay;

    public String getfName() {
        return fName;
    }

    public void setfName(String _fName) {
        if (_fName != null) {
            this.fName = _fName;
        }
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer _age) {
        if (_age != null) {
            this.age = _age;
        }
    }

    public Timestamp getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Timestamp _dateOfBirth) {
        if (_dateOfBirth != null) {
            this.dateOfBirth = _dateOfBirth;
        }
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double _salary) {
        if (_salary != null) {
            this.salary = _salary;
        }
    }

    public Boolean getIsEmp() {
        return isEmp;
    }

    public void setIsEmp(Boolean _isEmp) {
        if (_isEmp != null) {
            this.isEmp = _isEmp;
        }
    }

    public String getRuSure() {
        return ruSure;
    }

    public void setRuSure(String _ruSure) {
        if (_ruSure != null) {
            this.ruSure = _ruSure;
        }
    }

    public String getPrimaryKey() {
        return primaryKey1;
    }

    public void setPrimaryKey(String _primaryKey) {
        this.primaryKey = _primaryKey;
    }

    public String _getPrimarykey() {
        return primaryKey1;
    }

    public String getPrimaryKey1() {
        return primaryKey1;
    }

    public void setPrimaryKey1(String _primaryKey1) {
        this.primaryKey1 = _primaryKey1;
    }

    public int getVersionId() {
        return versionId;
    }

    public void setVersionId(int _versionId) {
        this.versionId = _versionId;
    }

    public void setPrimaryDisplay(String _primaryDisplay) {
        this.primaryDisplay = _primaryDisplay;
    }

    public SystemInfo getSystemInfo() {
        return systemInfo;
    }

    public void setSystemInfo(SystemInfo _systemInfo) {
        this.systemInfo = _systemInfo;
    }

    @JsonIgnore
    public boolean isHardDelete() {
        if (this.systemInfo == null) {
            this.systemInfo = new SystemInfo();
        }
        if (this.systemInfo.getActiveStatus() == -1) {
            return true;
        } else {
            return false;
        }
    }

    @JsonIgnore
    @Override
    public boolean isValid() throws SecurityException {
        boolean isValid = false;
        if (this.entityValidator != null) {
            isValid = this.entityValidator.validateEntity(this);
            this.systemInfo.setEntityValidated(true);
        } else {
            throw new java.lang.SecurityException();
        }
        return isValid;
    }

    @Override
    public void setEntityValidator(EntityValidatorHelper<Object> _validateFactory) {
        this.entityValidator = _validateFactory;
    }

    @Override
    public void setEntityAudit(int customerId, String userId, RECORD_TYPE recordType) {
        System.out.println("Setting logged in user info for " + recordType);
        if (entityAudit == null) {
            entityAudit = new EntityAudit();
        }
        if (recordType == RECORD_TYPE.ADD) {
            this.entityAudit.setCreatedBy(userId);
            this.entityAudit.setUpdatedBy(userId);
        } else {
            this.entityAudit.setUpdatedBy(userId);
        }
        setSystemInformation(recordType);
    }

    @Override
    public void setEntityAudit(int customerId, String userId) {
        if (entityAudit == null) {
            entityAudit = new EntityAudit();
        }
        if (getPrimaryKey() == null) {
            this.entityAudit.setCreatedBy(userId);
            this.entityAudit.setUpdatedBy(userId);
            this.systemInfo.setActiveStatus(1);
        } else {
            this.entityAudit.setUpdatedBy(userId);
        }
    }

    @JsonIgnore
    public String getLoggedInUserInfo() {
        String auditInfo = "";
        if (this.entityAudit != null) {
            auditInfo = entityAudit.toString();
        }
        return auditInfo;
    }

    @Override
    @JsonIgnore
    public void setSystemInformation(RECORD_TYPE recordType) {
        if (systemInfo == null) {
            systemInfo = new SystemInfo();
        }
        if (recordType == RECORD_TYPE.DELETE) {
            this.systemInfo.setActiveStatus(0);
        } else {
            this.systemInfo.setActiveStatus(1);
        }
    }

    @JsonIgnore
    public void setSystemInformation(Integer activeStatus) {
        this.systemInfo.setActiveStatus(activeStatus);
    }

    @JsonIgnore
    public String getSystemInformation() {
        String systemInfo = "";
        if (this.systemInfo != null) {
            systemInfo = systemInfo.toString();
        }
        return systemInfo;
    }

    @Override
    @JsonIgnore
    public void setSystemTxnCode(Integer transactionAccessCode) {
        if (systemInfo == null) {
            systemInfo = new SystemInfo();
        }
        this.systemInfo.setTxnAccessCode(transactionAccessCode);
    }

    @Override
    public int compare(PersonalDetails object1, PersonalDetails object2) {
        return 0;
    }

    public String getPrimaryDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append((fName == null ? " " : fName));
        return sb.toString();
    }

    public String toString() {
        return getPrimaryDisplay();
    }

    public int hashCode() {
        if (primaryKey1 == null) {
            return super.hashCode();
        } else {
            return primaryKey1.hashCode();
        }
    }

    public boolean equals(Object obj) {
        try {
            com.app.shared.testboundedcontext.testdomain.PersonalDetails other = (com.app.shared.testboundedcontext.testdomain.PersonalDetails) obj;
            if (primaryKey1 == null) {
                return false;
            } else if (!primaryKey1.equals(other.primaryKey1)) {
                return false;
            }
        } catch (java.lang.Exception ignore) {
            return false;
        }
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEntityValidated() {
        return this.systemInfo.isEntityValidated();
    }
}
