Ext.define('Salesnew.view.appreportui.ReportView', {
	extend : 'Ext.form.Panel',
	requires : ['Salesnew.view.appreportui.ReportViewController',
	            'Salesnew.view.appreportui.datagrid.DataGridPanel',
	            'Salesnew.view.appreportui.datagrid.DataGridView',
	            'Salesnew.view.appreportui.querycriteria.QueryCriteriaView',
	            'Salesnew.view.appreportui.chart.ChartView',
	            'Salesnew.view.appreportui.datapoint.DataPointView',
	            'Salesnew.view.googlemaps.map.MapPanel',
	            'Salesnew.view.appreportui.chartpoint.ChartPointView'
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
