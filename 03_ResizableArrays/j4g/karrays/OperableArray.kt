package karrays

/**
 * Created by sierisimo on 12/17/16.
 *
 */
class OperableArray(val initialCapacity: Int = 0) {
    private var elements: IntArray = intArrayOf()
    private var size = 0

    constructor(initialCapacity: Int = 0, array: IntArray) : this(initialCapacity) {
        elements = array.copyOf()
    }

    operator fun plus(array: IntArray) {
        println("Union Called")
    }

    operator fun mod(array: IntArray){
        println("Intersection called")
    }
}
