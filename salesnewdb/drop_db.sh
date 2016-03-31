




echo $PATH
DB_PATH=/tmp/applifire/db/BVBLZL61DVC71O8NV5AXG/6BE6DB6D-9D38-4A34-8DE5-68F3A79FF98C
MYSQL=/usr/bin
USER=salesnew
PASSWORD=salesnew
HOST=localhost


echo 'drop db starts....'
$MYSQL/mysql -h$HOST -u$USER -p$PASSWORD -e "SOURCE $DB_PATH/drop_db.sql";
echo 'drop db ends....'