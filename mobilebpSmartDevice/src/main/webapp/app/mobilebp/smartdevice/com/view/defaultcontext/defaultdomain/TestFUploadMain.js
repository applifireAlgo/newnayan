Ext.define('Mobilebp.mobilebp.smartdevice.com.view.defaultcontext.defaultdomain.TestFUploadMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "TestFUploadMainController",
     "restURL": "/TestFUpload",
     "requires": ["Mobilebp.mobilebp.shared.com.model.defaultcontext.defaultdomain.TestFUploadModel", "Mobilebp.mobilebp.smartdevice.com.controller.defaultcontext.defaultdomain.TestFUploadMainController", "Mobilebp.mobilebp.shared.com.viewmodel.defaultcontext.defaultdomain.TestFUploadViewModel"],
     "communicationLog": [],
     "tabPosition": "bottom",
     "margin": 5,
     "tabBar": {
          "hidden": true
     },
     "items": [{
          "title": "Data Browser",
          "layout": "border",
          "autoScroll": false,
          "customWidgetType": "vdBorderLayout",
          "items": [{
               "xtype": "treepanel",
               "customWidgetType": "vdTree",
               "title": "List",
               "useArrows": true,
               "rowLines": true,
               "columnLines": true,
               "rootVisible": false,
               "itemId": "TestFUploadTree",
               "listeners": {
                    "select": "treeClick"
               },
               "tbar": [{
                    "xtype": "triggerfield",
                    "customWidgetType": "vdTriggerField",
                    "width": "90%",
                    "height": "35",
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
               }],
               "region": "south",
               "height": "100%",
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false
          }, {
               "region": "center",
               "layout": "border",
               "customWidgetType": "vdBorderLayout",
               "items": [{
                    "customWidgetType": "vdFormpanel",
                    "viewModel": "TestFUploadViewModel",
                    "xtype": "form",
                    "displayName": "TestFUpload",
                    "title": "TestFUpload",
                    "name": "TestFUpload",
                    "itemId": "TestFUpload",
                    "bodyPadding": 10,
                    "items": [{
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
                         "bind": "{fileName}",
                         "columnWidth": 1
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
                         "bind": "{uploadFile}",
                         "columnWidth": 1
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
                         "isDockedItem": true,
                         "parentId": 1,
                         "customId": 620,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 620,
                              "customId": 633
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 620,
                              "customId": 634,
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "parentId": 620,
                              "customId": 635,
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {
                              "margin": "0 5 0 5",
                              "flex": 1,
                              "height": 30
                         }
                    }],
                    "listeners": {
                         "scope": "controller"
                    },
                    "extend": "Ext.form.Panel",
                    "region": "center"
               }]
          }]
     }]
});