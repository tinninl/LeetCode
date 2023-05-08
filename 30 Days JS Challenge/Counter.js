
var createCounter = function(init){

    // Keep track of the initial value for when we want to reset it
    var n = init;

    return {

        increment() {
            return ++init;  // Use PREFIX to increment before returning
        },

        decrement(){
            return --init;
        },

        reset() {
            init = n;
            return init;
        }
    }
}