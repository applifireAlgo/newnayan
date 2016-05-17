load data infile '/tmp/applifire/db/IVWOX6LP3AJPUMW0KDHFRW/0324EF80-6FA3-46E4-8715-4919398BACD2/art/data/art_chart_type.csv' "str '#appfirenewline#'" into table art_chart_type FIELDS TERMINATED BY '#appfire#' (chart_type_id,chart_id,chart_type,chart_default,created_by,created_date DATE 'yyyy-mm-dd hh24:mi:ss',updated_by,updated_date DATE 'yyyy-mm-dd hh24:mi:ss',version_id,active_status)

