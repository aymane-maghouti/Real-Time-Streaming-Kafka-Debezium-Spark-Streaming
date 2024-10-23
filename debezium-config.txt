curl -H 'content-type: application/json' localhost:8083/connectors --data '
{
  "name" : "smartphones-conn",
  "config":{
  "connector.class": "io.debezium.connector.postgresql.PostgresConnector",
  "topic.prefix": "cdc",
  "database.user": "postgres",
  "database.dbname": "smartphone_db",
  "database.hostname": "postgres",
  "database.password": "postgres",
  "database.server.name":"postgres",
  "database.port": "5432",
  "plugin.name": "pgoutput",
  "table.include.list":"public.smartphones",
  "decimal.handling.mode":"string"
  }
}'