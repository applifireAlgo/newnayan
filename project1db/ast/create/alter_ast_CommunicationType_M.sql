

ALTER TABLE ast_CommunicationType_M ADD CONSTRAINT fk_925c0af8c FOREIGN KEY (commGroupId) REFERENCES ast_CommunicationGroup_M(commGroupId);



exit;