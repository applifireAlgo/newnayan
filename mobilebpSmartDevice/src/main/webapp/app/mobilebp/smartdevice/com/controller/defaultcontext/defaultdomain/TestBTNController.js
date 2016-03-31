Ext.define('Mobilebp.mobilebp.smartdevice.com.controller.defaultcontext.defaultdomain.TestBTNController', {
     extend: 'Mobilebp.view.fw.frameworkController.FrameworkViewController',
     alias: 'controller.TestBTNController',
     onButtonClick: function(me, e, eOpts) {
          var componentArray = [this.view.down('#textfield_ext_26407'), this.view.down('#textfield_ext_26417')];
          var invalidCompoentArray = this.validateComponents(componentArray);
          if (invalidCompoentArray.length > 0) {
               return;
          }
          var jsonData = {};
          jsonData.tNm = this.view.down('#textfield_ext_26407').getValue();
          jsonData.frndNm = this.view.down('#textfield_ext_26417').getValue();
          var scope = this.getView();
          Ext.Ajax.request({
               url: AppRestUrl + 'secure/TestA/',
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