Ext.define('Mobilebp.view.reportui.datachart.DataChartViewTab', {
	extend : 'Ext.tab.Panel',
	requires : [ 'Mobilebp.view.reportui.datachart.DataChartTController',
	             'Mobilebp.view.reportui.datachart.datagrid.DataGridView',
	             'Mobilebp.view.reportui.datachart.chart.ChartTabView',
	             'Mobilebp.view.reportui.datachart.ChartPointView' ],
	controller : 'datacharttController',
	xtype : 'datachart-tabpanel',
	tabPosition : 'bottom',
	bodyStyle : 'background:#D8D8D8',
	listeners : {
		scope : "controller",
		tabchange : 'tabchange',
		afterrender:'afterTabPanelRender'
	}
});