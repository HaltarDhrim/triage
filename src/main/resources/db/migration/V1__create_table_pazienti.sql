CREATE TABLE pazienti(
   id SERIAL primary key,
   codfisc char(16),
   prioritaIniz INTEGER,
   priorita INTEGER,
   stato INTEGER,
   userInsert CHAR(8),
   timeInsert timestamp,
   userUpdate CHAR(8),
   timeUpdate timestamp
);
