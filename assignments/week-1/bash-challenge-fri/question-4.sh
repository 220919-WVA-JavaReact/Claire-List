#!/bin/bash

#print some output to the console, capturin

#print current home directory
echo $HOME;

#print current user name
whoami;

#print the message "Today is:" with the current date in MM/dd/yy format (if you make me
#format a date I WILL become unreasonable.)
echo Today is:
strdate= date +'%m/%d/%y';
echo $strdate;

#the message "No of users logged in :" with the num of current logged in users
echo "No of users logged in :"
who --count;
