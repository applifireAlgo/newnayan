Ext.define('Mobilebp.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Mobilebp.view.reportui.querycriteria.QueryCriteriaView',
			'Mobilebp.view.reportui.datachart.DataChartViewTab',
			'Mobilebp.view.reportui.datachart.DataChartViewPanel',
			'Mobilebp.view.reportui.ReportViewController' ,
			'Mobilebp.view.fw.MainDataPointPanel',
			'Mobilebp.view.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	isCustomReport:false,
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',
	height:500,
	width:"100%",
	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
