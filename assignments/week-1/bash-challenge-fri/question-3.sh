#!/bin/bash

#factorials ! Using a for loop

echo "Which number do you wish to factorialize?"
read number;

fact=1;

for (( i=1; i<=number; i++ ))
do
	let fact=fact*i;

done;

echo "${number} factorial is ${fact}";

