Ext.define('Project1.project1.web.com.view.sampleboundedcontext.sampledomain.TestEntMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "TestEntMainController",
     "restURL": "/TestEnt",
     "defaults": {
          "split": true
     },
     "requires": ["Project1.project1.shared.com.model.sampleboundedcontext.sampledomain.TestEntModel", "Project1.project1.web.com.controller.sampleboundedcontext.sampledomain.TestEntMainController", "Project1.project1.shared.com.viewmodel.sampleboundedcontext.sampledomain.TestEntViewModel"],
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
               "displayName": "TestEnt",
               "name": "TestEntTreeContainer",
               "itemId": "TestEntTreeContainer",
               "restURL": "/TestEnt",
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
                    "itemId": "TestEntTree",
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
                    "displayName": "TestEnt",
                    "title": "TestEnt",
                    "name": "TestEnt",
                    "itemId": "TestEntForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "testId",
                         "itemId": "testId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "testId",
                         "margin": "5 5 5 5",
                         "fieldLabel": "testId<font color='red'> *<\/font>",
                         "fieldId": "9E8DF902-C31B-4481-BA2E-0C27A2153093",
                         "hidden": true,
                         "value": "",
                         "bindable": "testId"
                    }, {
                         "name": "testName",
                         "itemId": "testName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "testName",
                         "margin": "5 5 5 5",
                         "fieldLabel": "testName<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "A76E40C0-8B80-417B-88F0-7441B4CD6C80",
                         "minLength": "1",
                         "maxLength": "256",
                         "bindable": "testName",
                         "columnWidth": 0.5
                    }, {
                         "name": "duration",
                         "itemId": "duration",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Duration",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Duration<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "B0D9C2BC-0CFA-42CB-808C-9E7DE49711F7",
                         "minValue": "-2147483648",
                         "maxValue": "2147483647",
                         "bindable": "duration",
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
                         "fieldId": "C9878DDA-3E77-4075-A15A-7C61CD97281A",
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
                         "customId": 933,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 933,
                              "customId": 430
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 933,
                              "customId": 431,
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
                              "parentId": 933,
                              "customId": 432,
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
                    "displayName": "TestEnt",
                    "title": "Details Grid",
                    "name": "TestEntGrid",
                    "itemId": "TestEntGrid",
                    "restURL": "/TestEnt",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "testId",
                         "dataIndex": "testId",
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
                         "header": "testName",
                         "dataIndex": "testName",
                         "flex": 1
                    }, {
                         "header": "Duration",
                         "dataIndex": "duration",
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
               "displayName": "TestEnt",
               "title": "TestEnt",
               "name": "TestEnt",
               "itemId": "TestEntForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "testId",
                    "itemId": "testId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "testId",
                    "margin": "5 5 5 5",
                    "fieldLabel": "testId<font color='red'> *<\/font>",
                    "fieldId": "9E8DF902-C31B-4481-BA2E-0C27A2153093",
                    "hidden": true,
                    "value": "",
                    "bindable": "testId"
               }, {
                    "name": "testName",
                    "itemId": "testName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "testName",
                    "margin": "5 5 5 5",
                    "fieldLabel": "testName<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "A76E40C0-8B80-417B-88F0-7441B4CD6C80",
                    "minLength": "1",
                    "maxLength": "256",
                    "bindable": "testName",
                    "columnWidth": 0.5
               }, {
                    "name": "duration",
                    "itemId": "duration",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Duration",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Duration<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "B0D9C2BC-0CFA-42CB-808C-9E7DE49711F7",
                    "minValue": "-2147483648",
                    "maxValue": "2147483647",
                    "bindable": "duration",
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
                    "fieldId": "C9878DDA-3E77-4075-A15A-7C61CD97281A",
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
                    "customId": 933,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 933,
                         "customId": 430
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 933,
                         "customId": 431,
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
                         "parentId": 933,
                         "customId": 432,
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