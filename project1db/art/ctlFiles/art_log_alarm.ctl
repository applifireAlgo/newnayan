load data infile '/tmp/applifire/db/IVWOX6LP3AJPUMW0KDHFRW/0324EF80-6FA3-46E4-8715-4919398BACD2/art/data/art_log_alarm.csv' "str '#appfirenewline#'" into table art_log_alarm FIELDS TERMINATED BY '#appfire#' (loggerPkId,alarmType,alarmData CHAR(20000),alarmVersion,created_by,created_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss".0"',updated_by,updated_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss".0"',version_id,active_status)
