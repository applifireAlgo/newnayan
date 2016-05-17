Ext.define('Mobilebp.mobilebp.shared.com.model.defaultcontext.defaultdomain.TestEModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "testid",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "testNM",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "testNo",
          "type": "number",
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