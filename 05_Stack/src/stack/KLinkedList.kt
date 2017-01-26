package stack

/**
 * Created by sierisimo on 1/13/17.
 *
 */
data class Node<T>(val value: T, var next: Node<T>?)

open class SingleLinkedList<T>(_head: Node<T>?) {
    var head: Node<T>? = _head
        protected set

    var tail: Node<T>? = head
        protected set

    var size: Int = if (head == null) 0 else 1
        protected set

    fun search(value: T): Node<T>? {
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

    //FIXME: Change to insert(value: T) because it's the right signature
    fun insert(node: Node<T>) {
        if (head == null) {
            head = node
            tail = head
            size = 1
        } else {
            tail?.next = node
            tail = node
            size++
        }
    }

    fun delete(node: Node<T>) {
        if (head != null) {
            if (head == node) {
                head = if (head!!.next != null) head!!.next else null
                if (head == null) {
                    tail = head
                    size = 0
                } else {
                    size--
                }
            } else {
                var previousNode: Node<T> = head!!
                var currentNode: Node<T>? = previousNode.next

                while (currentNode != null) {
                    if (currentNode == node) {
                        previousNode.next = currentNode.next
                        size--
                        break
                    } else {
                        previousNode = currentNode
                        currentNode = currentNode.next
                    }
                }

                if (currentNode == tail) {
                    tail = previousNode
                }
            }
        }
    }
/*
    override fun toString(): String {
        return if (head == null) {
            "SingleLinkedList[]"
        } else {
            val strBuilder = StringBuilder("SingleLinkedList[${head!!.value} -> ")

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
    */
}
