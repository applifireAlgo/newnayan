

ALTER TABLE ast_RoleMenuBridge_TP ADD CONSTRAINT fk_d22abca12 FOREIGN KEY (roleId) REFERENCES ast_Roles_T(roleId);



ALTER TABLE ast_RoleMenuBridge_TP ADD CONSTRAINT fk_9688101d1 FOREIGN KEY (menuId) REFERENCES ast_AppMenus_M(menuId);



exit;