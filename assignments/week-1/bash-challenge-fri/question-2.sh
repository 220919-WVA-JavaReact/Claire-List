#!/bin/bash

N=101; #I am the number of numbers +1; a consequence of 'start of sum' problem, below


#both the first and second numbers must also be declared, because of the way the loop 
#starts. Remember programming this on that old TI-80 calculator in high school? it's the
#"start of sum" problem :-)

a=0;
b=1;

echo "The Fibonacci Sequence is: "
for (( i=0; i<N; i++ ));
do
	echo -n "$a ";
	fn=$((a + b));
	a=$b; #I am equal to the next ie
	b=$fn;
done;
