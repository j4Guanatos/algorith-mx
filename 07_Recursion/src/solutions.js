function flat(arr) {
    var returnedArr = [];

    function innerFlat(accumulativeArr, elementToPush, indexOfElement) {
        console.log("Called with", accumulativeArr, elementToPush, indexOfElement);
        if (Array.isArray(elementToPush) && elementToPush.length > 0) {
            var firstElement = elementToPush.shift();

            accumulativeArr = innerFlat(accumulativeArr, firstElement, 0);
            accumulativeArr = innerFlat(accumulativeArr, elementToPush, 0);
        } else {
            if(!Array.isArray(elementToPush)) accumulativeArr.push(elementToPush);
        }

        return accumulativeArr;
    }

    returnedArr = innerFlat(returnedArr, arr, 0);

    return returnedArr;
}

var array = [1,2,[3,[4,5],6],7];
var original = array.slice();
var result = flat(array);

console.log("Original:", array);
console.log("Result: ", result);
