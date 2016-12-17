package karrays

import java.util.*

/**
 * Created by sierisimo on 12/17/16.
 *
 */
class OperableArray(val initialCapacity: Int = 0) {
    private var elements: IntArray = intArrayOf()

    private var size = 0

    constructor(initialCapacity: Int = 0, array: IntArray) : this(initialCapacity) {
        if (initialCapacity > size) {
            elements = IntArray(initialCapacity)
        }
        copyToElements(array)

        size = elements.size
    }

    operator fun plus(array: IntArray) {
        println("Union Called")
        size = elements.size + array.size

        val oldArray = elements.copyOf()
        elements = IntArray(size)

        var idx = 0
        var oIdx = 0
        var nIdx = 0

        while (idx < size) {
            val oElement = if (oIdx >= oldArray.size) Int.MAX_VALUE else oldArray[oIdx]
            val nElement = if (nIdx >= array.size) Int.MAX_VALUE else array[nIdx]

            elements[idx++] = if (oElement < nElement) {
                oIdx++
                oElement
            } else if (oElement > nElement) {
                nIdx++
                nElement
            } else {
                oIdx++
                nIdx++

                if ((oIdx <= oldArray.size) && (nIdx <= array.size)) oElement else 0
            }
        }

        removeUnnecessarySpace()
    }

    operator fun mod(array: IntArray) {
        println("Intersection called")
    }

    private fun copyToElements(array: IntArray) {
        for ((i, v) in array.withIndex()) {
            elements[i] = v
        }
    }

    // FIXME: Use the same array
    private fun removeUnnecessarySpace() {
        var lastIndex = 0
        var previousValue: Int = elements[0]

        for ((i, v) in elements.withIndex()) {
            if (previousValue < v) {
                lastIndex++
                previousValue = v
            }
        }

        val newArray = IntArray(++lastIndex)
        for ((i, v) in newArray.withIndex()) {
            newArray[i] = elements[i]
        }

        elements = newArray.copyOf()
    }

    override fun toString(): String {
        return "OperableArray{elements: ${elements.toList()}, size: $size"
    }
}
