Ext.define('Mobilebp.view.appreportui.chart.GroupChartPanel', {
	extend : 'Ext.panel.Panel',
	requires:['Mobilebp.view.appreportui.chart.GroupChartPanelController',
	          'Mobilebp.view.appreportui.chart.ChartPanel'],
	controller:'groupChartPanelController',
	xtype : 'groupChartPanel',
	groupChartJson:null,
	//title:'GPanel',
	plugins: 'responsive',
	responsiveConfig: {
       portrait: {
    	   layout: {
    	        type: 'table',
    	        columns : 1,
    	        tableAttrs: {
    	        	 style: {
    	        		 width: "100%"
    	        	 }
    	        },
    	        tdAttrs : {
    	            align : 'center',
    	            valign : 'middle',
    	        }
    		}
        },
        landscape: {
        	layout: {
                type: 'table',
                //columns :2,
                tableAttrs: {
                	 style: {
                		 width: "100%"
                	 }
                },
                tdAttrs : {
                    align : 'center',
                    valign : 'middle',
                }
        	}
        }
    },
	listeners:{
		afterrender:'grpChartPanelAfterRender'
	}
});