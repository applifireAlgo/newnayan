Ext.define('Mobilebp.mobilebp.web.com.view.defaultcontext.defaultdomain.TestEMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "TestEMainController",
     "restURL": "/TestE",
     "defaults": {
          "split": true
     },
     "requires": ["Mobilebp.mobilebp.shared.com.model.defaultcontext.defaultdomain.TestEModel", "Mobilebp.mobilebp.web.com.controller.defaultcontext.defaultdomain.TestEMainController", "Mobilebp.mobilebp.shared.com.viewmodel.defaultcontext.defaultdomain.TestEViewModel"],
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
               "displayName": "TestE",
               "name": "TestETreeContainer",
               "itemId": "TestETreeContainer",
               "restURL": "/TestE",
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
                    "itemId": "TestETree",
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
                    "displayName": "TestE",
                    "title": "TestE",
                    "name": "TestE",
                    "itemId": "TestEForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "testid",
                         "itemId": "testid",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "testid",
                         "margin": "5 5 5 5",
                         "fieldLabel": "testid<font color='red'> *<\/font>",
                         "fieldId": "5D8AB508-C23B-4526-860B-AD9812FEEEA8",
                         "hidden": true,
                         "value": "",
                         "bindable": "testid"
                    }, {
                         "name": "testNM",
                         "itemId": "testNM",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "testNM",
                         "margin": "5 5 5 5",
                         "fieldLabel": "testNM<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "0333779B-5FC9-42E1-A14D-F390520BDAB9",
                         "minLength": "1",
                         "maxLength": "256",
                         "bindable": "testNM",
                         "columnWidth": 0.5
                    }, {
                         "name": "testNo",
                         "itemId": "testNo",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "testNo",
                         "margin": "5 5 5 5",
                         "fieldLabel": "testNo<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "B9F0B1CA-216D-4C3F-B779-BBD87DBEC5D9",
                         "minValue": "-2147483648",
                         "maxValue": "2147483647",
                         "bindable": "testNo",
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
                         "fieldId": "9A17B449-5870-4310-A28C-12E55D0BAA03",
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
                         "customId": 26,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 26,
                              "customId": 262
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 26,
                              "customId": 263,
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
                              "parentId": 26,
                              "customId": 264,
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
                    "displayName": "TestE",
                    "title": "Details Grid",
                    "name": "TestEGrid",
                    "itemId": "TestEGrid",
                    "restURL": "/TestE",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "testid",
                         "dataIndex": "testid",
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
                         "header": "testNM",
                         "dataIndex": "testNM",
                         "flex": 1
                    }, {
                         "header": "testNo",
                         "dataIndex": "testNo",
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
               "displayName": "TestE",
               "title": "TestE",
               "name": "TestE",
               "itemId": "TestEForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "testid",
                    "itemId": "testid",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "testid",
                    "margin": "5 5 5 5",
                    "fieldLabel": "testid<font color='red'> *<\/font>",
                    "fieldId": "5D8AB508-C23B-4526-860B-AD9812FEEEA8",
                    "hidden": true,
                    "value": "",
                    "bindable": "testid"
               }, {
                    "name": "testNM",
                    "itemId": "testNM",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "testNM",
                    "margin": "5 5 5 5",
                    "fieldLabel": "testNM<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "0333779B-5FC9-42E1-A14D-F390520BDAB9",
                    "minLength": "1",
                    "maxLength": "256",
                    "bindable": "testNM",
                    "columnWidth": 0.5
               }, {
                    "name": "testNo",
                    "itemId": "testNo",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "testNo",
                    "margin": "5 5 5 5",
                    "fieldLabel": "testNo<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "B9F0B1CA-216D-4C3F-B779-BBD87DBEC5D9",
                    "minValue": "-2147483648",
                    "maxValue": "2147483647",
                    "bindable": "testNo",
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
                    "fieldId": "9A17B449-5870-4310-A28C-12E55D0BAA03",
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
                    "customId": 26,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 26,
                         "customId": 262
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 26,
                         "customId": 263,
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
                         "parentId": 26,
                         "customId": 264,
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