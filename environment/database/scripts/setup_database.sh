#!/bin/bash

echo "======== Importing database..."

mysql -u streaming_portal -ptest streaminglportal < dump.sql

echo "======== Database imported!"