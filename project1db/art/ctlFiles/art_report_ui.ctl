load data infile '/tmp/applifire/db/IVWOX6LP3AJPUMW0KDHFRW/0324EF80-6FA3-46E4-8715-4919398BACD2/art/data/art_report_ui.csv' "str '#appfirenewline#'" into table art_report_ui FIELDS TERMINATED BY '#appfire#' trailing nullcols(report_name,report_id,query_id,data_json CHAR(20000),chart_json CHAR(20000),created_by,created_date DATE 'yyyy-mm-dd hh24:mi:ss',updated_by,updated_date DATE 'yyyy-mm-dd hh24:mi:ss',project_id,project_version_id,app_creator_id,active_status,version_id,search_json CHAR(20000),advance_config_json CHAR(20000))
