**1. What is a TreeMap in Java, and how is it different from other Map implementations?**<br/>
Answer: TreeMap is a class in Java that implements the NavigableMap interface and extends AbstractMap. It is a Red-Black Tree-based implementation of the Map interface, which means it maintains its elements in sorted order based on the keys. Unlike HashMap, which does not guarantee any order of elements, TreeMap guarantees that its elements are sorted based on their natural order (or using a custom Comparator).

```java
// Example of creating a TreeMap
import java.util.*;

public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(3, "Three");
        treeMap.put(1, "One");
        treeMap.put(2, "Two");
        System.out.println(treeMap); // Output: {1=One, 2=Two, 3=Three}
    }
}
```

**2. Explain the internal data structure used by TreeMap to store elements.**<br/>
Answer: TreeMap uses a balanced Red-Black Tree data structure internally to store its elements. Each node in the tree represents a key-value pair (Entry). The keys in the tree are arranged in sorted order, and the tree is balanced using Red-Black Tree properties to ensure efficient operations like insertion, deletion, and retrieval.

**3. How does TreeMap maintain elements in sorted order? What is the underlying algorithm?**<br/>
Answer: TreeMap maintains elements in sorted order using a self-balancing binary search tree called Red-Black Tree. When elements are inserted or removed, the tree is rebalanced to ensure that it remains balanced, and elements are kept in sorted order based on their keys.

**4. What is the time complexity of common operations like insertion, deletion, and retrieval in TreeMap?**<br/>
Answer: The time complexity of common operations in TreeMap is O(log n), where n is the number of elements in the TreeMap. This is because TreeMap uses a Red-Black Tree, which ensures that the tree remains balanced, resulting in efficient operations.

**5. How does TreeMap handle elements with custom objects as keys? What are the requirements for such objects to work correctly with TreeMap?**<br/>
Answer: TreeMap handles custom objects as keys by relying on the natural ordering of the objects. For TreeMap to work correctly with custom objects, those objects must implement the Comparable interface or a custom Comparator must be provided while creating the TreeMap to specify the sorting order.

```java
// Example of TreeMap with custom objects and a custom Comparator
import java.util.*;

class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters, setters, and other methods...

    // Custom Comparator for sorting based on student ID
    static Comparator<Student> idComparator = Comparator.comparingInt(Student::getId);
}

public class TreeMapCustomObjectsExample {
    public static void main(String[] args) {
        TreeMap<Student, Integer> studentMarks = new TreeMap<>(Student.idComparator);
        studentMarks.put(new Student(101, "Alice"), 95);
        studentMarks.put(new Student(102, "Bob"), 80);
        studentMarks.put(new Student(103, "Charlie"), 87);
        System.out.println(studentMarks);
    }
}
```

**6. What happens if we try to use an object as a key that does not implement the Comparable interface?**<br/>
Answer: If we try to use an object as a key in TreeMap that does not implement the Comparable interface, a `ClassCastException` will be thrown at runtime, indicating that the objects are not comparable.

```java
// Example of trying to use non-comparable objects as keys in TreeMap
import java.util.*;

class NonComparableObject {
    // Some fields and methods...
}

public class TreeMapNonComparableExample {
    public static void main(String[] args) {
        TreeMap<NonComparableObject, Integer> map = new TreeMap<>();
        // Attempting to put a non-comparable object as key will throw a ClassCastException
        map.put(new NonComparableObject(), 10); // Throws ClassCastException
    }
}
```

**7. How can we create a TreeMap with a custom sorting order using a Comparator?**<br/>
Answer: We can create a TreeMap with a custom sorting order by providing a custom Comparator during the TreeMap's creation. The Comparator will define the sorting order for the keys in the TreeMap.

```java
// Example of creating a TreeMap with a custom Comparator
import java.util.*;

public class TreeMapCustomComparatorExample {
    public static void main(String[] args) {
        TreeMap<Integer, String> customSortedMap = new TreeMap<>(Collections.reverseOrder());
        customSortedMap.put(3, "Three");
        customSortedMap.put(1, "One");
        customSortedMap.put(2, "Two");
        System.out.println(customSortedMap); // Output: {3=Three, 2=Two, 1=One}
    }
}
```

