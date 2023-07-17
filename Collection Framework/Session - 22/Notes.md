# **The Queue Interface:**
The `java.util.Queue` interface is part of the `java.util.Collection` framework and represents an ordered list of objects. However, it has a key difference from other collection types like List. The Queue supports the ordering of elements in a first-in-first-out (FIFO) manner, which means the element that is first added to the Queue will be the first one to be retrieved.

FIFO Behavior:
In a FIFO Queue, the element at the front of the Queue is the next one to be removed when dequeuing. This behavior is similar to standing in a queue, where the first person who joins the line is the first one to be served.

Queue Interface Methods:
The Queue interface provides additional methods, in addition to the basic collection operations, to support queue-specific behavior:

1. `Object element()`: Retrieves the head of the Queue. This method is similar to `peek()` but throws an exception (`NoSuchElementException`) if the Queue is empty.

2. `boolean offer(Object e)`: Inserts the specified element into the Queue if possible. This method is useful when there is a possibility of the Queue being full (when using a bounded Queue implementation). It returns true if the element was successfully added, or false if the element cannot be added due to capacity restrictions.

3. `Object peek()`: Retrieves the head of the Queue without removing it. It returns null if the Queue is empty.

4. `Object poll()`: Retrieves and removes the head of the Queue, returning null if the Queue is empty.

5. `Object remove()`: Retrieves and removes the head of the Queue. This method is similar to `poll()` but throws an exception (`NoSuchElementException`) if the Queue is empty.

Two Forms of Methods:
Each method in the Queue interface exists in two forms:

1. Exception-throwing form: These methods throw an exception when the operation fails. For example, `remove()` and `element()` will throw `NoSuchElementException` if the Queue is empty.

2. Special value form: These methods return a special value (null or false) when the operation fails, instead of throwing an exception. For example, `poll()` and `peek()` return null if the Queue is empty, and `offer()` returns false if the Queue is at its maximum capacity and cannot accept more elements.

Example Usage of Queue Interface:
```java
import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        // Adding elements to the Queue
        queue.offer("Apple");
        queue.offer("Banana");
        queue.offer("Orange");

        // Retrieving and removing elements from the Queue
        while (!queue.isEmpty()) {
            String fruit = queue.poll();
            System.out.println("Next fruit: " + fruit);
        }
    }
}
```

Output:
```
Next fruit: Apple
Next fruit: Banana
Next fruit: Orange
```

In this example, we use a `LinkedList` to implement the Queue. We add three fruits to the Queue using `offer()`, and then we retrieve and remove them using `poll()` in the FIFO order.

The Queue interface is commonly used in scenarios where elements need to be processed in the order they were added, such as task scheduling, breadth-first searches, and other queue-based algorithms.

<br/>
<br/>

**Two Forms Of Methods in Queue Interface:**
The Queue interface provides methods for insertion, removal, and examination of elements in the Queue. Each method in the Queue interface exists in two forms: one form throws an exception if the operation fails, and the other form returns a special value if the operation fails.

1. Insertion:
   - `add(e)`: This method is used to insert the specified element `e` into the Queue. If the Queue is full and cannot accept more elements (e.g., when using a bounded Queue implementation), this method throws an `IllegalStateException` (exception-throwing form). Otherwise, it returns true (special value form) to indicate that the element was successfully added.

   - `offer(e)`: This method is also used to insert the specified element `e` into the Queue. If the Queue is at its maximum capacity and cannot accept more elements, it returns false (special value form) without throwing any exception. Otherwise, it adds the element to the Queue and returns true to indicate success.

2. Removal:
   - `remove()`: This method is used to remove and retrieve the head (first element) of the Queue. If the Queue is empty, it throws a `NoSuchElementException` (exception-throwing form). Otherwise, it removes the head element and returns it.

   - `poll()`: This method is also used to remove and retrieve the head of the Queue. If the Queue is empty, it returns null (special value form) without throwing any exception.

3. Examination:
   - `element()`: This method is used to examine (retrieve) the head of the Queue without removing it. If the Queue is empty, it throws a `NoSuchElementException` (exception-throwing form). Otherwise, it returns the head element.

   - `peek()`: This method is also used to examine the head of the Queue without removing it. If the Queue is empty, it returns null (special value form) without throwing any exception.

