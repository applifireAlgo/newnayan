Ext.define('Mobilebp.mobilebp.smartdevice.com.controller.defaultcontext.defaultdomain.CuiController', {
     extend: 'Mobilebp.view.fw.frameworkController.FrameworkViewController',
     alias: 'controller.CuiController',
     onButtonClick: function(me, e, eOpts) {
          var formComponent = new Ext.create('Mobileapp.mobileapp.smartdevice.com.view.defaultcontext.defaultdomain.PUI');
          formComponent.title = 'PUI';
          this.createWindow(formComponent);
     },
     onSaveClick: function(me, e, eOpts) {
          var componentArray = [this.view.down('#textfield_ext_3788'), this.view.down('#numberfield_ext_3798')];
          var invalidCompoentArray = this.validateComponents(componentArray);
          if (invalidCompoentArray.length > 0) {
               return;
          }
          var jsonData = {};
          jsonData.cName = this.view.down('#textfield_ext_3788').getValue();
          jsonData.cNo = this.view.down('#numberfield_ext_3798').getValue();
          var scope = this.getView();
          Ext.Ajax.request({
               url: AppRestUrl + 'secure/Child/',
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