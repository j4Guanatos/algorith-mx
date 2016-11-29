/**
 * Created by Sinuhe_Jaime on 25/11/2016.
 */
fun solution1(arrayOfInts: Array<Int>, number: Int): Set<Pair<Int, Int>> {
    // Filter elements of the sorted array to only the ones that are less than the number
    val listOfPossible = arrayOfInts.filter { it <= number }
            .toMutableList()

    val resultSet = listOfPossible.fold(mutableSetOf<Pair<Int, Int>>(), { mSet, element ->
        val complement = number - element
        if (listOfPossible.contains(complement)) {
            when (complement > element) {
                true -> mSet.add(Pair(element, complement))
                false -> mSet.add(Pair(complement, element))
            }
        }

        mSet
    })

    println("Set")
    println(resultSet)

    return resultSet
}

fun main(args: Array<String>) {
    println(solution1(arrayOf(12, 4, 2, 7, 9, 27, 1, 3, 8, 6, 5, 0), 7))

    println(solution1(arrayOf(12, 4, 2, 7, 9, 27, 1, 3, 8, 6, 5, 0), 5))

    println(solution1(arrayOf(12, 4, 2, 7, 9, 27, 27, 1, 3, 8, 6, 5, 0), 39))
}
