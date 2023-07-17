# How does resizing happens in HashMap?

Resizing in HashMap:

1. The resizing of a HashMap occurs when it becomes full or when the number of elements in the map exceeds a certain threshold, which is determined by the load factor.

2. The load factor is a measure of how full the HashMap is allowed to get before resizing is triggered. For example, if the load factor is set to 0.75, resizing will occur when the map is 75% full.

3. When the threshold is reached, the HashMap initiates the resizing process to prevent excessive collisions and maintain a good balance between the number of buckets and the number of elements.

4. Resizing involves increasing the size of the internal array, also known as the bucket array, to accommodate more elements efficiently. The new size is typically the next power of two that is greater than the current size.

5. The HashMap then creates a new array of the increased size and rehashes all the existing elements to distribute them evenly across the new bucket array.

6. The rehashing process recalculates the hash codes of all keys using the new array size to determine their new bucket locations. This step is essential to ensure that elements are distributed correctly in the resized HashMap.

7. After rehashing, the old array becomes eligible for garbage collection, and the new array becomes the active bucket array.

8. Resizing ensures that the HashMap maintains its key performance characteristics, such as O(1) time complexity for most operations like get() and put(), even as the number of elements grows.

9. However, resizing comes with a cost as it involves copying all the elements to a new array, which can be an expensive operation, especially for large HashMaps. To mitigate this, it is essential to choose an appropriate initial capacity and load factor for the HashMap based on the expected number of elements and the rate of growth.

In summary, resizing in HashMap is a dynamic process that ensures efficient storage and retrieval of elements as the size of the map changes over time. It allows HashMap to maintain its constant-time performance characteristics while accommodating a variable number of elements. Choosing the right initial capacity and load factor is crucial to strike a balance between space utilization and the frequency of resizing operations.

<br/>
<br/>

# **`TreeMap` in Java:**

**1. Introduction:**
- TreeMap is a class in Java that implements the NavigableMap interface and extends the AbstractMap class.
- It uses a balanced binary tree (usually a Red-Black Tree) data structure internally to store its elements, providing efficient searching, insertion, and deletion operations.

**2. Ordering and Sorting:**
- TreeMap stores its elements as key-value pairs, where each key is unique, and the elements are sorted based on the natural ordering of the keys.
- All keys inserted into the TreeMap must implement the Comparable interface or be provided with a custom Comparator to determine their ordering.

**3. Key Characteristics:**
- TreeMap maps keys to values and maintains the keys in ascending order.
- It allows multiple null values but does not permit null keys as it requires a total ordering of keys for the binary tree structure.

**4. Constructors:**
- TreeMap provides several constructors for creating and initializing instances:
  - `TreeMap()`: Constructs a new, empty tree map, using the natural ordering of its keys. All keys inserted into the map must implement the Comparable interface.
  - `TreeMap(Comparator)`: Constructs a new, empty tree map, ordered according to the given Comparator.
  - `TreeMap(Map)`: Constructs a new tree map containing the same mappings as the given map, ordered according to the natural ordering of its keys. All keys inserted into the new map must implement the Comparable interface.
  - `TreeMap(SortedMap)`: Constructs a TreeMap with the same mappings and ordering as the specified SortedMap.

**5. Time Complexity:**
- TreeMap operations, such as put(), get(), and remove(), have a guaranteed log(n) time complexity due to the balanced binary tree structure.
- The TreeMap ensures that the tree remains balanced through its internal balancing mechanisms.

**6. Advantages and Use Cases:**
- TreeMap is suitable for scenarios that require sorted data based on keys.
- It is efficient for frequent search, insertion, and removal of elements.

**7. Notes on Performance:**
- The time complexity of TreeMap operations may degrade to O(n) in case of a poorly balanced tree, but TreeMap maintains a balanced structure to ensure efficiency.

**8. Caution in Multithreaded Environments:**
- Like HashMap, TreeMap is not thread-safe in multithreaded environments.
- For concurrent applications, ConcurrentHashMap or Hashtable should be used instead.

In summary, TreeMap is a versatile data structure that offers ordered storage of key-value pairs. Its balanced binary tree structure guarantees efficient access and modification operations. However, caution should be exercised in multithreaded scenarios, and concurrent-safe alternatives should be considered. TreeMap is a valuable tool when sorted mappings are required and frequent operations with log(n) time complexity are desired.

<br/>
<br/>


**1. Basic Operations:**

- `put(K key, V value)`: Associates the specified value with the specified key in this map.

Example:
```java
TreeMap<String, Integer> treeMap = new TreeMap<>();
treeMap.put("John", 25);
treeMap.put("Alice", 30);
treeMap.put("Bob", 28);

// Resulting TreeMap: {Alice=30, Bob=28, John=25}
```

