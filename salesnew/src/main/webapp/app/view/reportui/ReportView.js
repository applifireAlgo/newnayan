Ext.define('Salesnew.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Salesnew.view.reportui.querycriteria.QueryCriteriaView',
			'Salesnew.view.reportui.datachart.DataChartViewTab',
			'Salesnew.view.reportui.datachart.DataChartViewPanel',
			'Salesnew.view.reportui.ReportViewController' ,
			'Salesnew.view.fw.MainDataPointPanel',
			'Salesnew.view.googlemaps.map.MapPanel'
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
