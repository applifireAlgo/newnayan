Ext.define('Project1.project1.shared.com.model.testboundedcontext.testdomain.PersonalDetailsModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "primaryKey1",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "fName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "age",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "dateOfBirth",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "salary",
          "type": "number",
          "defaultValue": ""
     }, {
          "name": "isEmp",
          "type": "boolean",
          "defaultValue": ""
     }, {
          "name": "ruSure",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "versionId",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "entityAudit",
          "reference": "EntityAudit"
     }, {
          "name": "primaryDisplay",
          "type": "string",
          "defaultValue": ""
     }]
});