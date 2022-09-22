#!/bin/bash
#hiiiiiiii (falls limp as is normal for being ritually drowned)
#email uniqueness-checking "middleware" :-)
#I check to see if the email is being used by another user on account creation 
#(handled, appending-users.sh)

#step one: read through the contents of our data
#grep <expression to match> mock-data.csv

### split on '@', only ahve to check first half
## if firstHalfOfEmail = user-providedFirstHalfOfEmail,
#we PROBABLY have a match.
#this would of course not account for same usernames but different domains euargh!
## But I think it is a reasonable assumption that someone with the same username but different
### domains is PROABABLY the same person, right?

#step two: use regex to check for matching email address

#if(match)
#echo 'email matches an existing register, try again.';
#exit;
#on true match, reject user input
#elif(!match)
#next()
#on !match, resume execution (where is next() when you need her???)

string= cat mock-data.csv;
substring= $email;
if [[ $string =~ *"$substring"* ]];
then
echo 'same email detected!'
else
echo 'null same email'
fi;
