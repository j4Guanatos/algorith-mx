# Stack problems

## General notes:

To give a litle more complexity and to make this more interesting, you have prohibited to use any Stack implementation on most popular languages, this means, that you have to create your own Stack implementation, for example, in C# this could be:

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


## Problem 1: Balanced Brackets

A bracket is considered to be any one of the following characters: `(`, `)`, `{`, `}`, `[`, or `]`.

Two brackets are considered to be a matched pair if the an opening bracket (i.e., `(`, `[`, or `{`) occurs to the left of a closing bracket (i.e., `)`, `]`, or `}`) of the exact same type. There are three types of matched pairs of brackets: `[]`, `{}`, and `()`.

A matching pair of brackets is not balanced if the set of brackets it encloses are not matched. For example, `{[(])}` is not balanced because the contents in between `{` and `}` are not balanced. The pair of square brackets encloses a single, unbalanced opening bracket, `(`, and the pair of parentheses encloses a single, unbalanced closing square bracket, `]`.

By this logic, we say a sequence of brackets is considered to be balanced if the following conditions are met:

* It contains no unmatched brackets.
* The subset of brackets enclosed within the confines of a matched pair of brackets is also a matched pair of brackets.
* Given  strings of brackets, determine whether each sequence of brackets is balanced. If a string is balanced, print `YES` on a new line; otherwise, print `NO` on a new line.

###Input Format

The first line contains a single integer, _n_, denoting the number of strings. 
Each line  of the  subsequent lines consists of a single string, _s_, denoting a sequence of brackets.

###Constraints

* 1 <= n <= 10E3
* 1 <= len(s) <= 10E3, where _len(s)_ is the length of the sequence.
* Each character in the sequence will be a bracket (i.e., `{`, `}`, `(`, `)`, `[`, and `]`).

###Output Format

For each string, print whether or not the string of brackets is balanced on a new line. If the brackets are balanced, print `YES`; otherwise, print `NO`.

###Sample Input

```
3
{[()]}
{[(])}
{{[[(())]]}}
```
###Sample Output

```
YES
NO
YES
```

###Explanation

The string `{[()]}` meets both criteria for being a balanced string, so we print `YES` on a new line.
The string `{[(])}` is not balanced, because the brackets enclosed by the matched pairs `[(]` and `(])` are not balanced.
The string `{{[[(())]]}}` meets both criteria for being a balanced string, so we print `YES` on a new line.


## Reverse Polish calculator

Given new-line-sepárated arithmetic calculations expressed in *RPN*(with only + - / * operations), print each operation's result in a new line.

### Explanation on palindrome

In reverse Polish notation the operators follow their operands; for instance, to add 3 and 4, one would write `"3 4 +"` rather than `"3 + 4"`. 
If there are multiple operations, the operator is given immediately after its second operand; so the expression written `"3 − 4 + 5"` in conventional notation would be written `"3 4 − 5 +"` in RPN: 4 is first subtracted from 3, then 5 added to it. 
An advantage of RPN is that it removes the need for parentheses that are required by infix notation. While `"3 − 4 × 5"` can also be written `"3 − (4 × 5)"`, that means something quite different from `"(3 − 4) × 5"`. 
In postfix, the former could be written `"3 4 5 × −"`, which unambiguously means `"3 (4 5 ×) −"` which reduces to `"3 20 −"`; the latter could be written `"3 4 − 5 ×"` (or `5 3 4 − ×`, if keeping similar formatting), which unambiguously means `"(3 4 −) 5 ×"`.

###Constraints

* All operands fit in a signed 32-bit int.
* All operators are one of `+ - * /`.
* Operands and operators are separated by spaces.
* All expressions are valid RPN expressions

### Sample input

`5 1 2 + 4 * + 3 −`

`3 4 5 * -`
### Sample output

`14`

`-17`

##
