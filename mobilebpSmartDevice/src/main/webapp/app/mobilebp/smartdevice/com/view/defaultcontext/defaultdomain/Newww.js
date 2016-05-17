Ext.define('Mobilebp.mobilebp.smartdevice.com.view.defaultcontext.defaultdomain.Newww', {
     "xtype": "newww",
     "name": "Form",
     "items": [{
          "xtype": "textfield",
          "fieldLabel": "User",
          "margin": 5,
          "bindable": "first/name",
          "name": "first/name",
          "itemId": "textfield_ext_12519"
     }],
     "border": true,
     "autoScroll": true,
     "title": "Form",
     "margin": 5,
     "itemId": "form_ext_12509",
     "dockedItems": [],
     "extend": "Ext.form.Panel",
     "listeners": {
          "afterrender": "onFormAfterrender",
          "scope": "controller"
     },
     "requires": ["Mobilebp.mobilebp.smartdevice.com.controller.defaultcontext.defaultdomain.NewwwController", "Mobilebp.mobilebp.shared.com.viewmodel.defaultcontext.defaultdomain.NewwwViewModel", "Mobilebp.mobilebp.shared.com.model.defaultcontext.defaultdomain.NewwwModel"],
     "viewModel": "NewwwViewModel",
     "controller": "NewwwController"
});