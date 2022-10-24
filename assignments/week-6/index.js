function sayHi() {
    var args = [];
    for (var _i = 0; _i < arguments.length; _i++) {
        args[_i] = arguments[_i];
    }
    console.log('Hi!');
}
function sayAnything(arg) {
    console.log(arg);
}
sayHi();
sayAnything('5');
sayAnything(69);
