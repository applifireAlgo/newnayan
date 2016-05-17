

ALTER TABLE `ast_TestUser_M` ADD CONSTRAINT FOREIGN KEY (`fName`) REFERENCES `ast_CoreContacts_T`(`contactId`);



ALTER TABLE `ast_TestUser_M` ADD CONSTRAINT FOREIGN KEY (`newuser`) REFERENCES `ast_User_T`(`userId`);

