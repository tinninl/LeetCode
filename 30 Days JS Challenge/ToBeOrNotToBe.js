/**
 * expect(5).toBe(5); // true
 * expect(5).notToBe(5); // throws "Equal"
 */

/**
 * 
 * @param {string} value 
 * @returns 
 */
var expect = function(value){

    return{

        toBe: (expected) => {

            if (value === expected)
                return true;
            else    
                throw new Error("Not Equal");

        },

        NotToBe: (expected) => {

            if (value !== expected)
                return true;
            else 
                throw new Error("Equal");

        }
    }
}