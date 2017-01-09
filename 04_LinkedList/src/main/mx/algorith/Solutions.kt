package mx.algorith

/**
 * Created by sierisimo on 1/8/17.
 */
fun solution1(list: NodeList<Int>): Boolean {
    var node1 = list.head
    var node2 = node1!!.next

    while (node1 != null && node2 != null) {
        if (node1 == node2) {
            return true
        } else {
            node1 = node1.next
            node2 = node2.next
            if (node2 == null) return false
            node2 = node2.next
        }
    }

    return false
}

fun solution2(list: NodeList<Int>): Boolean {
    val rList = getReversedList(list)
    var head = list.head
    var rHead = rList.head

    while (head != null && rHead != null) {
        if(head != rHead) return false
        head = head.next
        rHead = rHead.next
    }

    return true
}


fun getReversedList(list: NodeList<Int>): NodeList<Int> {
    var node = Node<Int>(list.head!!.value, null)
    var tmpNode = list.head

    while (tmpNode != null) {
        if (tmpNode.next != null) {
            val nNode = Node<Int>(tmpNode.next!!.value, node)
            node = nNode
        }
        tmpNode = tmpNode.next
    }

    return NodeList(node)
}

fun main(args: Array<String>) {
    val mock = getMockList()
    val rMock = getReversedList(mock)
    println(mock)
    println(rMock)

    println(solution2(mock))

    println(getPalindrome())
    println(solution2(getPalindrome()))
}
