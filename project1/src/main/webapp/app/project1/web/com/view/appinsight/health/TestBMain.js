Ext.define('Project1.project1.web.com.view.appinsight.health.TestBMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "TestBMainController",
     "restURL": "/TestB",
     "defaults": {
          "split": true
     },
     "requires": ["Project1.project1.shared.com.model.appinsight.health.TestBModel", "Project1.project1.web.com.controller.appinsight.health.TestBMainController", "Project1.project1.shared.com.viewmodel.appinsight.health.TestBViewModel"],
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
               "displayName": "TestB",
               "name": "TestBTreeContainer",
               "itemId": "TestBTreeContainer",
               "margin": "5 0 5 5",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "useArrows": true,
                    "name": "entityTreePanel",
                    "title": "Browse",
                    "rootVisible": false,
                    "itemId": "TestBTree",
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
                    "buttons": [{
                         "text": "Filter",
                         "handler": "onFilterClick",
                         "name": "filterButton"
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
                    "xtype": "form",
                    "displayName": "TestB",
                    "name": "TestB",
                    "itemId": "TestBForm",
                    "bodyPadding": 10,
                    "items": [{
                         "xtype": "form",
                         "itemId": "form0",
                         "customWidgetType": "vdCard",
                         "header": {
                              "hidden": true
                         },
                         "items": [{
                              "layout": "column",
                              "customWidgetType": "vdColumnLayout",
                              "header": {
                                   "hidden": true
                              },
                              "xtype": "panel",
                              "items": [{
                                   "name": "tid",
                                   "itemId": "tid",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "tid",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "tid<font color='red'> *<\/font>",
                                   "fieldId": "8E21784F-D002-4159-9C37-419031362F0B",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "tid"
                              }, {
                                   "name": "tno",
                                   "itemId": "tno",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "tno",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "tno<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "82DE51ED-4CFE-4EE8-8518-CAC3DB775A29",
                                   "minValue": "-2147483648",
                                   "maxValue": "2147483647",
                                   "bindable": "tno",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "tno1",
                                   "itemId": "tno1",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "tno1",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "tno1<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "BD6C2F1F-5E05-488D-8BFA-66FAE32A2908",
                                   "minValue": "-9223372000000000000",
                                   "maxValue": "9223372000000000000",
                                   "bindable": "tno1",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "tno3",
                                   "itemId": "tno3",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "tno3",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "tno3<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "40D8AEE4-C181-400E-AE85-E0355ADDBD86",
                                   "minValue": "-8388608",
                                   "maxValue": "8388607",
                                   "bindable": "tno3",
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
                                   "fieldId": "F4EDC9C8-0BDB-4744-90B1-A761DCE4B395",
                                   "bindable": "versionId",
                                   "hidden": true
                              }]
                         }]
                    }],
                    "tools": [{
                         "type": "help",
                         "tooltip": "Get Console",
                         "handler": "onConsoleClick"
                    }, {
                         "type": "refresh",
                         "tooltip": "Refresh Tab",
                         "handler": "init"
                    }],
                    "layout": "card",
                    "defaults": {
                         "autoScroll": true
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "margin": 0,
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {
                              "margin": "0 5 0 5"
                         }
                    }],
                    "listeners": {},
                    "extend": "Ext.form.Panel",
                    "region": "center",
                    "customWidgetType": "vdCardLayout"
               }, {
                    "xtype": "grid",
                    "customWidgetType": "vdGrid",
                    "displayName": "TestB",
                    "title": "Details Grid",
                    "name": "TestBGrid",
                    "itemId": "TestBGrid",
                    "store": [],
                    "bodyPadding": 10,
                    "requires": [],
                    "columns": [{
                         "header": "tid",
                         "dataIndex": "tid",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "tno",
                         "dataIndex": "tno",
                         "flex": 1
                    }, {
                         "header": "tno1",
                         "dataIndex": "tno1",
                         "flex": 1
                    }, {
                         "header": "tno3",
                         "dataIndex": "tno3",
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
               "xtype": "form",
               "displayName": "TestB",
               "name": "TestB",
               "itemId": "TestBForm",
               "bodyPadding": 10,
               "items": [{
                    "xtype": "form",
                    "itemId": "form0",
                    "customWidgetType": "vdCard",
                    "header": {
                         "hidden": true
                    },
                    "items": [{
                         "layout": "column",
                         "customWidgetType": "vdColumnLayout",
                         "header": {
                              "hidden": true
                         },
                         "xtype": "panel",
                         "items": [{
                              "name": "tid",
                              "itemId": "tid",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "tid",
                              "margin": "5 5 5 5",
                              "fieldLabel": "tid<font color='red'> *<\/font>",
                              "fieldId": "8E21784F-D002-4159-9C37-419031362F0B",
                              "hidden": true,
                              "value": "",
                              "bindable": "tid"
                         }, {
                              "name": "tno",
                              "itemId": "tno",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "tno",
                              "margin": "5 5 5 5",
                              "fieldLabel": "tno<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "82DE51ED-4CFE-4EE8-8518-CAC3DB775A29",
                              "minValue": "-2147483648",
                              "maxValue": "2147483647",
                              "bindable": "tno",
                              "columnWidth": 0.5
                         }, {
                              "name": "tno1",
                              "itemId": "tno1",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "tno1",
                              "margin": "5 5 5 5",
                              "fieldLabel": "tno1<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "BD6C2F1F-5E05-488D-8BFA-66FAE32A2908",
                              "minValue": "-9223372000000000000",
                              "maxValue": "9223372000000000000",
                              "bindable": "tno1",
                              "columnWidth": 0.5
                         }, {
                              "name": "tno3",
                              "itemId": "tno3",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "tno3",
                              "margin": "5 5 5 5",
                              "fieldLabel": "tno3<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "40D8AEE4-C181-400E-AE85-E0355ADDBD86",
                              "minValue": "-8388608",
                              "maxValue": "8388607",
                              "bindable": "tno3",
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
                              "fieldId": "F4EDC9C8-0BDB-4744-90B1-A761DCE4B395",
                              "bindable": "versionId",
                              "hidden": true
                         }]
                    }]
               }],
               "tools": [{
                    "type": "help",
                    "tooltip": "Get Console",
                    "handler": "onConsoleClick"
               }, {
                    "type": "refresh",
                    "tooltip": "Refresh Tab",
                    "handler": "init"
               }],
               "layout": "card",
               "defaults": {
                    "autoScroll": true
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "margin": 0,
                    "isDockedItem": true,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill"
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {
                         "margin": "0 5 0 5"
                    }
               }],
               "listeners": {},
               "extend": "Ext.form.Panel",
               "region": "center",
               "customWidgetType": "vdCardLayout"
          }]
     }]
});