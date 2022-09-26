#/!bin/bash

#I can get user info as specified, and put into a file. 
##this gets user info for a bank, and puts it into accounts.csv

#PROMPT user input
echo "Please select an OPTION: type <register>, <readd>, <searchfor>"
read arg

case $arg in
register)
#get user info
echo "WELCOME TO TRUST-BANK.INFO. PLEASE ENTER YOUR INFORMATION WHEN PROMPTED.";
echo "Enter your FIRST name.";
read fname;

echo "Enter your LAST name.";
read lname

echo "Enter your CONTACT INFO."
read contact

echo "Enter your PASSWORD."
read password

echo "Enter your ACCOUNT NUMBER"
read accountnum

infos=$fname"|"$lname"|"$contact"|"$password"|"$accountnum;

echo $infos;
echo $infos >> accounts.csv;
;;

readd)
cat accounts.csv;
;;

searchfor)
echo "Search the register for WHAT:"
read search;

grep $search accounts.csv;
;;
esac;

#exit;
