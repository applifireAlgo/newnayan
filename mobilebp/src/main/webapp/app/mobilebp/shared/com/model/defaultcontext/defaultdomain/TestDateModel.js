Ext.define('Mobilebp.mobilebp.shared.com.model.defaultcontext.defaultdomain.TestDateModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "tdid",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "today",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "tday",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "isHoliday",
          "type": "boolean",
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