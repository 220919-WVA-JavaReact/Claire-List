export {}
//This fixed it for osme reason!

function sayHi(...args: any): void{
    console.log('Hi!');
}

function sayAnything(arg: string | number){
    console.log(arg);
}

sayHi();
sayAnything('5');
sayAnything(69);