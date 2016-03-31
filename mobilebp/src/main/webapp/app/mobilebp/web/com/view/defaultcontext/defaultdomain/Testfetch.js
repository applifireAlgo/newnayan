Ext.define('Mobilebp.mobilebp.web.com.view.defaultcontext.defaultdomain.Testfetch', {
     "xtype": "testfetch",
     "items": [{
          "xtype": "displayfield",
          "fieldLabel": "firstName",
          "margin": 5,
          "bindable": "firstName",
          "style": "word-break: break-word; word-wrap: break-word;",
          "value": "DISPLAY CONTENT",
          "name": "firstName",
          "itemId": "displayfield_ext_13681"
     }],
     "border": true,
     "autoScroll": true,
     "title": "Form",
     "margin": 5,
     "itemId": "form_ext_13670",
     "dockedItems": [],
     "extend": "Ext.form.Panel",
     "listeners": {
          "afterrender": "onFormExt13670Afterrender",
          "scope": "controller"
     },
     "requires": ["Mobilebp.mobilebp.web.com.controller.defaultcontext.defaultdomain.TestfetchController", "Mobilebp.mobilebp.shared.com.viewmodel.defaultcontext.defaultdomain.TestfetchViewModel", "Mobilebp.mobilebp.shared.com.model.defaultcontext.defaultdomain.TestfetchModel"],
     "viewModel": "TestfetchViewModel",
     "controller": "TestfetchController"
});