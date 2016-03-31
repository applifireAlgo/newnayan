Ext.define('Salesnew.view.reportui.datachart.DataChartViewTab', {
	extend : 'Ext.tab.Panel',
	requires : [ 'Salesnew.view.reportui.datachart.DataChartTController',
	             'Salesnew.view.reportui.datachart.datagrid.DataGridView',
	             'Salesnew.view.reportui.datachart.chart.ChartTabView',
	             'Salesnew.view.reportui.datachart.ChartPointView' ],
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