Example Usage:
```java
import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        // Insertion
        queue.offer("Apple");
        queue.add("Banana");

        // Removal
        String removedElement = queue.poll();
        System.out.println("Removed Element: " + removedElement);

        // Examination
        String peekedElement = queue.peek();
        System.out.println("Peeked Element: " + peekedElement);

        // Remove all elements from the queue
        queue.clear();
        System.out.println("Queue is empty: " + queue.isEmpty());
    }
}
```

Output:
```
Removed Element: Apple
Peeked Element: Banana
Queue is empty: true
```

In this example, we use a `LinkedList` to implement the Queue. We insert elements using both `offer()` and `add()`, and then we remove the first element using `poll()` and examine the head element using `peek()`. Finally, we clear the Queue using `clear()` and check if it is empty using `isEmpty()`. Note that in this example, the Queue is not bounded, so both `offer()` and `add()` will always succeed. However, in a bounded Queue, `offer()` may return false when the Queue is full.

<br/>
<br/>

**Method Description (add() v/s offer()):**
1. `add()` method: The `add()` method is inherited from the Collection interface and is used to insert an element into the Queue. It will add the element unless it would violate the Queue's capacity restrictions, for example, when using a bounded Queue implementation. If the Queue is already at its maximum capacity and cannot accept more elements, the `add()` method throws an `IllegalStateException` to indicate that the element cannot be added.

2. `offer()` method: The `offer()` method is intended specifically for use on bounded queues. It is similar to the `add()` method in that it is used to insert an element into the Queue. However, if the Queue is at its maximum capacity and cannot accept more elements, the `offer()` method does not throw any exception. Instead, it returns `false` to indicate that the element could not be added to the Queue.

**Method Description (remove() v/s poll()):**
1. `remove()` method: The `remove()` method removes and returns the head (first element) of the Queue. The element removed is determined by the Queue's ordering policy. If the Queue is empty and there are no elements to remove, the `remove()` method throws a `NoSuchElementException` to indicate that the Queue is empty.

2. `poll()` method: The `poll()` method also removes and returns the head of the Queue. Like the `remove()` method, it follows the Queue's ordering policy to determine which element is removed. The key difference is that if the Queue is empty, the `poll()` method does not throw an exception. Instead, it returns `null` to indicate that there are no elements to remove from the Queue.

**Method Description (element() v/s peek()):**
1. `element()` method: The `element()` method returns, but does not remove, the head of the Queue. It retrieves the first element based on the Queue's ordering policy. If the Queue is empty, and there are no elements to retrieve, the `element()` method throws a `NoSuchElementException` to indicate that the Queue is empty.

2. `peek()` method: The `peek()` method is also used to examine (retrieve) the head of the Queue without removing it. Like the `element()` method, it follows the Queue's ordering policy to determine which element to retrieve. If the Queue is empty, the `peek()` method does not throw an exception. Instead, it returns `null` to indicate that there are no elements to retrieve from the Queue.

Example Usage:
```java
import java.util.LinkedList;
import java.util.Queue;

public class QueueMethodsExample {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        // add() vs offer()
        queue.add("Apple");
        boolean isOffered = queue.offer("Banana");
        System.out.println("Offered: " + isOffered);

        // remove() vs poll()
        String removedElement = queue.remove();
        System.out.println("Removed Element: " + removedElement);
        String polledElement = queue.poll();
        System.out.println("Polled Element: " + polledElement);

        // element() vs peek()
        String peekedElement = queue.element();
        System.out.println("Peeked Element: " + peekedElement);
        String peekedNull = queue.peek();
        System.out.println("Peeked Null: " + peekedNull);
    }
}
```

Output:
```
Offered: true
Removed Element: Apple
Polled Element: Banana
Peeked Element: Banana
Peeked Null: null
```

In this example, we use a `LinkedList` to implement the Queue. We demonstrate the difference between `add()` and `offer()` for insertion, `remove()` and `poll()` for removal, and `element()` and `peek()` for examination. Note that the behavior of these methods may vary depending on the implementation of the Queue.

<br/>
<br/>

