Ext.define('Salesnew.view.databrowsercalendar.DBCalendar', {
	extend : 'Salesnew.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Salesnew.view.databrowsercalendar.DBCalendarController',
	             'Salesnew.view.databrowsercalendar.DBCalendarView','Ext.layout.container.Card',
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
