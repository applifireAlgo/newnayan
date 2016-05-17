Ext.define('Mobilebp.mobilebp.web.com.controller.defaultcontext.defaultdomain.FrndUiController', {
     extend: 'Mobilebp.view.fw.frameworkController.FrameworkViewController',
     alias: 'controller.FrndUiController',
     onFormExt20216Afterrender: function(me, eOpts) {
          var jsonData = {};
          jsonData.tNm = this.view.down('#hiddenfield_ext_21255').getValue();
          var scope = this.getView();
          Ext.Ajax.request({
               url: 'secure/FNewWS/proFNew',
               async: true,
               method: 'POST',
               sender: scope,
               jsonData: jsonData,
               me: me,
               success: function(response, scope) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    if (responseText.response.success) {
                         var responseData = responseText.response.data;
                         scope.sender.down('#textfield_ext_20276').setValue(responseData.frndNm);
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