Ext.define('Salesnew.salesnew.shared.com.model.salesboundedcontext.sales.MaterialModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "auto",
          "defaultValue": ""
     }, {
          "name": "materialcode",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "materialdesc",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "brandcode",
          "reference": "Brand",
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