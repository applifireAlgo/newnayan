Ext.define('Mobilebp.mobilebp.smartdevice.com.view.defaultcontext.defaultdomain.FUui', {
     "xtype": "fUui",
     "items": [{
          "xtype": "textfield",
          "fieldLabel": "fileName",
          "margin": 5,
          "bindable": "fileName",
          "name": "fileName",
          "itemId": "textfield_ext_5922"
     }, {
          "xtype": "button",
          "name": "aduploFile",
          "pluginName": "upload",
          "isNativeWidget": true,
          "isNativeUploadBtn": true,
          "text": "Upload",
          "margin": 5,
          "itemId": "button_ext_8037"
     }],
     "margin": 5,
     "border": true,
     "autoScroll": true,
     "title": "Panel",
     "dockedItems": [{
          "xtype": "toolbar",
          "dock": "bottom",
          "ui": "footer",
          "isToolBar": true,
          "isDockedItem": true,
          "items": [{
               "xtype": "button",
               "name": "Button",
               "text": "Button",
               "margin": 5,
               "itemId": "button_ext_7115",
               "listeners": {
                    "click": "onButtonClick"
               }
          }],
          "dockedItems": [],
          "itemId": "toolbar_ext_7100"
     }],
     "itemId": "panel_ext_4917",
     "extend": "Ext.panel.Panel",
     "requires": ["Mobilebp.mobilebp.smartdevice.com.controller.defaultcontext.defaultdomain.FUuiController", "Mobilebp.mobilebp.shared.com.viewmodel.defaultcontext.defaultdomain.FUuiViewModel", "Mobilebp.mobilebp.shared.com.model.defaultcontext.defaultdomain.FUuiModel"],
     "viewModel": "FUuiViewModel",
     "controller": "FUuiController"
});