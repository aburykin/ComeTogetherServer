CREATE USER mr_test WITH
LOGIN
SUPERUSER
INHERIT
CREATEDB
CREATEROLE
NOREPLICATION
ENCRYPTED PASSWORD 'test';


CREATE DATABASE test_db
WITH
OWNER = mr_test
ENCODING = 'UTF8'
LC_COLLATE = 'en_US.UTF-8'
LC_CTYPE = 'en_US.UTF-8'
TABLESPACE = pg_default
CONNECTION LIMIT = -1
TEMPLATE = template0;


DROP SCHEMA IF EXISTS liqubase_schema CASCADE;
CREATE SCHEMA IF NOT EXISTS liqubase_schema;
ALTER SCHEMA liqubase_schema OWNER TO mr_test;

DROP SCHEMA IF EXISTS base_schema CASCADE;
CREATE SCHEMA IF NOT EXISTS base_schema;
ALTER SCHEMA base_schema OWNER TO mr_test;