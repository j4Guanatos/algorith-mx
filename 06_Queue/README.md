# Algorith-MX Group - Session 6

## Topic: Queues

### Overview 

A _Stack_ is another abstract data type (ADT), its main methods are: **enqueue**, used to add elements in the 'last position' (tail), and **dequeue**, which removes the element in the front (head).
This means that the queue behavior acts like (First in First Out), so the order to dispatch elements will be the same as the insertion order.

Real life representations could be: people waiting to pay in a supermarket, vehicles in a tollbooth, Tortillas queue, IMSS, etc.

### implementations

Queues can be implemented using an array or a linked list.

#### Array implementation
You define a capacity value to restrict the array length.
Head and Tail indexes need to be remembered, so you need to create two int variables.
And finally, the array that will store each element in the queue.

Enqueue add a new element in the TAIL
Dequeue removes the element in the FRONT

You can use an int variable to store the queue size, increasing and decreasing it each time a enqueue or dequeue call is executed.

#### Linked List implementation

No capacity restriction.

In order to implement a Queue using Linked list, you need to create a Node class (Single linked list).

This class will contain a data variable to store the value of the element, and a node class pointing to the next element.


### Problems



