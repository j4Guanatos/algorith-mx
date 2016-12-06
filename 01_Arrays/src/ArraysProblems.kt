/**
 * Created by Sinuhe_Jaime on 01/12/2016.
 */

fun searchMissing(sequentialArray: Array<Int>): Int = (1..sequentialArray.size + 1).sum() - sequentialArray.sum()

fun searchMissing2(sequentialArray: Array<Int>): Int = ((sequentialArray.size + 1) * (sequentialArray.size + 2)) / 2 - sequentialArray.sum()

//fun searchMissingFull(sequentialArray: Array<Int>): Int {
//    sequentialArray.sort()
//
//    var i = 0
//    while(i < sequentialArray.size){
//
//        i++
//    }
//}

fun jAndK(arr: Array<Int>, j: Int, k: Int): Pair<Int, Int> {
    val sortedArr = arr.sortedArray()
    return Pair(sortedArr[j - 1], sortedArr[sortedArr.size - k])
}

fun jAndKLiner(arr: Array<Int>, j: Int, k: Int): Pair<Int, Int> = Pair(arr.sortedArray()[j - 1], arr.sortedArray()[arr.size - k])

fun main(args: Array<String>) {
    val arr = arrayOf(1, 2, 3, 4, 5, 6, 8, 9, 10)

    println(searchMissing(arr))

    println(searchMissing2(arr))

    val arr1 = arrayOf(1, 3, 7, 9, 4)
    val arr2 = arrayOf(2, 3, 5, 1, 4, 8, 7, 6, 9)

    println(jAndK(arr1, 2, 3))
    println(jAndK(arr2, 2, 3))
}
