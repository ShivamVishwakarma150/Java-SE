# **`LinkedList` class**

**1. The `LinkedList` class:**
   - `LinkedList` implements the `List` interface, which means it provides functionalities to store and manipulate a sequence of elements.
   - Internally, it uses a doubly linked list data structure, where each element is stored in a node that contains references to the previous and next nodes in the list.
   - `LinkedList` is not synchronized, which means it is not thread-safe. If multiple threads access a `LinkedList` concurrently and modify it, proper synchronization should be implemented externally.
   - It permits all elements, including `null`. Unlike some other collection classes, `LinkedList` allows storing `null` values.
   - No Initial Capacity, capacity/size increases as elements are added.

**2. Characteristics of `LinkedList`:**
   - Insertion order is preserved: The elements are stored in the same order as they are added to the list.
   - Heterogeneous elements allowed: `LinkedList` can store elements of different types.
   - Duplicates are allowed: It allows storing duplicate elements.
   - Implements Serializable and Cloneable: This means `LinkedList` can be serialized to be stored in a file or passed between systems, and it can be cloned to create a shallow copy of the list.
   - Implements Deque interface: `LinkedList` provides all the functionalities of a double-ended queue, allowing elements to be added or removed from both ends.
   - Does not implement RandomAccess: The `LinkedList` class does not implement the `RandomAccess` interface, which means it is not optimized for random access to elements by index.
   - Good choice when frequent operations are adding and removing and worst when frequent operation is retrieval.

**3. Constructors of `LinkedList`:**
   - `public LinkedList()`: This constructor creates an empty `LinkedList` with no elements initially.
   - `public LinkedList(Collection c)`: This constructor creates a `LinkedList` containing the elements of the specified collection, in the order they are returned by the collection's iterator. It allows initializing a `LinkedList` with elements from another collection.

**4. Example of creating and adding elements to a `LinkedList`:**
   ```java
   LinkedList<String> fruits = new LinkedList<>();
   fruits.add("Mango");
   fruits.add("Apple");
   fruits.add("Guava");
   System.out.println("Contents are: " + fruits);
   ```
   Output:
   ```
   Contents are: [Mango, Apple, Guava]
   ```

**5. Traversing a `LinkedList` using an iterator:**
   To traverse a `LinkedList`, you can use an iterator to iterate over the elements and perform operations on them. Here's an example:
   ```java
   LinkedList<String> fruits = new LinkedList<>();
   fruits.add("Mango");
   // Add more fruits to the list

   Iterator<String> it = fruits.iterator();
   while (it.hasNext()) {
       String fruit = it.next();
       System.out.println(fruit);
   }
   ```

**6. Traversing a `LinkedList` backwards using a `ListIterator`:**
   To traverse a `LinkedList` backwards, you can use a `ListIterator` and its `hasPrevious()` and `previous()` methods. Here's an example:
   ```java
   LinkedList<String> fruits = new LinkedList<>();
   fruits.add("Mango");
   // Add more fruits to the list

   ListIterator<String> it = fruits.listIterator();
   for (; it.hasNext(); it.next());
   while (it.hasPrevious()) {
       String fruit = it.previous();
       System.out.println(fruit);
   }
   ```

In summary, `LinkedList` is a class that implements the `List` interface using a doubly linked list. It allows adding, removing, and manipulating elements in a flexible manner. It is useful when frequent operations involve adding or removing elements. The class provides various constructors, supports traversal using iterators and list iterators, and maintains the insertion order of elements.

# Methods of Linked List 

**1. public void addFirst(Object item):**
The `addFirst(Object item)` method adds the specified item (or element) at the first position in the LinkedList. It effectively inserts the element at the beginning of the list, shifting all existing elements to higher indices. Here's an example:

```java
LinkedList<Integer> numList = new LinkedList<>(Arrays.asList(10, 15, 20, 25, 30, 35));
numList.addFirst(5);

System.out.println("LinkedList: " + numList);
```

Output:
```
LinkedList: [5, 10, 15, 20, 25, 30, 35]
```

In this example, the number 5 is added at the first position in the LinkedList.

**2. public void addLast(Object item):**
The `addLast(Object item)` method adds the specified item (or element) at the last position in the LinkedList. It effectively appends the element at the end of the list. Here's an example:

```java
LinkedList<Integer> numList = new LinkedList<>(Arrays.asList(10, 15, 20, 25, 30, 35));
numList.addLast(40);

System.out.println("LinkedList: " + numList);
```

Output:
```
LinkedList: [10, 15, 20, 25, 30, 35, 40]
```

In this example, the number 40 is added at the last position in the LinkedList.

**3. public Object getFirst():**
The `getFirst()` method returns the item (or element) at the first position in the LinkedList, without removing it. It allows you to retrieve the element at the beginning of the list. Here's an example:

```java
LinkedList<Integer> numList = new LinkedList<>(Arrays.asList(10, 15, 20, 25, 30, 35));
int firstElement = numList.getFirst();

System.out.println("First Element: " + firstElement);
```

Output:
```
First Element: 10
```

In this example, the `getFirst()` method retrieves the first element from the LinkedList.

**4. public Object getLast():**
The `getLast()` method returns the item (or element) at the last position in the LinkedList, without removing it. It allows you to retrieve the element at the end of the list. Here's an example:

```java
LinkedList<Integer> numList = new LinkedList<>(Arrays.asList(10, 15, 20, 25, 30, 35));
int lastElement = numList.getLast();

System.out.println("Last Element: " + lastElement);
```

Output:
```
Last Element: 35
```

In this example, the `getLast()` method retrieves the last element from the LinkedList.

**5. public Object removeFirst():**
The `removeFirst()` method removes and returns the first item from the LinkedList. It effectively removes the element at the beginning of the list and updates the indices of the remaining elements. Here's an example:

```java
LinkedList<Integer> numList = new LinkedList<>(Arrays.asList(10, 15, 20, 25, 30, 35));
int removedElement = numList.removeFirst();

System.out.println("Removed Element: " + removedElement);
System.out.println("LinkedList: " + numList);
```

Output:
```
Removed Element: 10
LinkedList: [15, 20, 25, 30, 35]
```

In this example, the `removeFirst()` method removes the first element (10) from the LinkedList.

**6. public Object removeLast():**
The `removeLast()` method removes and returns the last item from the LinkedList. It effectively removes the element at the end of the list. Here's an example:

```java
LinkedList<Integer> numList = new LinkedList<>(Arrays.asList(10, 15, 20, 25, 30, 35));
int removedElement = numList.removeLast();

System.out.println("Removed Element: " + removedElement);
System.out.println("LinkedList: " + numList);
```

Output:
```
Removed Element: 35
LinkedList: [10, 15, 20, 25, 30]
```

In this example, the `removeLast()` method removes the last element (35) from the LinkedList.

In summary, the LinkedList class provides additional methods like `addFirst()`, `addLast()`, `getFirst()`, `getLast()`, `removeFirst()`, and `removeLast()` that allow you to manipulate the elements at the beginning and end of the list. These methods are specific to LinkedList and not provided by other List implementations.