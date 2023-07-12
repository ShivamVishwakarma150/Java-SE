# **`Vector` in Detail**

**1. The "Vector" class:**
- The Vector class in Java is a dynamic array implementation that implements the List, Serializable, Cloneable, and RandomAccess interfaces.
- It uses a growable array as its underlying data structure. The capacity of the array automatically increases as more elements are added.
- Duplicates are allowed in a Vector, meaning it can store multiple occurrences of the same element.
- Insertion order is preserved, meaning the elements are stored in the same order as they are added to the Vector.
- Vector allows null values to be stored, and it permits the storage of heterogeneous objects, meaning objects of different types can be added to the Vector.

**2. Most of the methods are synchronized, so it is thread-safe:**
- Vector is designed to be thread-safe, meaning it can be safely accessed and modified by multiple threads concurrently.
- Most of the methods in the Vector class are synchronized, which ensures that only one thread can access the Vector at a time, preventing race conditions and data inconsistencies.
- This synchronization comes at a cost of performance since acquiring and releasing locks for synchronization adds overhead. If thread safety is not required, other non-synchronized collections like ArrayList might offer better performance.

**3. Contains many legacy methods that are not part of the collections framework:**
- Vector class contains several legacy methods that were present before the introduction of the Java Collections Framework.
- These legacy methods are not part of the modern collections framework interfaces (such as List or Collection) and are generally less preferred for new development.
- It is recommended to use the methods defined in the List interface (which Vector implements) or other collections interfaces for consistency and compatibility with the modern collections framework.

**4. Constructors of Vector:**
Vector provides multiple constructors to create instances of Vector:
1. `public Vector()`: This constructor builds a default Vector with an initial capacity of 10. It creates an empty Vector with an initial capacity of 10 elements.
2. `public Vector(int capacity)`: This constructor constructs a Vector with the specified initial capacity. It creates an empty Vector with the given initial capacity.
3. `public Vector(int capacity, int incr)`: This constructor creates a Vector with the specified initial capacity and incremental capacity. It allows you to specify both the initial capacity and the increment by which the capacity should be increased if the Vector needs to grow.
4. `public Vector(Collection c)`: This constructor constructs a Vector containing the elements of the specified collection. It creates a new Vector and adds all the elements from the given collection in the order they are returned by the collection's iterator.

These constructors provide flexibility in creating Vector objects with different initial capacities and populating them with elements from other collections.

In summary, the Vector class in Java provides a dynamic array implementation that allows elements to be added and removed dynamically. It is thread-safe due to its synchronized methods, making it suitable for multi-threaded environments. Vector maintains insertion order, allows duplicates and null values, and provides various constructors for creating and initializing Vector objects with different capacities and elements. However, it also contains legacy methods that are not part of the modern collections framework, and their usage is generally discouraged in favor of the new collections interfaces and methods.

<br/>
<br/>

# Vector specific methods

**1. public void addElement(Object):**
The `addElement(Object)` method adds the specified object to the end of the Vector. It is similar to the `add()` method of the List interface. Here's an example:

```java
Vector<String> fruits = new Vector<>();
fruits.addElement("Mango");
fruits.addElement("Apple");
fruits.addElement("Guava");

System.out.println("Contents are: " + fruits);
```

Output:
```
Contents are: [Mango, Apple, Guava]
```

In this example, the `addElement()` method is used to add three fruits to the Vector.

**2. public int capacity():**
The `capacity()` method returns the current capacity of the Vector, which represents the number of elements it can hold without resizing. Here's an example:

```java
Vector<String> fruits = new Vector<>(5);
int capacity = fruits.capacity();

System.out.println("Capacity: " + capacity);
```

Output:
```
Capacity: 5
```

In this example, the `capacity()` method is used to retrieve the initial capacity of the Vector.

**3. public Object elementAt(int index):**
The `elementAt(int index)` method returns the element at the specified index in the Vector. It allows you to access an element based on its position. Here's an example:

```java
Vector<String> fruits = new Vector<>(Arrays.asList("Mango", "Apple", "Guava"));
String fruit = fruits.elementAt(1);

System.out.println("Element at index 1: " + fruit);
```

Output:
```
Element at index 1: Apple
```

In this example, the `elementAt()` method retrieves the element at index 1 (the second element) from the Vector.

