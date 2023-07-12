# **`Stack` in Detail**

**1. Stack extends Vector:**
The Stack class is a subclass of the Vector class. In Java, a class can extend only one other class, and by extending Vector, the Stack class inherits all the methods and behaviors of Vector. This includes implementing various interfaces such as Collection, List, Serializable, Cloneable, and RandomAccess.

**2. Specially designed to support LIFO behavior:**
A stack is a data structure that follows the Last-In-First-Out (LIFO) principle. It means that the last element added to the stack will be the first one to be removed. The Stack class is designed specifically to support this behavior.

**3. Insertion order preserved:**
The Stack class preserves the insertion order of elements. When you push elements onto the stack, they are added to the top, and when you pop elements from the stack, they are removed from the top in the reverse order of their insertion.

**4. Duplicates are allowed:**
The Stack class allows duplicate elements. You can push the same element multiple times onto the stack, and it will be stored and retrieved accordingly.

**5. Allows null to be passed:**
The Stack class allows null elements to be pushed onto the stack. You can push a null value onto the stack as a valid element.

**6. Permits heterogeneous objects:**
The Stack class permits the storage of objects of different types. You can push objects of different classes onto the stack without any restrictions.

Now, let's move on to the constructor and stack-specific methods.

Constructor of Stack:
The Stack class has only one constructor, which is the default constructor with no arguments:

```java
public Stack()
```

This constructor creates an empty stack, with no elements in it.

Stack-specific methods:

**1. `public Object push(Object element)`:**
This method pushes an item onto the top of the stack and returns the element pushed. It takes an object `element` as a parameter and adds it to the top of the stack.

Example usage:

```java
Stack<Integer> stack = new Stack<>();
stack.push(5);
stack.push(10);
stack.push(15);
```

**2. `public Object pop()`:**
The `pop()` method removes the object at the top of the stack and returns it. If the stack is empty, it throws an `EmptyStackException`.

Example usage:

```java
Stack<Integer> stack = new Stack<>();
stack.push(5);
stack.push(10);
int topElement = stack.pop(); // Removes and returns 10
```

**3. `public Object peek()`:**
The `peek()` method returns the object at the top of the stack without removing it. If the stack is empty, it throws an `EmptyStackException`.

Example usage:

```java
Stack<Integer> stack = new Stack<>();
stack.push(5);
stack.push(10);
int topElement = stack.peek(); // Returns 10 without removing it from the stack
```

**4. `public boolean empty()`:**
The `empty()` method checks whether the stack is empty or not. It returns `true` if the stack is empty, and `false` otherwise.

Example usage:

```java
Stack<Integer> stack = new Stack<>();
boolean isEmpty = stack.empty(); // Returns true
stack.push(5);
isEmpty = stack.empty(); // Returns false
```

**5. `public int search(Object element)`:**
The `search()` method searches for an element in the stack and returns its offset from the top of the stack. If the element is found, it returns the 1-based position (distance from the top), and if not found, it returns -1.

Example usage:

```java
Stack<Integer> stack = new Stack<>();
stack.push(5);
stack.push(10);
stack.push(15);
int position = stack.search(10); // Returns 2 (10 is at position 2 from the top)
int nonExistingPosition = stack.search(20); // Returns -1 (20 is not present in the stack)
```

These are the main features and methods of the Stack class. You can utilize these methods to implement a stack data structure in your Java programs.

<br/>
<br/>

# Examples Code

Example 1:
```java
Stack<Integer> numList = new Stack();
numList.push(10);
numList.push(20);
numList.push(30);
Iterator<Integer> en = numList.iterator();
while (en.hasNext()) {
    Integer obj = en.next();
    System.out.println(obj);
}
```
This example demonstrates how to use a `Stack` and an `Iterator` to iterate over its elements. 

1. We create a `Stack` called `numList` to store integers.
2. We push three integers (`10`, `20`, and `30`) onto the stack using the `push` method.
3. We create an iterator `en` by calling the `iterator` method on the `numList` stack.
4. The `while` loop iterates as long as the iterator has a next element.
5. Inside the loop, we retrieve the next element from the iterator using `next()` and assign it to the `obj` variable.
6. We then print the value of `obj`.

The output will be:
```
10
20
30
```

Example 2:
```java
Stack<Integer> numList = new Stack();
numList.push(10);
numList.push(20);
numList.push(30);
while (!numList.empty()) {
    Integer obj = numList.pop();
    System.out.println(obj);
}
```
This example demonstrates how to use a `Stack` and the `pop` method to retrieve and remove elements from the stack.

1. We create a `Stack` called `numList` to store integers.
2. We push three integers (`10`, `20`, and `30`) onto the stack using the `push` method.
3. The `while` loop continues as long as the stack is not empty (`!numList.empty()`).
4. Inside the loop, we retrieve and remove the top element from the stack using `pop()`, and assign it to the `obj` variable.
5. We then print the value of `obj`.

The output will be:
```
30
20
10
```

Example 3:
```java
Stack st = new Stack();
System.out.println("stack: " + st);
st.push(10);
st.push(20);
st.push(30);
System.out.println("stack:" + st);
System.out.println("Top element:" + st.peek());
System.out.println("Popped ele:" + st.pop());
System.out.println("stack: " + st);
```
This example demonstrates various operations on a `Stack`.

1. We create a `Stack` called `st`.
2. We print the initial state of the stack using `System.out.println`.
3. We push three integers (`10`, `20`, and `30`) onto the stack using the `push` method.
4. We print the updated state of the stack.
5. We use the `peek` method to retrieve the top element of the stack without removing it and print its value.
6. We use the `pop` method to retrieve and remove the top element from the stack and print its value.
7. We print the final state of the stack.

The output will be:
```
stack: []
stack: [10, 20, 30]
Top element: 30
Popped ele: 30
stack: [10, 20]
```

Example 4:
```java
Stack st = new Stack();
System.out.println("stack: " + st);
st.push(10);
st.push(20);
st.push(30);
System.out.println("Offset of 10:" + st.search(10));
System.out.println("Offset of 30:" + st.search(30));
System.out.println("Offset of 40:" + st.search(40));
```
This example demonstrates how to use the `search` method of `Stack` to find the position (offset) of an element in the stack.

1. We create a `Stack` called `st`.
2. We print the initial state of the stack using `System.out.println`.
3. We push three integers (`10`, `20`, and `30`) onto the stack using the `push` method.
4. We use the `search` method to find the offset of `10` in the stack and print the result.
5. We use the `search` method to find the offset of `30` in the stack and print the result.
6. We use the `search` method to find the offset of `40` (which is not present in the stack) and print the result.

The output will be:
```
stack: []
Offset of 10: 3
Offset of 30: 1
Offset of 40: -1
```