Ext.define('Mobilebp.mobilebp.smartdevice.com.view.defaultcontext.defaultdomain.ParentMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "ParentMainController",
     "restURL": "/Parent",
     "requires": ["Mobilebp.mobilebp.shared.com.model.defaultcontext.defaultdomain.ParentModel", "Mobilebp.mobilebp.smartdevice.com.controller.defaultcontext.defaultdomain.ParentMainController", "Mobilebp.mobilebp.shared.com.viewmodel.defaultcontext.defaultdomain.ParentViewModel"],
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
               "itemId": "ParentTree",
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
                    "viewModel": "ParentViewModel",
                    "xtype": "form",
                    "displayName": "Parent",
                    "title": "Parent",
                    "name": "Parent",
                    "itemId": "Parent",
                    "bodyPadding": 10,
                    "items": [{
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
                         "bind": "{pName}",
                         "columnWidth": 1
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
                         "bind": "{pNo}",
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
                         "customId": 126,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 126,
                              "customId": 796
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 126,
                              "customId": 797,
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
                              "parentId": 126,
                              "customId": 798,
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