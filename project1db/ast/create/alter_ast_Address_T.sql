

ALTER TABLE ast_Address_T ADD CONSTRAINT fk_c7ee47176 FOREIGN KEY (countryId) REFERENCES ast_Country_M(countryId);



ALTER TABLE ast_Address_T ADD CONSTRAINT fk_a80a607ff FOREIGN KEY (addressTypeId) REFERENCES ast_AddressType_M(addressTypeId);



ALTER TABLE ast_Address_T ADD CONSTRAINT fk_bbe78eb01 FOREIGN KEY (cityId) REFERENCES ast_City_M(cityId);



ALTER TABLE ast_Address_T ADD CONSTRAINT fk_56912d6de FOREIGN KEY (stateId) REFERENCES ast_State_M(stateId);



exit;