load data infile '/tmp/applifire/db/IVWOX6LP3AJPUMW0KDHFRW/0324EF80-6FA3-46E4-8715-4919398BACD2/art/data/art_component_config.csv' "str '#appfirenewline#'" into table art_component_config FIELDS TERMINATED BY '#appfire#' (id,component_name,initializer,status,project_id,project_version_id,app_creator_id,created_by,created_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',updated_by,updated_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',version_id,active_status)
