#!/bin/bash

#given 10 numbers, determine how many are positive and negative (+self = 0 ?)
# negcount++
#10-negcount = poscount
#echo the number of positive numbers is $poscount
#echo the number of negative numbers is $negcount

declare -a array;

#special array syntax: 'treat all instances of variable as an array pls'

echo 'Enter 10 numbers!';
read -a array;

poscount=0;
negcount=0;

for elem in "${array[@]}"
do
#'if num + self = 0, negcount++' ?
	if[ (${array:elem} + ${array:elem}) -eq 0] then ##something SCREWY is happening...
	${negcount}+=1; fi;
done;

echo 'The number of positive numbers is:'
10-${negcount}
echo 'The number of negative numbers is:'
${negcount};
