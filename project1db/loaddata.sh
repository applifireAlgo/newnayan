




ORACLE_HOME=/u01/app/oracle/product/11.2.0/xe
ORACLE_SID=XE
PATH=$PATH:$ORACLE_HOME/bin:$ORACLE_SID
export ORACLE_HOME
export ORACLE_SID
export PATH
OSNAME=`uname -s`
ART_DATA_PATH=/tmp/applifire/db/IVWOX6LP3AJPUMW0KDHFRW/0324EF80-6FA3-46E4-8715-4919398BACD2/art/data
AST_DATA_PATH=/tmp/applifire/db/IVWOX6LP3AJPUMW0KDHFRW/0324EF80-6FA3-46E4-8715-4919398BACD2/ast/data
ART_CTL_PATH=/tmp/applifire/db/IVWOX6LP3AJPUMW0KDHFRW/0324EF80-6FA3-46E4-8715-4919398BACD2/art/ctlFiles
ART_CTL_LOG_PATH=/tmp/applifire/db/IVWOX6LP3AJPUMW0KDHFRW/0324EF80-6FA3-46E4-8715-4919398BACD2/art/ctlLogs
AST_CTL_PATH=/tmp/applifire/db/IVWOX6LP3AJPUMW0KDHFRW/0324EF80-6FA3-46E4-8715-4919398BACD2/ast/ctlFiles
AST_CTL_LOG_PATH=/tmp/applifire/db/IVWOX6LP3AJPUMW0KDHFRW/0324EF80-6FA3-46E4-8715-4919398BACD2/ast/ctlLogs


APPLFIREUSER=root
APPLFIREPASSWORD=root
APPLFIREHOST=localhost



DB_NAME=project1
USER=project1
PASSWORD=project1
PORT=1521
HOST=localhost


echo 'load ART data starts....'
echo 'load AST data ends....'
echo ' load ART data starts....'
sqlldr $USER/$PASSWORD control=$ART_CTL_PATH/art_query.ctl log=$ART_CTL_LOG_PATH/art_query.log

sqlldr $USER/$PASSWORD control=$ART_CTL_PATH/art_report_ui.ctl log=$ART_CTL_LOG_PATH/art_report_ui.log

sqlldr $USER/$PASSWORD control=$ART_CTL_PATH/art_component_config.ctl log=$ART_CTL_LOG_PATH/art_component_config.log

sqlldr $USER/$PASSWORD control=$ART_CTL_PATH/art_log_severity_m.ctl log=$ART_CTL_LOG_PATH/art_log_severity_m.log

sqlldr $USER/$PASSWORD control=$ART_CTL_PATH/art_log_events_t_old.ctl log=$ART_CTL_LOG_PATH/art_log_events_t_old.log

sqlldr $USER/$PASSWORD control=$ART_CTL_PATH/art_chart_json.ctl log=$ART_CTL_LOG_PATH/art_chart_json.log

sqlldr $USER/$PASSWORD control=$ART_CTL_PATH/art_chart_category.ctl log=$ART_CTL_LOG_PATH/art_chart_category.log

sqlldr $USER/$PASSWORD control=$ART_CTL_PATH/art_chart_type.ctl log=$ART_CTL_LOG_PATH/art_chart_type.log

sqlldr $USER/$PASSWORD control=$ART_CTL_PATH/art_chart_data_field_json.ctl log=$ART_CTL_LOG_PATH/art_chart_data_field_json.log

sqlldr $USER/$PASSWORD control=$ART_CTL_PATH/art_lang_master.ctl log=$ART_CTL_LOG_PATH/art_lang_master.log

sqlldr $USER/$PASSWORD control=$ART_CTL_PATH/art_chart_properties.ctl log=$ART_CTL_LOG_PATH/art_chart_properties.log

sqlldr $USER/$PASSWORD control=$ART_CTL_PATH/art_chart_prop_language.ctl log=$ART_CTL_LOG_PATH/art_chart_prop_language.log

sqlldr $USER/$PASSWORD control=$ART_CTL_PATH/art_chart_template.ctl log=$ART_CTL_LOG_PATH/art_chart_template.log

sqlldr $USER/$PASSWORD control=$ART_CTL_PATH/art_report_builder_details.ctl log=$ART_CTL_LOG_PATH/art_report_builder_details.log

