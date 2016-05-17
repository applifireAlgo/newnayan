Ext.define('Project1.project1.web.com.view.testboundedcontext.testdomain.Screen1', {
     "xtype": "screen1",
     "items": [{
          "xtype": "grids",
          "name": "Grid",
          "title": "Grid",
          "autoScroll": true,
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
               "header": "Primarykey1",
               "dataIndex": "pRIMARYKEY1",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "Fname",
               "dataIndex": "fNAME",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "Age",
               "dataIndex": "aGE",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "Dateofbirth",
               "dataIndex": "dATEOFBIRTH",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "Salary",
               "dataIndex": "sALARY",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "Isemp",
               "dataIndex": "iSEMP",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "Rusure",
               "dataIndex": "rUSURE",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "Createdby",
               "dataIndex": "cREATEDBY",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "Createddate",
               "dataIndex": "cREATEDDATE",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "Updatedby",
               "dataIndex": "uPDATEDBY",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "Updateddate",
               "dataIndex": "uPDATEDDATE",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "Versionid",
               "dataIndex": "vERSIONID",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "Activestatus",
               "dataIndex": "aCTIVESTATUS",
               "flex": 1
          }, {
               "xtype": "gridcolumn",
               "header": "Txnaccesscode",
               "dataIndex": "tXNACCESSCODE",
               "flex": 1
          }],
          "itemId": "gridpanel_ext_6681",
          "store": {
               "autoLoad": true,
               "autoSync": true,
               "model": "Project1.project1.shared.com.model.testboundedcontext.NativeQueryModel",
               "proxy": {
                    "type": "ajax",
                    "url": "secure/DomainServiceToCallPerInfoWS/getEntityData",
                    "serviceId": "4B685997-9085-41B8-A227-33683CB3DE76",
                    "serviceOperationId": "0DED715D-41AA-41EE-9D95-3C0EF052D078",
                    "serviceType": 3,
                    "actionMethods": {
                         "read": "POST"
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
     "header": {
          "hidden": true
     },
     "dockedItems": [],
     "itemId": "form_ext_6661",
     "requires": ["Project1.project1.shared.com.model.testboundedcontext.PersonalINfoModel", "Project1.project1.shared.com.model.testboundedcontext.NativeQueryModel", "Project1.project1.web.com.controller.testboundedcontext.testdomain.Screen1Controller", "Project1.project1.shared.com.viewmodel.testboundedcontext.testdomain.Screen1ViewModel", "Project1.project1.shared.com.model.testboundedcontext.testdomain.Screen1Model", "Project1.view.fw.component.Grids"],
     "extend": "Ext.form.Panel",
     "viewModel": "Screen1ViewModel",
     "controller": "Screen1Controller"
});