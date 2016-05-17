Ext.define('Mobilebp.mobilebp.smartdevice.com.view.defaultcontext.defaultdomain.Rui', {
     "xtype": "rui",
     "items": [{
          "xtype": "reportview",
          "name": "cc",
          "title": "CC Report",
          "isCustomReport": true,
          "reportWidgets": ["2", "3"],
          "refId": "B101A76D-A7AD-48DE-B531-6F5AA1B25AEB",
          "margin": 5,
          "itemId": "reportview_ext_28459"
     }],
     "margin": 5,
     "border": true,
     "autoScroll": true,
     "title": "Panel",
     "itemId": "panel_ext_28448",
     "dockedItems": [],
     "requires": ["Mobilebp.view.reportui.ReportView", "Mobilebp.mobilebp.smartdevice.com.controller.defaultcontext.defaultdomain.RuiController", "Mobilebp.mobilebp.shared.com.viewmodel.defaultcontext.defaultdomain.RuiViewModel", "Mobilebp.mobilebp.shared.com.model.defaultcontext.defaultdomain.RuiModel"],
     "extend": "Ext.panel.Panel",
     "viewModel": "RuiViewModel",
     "controller": "RuiController"
});