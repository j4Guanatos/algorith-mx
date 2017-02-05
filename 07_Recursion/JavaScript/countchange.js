function change(money, coins) {
    return (function f(sum,coins) { return sum > money || coins.length == 0 ? 0 : sum == money ? 1 : f(coins[0] + sum, coins) + f(sum, coins.slice(1)); })(0, coins);
}

console.log(change(9,[1,2,5]));
console.log(change(4,[1,2]));