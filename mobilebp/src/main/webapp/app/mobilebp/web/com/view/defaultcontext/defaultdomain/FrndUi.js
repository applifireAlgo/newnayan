Ext.define('Mobilebp.mobilebp.web.com.view.defaultcontext.defaultdomain.FrndUi', {
     "xtype": "frndUi",
     "items": [{
          "xtype": "textfield",
          "fieldLabel": "FrndName",
          "margin": 5,
          "bindable": "frndNm",
          "name": "frndNm",
          "itemId": "textfield_ext_20276"
     }, {
          "xtype": "hiddenfield",
          "fieldLabel": "name",
          "bindable": "name",
          "margin": 5,
          "name": "name",
          "itemId": "hiddenfield_ext_21255"
     }],
     "border": true,
     "autoScroll": true,
     "title": "Form",
     "margin": 5,
     "dockedItems": [],
     "itemId": "form_ext_20216",
     "extend": "Ext.form.Panel",
     "listeners": {
          "afterrender": "onFormExt20216Afterrender",
          "scope": "controller"
     },
     "requires": ["Mobilebp.mobilebp.web.com.controller.defaultcontext.defaultdomain.FrndUiController", "Mobilebp.mobilebp.shared.com.viewmodel.defaultcontext.defaultdomain.FrndUiViewModel", "Mobilebp.mobilebp.shared.com.model.defaultcontext.defaultdomain.FrndUiModel"],
     "viewModel": "FrndUiViewModel",
     "controller": "FrndUiController"
});