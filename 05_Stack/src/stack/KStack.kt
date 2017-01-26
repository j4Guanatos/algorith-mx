package stack

/**
 * Created by sierisimo on 1/13/17.
 */
class KStack<T>(_head: Node<T>?) : SingleLinkedList<T>(_head) {
    fun push(item: T) {
        val newHead = Node<T>(item, if (head == null) null else head)

        if (head == null) tail = newHead

        head = newHead
        size++
    }

    fun pop(): T? {
        return if (head != null) {
            val oldHead = head
            head = head!!.next

            size--

            oldHead!!.value
        } else {
            tail = null
            size = 0
            null
        }
    }

    fun peek(): Node<T>? = head

    override fun toString(): String {
        return if (head == null) {
            "Stack[]"
        } else {
            val strBuilder = StringBuilder("Stack[${head!!.value} -> ")

            var tmpNode = head!!.next
            var counter = 0
            while (tmpNode != null) {
                counter++
                strBuilder.append("${tmpNode.value} -> ")
                tmpNode = tmpNode.next

                if (counter == 20) break
            }
            strBuilder.append("NULL]")

            strBuilder.toString()
        }
    }
}

fun processLine(line: String): String {
    val characters = line.split("")

    val mStack = KStack<String>(null)

    val corresponds: (String, String) -> Boolean = { lCh, ch ->
        when (lCh) {
            "(" -> ch == ")"
            "{" -> ch == "}"
            "[" -> ch == "]"
            else -> false
        }
    }

    var innerFlag = true

    val size = characters.size - 1
    (0..size)
            .filter { characters[it].isNotBlank() }
            .forEach {
                if (innerFlag) {
                    val ch = characters[it]
                    if (ch == "[" || ch == "{" || ch == "(") {
                        mStack.push(ch)
                    } else {
                        val lastCh = mStack.pop()
                        if (innerFlag && !corresponds(lastCh!!, ch)) innerFlag = false
                    }
                }
            }

    return if (innerFlag) "YES" else "NO"
}

fun main(args: Array<String>) {
    val n = readLine()
    val lines = mutableListOf<String>()

    for (i in (0..n!!.toInt() - 1)) {
        lines.add(readLine()!!.trim())
    }

    lines.forEach { println(processLine(it.trim())) }
}
