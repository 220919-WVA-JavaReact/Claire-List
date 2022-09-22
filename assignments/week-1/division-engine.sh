#!/bin/bash
case ${3} in

x) #multiply ie
echo $((${1} * ${2}));
;;

s) #sum ie
echo $((${1} + ${2}));
### this is because we are trying to write the VALUE of the expression within to stdout
;;
d) #difference ie
echo $((${1} - ${2}));
 ;;

di)
echo $((${1} / ${2}));
;;

#add modulus, case logicr

mod)
echo $((${1} % ${2}));
;;

*) #default case
echo 'unknown arguments supplied, please try again.';

;;
esac
