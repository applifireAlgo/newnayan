Ext.define('Mobilebp.view.appreportui.ReportView', {
	extend : 'Ext.form.Panel',
	requires : ['Mobilebp.view.appreportui.ReportViewController',
	            'Mobilebp.view.appreportui.datagrid.DataGridPanel',
	            'Mobilebp.view.appreportui.datagrid.DataGridView',
	            'Mobilebp.view.appreportui.querycriteria.QueryCriteriaView',
	            'Mobilebp.view.appreportui.chart.ChartView',
	            'Mobilebp.view.appreportui.datapoint.DataPointView',
	            'Mobilebp.view.googlemaps.map.MapPanel',
	            'Mobilebp.view.appreportui.chartpoint.ChartPointView'
	            ],
	xtype : 'reportView',
	controller : 'reportViewController',
	layout : 'border',
	reportJSON:null,
	listeners : {
		scope : 'controller',
		afterrender : 'afterRenderReport',
		boxready : 'fetchReportData'
	}
});
