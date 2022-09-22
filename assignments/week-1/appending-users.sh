#!/bin/bash
echo Enter your FIRST name, LAST name, a valid EMAIL, and good PASSWORD \; seperated by SPACES.
read fname lname email password;

args=$fname","$lname","$email","$password;

string= grep -w -c $email mock-data.csv; #what I mean:: only search specific word, and count number
#of times that word appears.


if [ $string -gt 0]
then
echo 'same email detected!'
else
echo 'null same email'
fi;


echo $args >> mock-data.csv;

cat mock-data.csv; #commented out be3cause it is giving me trouble...
