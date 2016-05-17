load data infile '/tmp/applifire/db/IVWOX6LP3AJPUMW0KDHFRW/0324EF80-6FA3-46E4-8715-4919398BACD2/art/data/art_health_scheduler_config_m.csv' "str '#appfirenewline#'" into table art_health_scheduler_config_m FIELDS TERMINATED BY '#appfire#' (schedulerId,schedulerkey,refreshTime,refreshUnit,batchSize,enabled,connectorClass,dataModel,schedulerName,threadPoolSize,version_id,created_by,
created_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',updated_by,updated_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',active_status)

