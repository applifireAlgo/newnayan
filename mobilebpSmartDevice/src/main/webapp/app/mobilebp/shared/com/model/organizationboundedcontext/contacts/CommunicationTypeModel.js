Ext.define('Mobilebp.mobilebp.shared.com.model.organizationboundedcontext.contacts.CommunicationTypeModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "commType",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "commTypeName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "commTypeDescription",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "commgroupid",
          "reference": "CommunicationGroup",
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