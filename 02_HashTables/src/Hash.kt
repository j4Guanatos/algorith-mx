import java.util.*

/**
 * Created by Sinuhe_Jaime on 09/12/2016.
 */

fun searchPairs(array: Array<Int>, target: Int): Pair<Int, Int> {
    val hashTable: Hashtable<Int, Int> = Hashtable()

    var complement: Int
    for ((i, v) in array.withIndex()) {
        if (hashTable[v] != null) {
            return Pair(hashTable[v]!!, i)
        } else {
            complement = target - v

            hashTable[complement] = i
        }
    }

    return Pair(-1, -1)
}

fun main(args: Array<String>) {
    var arr = arrayOf(2, 7, 11, 15)
    var target = 8

    arr = arrayOf(3, 7, 9, 0, 20, 30, 1000000, 1000, 900000, 90, 5, 10)

    println(searchPairs(arr, target))
}