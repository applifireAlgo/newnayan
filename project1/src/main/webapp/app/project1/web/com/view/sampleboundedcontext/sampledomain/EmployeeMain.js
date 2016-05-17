Ext.define('Project1.project1.web.com.view.sampleboundedcontext.sampledomain.EmployeeMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "EmployeeMainController",
     "restURL": "/Employee",
     "defaults": {
          "split": true
     },
     "requires": ["Project1.project1.shared.com.model.sampleboundedcontext.sampledomain.EmployeeModel", "Project1.project1.web.com.controller.sampleboundedcontext.sampledomain.EmployeeMainController", "Project1.project1.shared.com.viewmodel.sampleboundedcontext.sampledomain.EmployeeViewModel"],
     "communicationLog": [],
     "tabPosition": "bottom",
     "items": [{
          "title": "Data Browser",
          "layout": "border",
          "defaults": {
               "split": true
          },
          "autoScroll": false,
          "customWidgetType": "vdBorderLayout",
          "items": [{
               "xtype": "tabpanel",
               "customWidgetType": "vdTabLayout",
               "margin": "5 0 5 5",
               "border": 1,
               "style": {
                    "borderColor": "#f6f6f6",
                    "borderStyle": "solid",
                    "borderWidth": "1px"
               },
               "displayName": "Employee",
               "name": "EmployeeTreeContainer",
               "itemId": "EmployeeTreeContainer",
               "restURL": "/Employee",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "title": "Browse",
                    "name": "entityTreePanel",
                    "useArrows": true,
                    "rootVisible": false,
                    "itemId": "EmployeeTree",
                    "listeners": {
                         "select": "treeClick"
                    },
                    "tbar": [{
                         "xtype": "triggerfield",
                         "customWidgetType": "vdTriggerField",
                         "emptyText": "Search",
                         "triggerCls": "",
                         "listeners": {
                              "change": "onTriggerfieldChange",
                              "buffer": 250
                         }
                    }, "->", {
                         "xtype": "tool",
                         "type": "refresh",
                         "tooltip": "Refresh Tree Data",
                         "handler": "onTreeRefreshClick"
                    }]
               }, {
                    "title": "Advance Search",
                    "xtype": "form",
                    "customWidgetType": "vdFormpanel",
                    "itemId": "queryPanel",
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "text": "Filter",
                              "name": "filterButton",
                              "handler": "onFilterClick"
                         }]
                    }],
                    "items": []
               }],
               "region": "west",
               "width": "20%"
          }, {
               "region": "center",
               "layout": "border",
               "defaults": {
                    "split": true
               },
               "customWidgetType": "vdBorderLayout",
               "items": [{
                    "customWidgetType": "vdFormpanel",
                    "xtype": "form",
                    "displayName": "Employee",
                    "title": "Employee",
                    "name": "Employee",
                    "itemId": "EmployeeForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "empId",
                         "itemId": "empId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "empId",
                         "margin": "5 5 5 5",
                         "fieldLabel": "empId<font color='red'> *<\/font>",
                         "fieldId": "D144B09B-4EAB-47ED-AF78-EE1A9385421B",
                         "hidden": true,
                         "value": "",
                         "bindable": "empId"
                    }, {
                         "name": "empName",
                         "itemId": "empName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "empName",
                         "margin": "5 5 5 5",
                         "fieldLabel": "empName<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "9462D918-A39E-43A6-AFCC-8CCF566EFDEB",
                         "minLength": "1",
                         "maxLength": "256",
                         "bindable": "empName",
                         "columnWidth": 0.5
                    }, {
                         "name": "empSal",
                         "itemId": "empSal",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "empSal",
                         "margin": "5 5 5 5",
                         "fieldLabel": "empSal<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "297DA546-D1D3-4F6F-AA10-3D62D84BEB01",
                         "minValue": "0",
                         "maxValue": "1000000",
                         "bindable": "empSal",
                         "columnWidth": 0.5
                    }, {
                         "name": "versionId",
                         "itemId": "versionId",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "versionId",
                         "margin": "5 5 5 5",
                         "value": "-1",
                         "fieldLabel": "versionId",
                         "fieldId": "70ADAEF6-12CC-44A0-9B8F-F5C6AD0E6FAF",
                         "bindable": "versionId",
                         "hidden": true
                    }],
                    "layout": "column",
                    "defaults": {
                         "columnWidth": 0.5,
                         "labelAlign": "left",
                         "labelWidth": 200
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "ui": "footer",
                         "isDockedItem": true,
                         "parentId": 1,
                         "customId": 159,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 159,
                              "customId": 972
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 159,
                              "customId": 973,
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "resetFormButton",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "parentId": 159,
                              "customId": 974,
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {}
                    }],
                    "listeners": {
                         "scope": "controller"
                    },
                    "tools": [{
                         "type": "help",
                         "tooltip": "Console",
                         "handler": "onConsoleClick"
                    }, {
                         "type": "refresh",
                         "tooltip": "Refresh Tab",
                         "handler": "init"
                    }],
                    "extend": "Ext.form.Panel",
                    "region": "center"
               }, {
                    "xtype": "gridpanel",
                    "customWidgetType": "vdGrid",
                    "displayName": "Employee",
                    "title": "Details Grid",
                    "name": "EmployeeGrid",
                    "itemId": "EmployeeGrid",
                    "restURL": "/Employee",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "empId",
                         "dataIndex": "empId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryDisplay",
                         "dataIndex": "primaryDisplay",
                         "hidden": true
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "empName",
                         "dataIndex": "empName",
                         "flex": 1
                    }, {
                         "header": "empSal",
                         "dataIndex": "empSal",
                         "flex": 1
                    }, {
                         "header": "createdBy",
                         "dataIndex": "createdBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "createdDate",
                         "dataIndex": "createdDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedBy",
                         "dataIndex": "updatedBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedDate",
                         "dataIndex": "updatedDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "versionId",
                         "dataIndex": "versionId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "activeStatus",
                         "dataIndex": "activeStatus",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "txnAccessCode",
                         "dataIndex": "txnAccessCode",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "xtype": "actioncolumn",
                         "customWidgetType": "vdActionColumn",
                         "width": 30,
                         "sortable": false,
                         "menuDisable": true,
                         "items": [{
                              "icon": "images/delete.gif",
                              "tooltip": "Delete Record",
                              "handler": "onDeleteActionColumnClickMainGrid"
                         }]
                    }],
                    "listeners": {
                         "itemclick": "onGridItemClick"
                    },
                    "tools": [{
                         "type": "refresh",
                         "tooltip": "Refresh Grid Data",
                         "handler": "onGridRefreshClick"
                    }],
                    "collapsible": true,
                    "titleCollapse": true,
                    "collapseMode": "header",
                    "region": "south",
                    "height": "40%"
               }]
          }]
     }, {
          "title": "Add New",
          "itemId": "addNewForm",
          "layout": "border",
          "customWidgetType": "vdBorderLayout",
          "autoScroll": false,
          "items": [{
               "customWidgetType": "vdFormpanel",
               "xtype": "form",
               "displayName": "Employee",
               "title": "Employee",
               "name": "Employee",
               "itemId": "EmployeeForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "empId",
                    "itemId": "empId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "empId",
                    "margin": "5 5 5 5",
                    "fieldLabel": "empId<font color='red'> *<\/font>",
                    "fieldId": "D144B09B-4EAB-47ED-AF78-EE1A9385421B",
                    "hidden": true,
                    "value": "",
                    "bindable": "empId"
               }, {
                    "name": "empName",
                    "itemId": "empName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "empName",
                    "margin": "5 5 5 5",
                    "fieldLabel": "empName<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "9462D918-A39E-43A6-AFCC-8CCF566EFDEB",
                    "minLength": "1",
                    "maxLength": "256",
                    "bindable": "empName",
                    "columnWidth": 0.5
               }, {
                    "name": "empSal",
                    "itemId": "empSal",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "empSal",
                    "margin": "5 5 5 5",
                    "fieldLabel": "empSal<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "297DA546-D1D3-4F6F-AA10-3D62D84BEB01",
                    "minValue": "0",
                    "maxValue": "1000000",
                    "bindable": "empSal",
                    "columnWidth": 0.5
               }, {
                    "name": "versionId",
                    "itemId": "versionId",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "versionId",
                    "margin": "5 5 5 5",
                    "value": "-1",
                    "fieldLabel": "versionId",
                    "fieldId": "70ADAEF6-12CC-44A0-9B8F-F5C6AD0E6FAF",
                    "bindable": "versionId",
                    "hidden": true
               }],
               "layout": "column",
               "defaults": {
                    "columnWidth": 0.5,
                    "labelAlign": "left",
                    "labelWidth": 200
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "ui": "footer",
                    "isDockedItem": true,
                    "parentId": 1,
                    "customId": 159,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 159,
                         "customId": 972
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 159,
                         "customId": 973,
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "resetFormButton",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "parentId": 159,
                         "customId": 974,
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {}
               }],
               "listeners": {
                    "scope": "controller"
               },
               "tools": [{
                    "type": "help",
                    "tooltip": "Console",
                    "handler": "onConsoleClick"
               }, {
                    "type": "refresh",
                    "tooltip": "Refresh Tab",
                    "handler": "init"
               }],
               "extend": "Ext.form.Panel",
               "region": "center"
          }]
     }]
});