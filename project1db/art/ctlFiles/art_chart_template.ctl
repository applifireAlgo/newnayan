load data infile '/tmp/applifire/db/IVWOX6LP3AJPUMW0KDHFRW/0324EF80-6FA3-46E4-8715-4919398BACD2/art/data/art_chart_template.csv' "str '#appfirenewline#'" into table art_chart_template FIELDS TERMINATED BY '#appfire#' (template_id,template_name,template_json,created_by,created_date DATE 'yyyy-mm-dd hh24:mi:ss',updated_by,updated_date DATE 'yyyy-mm-dd hh24:mi:ss',version_id,project_id,project_version_id,active_status,app_creator_id)

