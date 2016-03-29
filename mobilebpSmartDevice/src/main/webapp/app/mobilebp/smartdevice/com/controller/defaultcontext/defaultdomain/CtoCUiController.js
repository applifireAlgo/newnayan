Ext.define('Mobilebp.mobilebp.smartdevice.com.controller.defaultcontext.defaultdomain.CtoCUiController', {
     extend: 'Mobilebp.view.fw.frameworkController.FrameworkViewController',
     alias: 'controller.CtoCUiController',
     onCountryIdChange: function(me, newValue, oldValue, eOpts) {
          var jsonData = {};
          jsonData.findKey = this.view.down('#combo_ext_5525').getValue();
          var scope = this.getView();
          Ext.Ajax.request({
               url: AppRestUrl + 'secure/State/findByCountryId',
               async: true,
               method: 'POST',
               sender: scope,
               jsonData: jsonData,
               me: me,
               success: function(response, scope) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    if (responseText.response.success) {
                         var responseData = responseText.response.data;
                         var combo_ext_5536 = scope.sender.down('#combo_ext_5536');
                         scope.sender.controller.setComboComponentData(responseData, combo_ext_5536, 'stateName', 'stateId');
                    } else {
                         scope.sender.controller.responseHandler(responseText.response);
                    }
               },
               failure: function(response, scope) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    Ext.Msg.alert('Server Response', responseText.response.message);
               }
          }, scope);
     }
});