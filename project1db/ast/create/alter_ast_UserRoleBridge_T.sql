

ALTER TABLE ast_UserRoleBridge_T ADD CONSTRAINT fk_3a0b1532b FOREIGN KEY (roleId) REFERENCES ast_Roles_T(roleId);



ALTER TABLE ast_UserRoleBridge_T ADD CONSTRAINT fk_c7b871338 FOREIGN KEY (userId) REFERENCES ast_User_T(userId);



exit;