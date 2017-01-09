# Algorith-MX Group - Session 5

## Topic: Stacks

### Overview 

A _Stack_ is an abstract data type that serves as a collection of elements, with two principal operations: **push**, which adds an element to the collection, and **pop**, which removes the most recently added element that was not yet removed. 
The order in which elements come off a stack gives rise to its alternative name, _LIFO_ (for last in, first out). Additionally, a **peek** operation may give access to the top without modifying the stack.

The name "stack" for this type of structure comes from the analogy to a set of physical items stacked on top of each other, which makes it easy to take an item off the top of the stack, while getting to an item deeper in the stack may require taking off multiple other items first.

Considered as a linear data structure, or more abstractly a sequential collection, the **push** and **pop** operations occur only at one end of the structure, referred to as the top of the stack. This makes it possible to implement a stack as a singly linked list and a pointer to the top element.

### implementations

A stack can be easily implemented either through an array or a linked list. What identifies the data structure as a stack in either case is not the implementation but the interface: the user is only allowed to pop or push items onto the array or linked list, with few other helper operations.

#### Array implementation

An array can be used to implement a (bounded) stack, as follows. 

The first element (usually at the zero offset) is the bottom, resulting in array[0] being the first element pushed onto the stack and the last element popped off. 

The program must keep track of the size (length) of the stack, using a variable top that records the number of items pushed so far, therefore pointing to the place in the array where the next element is to be inserted (assuming a zero-based index convention). 

Thus, the stack itself can be effectively implemented as a three-element structure

```cs
class Stack<T> {
  int capacity;
  int top;
  T[] items;

  public Stack<T>(int capacity){
    this.capacity = capacity;
    items = new T[capacity];
    top = -1;
  }

  public void Push(T item){
    if(top+1 >= capacity) throw new StackOverflowException();
    top ++;
    items[top] = item;
  }
  public T Pop(){
    if( top < 0 ) throw new StackUnderflowException();
    T returnValue = items[top];
    top --;
    return returnValue;
  }
}
```
#### Linked List implementation

Another option for implementing stacks is to use a singly linked list. 

A stack is then a pointer to the `HEAD` of the list, with perhaps a counter to keep track of the size of the Stack.

```cs
class StackFrame<T> {
  T data;
  StackFrame next;
  public StackFrame<T>(T data, StackFrame<T> next){
    this.data = data;
    this.next = next;
  }
}

class Stack<T> {
  StackFrame<T> head;
  int size;

  public Stack<T>(){
    size = 0;
    head = null;
  }

  public void Push<T>(T item){
    StackFrame<T> frame = new StackFrame<T>(item, head);
    head = frame;
    size++;
  }

  public T Pop<T>(){
    if(head == null)  throw new StackUnderflowException();
    T item = head.data;
    head = head.next;
    size--;
  }
}
```

### Problems on Stack

To see the problems proposed on this topic see the [Problems directory](problems)

