DROP TABLE IF EXISTS `ast_SessionData_T`;

CREATE TABLE `ast_SessionData_T` ( `dataId` VARCHAR(256) NOT NULL, `customerId` VARCHAR(64) NULL DEFAULT NULL, `userId` VARCHAR(64) NOT NULL, `sessionKey` VARCHAR(64) NOT NULL, `dataType` INT(10) NOT NULL, `numberValue` INT(10) NULL DEFAULT NULL, `dateTimeValue` TIMESTAMP NULL DEFAULT NULL, `stringValue` VARCHAR(2000) NULL DEFAULT NULL, `booleanValue` TINYINT(1) NULL DEFAULT NULL, `jsonValue` TEXT NULL DEFAULT NULL, `appSessionId` VARCHAR(256) NOT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`dataId`));

