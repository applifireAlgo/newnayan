Ext.define('Mobilebp.mobilebp.web.com.view.defaultcontext.defaultdomain.TestUserMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "TestUserMainController",
     "restURL": "/TestUser",
     "defaults": {
          "split": true
     },
     "requires": ["Mobilebp.mobilebp.shared.com.model.defaultcontext.defaultdomain.TestUserModel", "Mobilebp.mobilebp.web.com.controller.defaultcontext.defaultdomain.TestUserMainController", "Mobilebp.mobilebp.shared.com.model.organizationboundedcontext.contacts.CoreContactsModel", "Mobilebp.mobilebp.shared.com.model.aaaboundedcontext.authentication.UserModel", "Mobilebp.mobilebp.shared.com.viewmodel.defaultcontext.defaultdomain.TestUserViewModel"],
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
               "displayName": "TestUser",
               "name": "TestUserTreeContainer",
               "itemId": "TestUserTreeContainer",
               "restURL": "/TestUser",
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
                    "itemId": "TestUserTree",
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
                    "displayName": "TestUser",
                    "title": "TestUser",
                    "name": "TestUser",
                    "itemId": "TestUserForm",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "tuId",
                         "itemId": "tuId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "tuId",
                         "margin": "5 5 5 5",
                         "fieldLabel": "tuId<font color='red'> *<\/font>",
                         "fieldId": "CB3EBCB8-1977-45C1-BC67-0A433A0BE1BE",
                         "hidden": true,
                         "value": "",
                         "bindable": "tuId"
                    }, {
                         "name": "fName",
                         "itemId": "fName",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "fName",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Mobilebp.mobilebp.shared.com.model.organizationboundedcontext.contacts.CoreContactsModel"
                         },
                         "allowBlank": false,
                         "fieldLabel": "fName<font color='red'> *<\/font>",
                         "fieldId": "9628D17E-4D86-4EC8-96C8-1A12E49196F5",
                         "restURL": "CoreContacts",
                         "bindable": "fName",
                         "columnWidth": 0.5
                    }, {
                         "name": "newuser",
                         "itemId": "newuser",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "User",
                         "margin": "5 5 5 5",
                         "valueField": "primaryKey",
                         "displayField": "primaryDisplay",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Mobilebp.mobilebp.shared.com.model.aaaboundedcontext.authentication.UserModel"
                         },
                         "allowBlank": false,
                         "fieldLabel": "User<font color='red'> *<\/font>",
                         "fieldId": "856D2E50-8E41-492C-A5A5-A5C8BCA77D23",
                         "restURL": "User",
                         "bindable": "newuser",
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
                         "fieldId": "E8CCE0B1-C40C-441F-8954-58398FB4A0EB",
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
                         "customId": 512,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 512,
                              "customId": 881
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "name": "saveFormButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 512,
                              "customId": 882,
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
                              "parentId": 512,
                              "customId": 883,
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
                    "displayName": "TestUser",
                    "title": "Details Grid",
                    "name": "TestUserGrid",
                    "itemId": "TestUserGrid",
                    "restURL": "/TestUser",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "tuId",
                         "dataIndex": "tuId",
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
                         "header": "fName",
                         "dataIndex": "fName",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "User",
                         "dataIndex": "newuser",
                         "renderer": "renderFormValue",
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
               "displayName": "TestUser",
               "title": "TestUser",
               "name": "TestUser",
               "itemId": "TestUserForm",
               "bodyPadding": 10,
               "items": [{
                    "name": "tuId",
                    "itemId": "tuId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "tuId",
                    "margin": "5 5 5 5",
                    "fieldLabel": "tuId<font color='red'> *<\/font>",
                    "fieldId": "CB3EBCB8-1977-45C1-BC67-0A433A0BE1BE",
                    "hidden": true,
                    "value": "",
                    "bindable": "tuId"
               }, {
                    "name": "fName",
                    "itemId": "fName",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "fName",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Mobilebp.mobilebp.shared.com.model.organizationboundedcontext.contacts.CoreContactsModel"
                    },
                    "allowBlank": false,
                    "fieldLabel": "fName<font color='red'> *<\/font>",
                    "fieldId": "9628D17E-4D86-4EC8-96C8-1A12E49196F5",
                    "restURL": "CoreContacts",
                    "bindable": "fName",
                    "columnWidth": 0.5
               }, {
                    "name": "newuser",
                    "itemId": "newuser",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "User",
                    "margin": "5 5 5 5",
                    "valueField": "primaryKey",
                    "displayField": "primaryDisplay",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Mobilebp.mobilebp.shared.com.model.aaaboundedcontext.authentication.UserModel"
                    },
                    "allowBlank": false,
                    "fieldLabel": "User<font color='red'> *<\/font>",
                    "fieldId": "856D2E50-8E41-492C-A5A5-A5C8BCA77D23",
                    "restURL": "User",
                    "bindable": "newuser",
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
                    "fieldId": "E8CCE0B1-C40C-441F-8954-58398FB4A0EB",
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
                    "customId": 512,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 512,
                         "customId": 881
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "name": "saveFormButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 512,
                         "customId": 882,
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
                         "parentId": 512,
                         "customId": 883,
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