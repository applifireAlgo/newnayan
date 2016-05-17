

ALTER TABLE ast_City_M ADD CONSTRAINT fk_c97fdf4fe FOREIGN KEY (countryId) REFERENCES ast_Country_M(countryId);



ALTER TABLE ast_City_M ADD CONSTRAINT fk_11a051615 FOREIGN KEY (stateId) REFERENCES ast_State_M(stateId);



exit;