**Object Ordering in Queue:**
1. Queues typically, but not necessarily, order elements in a FIFO (first-in-first-out) manner: FIFO means that the element that was added first to the queue will be the first one to be removed. This ordering ensures that elements are processed in the order they were added, similar to a line or queue in real-world scenarios.

2. Among the exceptions are priority queues, which order elements according to their values: Priority queues are a specialized type of queue that assigns a priority value to each element. Elements with higher priority values are removed before elements with lower priority values, regardless of the order they were added. This is in contrast to a regular FIFO queue, where elements are removed in the order they were inserted.

3. Whatever ordering is used, the head of the queue is the element that would be removed by a call to remove() or poll(): In both regular FIFO queues and priority queues, the head of the queue is the next element to be removed. The `remove()` and `poll()` methods remove and return the head of the queue, respecting the specified ordering.

4. In a FIFO queue, all new elements are inserted at the tail of the queue: In a standard FIFO queue, elements are inserted at the end (tail) of the queue, and they remain in the queue until they are removed from the front (head). This ensures that the oldest element is the first to be removed.

5. Other kinds of queues may use different placement rules: While FIFO is the most common ordering rule for queues, some specialized queue implementations may use different rules for placing elements. For example, in a LIFO (last-in-first-out) queue, the last element inserted is the first one to be removed, which is similar to a stack.

6. Every Queue implementation must specify its ordering properties: The ordering properties of a Queue are defined by its specific implementation. For instance, a LinkedList-based Queue will follow FIFO order, while a PriorityQueue will follow a specific ordering based on element priorities.

Overall, the ordering of elements in a Queue depends on the particular implementation being used. It is essential to refer to the documentation of the specific Queue implementation to understand its ordering behavior and ensure that it meets the requirements of the application. For standard FIFO behavior, the LinkedList class is commonly used, while for priority-based ordering, the PriorityQueue class is employed.

<br/>
<br/>

**Bounded and Unbounded Queue:**
1. It is possible for a Queue implementation to restrict the number of elements that it holds; such queues are known as Bounded: A bounded queue is a type of queue that has a maximum capacity or size limit. Once the queue reaches its capacity, attempting to add more elements will result in blocking or throwing an exception, depending on the implementation.

2. While a queue in which there is no upper limit specified is called an Unbounded Queue: An unbounded queue, on the other hand, has no specified upper limit on the number of elements it can hold. Elements can be added to an unbounded queue without any restrictions until the system's memory allows.

3. Some Queue implementations in java.util.concurrent are bounded, but the implementations in java.util are not: The `java.util.concurrent` package provides several thread-safe queue implementations, some of which are bounded and others that are unbounded. These implementations are designed for concurrent use in multi-threaded environments.

4. For example, `java.util.concurrent.ArrayBlockingQueue` is a bounded queue, while `PriorityQueue` available in `java.util` is Unbounded: `ArrayBlockingQueue` is a bounded queue that stores elements in an array with a fixed capacity. Once the queue is full, any attempt to add more elements will result in blocking until space becomes available. On the other hand, `PriorityQueue` is an unbounded priority queue that orders elements based on their natural order or a custom comparator.

The choice between using a bounded or unbounded queue depends on the requirements of the specific application. Bounded queues are useful in scenarios where resource constraints or system limitations need to be managed, while unbounded queues are suitable when the number of elements is unpredictable, and there are no strict size restrictions. Additionally, when working with multi-threaded applications, it is crucial to use thread-safe queue implementations to ensure proper synchronization and avoid data corruption.

<br/>
<br/>

**Handling of null by Queue:**

1. Queue implementations generally do not allow insertion of null elements: In most cases, Queue implementations do not permit the insertion of null elements. This is because null is often used as a special value to indicate the absence of a valid element. Allowing null elements in a queue could lead to ambiguity and make it difficult to distinguish between an empty queue and a queue containing null as a valid element.

2. The LinkedList implementation permits null elements: The `LinkedList` class, which implements the `Queue` interface, is an exception to the general rule. It allows the insertion of null elements. However, it is essential to be cautious when using null in a queue.

3. Avoid using null in a Queue: Although `LinkedList` allows null elements, it is generally not recommended to use null as a valid element in a queue. Using null can make the code harder to read and maintain, as null values do not provide any meaningful information about the data being stored in the queue. Instead, it is better to use specific values or objects to represent empty or missing data.

