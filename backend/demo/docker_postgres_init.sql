CREATE USER postggres WITH PASSWORD 'postggres' CREATEDB;

CREATE DATABASE demo
    WITH
        OWNER = demouser
        ENCODING = 'UTF8'
        LC_COLLATE = 'en_US.utf8'
        LC_CTYPE = 'en_US.utf8'
        TABLESPACE = pg_default
        CONNECTION LIMIT = -1;