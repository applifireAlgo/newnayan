load data infile '/tmp/applifire/db/IVWOX6LP3AJPUMW0KDHFRW/0324EF80-6FA3-46E4-8715-4919398BACD2/art/data//art_report_builder_details.csv' "str '#appfirenewline#'" into table art_report_builder_details FIELDS TERMINATED BY '#appfire#' TRAILING NULLCOLS  (report_id,report_name,report_synopsis CHAR(50000),report_help CHAR(50000),query_criteria_json CHAR(50000),grid_conf_json CHAR(50000),chart_properties CHAR(50000),drilldown_json CHAR(50000),dataEndPoint_json CHAR(50000),created_by,
created_date DATE 'yyyy-mm-dd hh24:mi:ss',updated_by,updated_date DATE 'yyyy-mm-dd hh24:mi:ss',project_id,project_version_id,app_creator_id,active_status,
version_id,query_info CHAR(50000),other_properties_json CHAR(50000),search_json CHAR(50000),edit_flag,bounded_context,system_flag
,advance_config_json CHAR(50000) nullif advance_config_json="\N")

