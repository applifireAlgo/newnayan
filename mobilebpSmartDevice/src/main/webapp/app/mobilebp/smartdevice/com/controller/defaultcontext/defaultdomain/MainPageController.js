Ext.define('Mobilebp.mobilebp.smartdevice.com.controller.defaultcontext.defaultdomain.MainPageController', {
     extend: 'Mobilebp.view.fw.frameworkController.FrameworkViewController',
     alias: 'controller.MainPageController',
     onTestUIClick: function(me, e, eOpts) {
          var formComponent = new Ext.create('Mobileapp.mobileapp.smartdevice.com.view.defaultcontext.defaultdomain.TestUi');
          formComponent.title = 'TestUi';
          this.createWindow(formComponent);
     },
     onCcuiClick: function(me, e, eOpts) {
          var formComponent = new Ext.create('Mobileapp.mobileapp.smartdevice.com.view.defaultcontext.defaultdomain.CtoCUi');
          formComponent.title = 'CtoCUi';
          var tabs = Ext.getCmp('appMainTabPanel');
          tabs.remove(this.getView());
          tabs.add(formComponent);
          tabs.setActiveTab(formComponent);
     },
     onCUiClick: function(me, e, eOpts) {
          var formComponent = new Ext.create('Mobileapp.mobileapp.smartdevice.com.view.defaultcontext.defaultdomain.Cui');
          formComponent.title = 'Cui';
          this.createWindow(formComponent);
     }
});