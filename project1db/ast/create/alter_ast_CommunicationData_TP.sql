

ALTER TABLE ast_CommunicationData_TP ADD CONSTRAINT fk_d92e2cf8a FOREIGN KEY (commGroupId) REFERENCES ast_CommunicationGroup_M(commGroupId);



ALTER TABLE ast_CommunicationData_TP ADD CONSTRAINT fk_01fe4feac FOREIGN KEY (commType) REFERENCES ast_CommunicationType_M(commType);



exit;