- `get(Object key)`: Returns the value to which the specified key is mapped, or null if the map contains no mapping for the key.

Example:
```java
int age = treeMap.get("Alice"); // age = 30
int nonExistentAge = treeMap.get("Eve"); // nonExistentAge = null
```

- `remove(Object key)`: Removes the mapping for the specified key from this map if present.

Example:
```java
treeMap.remove("Bob");

// Resulting TreeMap: {Alice=30, John=25}
```

**2. Size and Clear Operations:**

- `int size()`: Returns the number of key-value mappings in the map.

Example:
```java
int size = treeMap.size(); // size = 2
```

- `boolean isEmpty()`: Returns true if the map contains no key-value mappings.

Example:
```java
boolean empty = treeMap.isEmpty(); // empty = false
```

- `void clear()`: Removes all of the mappings from this map.

Example:
```java
treeMap.clear();
// Resulting TreeMap: {}
```

**3. Views and Iterators:**

- `Set<K> keySet()`: Returns a Set view of the keys contained in the map.

Example:
```java
Set<String> keys = treeMap.keySet(); // keys = [Alice, John]
```

- `Collection<V> values()`: Returns a Collection view of the values contained in the map.

Example:
```java
Collection<Integer> values = treeMap.values(); // values = [30, 25]
```

- `Set<Map.Entry<K, V>> entrySet()`: Returns a Set view of the mappings contained in the map.

Example:
```java
Set<Map.Entry<String, Integer>> entries = treeMap.entrySet();
// entries = [{Alice=30}, {John=25}]
```

- `Iterator<K> descendingKeyIterator()`: Returns an iterator over the keys in descending order.

Example:
```java
Iterator<String> descendingIterator = treeMap.descendingKeyIterator();
while (descendingIterator.hasNext()) {
    String key = descendingIterator.next();
    // Process keys in descending order
}
```

- `Iterator<Map.Entry<K, V>> descendingEntryIterator()`: Returns an iterator over the entries in descending key order.

Example:
```java
Iterator<Map.Entry<String, Integer>> descendingEntryIterator = treeMap.descendingEntryIterator();
while (descendingEntryIterator.hasNext()) {
    Map.Entry<String, Integer> entry = descendingEntryIterator.next();
    // Process entries in descending key order
}
```
**4. Navigation Operations:**

- `K firstKey()`: Returns the first (lowest) key currently in the map.

Example:
```java
String firstKey = treeMap.firstKey(); // firstKey = "Alice"
```

- `K lastKey()`: Returns the last (highest) key currently in the map.

Example:
```java
String lastKey = treeMap.lastKey(); // lastKey = "John"
```

- `K ceilingKey(K key)`: Returns the least key greater than or equal to the given key, or null if there is no such key.

Example:
```java
String key = treeMap.ceilingKey("Eve"); // key = "John"
```

- `K floorKey(K key)`: Returns the greatest key less than or equal to the given key, or null if there is no such key.

Example:
```java
String key = treeMap.floorKey("David"); // key = "Alice"
```

- `K higherKey(K key)`: Returns the least key strictly greater than the given key, or null if there is no such key.

Example:
```java
String key = treeMap.higherKey("Bob"); // key = "John"
```

- `K lowerKey(K key)`: Returns the greatest key strictly less than the given key, or null if there is no such key.

Example:
```java
String key = treeMap.lowerKey("Bob"); // key = "Alice"
```

**5. Submaps:**

- `NavigableMap<K,V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive)`: Returns a view of the portion of the map whose keys range from `fromKey` to `toKey`.

Example:
```java
NavigableMap<String, Integer> subMap = treeMap.subMap("Alice", true, "John", true);
// subMap = {Alice=30, John=25}
```

- `NavigableMap<K,V> headMap(K toKey, boolean inclusive)`: Returns a view of the portion of the map whose keys are strictly less than `toKey`.

Example:
```java
NavigableMap<String, Integer> headMap = treeMap.headMap("John", true);
// headMap = {Alice=30}
```

- `NavigableMap<K,V> tailMap(K fromKey, boolean inclusive)`: Returns a view of the portion of the map whose keys are greater than or equal to `fromKey`.

Example:
```java
NavigableMap<String, Integer> tailMap = treeMap.tailMap("Bob", true);
// tailMap = {John=25}
```

- `SortedMap<K,V> subMap(K fromKey, K toKey)`: Returns a view of the portion of the map whose keys range from `fromKey` (inclusive) to `toKey` (exclusive).

Example:
```java
SortedMap<String, Integer> subMap = treeMap.subMap("Alice", "John");
// subMap = {Alice=30}
```
