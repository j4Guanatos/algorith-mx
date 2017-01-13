package mx.algorith

/**
 * Created by sierisimo on 1/8/17.
 */
data class Node<T>(val value: T, var next: Node<T>?)

class NodeList<T>(_head: Node<T>?) {
    var head: Node<T>? = _head
        private set

    var tail: Node<T>? = head
        private set

    var size: Int = if (head == null) 0 else 1
        private set

    fun search(value: Node<T>): Node<T>? {
        return if (head == null) null
        else {
            if (head!!.value == value) head
            else {
                var solution: Node<T>? = null
                var newHead = head

                while (newHead != null) {
                    val next = newHead.next
                    if (next?.value == value) {
                        solution = next
                        break
                    } else {
                        newHead = next
                    }
                }

                solution
            }
        }
    }

    fun insert(node: Node<T>) {
        if (head == null) {
            head = node
            tail = head
        } else {
            tail?.next = node
            tail = node
        }
    }

    fun delete(node: Node<T>) {

    }

    override fun toString(): String {
        return if (head == null) {
            "[]"
        } else {
            val strBuilder = StringBuilder("[${head!!.value} -> ")

            var tmpNode = head!!.next
            var counter = 0
            while (tmpNode != null) {
                counter++
                strBuilder.append("${tmpNode.value} -> ")
                tmpNode = tmpNode.next

                if(counter == 20) break
            }
            strBuilder.append("NULL]")

            strBuilder.toString()
        }
    }
}

fun getMockList(): NodeList<Int> {
    val mList = NodeList(Node<Int>(3, null))
    var i = 13

    while (i < 20) {
        mList.insert(Node<Int>(i++, null))
    }

    return mList
}

fun getCycledList(): NodeList<Int> {
    val mList = getMockList()
    mList.insert(mList.head!!.next!!)

    println(mList)

    return mList
}

fun getPalindrome(): NodeList<Int>{
    var i = 13
    val mList = NodeList<Int>(null)

    while (i < 20) {
        mList.insert(Node<Int>(i++, null))
    }

    while (i > 12){
        mList.insert(Node<Int>(i--, null))
    }

    return mList
}