**8. Explain the role of Red-Black Trees in TreeMap and how they help maintain balanced trees.**<br/>
Answer: Red-Black Trees are a type of self-balancing binary search tree. They play a crucial role in TreeMap by ensuring that the tree remains balanced, even after multiple insertions and deletions. The Red-Black Tree properties ensure that the height of the tree remains logarithmic, which results in efficient operations like insertion, deletion, and retrieval with a time complexity of O(log n).

**9. What is the difference between TreeMap and TreeSet in terms of usage and performance?**<br/>
Answer: TreeMap is a Map implementation that associates keys with values, while TreeSet is a Set implementation that stores unique elements in sorted order. The main difference is that TreeMap stores key-value pairs, whereas TreeSet only stores elements (values). In terms of performance, both TreeMap and TreeSet have similar time complexities for common operations, which are O(log n). However, TreeMap is used when we need to map keys to values, while TreeSet is used when we need to store unique elements in sorted order.

**10. Can TreeMap contain duplicate values but unique keys?**<br/>
Answer: No, TreeMap cannot contain duplicate values. Each key in the TreeMap must be unique. If you try to put a key-value pair with an existing key, the new value will replace the old one, and the TreeMap will only contain the latest value for that key.

**11. How does TreeMap handle null values?**<br/>
Answer: TreeMap can contain multiple null values but cannot have a null key. The TreeMap relies on the natural ordering of keys (or a custom Comparator) to sort elements, so a null key would lead to a NullPointerException.

**12. How to efficiently traverse a TreeMap in both ascending and descending order?**<br/>
Answer: To traverse a TreeMap in ascending order, you can use the `entrySet()` method or the `keySet()` method along with an iterator or a for-each loop. To traverse in descending order, you can use the `descendingMap()` method.

```java
// Example of traversing a TreeMap in ascending and descending order
import java.util.*;

public class TreeMapTraverseExample {
    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(3, "Three");
        treeMap.put(1, "One");
        treeMap.put(2, "Two");

        // Traverse in ascending order using entrySet() and for-each loop
        for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // Traverse in descending order using descendingMap() and iterator
        NavigableMap<Integer, String> descendingMap = treeMap.descendingMap();
        Iterator<Map.Entry<Integer, String>> descendingIterator = descendingMap.entrySet().iterator();
        while (descendingIterator.hasNext()) {
            Map.Entry<Integer, String> entry = descendingIterator.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
```

**13. What is the use of the NavigableMap interface, and how is it related to TreeMap?**<br/>
Answer: The NavigableMap interface is a sub-interface of the SortedMap interface, and it extends the functionality to navigate through the map in various ways. TreeMap implements the NavigableMap interface, providing additional methods for navigation and range queries. Some of the important methods in NavigableMap are `lowerEntry()`, `higherEntry()`, `ceilingEntry()`, and `floorEntry()`, which allow us to retrieve entries based on keys in a specific range.

```java
// Example of using NavigableMap methods with TreeMap
import java.util.*;

public class TreeMapNavigableMapExample {
    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(3, "Three");
        treeMap.put(1, "One");
        treeMap.put(2, "Two");

        // Retrieve the entry with the highest key less than 3
        Map.Entry<Integer, String> lowerEntry = treeMap.lowerEntry(3);
        System.out.println("Lower Entry: " + lowerEntry); // Output: Lower Entry: 2=Two

        // Retrieve the entry with the lowest key greater than 1
        Map.Entry<Integer, String> higherEntry = treeMap.higherEntry(1);
        System.out.println("Higher Entry: " + higherEntry); // Output: Higher Entry: 2=Two

        // Retrieve the entry with the lowest key greater than or equal to 2
        Map.Entry<Integer, String> ceilingEntry = treeMap.ceilingEntry(2);
        System.out.println("Ceiling Entry: " + ceilingEntry); // Output: Ceiling Entry: 2=Two

        // Retrieve the entry with the highest key less than or equal to 2
        Map.Entry<Integer, String> floorEntry = treeMap.floorEntry(2);
        System.out.println("Floor Entry: " + floorEntry); // Output: Floor Entry: 2=Two
    }
}
```

**14. How to efficiently find the smallest and largest keys in a TreeMap?**<br/>
Answer: TreeMap provides `firstKey()` and `lastKey()` methods to efficiently find the smallest and largest keys, respectively.