**Queue Implementations:**

1. LinkedList is a pretty standard queue implementation: The `LinkedList` class provides a standard implementation of a queue, supporting all the basic queue operations like adding elements to the end of the queue (enqueue) and removing elements from the front of the queue (dequeue). It follows the first-in-first-out (FIFO) ordering of elements.

2. PriorityQueue stores its elements based on their natural order or a custom comparator: The `PriorityQueue` class is a priority queue implementation. It stores its elements in a way that allows retrieval in priority order, where elements with the highest priority come first. The priority is determined either by the natural ordering of elements (if they implement `Comparable`) or by a custom comparator provided to the `PriorityQueue`.

In summary, Queue implementations typically do not allow null elements, except for `LinkedList`, which permits them. However, using null in a queue is generally discouraged due to potential confusion and readability issues. Instead, it is better to use specific values or objects to represent empty or missing data in a queue. Additionally, `LinkedList` and `PriorityQueue` are two popular implementations of the Queue interface, each serving different purposes based on the requirements of the application.

<br/>
<br/>

# Code And their explanation

```java
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<String> myQueue = new LinkedList<>();
        myQueue.offer("Monday");
        myQueue.offer("Tuesday");
        boolean flag = myQueue.offer("Wednesday");
        System.out.println("Wednesday inserted successfully? " + flag);

        try {
            myQueue.add("Thursday");
            myQueue.add("Friday");
            myQueue.add("Weekend");
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        System.out.println("Pick the head of the queue: " + myQueue.peek());

        String head = null;
        try {
            head = myQueue.remove();
            System.out.print("1) Push out " + head + " from the queue ");
            System.out.println("and the new head is now: " + myQueue.element());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }

        head = myQueue.poll();
        System.out.print("2) Push out " + head + " from the queue ");
        System.out.println("and the new head is now: " + myQueue.peek());
        System.out.println("Does the queue contain 'Weekend'? " + myQueue.contains("Weekend"));
        System.out.println("Does the queue contain 'Monday'? " + myQueue.contains("Monday"));
    }
}
```

**Output**

```
    Wednesday inserted successfully? true
    Pick the head of the queue: Monday
    1) Push out Monday from the queue and the new head is
    now: Tuesday
    2) Push out Tuesday from the queueand the new head is
    now: Wednesday
    Does the queue contain 'Weekend'? true
    Does the queue contain 'Monday'? false
```

Explanation:
1. We create a `Queue` called `myQueue` using the `LinkedList` implementation: `Queue<String> myQueue = new LinkedList<>();`
2. We use the `offer()` method to add elements "Monday," "Tuesday," and "Wednesday" to the queue: 
   ```java
   myQueue.offer("Monday");
   myQueue.offer("Tuesday");
   boolean flag = myQueue.offer("Wednesday");
   ```
   The `offer()` method returns true if the element is successfully inserted.
3. The output confirms that "Wednesday" was inserted successfully, as indicated by the value of `flag` being true: 
   ```
   Wednesday inserted successfully? true
   ```
4. We use the `add()` method to add elements "Thursday," "Friday," and "Weekend" to the queue: 
   ```java
   try {
       myQueue.add("Thursday");
       myQueue.add("Friday");
       myQueue.add("Weekend");
   } catch (IllegalStateException e) {
       e.printStackTrace();
   }
   ```
   However, the `LinkedList` class, being an implementation of `Queue`, has no specific capacity restrictions, so it does not throw an `IllegalStateException` for being "full" like other bounded queue implementations. The catch block is executed, and the output shows the stack trace of the exception that would have been thrown if it were a bounded queue.
5. We use the `peek()` method to see the head of the queue without removing it: 
   ```java
   System.out.println("Pick the head of the queue: " + myQueue.peek());
   ```
   The output shows "Monday" as it is the head of the queue: 
   ```
   Pick the head of the queue: Monday
   ```
6. We use the `remove()` method to remove and retrieve the head of the queue: 
   ```java
   head = myQueue.remove();
   ```
   The value of `head` will be "Monday."
