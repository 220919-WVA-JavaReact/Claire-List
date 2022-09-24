#!/bin/bash

#given 10 numbers, determine how many are positive and how many are negative.
## positive count is determined by 10-negcount, hence being the only variable here.

declare -a array;

#special array syntax: 'treat all instances of variable as an array pls'

echo 'Enter 10 numbers!';
read -a array;

negcount=0;

for elem in "${array[@]}"
do
#if num = self negcount +1
if[ (${array:elem} + ${array:elem}) -eq 0]
then
${negcount}+=1;
fi;
done;

echo 'The number of positive numbers is:'
10-${negcount}
echo 'The number of negative numbers is:'
${negcount};
