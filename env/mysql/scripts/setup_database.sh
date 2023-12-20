#!/bin/bash

echo "============== Importing dump to database..."

mysql -u root -ptest streaminglportal < streaminglportal_19_09.sql

echo "==============   ...      . ..     ... Ready!"