**4. public Object firstElement():**
The `firstElement()` method returns the first element in the Vector. It allows you to retrieve the element at the beginning of the Vector without removing it. Here's an example:

```java
Vector<String> fruits = new Vector<>(Arrays.asList("Mango", "Apple", "Guava"));
String firstFruit = fruits.firstElement();

System.out.println("First Element: " + firstFruit);
```

Output:
```
First Element: Mango
```

In this example, the `firstElement()` method retrieves the first element from the Vector.

**5. public Object lastElement():**
The `lastElement()` method returns the last element in the Vector. It allows you to retrieve the element at the end of the Vector without removing it. Here's an example:

```java
Vector<String> fruits = new Vector<>(Arrays.asList("Mango", "Apple", "Guava"));
String lastFruit = fruits.lastElement();

System.out.println("Last Element: " + lastFruit);
```

Output:
```
Last Element: Guava
```

In this example, the `lastElement()` method retrieves the last element from the Vector.

**6. public void removeAllElements():**
The `removeAllElements()` method removes all elements from the Vector, leaving it empty. It clears the Vector and resets its size to zero. Here's an example:

```java
Vector<String> fruits = new Vector<>(Arrays.asList("Mango", "Apple", "Guava"));
fruits.removeAllElements();

System.out.println("Contents after removal: " + fruits);
```

Output:
```
Contents after removal: []
```

In this example, the `removeAllElements()` method removes all elements from the Vector.

**7. public boolean removeElement(Object):**
The `removeElement(Object)` method removes the specified element from the Vector. It returns `true` if the element was found and successfully removed, and `false` if the element was not found. Here's an example:

```java
Vector<String> fruits = new Vector<>(Arrays.asList("Mango", "Apple", "Guava"));
boolean removed = fruits.removeElement("Apple");

System.out.println("Element removed: " + removed);
System.out.println("Contents after removal: " + fruits);
```

Output:
```
Element removed: true
Contents after removal: [Mango, Guava]
```

In this example, the `removeElement()` method is used to remove the element "Apple" from the Vector.

**8. public boolean removeElementAt(int index):**
The `removeElementAt(int index)` method removes the element at the specified index from the Vector. It returns `true` if the element was successfully removed, and `false` if the index is out of bounds. Here's an example:

```java
Vector<String> fruits = new Vector<>(Arrays.asList("Mango", "Apple", "Guava"));
boolean removed = fruits.removeElementAt(1);

System.out.println("Element removed: " + removed);
System.out.println("Contents after removal: " + fruits);
```

Output:
```
Element removed: true
Contents after removal: [Mango, Guava]
```

In this example, the `removeElementAt()` method removes the element at index 1 ("Apple") from the Vector.

**9. public void setElementAt(Object element, int index):**
The `setElementAt(Object element, int index)` method sets the value of the element at the specified index in the Vector. It allows you to modify an element at a particular position. Here's an example:

```java
Vector<String> fruits = new Vector<>(Arrays.asList("Mango", "Apple", "Guava"));
fruits.setElementAt("Banana", 1);

System.out.println("Contents after modification: " + fruits);
```

Output:
```
Contents after modification: [Mango, Banana, Guava]
```

In this example, the `setElementAt()` method is used to change the element at index 1 from "Apple" to "Banana".

**10. public Enumeration elements():**
The `elements()` method returns an Enumeration object that can be used to iterate over the elements in the Vector. Enumeration is an older interface used to iterate over collection elements before the introduction of the enhanced for loop and the Iterator interface. Here's an example:

```java
Vector<String> fruits = new Vector<>(Arrays.asList("Mango", "Apple", "Guava"));
Enumeration<String> enumeration = fruits.elements();

while (enumeration.hasMoreElements()) {
    String fruit = enumeration.nextElement();
    System.out.println(fruit);
}
```

Output:
```
Mango
Apple
Guava
```

In this example, the `elements()` method is used to obtain an Enumeration object, which is then used to iterate over the elements in the Vector.

In summary, the Vector class provides various methods specific to itself. These methods allow you to add elements, retrieve elements at specific positions, remove elements, modify elements, and iterate over the elements using an Enumeration object. Understanding and utilizing these methods can help you manipulate and work with Vector effectively.