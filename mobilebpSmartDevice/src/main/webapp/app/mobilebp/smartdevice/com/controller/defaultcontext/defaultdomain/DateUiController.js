Ext.define('Mobilebp.mobilebp.smartdevice.com.controller.defaultcontext.defaultdomain.DateUiController', {
     extend: 'Mobilebp.view.fw.frameworkController.FrameworkViewController',
     alias: 'controller.DateUiController',
     onGMClick: function(me, e, eOpts) {
          var componentArray = [this.view.down('#customdatetimefield_ext_4525'), this.view.down('#textfield_ext_4514'), this.view.down('#checkbox_ext_4540')];
          var invalidCompoentArray = this.validateComponents(componentArray);
          if (invalidCompoentArray.length > 0) {
               return;
          }
          var jsonData = {};
          jsonData.today = this.view.down('#customdatetimefield_ext_4525').getValues();
          jsonData.tday = this.view.down('#textfield_ext_4514').getValue();
          jsonData.isHoliday = this.view.down('#checkbox_ext_4540').getValue();
          var scope = this.getView();
          Ext.Ajax.request({
               url: AppRestUrl + 'secure/TestDate/',
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