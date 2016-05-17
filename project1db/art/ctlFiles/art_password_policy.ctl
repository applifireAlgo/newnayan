load data infile '/tmp/applifire/db/IVWOX6LP3AJPUMW0KDHFRW/0324EF80-6FA3-46E4-8715-4919398BACD2/art/data/art_password_policy.csv' "str '#appfirenewline#'" into table art_password_policy FIELDS TERMINATED BY '#appfire#' (policyId,policyName,policyDescription,minPwdLength,maxPwdLength,minCapitalLetters,minSmallLetters,minNumericValues,minSpecialLetters,allowedSpecialLetters
,version_id,updated_by,updated_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss".0"',created_by,created_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss".0"')

