load data infile '/tmp/applifire/db/IVWOX6LP3AJPUMW0KDHFRW/0324EF80-6FA3-46E4-8715-4919398BACD2/art/data/cloud_drive_tags.csv' "str '#appfirenewline#'" into table cloud_drive_tags FIELDS TERMINATED BY '#appfire#' (tag_id,tag_hierachy,tag_name,tag_image,created_by,created_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',updated_by,updated_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',version_id,active_status,app_creator_id)

