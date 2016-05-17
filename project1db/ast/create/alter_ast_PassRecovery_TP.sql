

ALTER TABLE ast_PassRecovery_TP ADD CONSTRAINT fk_542987867 FOREIGN KEY (questionId) REFERENCES ast_Question_M(questionId);



ALTER TABLE ast_PassRecovery_TP ADD CONSTRAINT fk_f467b3ce5 FOREIGN KEY (userId) REFERENCES ast_User_T(userId);



exit;