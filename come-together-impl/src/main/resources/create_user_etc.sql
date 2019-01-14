CREATE USER test WITH
LOGIN
SUPERUSER
INHERIT
CREATEDB
CREATEROLE
NOREPLICATION
ENCRYPTED PASSWORD 'test';


CREATE DATABASE test_db
WITH
OWNER = test
ENCODING = 'UTF8'
LC_COLLATE = 'en_US.UTF-8'
LC_CTYPE = 'en_US.UTF-8'
TABLESPACE = pg_default
CONNECTION LIMIT = -1
TEMPLATE = template0;


CREATE SCHEMA liqubase_schema;
ALTER SCHEMA liqubase_schema OWNER TO test;

CREATE SCHEMA base_schema;
ALTER SCHEMA base_schema OWNER TO test;
