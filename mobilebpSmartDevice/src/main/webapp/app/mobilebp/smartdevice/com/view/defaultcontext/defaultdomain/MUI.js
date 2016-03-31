Ext.define('Mobilebp.mobilebp.smartdevice.com.view.defaultcontext.defaultdomain.MUI', {
     "xtype": "mUI",
     "items": [{
          "xtype": "textfield",
          "fieldLabel": "tNm",
          "margin": 5,
          "bindable": "tNm",
          "name": "tNm",
          "itemId": "textfield_ext_25383"
     }, {
          "xtype": "button",
          "name": "Button",
          "text": "Button",
          "margin": 5,
          "itemId": "button_ext_25419",
          "listeners": {
               "click": "onButtonClick"
          }
     }, {
          "xtype": "grids",
          "name": "Grid",
          "title": "Grid",
          "hiddenName": "Grid",
          "margin": 5,
          "collapseMode": "header",
          "border": true,
          "editTools": false,
          "features": [],
          "plugins": [{
               "ptype": "cellediting",
               "clicksToEdit": 1
          }],
          "columns": [{
               "xtype": "gridcolumn",
               "header": "tAid",
               "hidden": true,
               "dataIndex": "tAid",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "tNm",
               "hidden": true,
               "dataIndex": "tNm",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "frndNm",
               "hidden": true,
               "dataIndex": "frndNm",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "createdBy",
               "hidden": true,
               "dataIndex": "createdBy",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "createdDate",
               "hidden": true,
               "dataIndex": "createdDate",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "updatedBy",
               "hidden": true,
               "dataIndex": "updatedBy",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "updatedDate",
               "hidden": true,
               "dataIndex": "updatedDate",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "versionId",
               "hidden": true,
               "dataIndex": "versionId",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "activeStatus",
               "hidden": true,
               "dataIndex": "activeStatus",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "txnAccessCode",
               "hidden": true,
               "dataIndex": "txnAccessCode",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "primaryDisplay",
               "hidden": true,
               "dataIndex": "primaryDisplay",
               "flex": 1
          }, {
               "xtype": "templatecolumn",
               "tpl": "<div><div align='left' style='margin-right: 2em;'><b>tNm :<\/b> {tNm}<\/div><div align='left' style='margin-right: 2em;'><b>frndNm :<\/b> {frndNm}<\/div><\/div>",
               "flex": 1
          }],
          "itemId": "gridpanel_ext_25433",
          "isRelatedWith": "eomddjlai",
          "store": {
               "model": "Mobilebp.mobilebp.shared.com.model.defaultcontext.defaultdomain.TestAModel",
               "autoLoad": true,
               "autoSync": true,
               "proxy": {
                    "type": "ajax",
                    "url": AppRestUrl+"secure/TestA/findAll",
                    "serviceId": "D310899F-6453-49FA-9635-CC4982816F25",
                    "serviceOperationId": "6A626287-416D-4D4D-8DED-32555BA30186",
                    "actionMethods": {
                         "read": "GET"
                    },
                    "headers": {
                         "Content-Type": "application/json"
                    },
                    "extraParams": {},
                    "reader": {
                         "type": "json",
                         "rootProperty": "response.data"
                    }
               }
          },
          "tools": [{
               "type": "refresh",
               "tooltip": "Refresh Grid Data",
               "handler": "onGridRefreshClick"
          }]
     }],
     "border": true,
     "autoScroll": true,
     "title": "Form",
     "margin": 5,
     "itemId": "form_ext_25374",
     "dockedItems": [],
     "requires": ["Mobilebp.mobilebp.shared.com.model.defaultcontext.defaultdomain.TestAModel", "Mobilebp.mobilebp.smartdevice.com.controller.defaultcontext.defaultdomain.MUIController", "Mobilebp.mobilebp.shared.com.viewmodel.defaultcontext.defaultdomain.MUIViewModel", "Mobilebp.mobilebp.shared.com.model.defaultcontext.defaultdomain.MUIModel", "Mobilebp.view.fw.component.Grids"],
     "extend": "Ext.form.Panel",
     "viewModel": "MUIViewModel",
     "controller": "MUIController"
});