Ext.define('Mobilebp.mobilebp.smartdevice.com.controller.defaultcontext.defaultdomain.MUIController', {
     extend: 'Mobilebp.view.fw.frameworkController.FrameworkViewController',
     alias: 'controller.MUIController',
     onButtonClick: function(me, e, eOpts) {
          var componentArray = [this.view.down('#textfield_ext_25383')];
          var invalidCompoentArray = this.validateComponents(componentArray);
          if (invalidCompoentArray.length > 0) {
               return;
          }
          var jsonData = {};
          jsonData.tNm = this.view.down('#textfield_ext_25383').getValue();
          var scope = this.getView();
          Ext.Ajax.request({
               url: AppRestUrl + 'secure/FNewWS/proFNew',
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
                         var responseData = responseText.response.data;
                         var Grid = scope.sender.down('#gridpanel_ext_25433');
                         Grid.store.setData(responseData);
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