```java
// Example of finding smallest and largest keys in a TreeMap
import java.util.*;

public class TreeMapSmallestLargestKeysExample {
    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(3, "Three");
        treeMap.put(1, "One");
        treeMap.put(2, "Two");

        int smallestKey = treeMap.firstKey();
        int largestKey = treeMap.lastKey();

        System.out.println("Smallest Key: " + smallestKey); // Output: Smallest Key: 1
        System.out.println("Largest Key: " + largestKey);   // Output: Largest Key: 3
    }
}
```

**15. Can we modify the keys of elements once they are inserted into the TreeMap?**<br/>
Answer: No, we cannot modify the keys of elements once they are inserted into the TreeMap. The keys in a TreeMap are used to maintain the sorted order of elements, so modifying a key would disrupt the order and potentially lead to incorrect behavior.

**16. How does TreeMap handle concurrent access in a multi-threaded environment? Is it thread-safe?**<br/>
Answer: TreeMap is not thread-safe for concurrent access. If multiple threads modify the TreeMap concurrently, it can lead to data corruption and inconsistency. To handle concurrent access, you should use a thread-safe map implementation like `ConcurrentHashMap`.

**17. Explain how TreeMap handles resizing and rehashing when the map grows in size.**<br/>
Answer: TreeMap doesn't use resizing and rehashing like hash-based collections (e.g., HashMap). Instead, TreeMap maintains a balanced binary search tree (Red-Black Tree) to ensure efficient operations. When new elements are added, the tree is adjusted and balanced to maintain its logarithmic height, providing a time complexity of O(log n) for most operations.

**18. When should we use TreeMap over other Map implementations like HashMap or LinkedHashMap?**<br/>
Answer: TreeMap should be used when you require elements to be stored in a sorted order based on their keys. If you need to perform range queries, navigate through elements in a specific order, or retrieve the smallest and largest keys efficiently, TreeMap is a better choice. However, it's important to note that TreeMap has a higher time complexity for most operations (O(log n)) compared to HashMap (O(1)) or LinkedHashMap (O(1)). Therefore, if you prioritize fast retrieval by key and don't require sorting, HashMap or LinkedHashMap might be more suitable.

**19. How to perform range queries (finding elements within a specific key range) in TreeMap?**<br/>
Answer: TreeMap provides methods to perform range queries using its NavigableMap capabilities. The `subMap()`, `headMap()`, and `tailMap()` methods allow you to retrieve a portion of the TreeMap that falls within a specified key range.

```java
// Example of performing range queries in TreeMap
import java.util.*;

public class TreeMapRangeQueryExample {
    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "One");
        treeMap.put(2, "Two");
        treeMap.put(3, "Three");
        treeMap.put(4, "Four");
        treeMap.put(5, "Five");

        // Retrieve entries with keys between 2 (inclusive) and 4 (exclusive)
        SortedMap<Integer, String> rangeMap = treeMap.subMap(2, 4);
        System.out.println("Range Map: " + rangeMap); // Output: Range Map: {2=Two, 3=Three}

        // Retrieve entries with keys less than 4 (exclusive)
        SortedMap<Integer, String> headMap = treeMap.headMap(4);
        System.out.println("Head Map: " + headMap); // Output: Head Map: {1=One, 2=Two, 3=Three}

        // Retrieve entries with keys greater than or equal to 3
        SortedMap<Integer, String> tailMap = treeMap.tailMap(3);
        System.out.println("Tail Map: " + tailMap); // Output: Tail Map: {3=Three, 4=Four, 5=Five}
    }
}
```

**20. Is there any way to perform custom operations while traversing a TreeMap?**<br/>
Answer: Yes, you can perform custom operations while traversing a TreeMap using iterators or Java Streams. For example, you can use `forEach()` to apply custom logic to each entry in the TreeMap.

```java
// Example of performing custom operations while traversing a TreeMap
import java.util.*;

public class TreeMapCustomOperationsExample {
    public static void main(String[] args) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("one", 1);
        treeMap.put("two", 2);
        treeMap.put("three", 3);

        // Using iterator to perform custom operation on values
        Iterator<Integer> valuesIterator = treeMap.values().iterator();
        while (valuesIterator.hasNext()) {
            int value = valuesIterator.next();
            System.out.println("Custom Operation: " + (value * 10)); // Custom Operation: 10, Custom Operation: 20, Custom Operation: 30
        }

        // Using Java Streams to perform custom operation on keys
        treeMap.keySet().stream()
                .map(key -> "Key: " + key)
                .forEach(System.out::println); // Output: Key: one, Key: three, Key: two
    }
}
```
