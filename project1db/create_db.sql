
connect sys/oracle as sysdba
create tablespace project1 DATAFILE '/u01/app/oracle/oradata/project1.dbf' SIZE 100M EXTENT MANAGEMENT LOCAL AUTOALLOCATE;
declare
userexist integer;
begin
select count(*) into userexist from dba_users where username='PROJECT1';
if (userexist = 0) then
execute immediate 'create user project1 identified by project1 default tablespace project1';
end if;
end;
/
ALTER USER "PROJECT1" DEFAULT TABLESPACE "PROJECT1" TEMPORARY TABLESPACE "TEMP" ACCOUNT UNLOCK ;
exit;