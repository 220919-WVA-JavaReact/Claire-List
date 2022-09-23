#!/bin/bash

#fibonnaci sequence --up 144. 100 is not a fibonacci number :-)

N=13;
#;this is the number of digits up to 144 (100 is not a fibonacci number after all!)

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
