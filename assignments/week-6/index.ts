function sayHi(){
    console.log('Hi!');
}

function sayAnything(any: string | number){
    console.log(any);
}

sayHi();
sayAnything('5');
sayAnything(69);