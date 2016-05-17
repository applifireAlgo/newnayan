

ALTER TABLE ast_CommunicationMap_B ADD CONSTRAINT fk_78bb57779 FOREIGN KEY (contactId) REFERENCES ast_CoreContacts_T(contactId);



ALTER TABLE ast_CommunicationMap_B ADD CONSTRAINT fk_5c536d606 FOREIGN KEY (commDataId) REFERENCES ast_CommunicationData_TP(commDataId);



exit;