#!/bin/bash
echo Enter your FIRST name, LAST name, a valid EMAIL, and good PASSWORD \; seperated by SPACES.
read fname lname email password;

args=$fname","$lname","$email","$password;
echo $args >> mock-data.csv;

cat mock-data.csv; #commented out be3cause it is giving me trouble...
