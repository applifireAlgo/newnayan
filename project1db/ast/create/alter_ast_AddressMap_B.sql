

ALTER TABLE ast_AddressMap_B ADD CONSTRAINT fk_dacc25068 FOREIGN KEY (contactId) REFERENCES ast_CoreContacts_T(contactId);



ALTER TABLE ast_AddressMap_B ADD CONSTRAINT fk_5ecf3885f FOREIGN KEY (addressId) REFERENCES ast_Address_T(addressId);



exit;