Ext.define('Mobilebp.mobilebp.smartdevice.com.view.defaultcontext.defaultdomain.TestDateMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "TestDateMainController",
     "restURL": "/TestDate",
     "requires": ["Mobilebp.mobilebp.shared.com.model.defaultcontext.defaultdomain.TestDateModel", "Mobilebp.mobilebp.smartdevice.com.controller.defaultcontext.defaultdomain.TestDateMainController", "Mobilebp.mobilebp.shared.com.viewmodel.defaultcontext.defaultdomain.TestDateViewModel"],
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
               "itemId": "TestDateTree",
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
                    "viewModel": "TestDateViewModel",
                    "xtype": "form",
                    "displayName": "TestDate",
                    "title": "TestDate",
                    "name": "TestDate",
                    "itemId": "TestDate",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "today",
                         "itemId": "today",
                         "xtype": "customdatetimefield",
                         "customWidgetType": "vdCustomDateTime",
                         "displayName": "today",
                         "margin": "5 5 5 5",
                         "submitFormat": "d-m-Y H:i:s",
                         "format": "d-m-Y H:i:s",
                         "fieldLabel": "today<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "E0A7445E-DBC3-414D-AF8E-6BCAAB60B265",
                         "bind": "{today}",
                         "columnWidth": 1
                    }, {
                         "name": "tday",
                         "itemId": "tday",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Day",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Day<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "ADC51D89-3445-447A-A620-A5720D468205",
                         "minLength": "1",
                         "maxLength": "256",
                         "bind": "{tday}",
                         "columnWidth": 1
                    }, {
                         "name": "isHoliday",
                         "itemId": "isHoliday",
                         "xtype": "checkbox",
                         "customWidgetType": "vdCheckbox",
                         "displayName": "Holiday",
                         "margin": "5 5 5 5",
                         "value": "0",
                         "inputValue": true,
                         "fieldLabel": "Holiday<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "FDFDC0F5-3BEC-43D1-A6A9-EFCFABB5BEAF",
                         "bind": "{isHoliday}",
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
                         "customId": 795,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 795,
                              "customId": 286
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 795,
                              "customId": 287,
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
                              "parentId": 795,
                              "customId": 288,
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