7. We print the result and show the new head of the queue using the `element()` method: 
   ```java
   System.out.print("1) Push out " + head + " from the queue ");
   System.out.println("and the new head is now: " + myQueue.element());
   ```
   The output shows "1) Push out Monday from the queue and the new head is now: Tuesday."
8. We use the `poll()` method to remove and retrieve the head of the queue again: 
   ```java
   head = myQueue.poll();
   ```
   The value of `head` will be "Tuesday."
9. We print the result and show the new head of the queue using the `peek()` method: 
   ```java
   System.out.print("2) Push out " + head + " from the queue ");
   System.out.println("and the new head is now: " + myQueue.peek());
   ```
   The output shows "2) Push out Tuesday from the queue and the new head is now: Wednesday."
10. We use the `contains()` method to check if "Weekend" and "Monday" are present in the queue: 
    ```java
    System.out.println("Does the queue contain 'Weekend'? " + myQueue.contains("Weekend"));
    System.out.println("Does the queue contain 'Monday'? " + myQueue.contains("Monday"));
    ```
    The output shows that "Weekend" is present, but "Monday" is not in the queue: 
    ```
    Does the queue contain 'Weekend'? true
    Does the queue contain 'Monday'? false
    ```

<br/>
<br/>
<br/>



# PriorityQueue Class

The `PriorityQueue` class was introduced in Java 1.5 as part of the Java Collections Framework. It represents an unbounded queue based on a priority heap. The elements of the priority queue are ordered based on either the natural order (if elements implement the `Comparable` interface) or a provided `Comparator` for custom ordering.

**Priority and Use Case**

The primary use case for `PriorityQueue` is to handle elements based on priority. In scenarios where elements need to be processed based on their priority, such as processing high-priority tasks before low-priority ones, the `PriorityQueue` is very useful. For example, in a printer queue, higher-priority documents can be printed before lower-priority documents.

**Ordering of Elements**

The head of the `PriorityQueue` is the least item in the order. The element at the front of the `PriorityQueue` is the one with the highest priority as per the ordering defined. It will be the first element dequeued when calling `poll()` or `remove()`. Ties between elements in the `PriorityQueue` are decided arbitrarily, meaning that if multiple elements have the same priority, the order of these elements might be arbitrary, and the choice depends on the underlying data structure and implementation.

**Null Values**

`null` values are not allowed in a `PriorityQueue`. Unlike some other collection types, attempting to add `null` to a `PriorityQueue` will result in a `NullPointerException`.

**Synchronization**

`PriorityQueue` is not synchronized, meaning it does not provide built-in synchronization for concurrent access by multiple threads. If multiple threads modify the queue simultaneously, it may lead to unexpected behavior. To make it thread-safe, you can use the `PriorityBlockingQueue` class instead.

**Dynamic Size**

`PriorityQueue` is unbounded and grows dynamically based on the number of elements. Unlike some other collections with a fixed size, `PriorityQueue` can grow dynamically as you add elements. As elements are added, the internal capacity is increased to accommodate them.

**Iterator Order**

The iterator of `PriorityQueue` does not guarantee any particular order during traversal. The order of elements returned by the iterator of a `PriorityQueue` is not specified. It may or may not follow the priority order. If you need to traverse elements in priority order, you should use dequeue operations like `poll()` instead.

**Performance**

Performance-wise, the `contains()` method takes linear time O(n) because it needs to traverse the queue to check for the presence of an element. On the other hand, `peek()`, `element()`, and `size()` operations have fixed time complexities O(1) as they only access the head of the queue or its size. The insertion (`offer()`) and removal (`poll()` and `remove()`) operations in a `PriorityQueue` have a time complexity of O(log n). The priority heap data structure ensures that these operations are efficient and maintain the heap properties while performing them.

<br/>
<br/>

# Methods of `PriorityQueue` Class

**Methods for Adding Elements:**

1. `boolean add(E e)`: Inserts the specified element into the priority queue. Returns true if the element is added successfully, and false if it fails.
2. `boolean offer(E e)`: Inserts the specified element into the priority queue. Returns true if the element is added successfully, and false if it fails.
3. `boolean addAll(Collection<? extends E> c)`: Adds all the elements from the specified collection to the priority queue.

**Methods for Removing Elements:**

