#!/bin/bash

echo "======== Importing dump to database..."

mysql -u streaming_portal -ptest streaminglportal < dump.sql

echo "======== Database imported!"