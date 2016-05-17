

ALTER TABLE ast_Login_T ADD CONSTRAINT fk_d5f1da534 FOREIGN KEY (contactId) REFERENCES ast_CoreContacts_T(contactId);



ALTER TABLE ast_Login_T ADD CONSTRAINT fk_91cf0a4f8 FOREIGN KEY (userId) REFERENCES ast_User_T(userId);



exit;