

ALTER TABLE ast_UserAppState_T ADD CONSTRAINT fk_e34dd49b2 FOREIGN KEY (appSessionId) REFERENCES ast_LoginSession_T(AppSessionId);



exit;