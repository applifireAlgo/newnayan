Ext.define('Mobilebp.mobilebp.smartdevice.com.view.defaultcontext.defaultdomain.Cui', {
     "xtype": "cui",
     "items": [{
          "xtype": "textfield",
          "fieldLabel": "cName",
          "margin": 5,
          "bindable": "cName",
          "name": "cName",
          "itemId": "textfield_ext_3788"
     }, {
          "xtype": "numberfield",
          "fieldLabel": "cNo",
          "name": "cNo",
          "margin": 5,
          "bindable": "cNo",
          "itemId": "numberfield_ext_3798"
     }],
     "border": true,
     "autoScroll": true,
     "title": "Form",
     "margin": 5,
     "itemId": "form_ext_3750",
     "dockedItems": [{
          "xtype": "toolbar",
          "dock": "bottom",
          "ui": "footer",
          "isToolBar": true,
          "isDockedItem": true,
          "items": [{
               "xtype": "button",
               "name": "Save",
               "text": "Save",
               "margin": 5,
               "itemId": "button_ext_3880",
               "icon": "images/1459171897736.png",
               "listeners": {
                    "click": "onSaveClick"
               }
          }, {
               "xtype": "button",
               "name": "Button",
               "text": "Button",
               "margin": 5,
               "itemId": "button_ext_4114",
               "listeners": {
                    "click": "onButtonClick"
               }
          }],
          "itemId": "toolbar_ext_3865",
          "dockedItems": []
     }],
     "extend": "Ext.form.Panel",
     "requires": ["Mobilebp.mobilebp.smartdevice.com.controller.defaultcontext.defaultdomain.CuiController", "Mobilebp.mobilebp.shared.com.viewmodel.defaultcontext.defaultdomain.CuiViewModel", "Mobilebp.mobilebp.shared.com.model.defaultcontext.defaultdomain.CuiModel"],
     "viewModel": "CuiViewModel",
     "controller": "CuiController"
});