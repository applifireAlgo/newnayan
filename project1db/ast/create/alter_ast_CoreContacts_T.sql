

ALTER TABLE ast_CoreContacts_T ADD CONSTRAINT fk_859b5a5b8 FOREIGN KEY (timeZoneId) REFERENCES ast_Timezone_M(timeZoneId);



ALTER TABLE ast_CoreContacts_T ADD CONSTRAINT fk_a7027ee56 FOREIGN KEY (genderId) REFERENCES ast_Gender_M(genderId);



ALTER TABLE ast_CoreContacts_T ADD CONSTRAINT fk_ce570a1b9 FOREIGN KEY (titleId) REFERENCES ast_Title_M(titleId);



ALTER TABLE ast_CoreContacts_T ADD CONSTRAINT fk_02f929109 FOREIGN KEY (nativeLanguageCode) REFERENCES ast_Language_M(languageId);



exit;