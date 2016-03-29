Ext.define('Mobilebp.mobilebp.smartdevice.com.view.defaultcontext.defaultdomain.ChildMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "ChildMainController",
     "restURL": "/Child",
     "requires": ["Mobilebp.mobilebp.shared.com.model.defaultcontext.defaultdomain.ChildModel", "Mobilebp.mobilebp.smartdevice.com.controller.defaultcontext.defaultdomain.ChildMainController", "Mobilebp.mobilebp.shared.com.viewmodel.defaultcontext.defaultdomain.ChildViewModel"],
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
               "itemId": "ChildTree",
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
                    "viewModel": "ChildViewModel",
                    "xtype": "form",
                    "displayName": "Child",
                    "title": "Child",
                    "name": "Child",
                    "itemId": "Child",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "cName",
                         "itemId": "cName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "cName",
                         "margin": "5 5 5 5",
                         "fieldLabel": "cName<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "2E2A8DBD-985C-4640-BC9F-D714941B7A55",
                         "minLength": "1",
                         "maxLength": "256",
                         "bind": "{cName}",
                         "columnWidth": 1
                    }, {
                         "name": "cNo",
                         "itemId": "cNo",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "cNo",
                         "margin": "5 5 5 5",
                         "fieldLabel": "cNo<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "05BD2290-BF72-44C3-B3A1-57B9984DC764",
                         "minValue": "-2147483648",
                         "maxValue": "2147483647",
                         "bind": "{cNo}",
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
                         "customId": 308,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 308,
                              "customId": 444
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 308,
                              "customId": 445,
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
                              "parentId": 308,
                              "customId": 446,
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