sqlldr $USER/$PASSWORD control=$ART_CTL_PATH/art_log_config_m.ctl log=$ART_CTL_LOG_PATH/art_log_config_m.log

sqlldr $USER/$PASSWORD control=$ART_CTL_PATH/art_password_algorithm.ctl log=$ART_CTL_LOG_PATH/art_password_algorithm.log

sqlldr $USER/$PASSWORD control=$ART_CTL_PATH/art_password_policy.ctl log=$ART_CTL_LOG_PATH/art_password_policy.log

sqlldr $USER/$PASSWORD control=$ART_CTL_PATH/art_health_scheduler_config_m.ctl log=$ART_CTL_LOG_PATH/art_health_scheduler_config_m.log

sqlldr $USER/$PASSWORD control=$ART_CTL_PATH/art_health_status_config_m.ctl log=$ART_CTL_LOG_PATH/art_health_status_config_m.log

sqlldr $USER/$PASSWORD control=$ART_CTL_PATH/cloud_drive_file_content_type.ctl log=$ART_CTL_LOG_PATH/cloud_drive_file_content_type.log

sqlldr $USER/$PASSWORD control=$ART_CTL_PATH/cloud_drive_tags.ctl log=$ART_CTL_LOG_PATH/cloud_drive_tags.log

sqlldr $USER/$PASSWORD control=$ART_CTL_PATH/art_external_integration.ctl log=$ART_CTL_LOG_PATH/art_external_integration.log

sqlldr $USER/$PASSWORD control=$ART_CTL_PATH/art_job_details.ctl log=$ART_CTL_LOG_PATH/art_job_details.log

sqlldr $USER/$PASSWORD control=$ART_CTL_PATH/art_scheduler_details.ctl log=$ART_CTL_LOG_PATH/art_scheduler_details.log

sqlldr $USER/$PASSWORD control=$ART_CTL_PATH/art_schedule_config.ctl log=$ART_CTL_LOG_PATH/art_schedule_config.log

sqlldr $USER/$PASSWORD control=$ART_CTL_PATH/art_app_notification_template.ctl log=$ART_CTL_LOG_PATH/art_app_notification_template.log

sqlldr $USER/$PASSWORD control=$ART_CTL_PATH/art_log_alarm.ctl log=$ART_CTL_LOG_PATH/art_log_alarm.log

sqlldr $USER/$PASSWORD control=$ART_CTL_PATH/art_log_architecture_layer_m.ctl log=$ART_CTL_LOG_PATH/art_log_architecture_layer_m.log

sqlldr $USER/$PASSWORD control=$ART_CTL_PATH/art_log_status_m.ctl log=$ART_CTL_LOG_PATH/art_log_status_m.log

sqlldr $USER/$PASSWORD control=$ART_CTL_PATH/art_log_event_action_m.ctl log=$ART_CTL_LOG_PATH/art_log_event_action_m.log

sqlldr $USER/$PASSWORD control=$ART_CTL_PATH/art_log_exception_m.ctl log=$ART_CTL_LOG_PATH/art_log_exception_m.log

echo 'load ART data ends....'

echo 'load AST data starts....'
sqlldr $USER/$PASSWORD control=$AST_CTL_PATH/ast_Timezone_M.ctl log=$AST_CTL_LOG_PATH/Timezone.log

sqlldr $USER/$PASSWORD control=$AST_CTL_PATH/ast_Language_M.ctl log=$AST_CTL_LOG_PATH/Language.log

sqlldr $USER/$PASSWORD control=$AST_CTL_PATH/ast_Country_M.ctl log=$AST_CTL_LOG_PATH/Country.log

sqlldr $USER/$PASSWORD control=$AST_CTL_PATH/ast_State_M.ctl log=$AST_CTL_LOG_PATH/State.log

sqlldr $USER/$PASSWORD control=$AST_CTL_PATH/ast_City_M.ctl log=$AST_CTL_LOG_PATH/City.log

sqlldr $USER/$PASSWORD control=$AST_CTL_PATH/ast_AddressType_M.ctl log=$AST_CTL_LOG_PATH/AddressType.log

sqlldr $USER/$PASSWORD control=$AST_CTL_PATH/ast_Address_T.ctl log=$AST_CTL_LOG_PATH/Address.log

sqlldr $USER/$PASSWORD control=$AST_CTL_PATH/ast_ContactType_M.ctl log=$AST_CTL_LOG_PATH/ContactType.log

