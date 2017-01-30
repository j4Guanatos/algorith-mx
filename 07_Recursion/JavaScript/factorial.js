function factorial(num)
{
    // If the number is less than 0, reject it.
    if (num < 0) {
        return -1;
    }
    // If the number is 0, its factorial is 1.
    else if (num == 0) {
        return 1;
    }
    // Otherwise, call this recursive procedure again.
    else {
        console.log(`(${num}) * (${num} - 1)`)
        return (num * factorial(num - 1));
    }
}

console.log(factorial(8));