4. `E remove()`: Retrieves and removes the head of the priority queue. Throws `NoSuchElementException` if the queue is empty.
5. `E poll()`: Retrieves and removes the head of the priority queue, or returns null if the queue is empty.
6. `boolean remove(Object o)`: Removes a single instance of the specified element from the priority queue, if it is present.
7. `boolean removeAll(Collection<?> c)`: Removes all the elements in the specified collection from the priority queue, if they are present.
8. `boolean retainAll(Collection<?> c)`: Retains only the elements in the priority queue that are contained in the specified collection.
9. `void clear()`: Removes all the elements from the priority queue.

**Methods for Retrieving Elements:**

10. `E element()`: Retrieves, but does not remove, the head of the priority queue. Throws `NoSuchElementException` if the queue is empty.
11. `E peek()`: Retrieves, but does not remove, the head of the priority queue, or returns null if the queue is empty.
12. `Iterator<E> iterator()`: Returns an iterator over the elements in the priority queue.
13. `Object[] toArray()`: Returns an array containing all the elements in the priority queue.
14. `<T> T[] toArray(T[] a)`: Returns an array containing all the elements in the priority queue, using the provided array if it is large enough; otherwise, a new array is created.

**Methods for Checking Size and Empty:**

15. `int size()`: Returns the number of elements in the priority queue.
16. `boolean isEmpty()`: Returns true if the priority queue is empty, otherwise returns false.

**Methods for Iterating and Performing Actions:**

17. `void forEach(Consumer<? super E> action)`: Performs the given action for each element of the priority queue until all elements have been processed or the action throws an exception.

Please note that some methods in the `PriorityQueue` class are inherited from its superclasses, like `AbstractQueue` and `AbstractCollection`.

<br/>
<br/>

# Let's go through each method of the `PriorityQueue` class and explain them with example code snippets:

**1. `boolean add(E e)` and `boolean offer(E e)`:**

   These methods are used to add an element to the priority queue.

   ```java
   import java.util.PriorityQueue;

   public class PriorityQueueExample {
       public static void main(String[] args) {
           PriorityQueue<Integer> pq = new PriorityQueue<>();

           // Using add() method
           pq.add(10);
           pq.add(5);
           pq.add(20);

           // Using offer() method
           boolean added = pq.offer(15);
           if (added) {
               System.out.println("Element 15 inserted successfully.");
           }

           System.out.println("PriorityQueue: " + pq); // Output: PriorityQueue: [5, 10, 20, 15]
       }
   }
   ```

**2. `boolean addAll(Collection<? extends E> c)`:**

   This method is used to add all elements from a collection to the priority queue.

   ```java
   import java.util.PriorityQueue;
   import java.util.Arrays;

   public class PriorityQueueExample {
       public static void main(String[] args) {
           PriorityQueue<Integer> pq = new PriorityQueue<>();
           Integer[] elements = {30, 25, 40};

           // Using addAll() method
           pq.addAll(Arrays.asList(elements));

           System.out.println("PriorityQueue: " + pq); // Output: PriorityQueue: [25, 30, 40]
       }
   }
   ```

**3. `E remove()` and `E poll()`:**

   These methods are used to retrieve and remove the head of the priority queue.

   ```java
   import java.util.PriorityQueue;

   public class PriorityQueueExample {
       public static void main(String[] args) {
           PriorityQueue<Integer> pq = new PriorityQueue<>();
           pq.add(10);
           pq.add(5);
           pq.add(20);

           // Using remove() method
           int head = pq.remove();
           System.out.println("Removed head: " + head); // Output: Removed head: 5

           // Using poll() method
           int nextHead = pq.poll();
           System.out.println("Next head: " + nextHead); // Output: Next head: 10

           System.out.println("PriorityQueue: " + pq); // Output: PriorityQueue: [20]
       }
   }
   ```

