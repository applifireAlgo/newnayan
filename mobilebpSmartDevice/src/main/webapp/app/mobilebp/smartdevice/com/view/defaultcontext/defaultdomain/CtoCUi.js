Ext.define('Mobilebp.mobilebp.smartdevice.com.view.defaultcontext.defaultdomain.CtoCUi', {
     "xtype": "ctoCUi",
     "items": [{
          "xtype": "combo",
          "name": "countryId",
          "margin": 5,
          "bindable": "countryId",
          "typeAhead": true,
          "queryMode": "local",
          "minChars": 1,
          "fieldLabel": "Country",
          "displayField": "countryName",
          "valueField": "countryId",
          "itemId": "combo_ext_5525",
          "store": {
               "model": "Mobilebp.mobilebp.shared.com.model.organizationboundedcontext.location.CountryModel",
               "autoLoad": true,
               "autoSync": true,
               "sorters": [{
                    "property": "countryName",
                    "direction": "ASC"
               }],
               "proxy": {
                    "type": "ajax",
                    "url": AppRestUrl+"secure/Country/findAll",
                    "serviceId": "0DEFF97E-15E7-41AE-A444-CC0E158E6AC4",
                    "serviceOperationId": "43DB0D0D-45CF-4013-9CDB-0A67C59C8B12",
                    "actionMethods": {
                         "read": "GET"
                    },
                    "headers": {
                         "Content-Type": "application/json"
                    },
                    "extraParams": {},
                    "reader": {
                         "type": "json",
                         "rootProperty": "response.data"
                    }
               }
          },
          "listeners": {
               "change": "onCountryIdChange"
          }
     }, {
          "xtype": "combo",
          "name": "StateId",
          "margin": 5,
          "bindable": "StateId",
          "typeAhead": true,
          "queryMode": "local",
          "minChars": 1,
          "fieldLabel": "State",
          "displayField": "stateName",
          "valueField": "stateId",
          "itemId": "combo_ext_5536",
          "isRelatedWith": "hlbnjcnji",
          "store": {
               "model": "Mobilebp.mobilebp.shared.com.model.organizationboundedcontext.location.StateModel",
               "autoLoad": true,
               "autoSync": true,
               "sorters": [{
                    "property": "stateName",
                    "direction": "ASC"
               }],
               "proxy": {
                    "type": "ajax",
                    "url": AppRestUrl+"secure/State/findAll",
                    "serviceId": "367EE30C-3F0E-42B2-AE9E-6171DD022E2E",
                    "serviceOperationId": "0C3ACF0F-3DD6-4900-B2E5-B493F65BF160",
                    "actionMethods": {
                         "read": "GET"
                    },
                    "headers": {
                         "Content-Type": "application/json"
                    },
                    "extraParams": {},
                    "reader": {
                         "type": "json",
                         "rootProperty": "response.data"
                    }
               }
          }
     }],
     "border": true,
     "autoScroll": true,
     "title": "Form",
     "margin": 5,
     "itemId": "form_ext_5516",
     "dockedItems": [],
     "requires": ["Mobilebp.mobilebp.shared.com.model.organizationboundedcontext.location.CountryModel", "Mobilebp.mobilebp.shared.com.model.organizationboundedcontext.location.StateModel", "Mobilebp.mobilebp.smartdevice.com.controller.defaultcontext.defaultdomain.CtoCUiController", "Mobilebp.mobilebp.shared.com.viewmodel.defaultcontext.defaultdomain.CtoCUiViewModel", "Mobilebp.mobilebp.shared.com.model.defaultcontext.defaultdomain.CtoCUiModel"],
     "extend": "Ext.form.Panel",
     "viewModel": "CtoCUiViewModel",
     "controller": "CtoCUiController"
});