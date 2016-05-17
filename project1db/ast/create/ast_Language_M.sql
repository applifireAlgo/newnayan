CREATE TABLE ast_Language_M ( languageId VARCHAR2(64)  NOT NULL, language VARCHAR2(256)  NOT NULL, languageType VARCHAR2(32)  DEFAULT NULL, languageDescription VARCHAR2(256)  DEFAULT NULL, languageIcon VARCHAR2(128)  DEFAULT NULL, alpha2 VARCHAR2(2)  DEFAULT NULL, alpha3 VARCHAR2(3)  DEFAULT NULL, alpha4 VARCHAR2(4)  DEFAULT NULL, alpha4parentid NUMBER(11)  DEFAULT NULL, createdBy VARCHAR2(64)  DEFAULT '-1', createdDate TIMESTAMP  DEFAULT '01-Jan-2000 10:10:10', updatedBy VARCHAR2(64)  DEFAULT '-1', updatedDate TIMESTAMP  DEFAULT '01-Jan-2000 10:10:10', versionId NUMBER(11)  DEFAULT '-1', activeStatus NUMBER(1)  DEFAULT '1', txnAccessCode NUMBER  DEFAULT NULL, PRIMARY KEY (languageId));

exit;