sqlldr $USER/$PASSWORD control=$AST_CTL_PATH/ast_CommunicationGroup_M.ctl log=$AST_CTL_LOG_PATH/CommunicationGroup.log

sqlldr $USER/$PASSWORD control=$AST_CTL_PATH/ast_CommunicationType_M.ctl log=$AST_CTL_LOG_PATH/CommunicationType.log

sqlldr $USER/$PASSWORD control=$AST_CTL_PATH/ast_Gender_M.ctl log=$AST_CTL_LOG_PATH/Gender.log

sqlldr $USER/$PASSWORD control=$AST_CTL_PATH/ast_Title_M.ctl log=$AST_CTL_LOG_PATH/Title.log

sqlldr $USER/$PASSWORD control=$AST_CTL_PATH/ast_CoreContacts_T.ctl log=$AST_CTL_LOG_PATH/CoreContacts.log

sqlldr $USER/$PASSWORD control=$AST_CTL_PATH/ast_AddressMap_B.ctl log=$AST_CTL_LOG_PATH/AddressMap.log

sqlldr $USER/$PASSWORD control=$AST_CTL_PATH/ast_CommunicationData_TP.ctl log=$AST_CTL_LOG_PATH/CommunicationData.log

sqlldr $USER/$PASSWORD control=$AST_CTL_PATH/ast_CommunicationMap_B.ctl log=$AST_CTL_LOG_PATH/CommunicationMap.log

sqlldr $USER/$PASSWORD control=$AST_CTL_PATH/ast_UserAccessLevel_M.ctl log=$AST_CTL_LOG_PATH/UserAccessLevel.log

sqlldr $USER/$PASSWORD control=$AST_CTL_PATH/ast_UserAccessDomain_M.ctl log=$AST_CTL_LOG_PATH/UserAccessDomain.log

sqlldr $USER/$PASSWORD control=$AST_CTL_PATH/ast_User_T.ctl log=$AST_CTL_LOG_PATH/User.log

sqlldr $USER/$PASSWORD control=$AST_CTL_PATH/ast_Login_T.ctl log=$AST_CTL_LOG_PATH/Login.log

sqlldr $USER/$PASSWORD control=$AST_CTL_PATH/ast_LoginSession_T.ctl log=$AST_CTL_LOG_PATH/LoginSession.log

sqlldr $USER/$PASSWORD control=$AST_CTL_PATH/ast_UserAppState_T.ctl log=$AST_CTL_LOG_PATH/UserAppState.log

sqlldr $USER/$PASSWORD control=$AST_CTL_PATH/ast_PassRecovery_TP.ctl log=$AST_CTL_LOG_PATH/PassRecovery.log

sqlldr $USER/$PASSWORD control=$AST_CTL_PATH/ast_UserData_TP.ctl log=$AST_CTL_LOG_PATH/UserData.log

sqlldr $USER/$PASSWORD control=$AST_CTL_PATH/ast_SessionData_T.ctl log=$AST_CTL_LOG_PATH/SessionData.log

sqlldr $USER/$PASSWORD control=$AST_CTL_PATH/ast_Roles_T.ctl log=$AST_CTL_LOG_PATH/Roles.log

sqlldr $USER/$PASSWORD control=$AST_CTL_PATH/ast_UserRoleBridge_T.ctl log=$AST_CTL_LOG_PATH/UserRoleBridge.log

echo 'load AST data ends....'

echo 'load AST data starts....'
sqlldr $USER/$PASSWORD control=$AST_CTL_PATH/ast_AppMenus_M.ctl log=$AST_CTL_LOG_PATH/AppMenus.log

sqlldr $USER/$PASSWORD control=$AST_CTL_PATH/ast_RoleMenuBridge_TP.ctl log=$AST_CTL_LOG_PATH/RoleMenuBridge.log

sqlldr $USER/$PASSWORD control=$AST_CTL_PATH/ast_PasswordPolicy_M.ctl log=$AST_CTL_LOG_PATH/PasswordPolicy.log

sqlldr $USER/$PASSWORD control=$AST_CTL_PATH/ast_Question_M.ctl log=$AST_CTL_LOG_PATH/Question.log

sqlldr $USER/$PASSWORD control=$AST_CTL_PATH/ast_PasswordAlgo_M.ctl log=$AST_CTL_LOG_PATH/PasswordAlgo.log

echo 'load AST data ends....'
