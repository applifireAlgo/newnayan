Ext.define('Mobilebp.mobilebp.smartdevice.com.view.defaultcontext.defaultdomain.MainPage', {
     "xtype": "mainPage",
     "items": [{
          "xtype": "panel",
          "items": [{
               "xtype": "button",
               "name": "TestUI",
               "text": "TestUI",
               "margin": 5,
               "columnWidth": 0.5,
               "itemId": "button_ext_4428",
               "listeners": {
                    "click": "onTestUIClick"
               }
          }, {
               "xtype": "button",
               "name": "CUi",
               "text": "CUi",
               "margin": 5,
               "columnWidth": 0.5,
               "itemId": "button_ext_4444",
               "listeners": {
                    "click": "onCUiClick"
               }
          }],
          "layout": "column",
          "autoScroll": true,
          "border": true,
          "title": "Column Layout",
          "margin": 5,
          "dockedItems": [],
          "itemId": "panel_ext_4413"
     }, {
          "xtype": "button",
          "name": "Ccui",
          "text": "Ccui",
          "margin": 5,
          "itemId": "button_ext_6470",
          "listeners": {
               "click": "onCcuiClick"
          }
     }],
     "border": true,
     "autoScroll": true,
     "title": "Form",
     "margin": 5,
     "dockedItems": [],
     "itemId": "form_ext_4405",
     "extend": "Ext.form.Panel",
     "requires": ["Mobilebp.mobilebp.smartdevice.com.controller.defaultcontext.defaultdomain.MainPageController", "Mobilebp.mobilebp.shared.com.viewmodel.defaultcontext.defaultdomain.MainPageViewModel", "Mobilebp.mobilebp.shared.com.model.defaultcontext.defaultdomain.MainPageModel"],
     "viewModel": "MainPageViewModel",
     "controller": "MainPageController"
});