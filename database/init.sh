set -e
psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
    CREATE DATABASE user_database;
    CREATE SCHEMA user_store;
    CREATE TABLE IF NOT EXISTS user_store.users
    (
      id INTEGER NOT NULL CONSTRAINT users_pkey PRIMARY KEY,
      nameUser VARCHAR NOT NULL,
      ageUser VARCHAR NOT NULL
    );
EOSQL