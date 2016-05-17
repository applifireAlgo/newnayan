Ext.define('Mobilebp.mobilebp.smartdevice.com.view.defaultcontext.defaultdomain.PUI', {
     "xtype": "pUI",
     "items": [{
          "xtype": "panel",
          "items": [{
               "xtype": "panel",
               "items": [{
                    "xtype": "numberfield",
                    "fieldLabel": "PNO",
                    "name": "pNo",
                    "margin": 5,
                    "bindable": "pNo",
                    "itemId": "numberfield_ext_9943"
               }, {
                    "xtype": "textfield",
                    "fieldLabel": "pName",
                    "margin": 5,
                    "bindable": "pName",
                    "name": "pName",
                    "itemId": "textfield_ext_9920"
               }],
               "margin": 5,
               "border": true,
               "autoScroll": true,
               "title": "Panel",
               "rowspan": 0,
               "colspan": 0,
               "itemId": "panel_ext_9899",
               "dockedItems": []
          }],
          "layout": {
               "type": "table",
               "columns": 3,
               "tableAttrs": {
                    "style": {
                         "width": "100%"
                    }
               }
          },
          "title": "Table Layout",
          "border": true,
          "margin": 5,
          "itemId": "panel_ext_9808",
          "dockedItems": []
     }, {
          "xtype": "button",
          "name": "Button",
          "text": "Button",
          "margin": 5,
          "itemId": "button_ext_10066",
          "listeners": {
               "click": "onButtonClick"
          }
     }],
     "margin": 5,
     "border": true,
     "autoScroll": true,
     "title": "Panel",
     "itemId": "panel_ext_8455",
     "dockedItems": [],
     "extend": "Ext.panel.Panel",
     "requires": ["Mobilebp.mobilebp.smartdevice.com.controller.defaultcontext.defaultdomain.PUIController", "Mobilebp.mobilebp.shared.com.viewmodel.defaultcontext.defaultdomain.PUIViewModel", "Mobilebp.mobilebp.shared.com.model.defaultcontext.defaultdomain.PUIModel"],
     "viewModel": "PUIViewModel",
     "controller": "PUIController"
});