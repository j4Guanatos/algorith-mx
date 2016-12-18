package karrays

/**
 * Created by sierisimo on 12/17/16.
 */
fun main(args: Array<String>) {
    var inputReader = readLine()

    val lines = mutableListOf<String>()

    var operation: String
    var arrayParameter: IntArray

    val firstArray = inputReader?.split(" ")?.map(String::toInt)?.toIntArray()

    val operableArray = OperableArray(firstArray!!)

    do {
        inputReader = readLine()

        if (inputReader == null) break

        lines.add(inputReader)
    } while (inputReader != null)

    lines.listIterator()
            .forEach {
                val elementsOnInput = it.split(" ")
                operation = elementsOnInput[0]

                arrayParameter = elementsOnInput.subList(1, elementsOnInput.size)
                        .map(String::toInt)
                        .toIntArray()

                when (operation) {
                    "i" -> operableArray % arrayParameter
                    "u" -> operableArray + arrayParameter
                }
            }

    print(operableArray)
}
