Ext.define('Mobilebp.view.smartdevice.MainViewport', {
		extend:'Ext.container.Viewport',
		bodyPadding : 5,
		closable : false,
		xtype : 'mainViewport',
		id:'mainViewport',
		autoDestroy : true,
		requires : ['Mobilebp.view.smartdevice.login.Login'],
		layout:'fit',
		title:'Viewport',
		items:[{
			xtype:'login'
		}]
});