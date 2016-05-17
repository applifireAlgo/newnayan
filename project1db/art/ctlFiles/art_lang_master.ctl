load data infile '/tmp/applifire/db/IVWOX6LP3AJPUMW0KDHFRW/0324EF80-6FA3-46E4-8715-4919398BACD2/art/data/art_lang_master.csv' "str '#appfirenewline#'" into table art_lang_master FIELDS TERMINATED BY '#appfire#' (lang_id,lang_name,country_code,country_name,updated_by,updated_date DATE 'yyyy-mm-dd hh24:mi:ss',created_by,created_date DATE 'yyyy-mm-dd hh24:mi:ss',version_id,active_status)