**4. `boolean remove(Object o)`, `boolean removeAll(Collection<?> c)`, and `boolean retainAll(Collection<?> c)`:**

   These methods are used to remove elements from the priority queue based on different conditions.

   ```java
   import java.util.PriorityQueue;
   import java.util.Arrays;

   public class PriorityQueueExample {
       public static void main(String[] args) {
           PriorityQueue<Integer> pq = new PriorityQueue<>();
           pq.addAll(Arrays.asList(10, 5, 20, 15));

           // Using remove(Object o) method
           boolean removed = pq.remove(5);
           if (removed) {
               System.out.println("Element 5 removed successfully.");
           }

           // Using removeAll(Collection<?> c) method
           boolean allRemoved = pq.removeAll(Arrays.asList(10, 15));
           if (allRemoved) {
               System.out.println("All elements removed successfully.");
           }

           // Using retainAll(Collection<?> c) method
           boolean retained = pq.retainAll(Arrays.asList(20));
           if (retained) {
               System.out.println("Only element 20 is retained.");
           }

           System.out.println("PriorityQueue: " + pq); // Output: PriorityQueue: [20]
       }
   }
   ```

**5. `E element()` and `E peek()`:**

   These methods are used to retrieve, but not remove, the head of the priority queue.

   ```java
   import java.util.PriorityQueue;

   public class PriorityQueueExample {
       public static void main(String[] args) {
           PriorityQueue<Integer> pq = new PriorityQueue<>();
           pq.addAll(Arrays.asList(10, 5, 20));

           // Using element() method
           int head = pq.element();
           System.out.println("Head of the PriorityQueue: " + head); // Output: Head of the PriorityQueue: 5

           // Using peek() method
           int peekHead = pq.peek();
           System.out.println("Peek head of the PriorityQueue: " + peekHead); // Output: Peek head of the PriorityQueue: 5

           System.out.println("PriorityQueue: " + pq); // Output: PriorityQueue: [5, 10, 20]
       }
   }
   ```

**6. `Iterator<E> iterator()`, `Object[] toArray()`, and `<T> T[] toArray(T[] a)`:**

   These methods are used to retrieve elements or convert the priority queue to an array.

   ```java
   import java.util.PriorityQueue;
   import java.util.Iterator;

   public class PriorityQueueExample {
       public static void main(String[] args) {
           PriorityQueue<Integer> pq = new PriorityQueue<>();
           pq.addAll(Arrays.asList(10, 5, 20));

           // Using iterator() method
           Iterator<Integer> iterator = pq.iterator();
           System.out.print("PriorityQueue elements: ");
           while (iterator.hasNext()) {
               System.out.print(iterator.next() + " "); // Output: PriorityQueue elements: 5 10 20
           }
           System.out.println();

           // Using toArray() method
           Object[] arr = pq.toArray();
           System.out.println("Array representation of PriorityQueue: " + Arrays.toString(arr)); // Output: Array representation of PriorityQueue: [5, 10, 20]

           // Using toArray(T[] a) method
           Integer[] intArr = new Integer[pq.size()];
           pq.toArray(intArr);
           System.out.println("Integer array representation of PriorityQueue: " + Arrays.toString(intArr)); // Output: Integer array representation of PriorityQueue: [5, 10, 20]
       }
   }
   ```

**7. `int size()` and `boolean isEmpty()`:**

   These methods are used to check the size and emptiness of the priority queue.

   ```java
   import java.util.PriorityQueue;

   public class PriorityQueueExample {
       public static void main(String[] args) {
           PriorityQueue<Integer> pq = new PriorityQueue<>();
           pq.addAll(Arrays.asList(10, 5, 20));

           // Using size() method
           int size = pq.size();
           System.out.println("Size of the PriorityQueue: " + size); // Output: Size of the PriorityQueue: 3

           // Using isEmpty() method
           boolean empty = pq.isEmpty();
           System.out.println("PriorityQueue is empty: " + empty); // Output: PriorityQueue is empty: false
       }
   }
   ```

**8. `void forEach(Consumer<? super E> action)`:**

   This method is used to perform the given action for each element in the priority queue.

   ```java
   import java.util.PriorityQueue;

   public class PriorityQueueExample {
       public static void main(String[] args) {
           PriorityQueue<String> pq = new PriorityQueue<>();
           pq.addAll(Arrays.asList("apple", "banana", "orange"));

           // Using forEach() method
           pq.forEach(item -> System.out.println("Fruit: " + item));

           /* Output:
              Fruit: apple
              Fruit: banana
              Fruit: orange
           */
       }
   }
   ```

These are the main methods of the `PriorityQueue` class, and their respective examples demonstrate how to use them effectively.