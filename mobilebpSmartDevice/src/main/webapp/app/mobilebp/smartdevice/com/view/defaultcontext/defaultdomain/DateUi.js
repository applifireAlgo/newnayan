Ext.define('Mobilebp.mobilebp.smartdevice.com.view.defaultcontext.defaultdomain.DateUi', {
     "xtype": "dateUi",
     "items": [{
          "xtype": "textfield",
          "fieldLabel": "Day",
          "margin": 5,
          "bindable": "tday",
          "name": "tday",
          "itemId": "textfield_ext_4514"
     }, {
          "xtype": "customdatetimefield",
          "fieldLabel": "Today",
          "name": "today",
          "bindable": "today",
          "margin": 5,
          "itemId": "customdatetimefield_ext_4525",
          "submitFormat": "d-m-Y H:m:s"
     }, {
          "xtype": "checkbox",
          "fieldLabel": "isHoliday",
          "name": "isHoliday",
          "bindable": "isHoliday",
          "margin": 5,
          "itemId": "checkbox_ext_4540"
     }, {
          "xtype": "button",
          "name": "GM",
          "text": "GM",
          "margin": 5,
          "itemId": "button_ext_4673",
          "listeners": {
               "click": "onGMClick"
          }
     }],
     "border": true,
     "autoScroll": true,
     "title": "GoodMorning",
     "margin": 5,
     "itemId": "form_ext_3498",
     "dockedItems": [],
     "extend": "Ext.form.Panel",
     "requires": ["Mobilebp.mobilebp.smartdevice.com.controller.defaultcontext.defaultdomain.DateUiController", "Mobilebp.mobilebp.shared.com.viewmodel.defaultcontext.defaultdomain.DateUiViewModel", "Mobilebp.mobilebp.shared.com.model.defaultcontext.defaultdomain.DateUiModel", "Mobilebp.view.fw.component.DateTimeField", "Mobilebp.view.fw.component.DateTimePicker"],
     "viewModel": "DateUiViewModel",
     "controller": "DateUiController"
});