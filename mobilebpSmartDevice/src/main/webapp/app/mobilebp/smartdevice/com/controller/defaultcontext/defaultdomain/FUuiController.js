Ext.define('Mobilebp.mobilebp.smartdevice.com.controller.defaultcontext.defaultdomain.FUuiController', {
     extend: 'Mobilebp.view.fw.frameworkController.FrameworkViewController',
     alias: 'controller.FUuiController',
     onButtonClick: function(me, e, eOpts) {
          var componentArray = [this.view.down('#textfield_ext_5922')];
          var invalidCompoentArray = this.validateComponents(componentArray);
          if (invalidCompoentArray.length > 0) {
               return;
          }
          var jsonData = {};
          jsonData.fileName = this.view.down('#textfield_ext_5922').getValue();
          var scope = this.getView();
          Ext.Ajax.request({
               url: AppRestUrl + 'secure/TestFUpload/',
               async: true,
               method: 'POST',
               sender: scope,
               jsonData: jsonData,
               me: me,
               maskEnable: true,
               maskEle: scope,
               success: function(response, scope) {
                    var responseText = Ext.JSON.decode(response.responseText);
                    if (responseText.response.success) {
                         Ext.Msg.alert('Server Response', responseText.response.message);
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