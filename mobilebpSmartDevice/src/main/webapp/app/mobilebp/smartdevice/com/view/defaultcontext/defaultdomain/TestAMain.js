Ext.define('Mobilebp.mobilebp.smartdevice.com.view.defaultcontext.defaultdomain.TestAMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "TestAMainController",
     "restURL": "/TestA",
     "requires": ["Mobilebp.mobilebp.shared.com.model.defaultcontext.defaultdomain.TestAModel", "Mobilebp.mobilebp.smartdevice.com.controller.defaultcontext.defaultdomain.TestAMainController", "Mobilebp.mobilebp.shared.com.viewmodel.defaultcontext.defaultdomain.TestAViewModel"],
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
               "itemId": "TestATree",
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
                    "viewModel": "TestAViewModel",
                    "xtype": "form",
                    "displayName": "TestA",
                    "title": "TestA",
                    "name": "TestA",
                    "itemId": "TestA",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "tNm",
                         "itemId": "tNm",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Name<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "60FC3C3C-5B9B-4597-A7E8-DDAEDA13123C",
                         "minLength": "1",
                         "maxLength": "256",
                         "bind": "{tNm}",
                         "columnWidth": 1
                    }, {
                         "name": "frndNm",
                         "itemId": "frndNm",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "FriendNm",
                         "margin": "5 5 5 5",
                         "fieldLabel": "FriendNm<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "1876E401-351B-42BC-A2B7-81A79EE6A1A8",
                         "minLength": "1",
                         "maxLength": "256",
                         "bind": "{frndNm}",
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
                         "customId": 236,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 236,
                              "customId": 334
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 236,
                              "customId": 335,
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
                              "parentId": 236,
                              "customId": 336,
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