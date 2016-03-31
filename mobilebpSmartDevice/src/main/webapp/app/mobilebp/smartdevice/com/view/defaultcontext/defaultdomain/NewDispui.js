Ext.define('Mobilebp.mobilebp.smartdevice.com.view.defaultcontext.defaultdomain.NewDispui', {
     "xtype": "newDispui",
     "name": "Info",
     "items": [{
          "xtype": "displayfield",
          "fieldLabel": "Current User",
          "margin": 5,
          "bindable": "fname",
          "style": "word-break: break-word; word-wrap: break-word;",
          "value": "DISPLAY CONTENT",
          "name": "fname",
          "itemId": "displayfield_ext_10266"
     }],
     "border": true,
     "autoScroll": true,
     "title": "Info",
     "margin": 5,
     "itemId": "form_ext_10256",
     "dockedItems": [],
     "extend": "Ext.form.Panel",
     "listeners": {
          "afterrender": "onInfoAfterrender",
          "scope": "controller"
     },
     "requires": ["Mobilebp.mobilebp.smartdevice.com.controller.defaultcontext.defaultdomain.NewDispuiController", "Mobilebp.mobilebp.shared.com.viewmodel.defaultcontext.defaultdomain.NewDispuiViewModel", "Mobilebp.mobilebp.shared.com.model.defaultcontext.defaultdomain.NewDispuiModel"],
     "viewModel": "NewDispuiViewModel",
     "controller": "NewDispuiController"
});