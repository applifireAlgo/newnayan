Ext.define('Mobilebp.mobilebp.web.com.view.defaultcontext.defaultdomain.TestFUploadMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "TestFUploadMainController",
     "restURL": "/TestFUpload",
     "defaults": {
          "split": true
     },
     "requires": ["Mobilebp.mobilebp.shared.com.model.defaultcontext.defaultdomain.TestFUploadModel", "Mobilebp.mobilebp.web.com.controller.defaultcontext.defaultdomain.TestFUploadMainController", "Mobilebp.view.fw.component.FileUploadComponent", "Mobilebp.mobilebp.shared.com.viewmodel.defaultcontext.defaultdomain.TestFUploadViewModel"],
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
               "displayName": "TestFUpload",
               "name": "TestFUploadTreeContainer",
               "itemId": "TestFUploadTreeContainer",
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
                    "itemId": "TestFUploadTree",
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
                    "displayName": "TestFUpload",
                    "name": "TestFUpload",
                    "itemId": "TestFUploadForm",
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
                                   "name": "tfId",
                                   "itemId": "tfId",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "tfId",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "tfId<font color='red'> *<\/font>",
                                   "fieldId": "F1335C34-7C1E-4DC0-9E21-EE516A86D60A",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "tfId"
                              }, {
                                   "name": "fileName",
                                   "itemId": "fileName",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "fileName",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "fileName<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "58FE6284-C122-4741-AEBF-390249008269",
                                   "minLength": "1",
                                   "maxLength": "256",
                                   "bindable": "fileName",
                                   "columnWidth": 0.5
                              }, {
                                   "items": [{
                                        "name": "filePathHidden",
                                        "xtype": "hidden",
                                        "itemId": "filePathHidden"
                                   }, {
                                        "name": "uploadFile",
                                        "itemId": "uploadFile",
                                        "xtype": "fileupload",
                                        "customWidgetType": "vdFileUpload",
                                        "displayName": "uploadFile",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "uploadFile<font color='red'> *<\/font>",
                                        "allowBlank": false,
                                        "fieldId": "C221D50B-C229-4F31-B2A0-0D7806F88A71",
                                        "bindable": "uploadFile",
                                        "columnWidth": 0.5
                                   }]
                              }, {
                                   "name": "versionId",
                                   "itemId": "versionId",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "versionId",
                                   "margin": "5 5 5 5",
                                   "value": "-1",
                                   "fieldLabel": "versionId",
                                   "fieldId": "2C9EEC71-BE0F-4FA7-ACFB-83AD72CD621B",
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
                    "displayName": "TestFUpload",
                    "title": "Details Grid",
                    "name": "TestFUploadGrid",
                    "itemId": "TestFUploadGrid",
                    "store": [],
                    "bodyPadding": 10,
                    "requires": [],
                    "columns": [{
                         "header": "tfId",
                         "dataIndex": "tfId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "fileName",
                         "dataIndex": "fileName",
                         "flex": 1
                    }, {
                         "header": "uploadFile",
                         "dataIndex": "uploadFile",
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
               "displayName": "TestFUpload",
               "name": "TestFUpload",
               "itemId": "TestFUploadForm",
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
                              "name": "tfId",
                              "itemId": "tfId",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "tfId",
                              "margin": "5 5 5 5",
                              "fieldLabel": "tfId<font color='red'> *<\/font>",
                              "fieldId": "F1335C34-7C1E-4DC0-9E21-EE516A86D60A",
                              "hidden": true,
                              "value": "",
                              "bindable": "tfId"
                         }, {
                              "name": "fileName",
                              "itemId": "fileName",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "fileName",
                              "margin": "5 5 5 5",
                              "fieldLabel": "fileName<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "58FE6284-C122-4741-AEBF-390249008269",
                              "minLength": "1",
                              "maxLength": "256",
                              "bindable": "fileName",
                              "columnWidth": 0.5
                         }, {
                              "items": [{
                                   "name": "filePathHidden",
                                   "xtype": "hidden",
                                   "itemId": "filePathHidden"
                              }, {
                                   "name": "uploadFile",
                                   "itemId": "uploadFile",
                                   "xtype": "fileupload",
                                   "customWidgetType": "vdFileUpload",
                                   "displayName": "uploadFile",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "uploadFile<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "C221D50B-C229-4F31-B2A0-0D7806F88A71",
                                   "bindable": "uploadFile",
                                   "columnWidth": 0.5
                              }]
                         }, {
                              "name": "versionId",
                              "itemId": "versionId",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "versionId",
                              "margin": "5 5 5 5",
                              "value": "-1",
                              "fieldLabel": "versionId",
                              "fieldId": "2C9EEC71-BE0F-4FA7-ACFB-83AD72CD621B",
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