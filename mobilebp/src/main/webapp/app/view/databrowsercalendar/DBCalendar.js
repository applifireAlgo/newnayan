Ext.define('Mobilebp.view.databrowsercalendar.DBCalendar', {
	extend : 'Mobilebp.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Mobilebp.view.databrowsercalendar.DBCalendarController',
	             'Mobilebp.view.databrowsercalendar.DBCalendarView','Ext.layout.container.Card',
	             'Ext.calendar.view.Day', 'Ext.calendar.view.Week',
	             'Ext.calendar.view.Month',
	             'Ext.calendar.form.EventDetails',
	             'Ext.calendar.data.EventMappings'],
	controller : 'databrowsercalendar',
	items : [],
	listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}
});
