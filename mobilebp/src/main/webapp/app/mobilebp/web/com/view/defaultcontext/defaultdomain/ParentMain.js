Ext.define('Mobilebp.mobilebp.web.com.view.defaultcontext.defaultdomain.ParentMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "ParentMainController",
     "restURL": "/Parent",
     "defaults": {
          "split": true
     },
     "requires": ["Mobilebp.mobilebp.shared.com.model.defaultcontext.defaultdomain.ParentModel", "Mobilebp.mobilebp.web.com.controller.defaultcontext.defaultdomain.ParentMainController", "Mobilebp.mobilebp.shared.com.viewmodel.defaultcontext.defaultdomain.ParentViewModel"],
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
               "displayName": "Parent",
               "name": "ParentTreeContainer",
               "itemId": "ParentTreeContainer",
               "restURL": "/Parent",
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
                    "itemId": "ParentTree",
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
                    "displayName": "Parent",
                    "title": "Parent",
                    "name": "Parent",
                    "itemId": "ParentForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "pId",
                         "itemId": "pId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "pId",
                         "margin": "5 5 5 5",
                         "fieldLabel": "pId<font color='red'> *<\/font>",
                         "fieldId": "4FFFA2FE-FE5D-4118-910F-04763AC8710D",
                         "hidden": true,
                         "value": "",
                         "bindable": "pId"
                    }, {
                         "name": "pName",
                         "itemId": "pName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "pName",
                         "margin": "5 5 5 5",
                         "fieldLabel": "pName<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "7C6F2A7A-052F-4E73-BAE6-2190561C4106",
                         "minLength": "1",
                         "maxLength": "256",
                         "bindable": "pName",
                         "columnWidth": 0.5
                    }, {
                         "name": "pNo",
                         "itemId": "pNo",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "pNo",
                         "margin": "5 5 5 5",
                         "fieldLabel": "pNo<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "0F55E359-C301-454A-80BA-A0C5D7559DE1",
                         "minValue": "-2147483648",
                         "maxValue": "2147483647",
                         "bindable": "pNo",
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
                         "fieldId": "C170CCAA-0923-4AB0-9B48-47C53134102F",
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
                         "customId": 398,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 398,
                              "customId": 678
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 398,
                              "customId": 679,
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
                              "parentId": 398,
                              "customId": 680,
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
                    "displayName": "Parent",
                    "title": "Details Grid",
                    "name": "ParentGrid",
                    "itemId": "ParentGrid",
                    "restURL": "/Parent",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "pId",
                         "dataIndex": "pId",
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
                         "header": "pName",
                         "dataIndex": "pName",
                         "flex": 1
                    }, {
                         "header": "pNo",
                         "dataIndex": "pNo",
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
               "displayName": "Parent",
               "title": "Parent",
               "name": "Parent",
               "itemId": "ParentForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "pId",
                    "itemId": "pId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "pId",
                    "margin": "5 5 5 5",
                    "fieldLabel": "pId<font color='red'> *<\/font>",
                    "fieldId": "4FFFA2FE-FE5D-4118-910F-04763AC8710D",
                    "hidden": true,
                    "value": "",
                    "bindable": "pId"
               }, {
                    "name": "pName",
                    "itemId": "pName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "pName",
                    "margin": "5 5 5 5",
                    "fieldLabel": "pName<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "7C6F2A7A-052F-4E73-BAE6-2190561C4106",
                    "minLength": "1",
                    "maxLength": "256",
                    "bindable": "pName",
                    "columnWidth": 0.5
               }, {
                    "name": "pNo",
                    "itemId": "pNo",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "pNo",
                    "margin": "5 5 5 5",
                    "fieldLabel": "pNo<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "0F55E359-C301-454A-80BA-A0C5D7559DE1",
                    "minValue": "-2147483648",
                    "maxValue": "2147483647",
                    "bindable": "pNo",
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
                    "fieldId": "C170CCAA-0923-4AB0-9B48-47C53134102F",
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
                    "customId": 398,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 398,
                         "customId": 678
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 398,
                         "customId": 679,
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
                         "parentId": 398,
                         "customId": 680,
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