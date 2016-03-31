Ext.define('Mobilebp.mobilebp.smartdevice.com.view.defaultcontext.defaultdomain.TestUi', {
     "xtype": "testUi",
     "items": [{
          "xtype": "textfield",
          "fieldLabel": "TEst NM",
          "margin": 5,
          "bindable": "testNM",
          "name": "testNM",
          "itemId": "textfield_ext_3176"
     }, {
          "xtype": "textfield",
          "fieldLabel": "testNo",
          "margin": 5,
          "bindable": "testNo",
          "name": "testNo",
          "itemId": "textfield_ext_3186"
     }, {
          "xtype": "button",
          "name": "save",
          "text": "save",
          "margin": 5,
          "itemId": "button_ext_3249",
          "listeners": {
               "click": "onSaveClick"
          }
     }],
     "border": true,
     "autoScroll": true,
     "title": "Form",
     "margin": 5,
     "itemId": "form_ext_3167",
     "dockedItems": [],
     "extend": "Ext.form.Panel",
     "requires": ["Mobilebp.mobilebp.smartdevice.com.controller.defaultcontext.defaultdomain.TestUiController", "Mobilebp.mobilebp.shared.com.viewmodel.defaultcontext.defaultdomain.TestUiViewModel", "Mobilebp.mobilebp.shared.com.model.defaultcontext.defaultdomain.TestUiModel"],
     "viewModel": "TestUiViewModel",
     "controller": "TestUiController"
});