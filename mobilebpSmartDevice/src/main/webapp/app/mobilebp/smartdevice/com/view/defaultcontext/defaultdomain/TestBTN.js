Ext.define('Mobilebp.mobilebp.smartdevice.com.view.defaultcontext.defaultdomain.TestBTN', {
     "xtype": "testBTN",
     "items": [{
          "xtype": "textfield",
          "fieldLabel": "Name",
          "margin": 5,
          "bindable": "tNm",
          "name": "tNm",
          "itemId": "textfield_ext_26407"
     }, {
          "xtype": "textfield",
          "fieldLabel": "Frnd Name",
          "margin": 5,
          "bindable": "frndNm",
          "name": "frndNm",
          "itemId": "textfield_ext_26417"
     }, {
          "xtype": "button",
          "name": "Button",
          "text": "Button",
          "margin": 5,
          "itemId": "button_ext_26429",
          "icon": "images/1459255980295.png",
          "listeners": {
               "click": "onButtonClick"
          }
     }],
     "border": true,
     "autoScroll": true,
     "title": "Form",
     "margin": 5,
     "itemId": "form_ext_26398",
     "dockedItems": [],
     "extend": "Ext.form.Panel",
     "requires": ["Mobilebp.mobilebp.smartdevice.com.controller.defaultcontext.defaultdomain.TestBTNController", "Mobilebp.mobilebp.shared.com.viewmodel.defaultcontext.defaultdomain.TestBTNViewModel", "Mobilebp.mobilebp.shared.com.model.defaultcontext.defaultdomain.TestBTNModel"],
     "viewModel": "TestBTNViewModel",
     "controller": "TestBTNController"
});