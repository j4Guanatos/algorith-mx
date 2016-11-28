/**
 * Created by Sinuhe_Jaime on 25/11/2016.
 */
fun solution1(arrayOfInts: Array<Int>, number: Int): Set<Pair<Int, Int>> {
    // This tooks O(n) in the worst case which is when the array is almost sorted.
    arrayOfInts.sort()

    // Filter elements of the sorted array to only the ones that are less than the number
    // Filter could be improved if we found the index of the element that is less than the number
    val listOfPossible = arrayOfInts.filter { it <= number }

    val pairs = mutableSetOf<Pair<Int, Int>>()

    var idxFirst = 0
    var idxLast = listOfPossible.size - 1

    while (idxFirst != idxLast) {
        val first = listOfPossible[idxFirst]
        val last = listOfPossible[idxLast]

        val sum = first + last
        if (sum > number) {
            idxLast--
        } else if (sum < number) {
            idxFirst++
        } else {
            pairs.add(Pair(listOfPossible[idxFirst], listOfPossible[idxLast]))
            idxFirst++
        }
    }

    return pairs
}

fun main(args: Array<String>) {
    println(solution1(arrayOf(12, 4, 2, 7, 9, 27, 1, 3, 8, 6, 5, 0), 7))

    println(solution1(arrayOf(12, 4, 2, 7, 9, 27, 1, 3, 8, 6, 5, 0), 5))

    println(solution1(arrayOf(12, 4, 2, 7, 9, 27, 27, 1, 3, 8, 6, 5, 0), 39))
}
