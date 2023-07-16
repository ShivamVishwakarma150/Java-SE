# `HashMap` internal Working

**1. Introduction:**
   - HashMap works on the principle of hashing.
   - It allows storing and retrieving objects in constant time O(1) provided we know the key.

**2. Internal Structure:**
   - HashMap maintains an array of buckets, where each bucket is a linked list of key-value pairs encapsulated as Entry objects.
   - This array of buckets is called the table, and each node of the linked list is an instance of a private class called Entry.

**3. Working of put() Method:**
   - The put() method is called to store key-value pairs in the HashMap.
   - The key object is checked for null. If it's null, the value is stored at table[0] position because the hash code for null is always 0.
   - A hash value is calculated using the key's hash code by calling its hashCode() method.
   - The indexFor(hash, table.length) function is called to calculate the exact index position for storing the Entry object.
   - If two unequal objects have the same hash code, HashMap uses linked lists to handle collisions. Entry objects are stored in LinkedList form.
   - If there is already an object at the calculated index, its next attribute is checked. If it's null, the current Entry object becomes the next node in the LinkedList.

**4. Handling Duplicate Keys:**
   - When adding a value object with the same key as entered before, it replaces the old value.
   - To identify an exact match for the key object, the equals() method is called on the key object for each Entry object in the LinkedList.

**5. Handling Hash Codes:**
   - The hash code obtained from the hashCode() method cannot be used directly as an index in the bucket.
   - HashMap uses a hash() function, which brings the hash value within the range of array index size.

**6. Working of get() Method:**
   - The get() method is called to retrieve the value associated with a specific key.
   - The key uniqueness is determined in a similar way as the put() method.
   - The moment HashMap identifies an exact match for the key object passed as an argument, it returns the value object stored in the current Entry object.

**7. Conclusion:**
   - The data structure to store Entry objects is an array named table of type Entry.
   - The key object's hashCode() is used to calculate the index location of the Entry object.
   - The key object's equals() method is used to maintain uniqueness of keys in the map.
   - Value object's hashCode() and equals() methods are not used in HashMap's get() and put() methods.
   - Hash code for null keys is always zero, and such Entry objects are always stored at index zero in the Entry[].
   - If two key objects have the same hash code, they will always go to the same index in the table array.
   - If two key objects do not have the same hash code, they may or may not go to the same index in the table array.

<br/>
<br/>

# Example Code for understanding HashMap Internal Working

1. **Creation of HashMap:**
   ```java
   HashMap<String, Integer> person = new HashMap<>();
   ```
   - We create a new `HashMap` called `person` with keys of type `String` and values of type `Integer`.

2. **Adding Elements to the HashMap:**
   ```java
   person.put("Rahul", 24);
   person.put("Nitin", 22);
   person.put("Rohit", 23);
   person.put("Rahu", 26);
   person.put("Sunil", 25);
   ```
   - Here, we add five key-value pairs to the `person` HashMap.
   - The key-value pairs are:
     - "Rahul" -> 24
     - "Nitin" -> 22
     - "Rohit" -> 23
     - "Rahu" -> 26
     - "Sunil" -> 25

3. **Internal Working (Hashing and Bucketing):**
   - When we call the `put()` method to add elements to the HashMap, the following happens internally:

     **a. Hashing:**
     - For each key (String) added to the HashMap, its `hashCode()` method is called to calculate its hash code. The hash code is an integer that represents the unique value of the key.
     - The hash code is used to find the index (bucket) in the internal array (table) where the key-value pair will be stored.

     **b. Bucketing:**
     - If the hash code of two keys is the same (hash code collision), their key-value pairs will be stored in the same bucket (linked list) in the HashMap.
     - For example, "Rahul" and "Rahu" have the same hash code, so they will be stored in the same bucket.

4. **Internal Structure:**
   - The internal structure of the `person` HashMap will look like this (assuming no rehashing has occurred for simplicity):
   
   ```
   Index 0: [null]
   Index 1: [null]
   Index 2: [null]
   Index 3: [null]
   Index 4: [null]
   Index 5: [Rohit -> 23]
   Index 6: [Rahul -> 24, Rahu -> 26]
   Index 7: [Nitin -> 22, Sunil -> 25]
   Index 8: [null]
   Index 9: [null]
   ```
   - The key-value pairs are stored in the linked lists within their respective buckets.

5. **Retrieving Elements from the HashMap:**
   - We can retrieve values from the HashMap using the `get()` method.

   ```java
   Integer rahulAge = person.get("Rahul"); // rahulAge = 24
   Integer nitinAge = person.get("Nitin"); // nitinAge = 22
   Integer rohitAge = person.get("Rohit"); // rohitAge = 23
   Integer rahuAge = person.get("Rahu");   // rahuAge = 26
   Integer sunilAge = person.get("Sunil"); // sunilAge = 25
   ```
   - When we call `get("Rahul")`, the `hashCode()` method of the key "Rahul" is calculated, and it finds the correct bucket (index 6) in the internal array.
   - Then, it uses the `equals()` method to compare the key "Rahul" with the keys in the linked list within the bucket and finds a match ("Rahul" -> 24).

6. **Conclusion:**
   - The HashMap stores key-value pairs based on their hash codes and handles collisions using linked lists within the same bucket.
   - The retrieval of elements from the HashMap is done in constant time O(1) on average, making it an efficient data structure for lookups.

# Enhancements Done By `Java 8`

In Java 8, there is a performance improvement made for HashMap objects that deals with handling hash collisions. When multiple key-value pairs have the same hash code and need to be stored in the same hash bucket, traditional HashMaps use a linked list to handle such collisions. This approach works well in most cases, but in scenarios where there are high hash collisions and the linked list becomes too long, it can lead to performance degradation, especially when searching for elements.

To address this issue, Java 8 introduced a new enhancement to HashMaps. Once the number of items in a hash bucket grows beyond a certain threshold, that bucket switches from using a linked list of entries to a balanced tree. This enhancement improves the worst-case performance of HashMaps from O(n) to O(log n) in cases of high hash collisions.

Here's a detailed explanation of the enhancements made in Java 8 HashMap:

**1. Hash Collisions:**
   - When different keys have the same hash code, they are assigned to the same bucket in the HashMap, leading to hash collisions.
   - Traditionally, HashMaps handle hash collisions by creating a linked list of Entry objects in the same bucket.
   - The time complexity for searching elements in a linked list is O(n), where n is the number of elements in the list.

**2. Tree-Based Buckets:**
   - Java 8 introduces an enhancement to switch the representation of a hash bucket from a linked list to a balanced tree once the bucket's size exceeds a certain threshold.
   - The threshold value for this enhancement is TREEIFY_THRESHOLD = 8. In other words, if the number of elements in a bucket is 8 or more, it will be converted into a balanced tree.

**3. Balanced Trees:**
   - By converting the bucket into a balanced tree, the worst-case performance of searching elements improves from O(n) to O(log n).
   - A balanced tree allows for faster search operations, reducing the time complexity for locating elements within the bucket.

**4. When is Treeification Performed?**
   - Treeification is performed during certain operations that modify the HashMap, such as put(), putAll(), and resize().
   - When a bucket exceeds the TREEIFY_THRESHOLD, the HashMap automatically converts the linked list to a balanced tree.

**5. Performance Improvement:**
   - The introduction of tree-based buckets improves the performance of HashMaps in scenarios where there are high hash collisions and long linked lists.
   - In such situations, the tree-based implementation ensures faster access to elements, making HashMap operations more efficient.

Overall, the enhancement introduced in Java 8 for HashMaps provides a significant performance improvement in cases of high hash collisions. It dynamically adapts to different scenarios, maintaining the constant-time complexity for most operations while efficiently handling situations with long linked lists by converting them into balanced trees.



<br/>
<br/>
<br/>

# Important FAQ's 

**Q: What is the requirement for an object to be used as a key in HashMap?**<br/>
A: The key object must implement the equals() and hashCode() methods. The hashCode() method is used when we insert the key object into the map, while the equals() method is used when we try to retrieve a value based on the key from the map.

**Q: What is the requirement for an object to be used as a value in HashMap?**<br/>
A: The value object must implement the equals() method.

**Q: What will happen if you try to store a key which is already present in HashMap?**<br/>
A: If we store an existing key in the HashMap, then it will override the old value with the new value, and put() will return the old value. There will not be any exception or error.

**Q: Can you store a null key in Java HashMap?**<br/>
A: Yes, HashMap allows one null key, which is stored at the first location of the bucket array (bucket[0] = value). The HashMap doesn't call hashCode() on the null key because it will throw NullPointerException. When a user calls the get() method with null, the value of the first index is returned.

**Q: How does HashMap handle collisions in Java?**<br/>
A: The java.util.HashMap uses chaining to handle collisions, which means new entries are stored in a linked list along with the existing value, and then that linked list is stored in the bucket location. In the worst case, where all keys have the same hash code, our hash table will be turned into a linked list, and searching a value will take O(n) time as opposed to O(1) time.

**Q: Which data structure does HashMap represent?**<br/>
A: The HashMap is an implementation of the hash table data structure, which is ideal for mapping one value to another, such as an id to a name, as we can search for a value in O(1) time if we have the key.

**Q: Can you explain what is this Hash Table?**<br/>
A: Even though HashMap represents a hash table, it is internally implemented using an array and linked list data structure in JDK. The array data structure is used as a bucket, while the linked list is used to store all mappings that land in the same bucket. From Java 8 onwards, the linked list is dynamically replaced by a binary search tree once the number of elements in the linked list crosses a certain threshold to improve performance.

**Q: Is HashMap thread-safe in Java?**<br/>
A: No, HashMap is not thread-safe in Java. We should not share a HashMap with multiple threads if one or more threads are modifying the HashMap (e.g., inserting or removing an entry). However, we can easily share a read-only HashMap.

**Q: How do you create a read-only HashMap?**<br/>
A: A read-only HashMap means a HashMap where we cannot perform modification operations like put(), remove(), or replace(). We can only read from the Map by using the get() method or by using an Iterator of the Map. In Java, we can use the Collections.unmodifiableMap() method to create a read-only HashMap. Any modification in the read-only Map will result in a java.lang.UnsupportedOperationException.

**Q: What will happen if you use HashMap in a multithreaded Java application?**<br/>

A: If we use a HashMap in a multithreaded environment where multiple threads are structurally modifying the map (e.g., adding, removing, or modifying mappings), it can lead to various issues due to race conditions. The internal data structure of the HashMap may become corrupted, and the map may lose its consistency.

In a multithreaded scenario, if two or more threads attempt to modify the HashMap simultaneously, they may interfere with each other's operations. For example, one thread might be in the middle of adding an entry while another thread tries to remove an entry, causing the linked list or tree structure within the HashMap to break. As a result, some entries may be lost, some links may go missing, and the map may end up with incorrect or inconsistent data.

Therefore, using a regular HashMap in a multithreaded application without proper synchronization is not safe. Instead, it is advised to use thread-safe map implementations designed to handle concurrent access.

**Q: In which order are mappings stored in HashMap?**<br/>

HashMap does not provide any ordering guarantee for keys, values, or entries. The order of mappings in a HashMap is not based on the insertion order, and it can vary depending on factors like the internal hash function and the resizing of the HashMap.

Since the primary goal of a HashMap is fast key-based lookup, the order of elements is not a concern. When retrieving elements from the HashMap using key-value pairs or iteration, the order in which they are returned is not predictable or guaranteed.

If you need to maintain the order of insertion or the order of keys/values, you can use other implementations like `LinkedHashMap` or `TreeMap`.

**Q: How do you sort HashMap in Java?**<br/>

As mentioned earlier, HashMap itself does not provide built-in sorting functionality because it is not an ordered collection. However, you can sort the contents of a HashMap based on keys, values, or entries by transferring them to an ordered map implementation.

1. Sorting based on keys:
   ```java
   Map<String, Integer> hashMap = new HashMap<>();
   // Add elements to the HashMap...

   Map<String, Integer> sortedMap = new TreeMap<>(hashMap);
   // Now 'sortedMap' will contain the entries sorted based on keys.
   ```

2. Sorting based on values:
   ```java
   // Assuming 'hashMap' contains String keys and Integer values
   List<Map.Entry<String, Integer>> list = new ArrayList<>(hashMap.entrySet());
   list.sort(Map.Entry.comparingByValue());

   Map<String, Integer> sortedMap = new LinkedHashMap<>();
   for (Map.Entry<String, Integer> entry : list) {
       sortedMap.put(entry.getKey(), entry.getValue());
   }
   // Now 'sortedMap' will contain the entries sorted based on values.
   ```

3. Sorting based on entries (key-value pairs):
   ```java
   // Assuming 'hashMap' contains String keys and Integer values
   List<Map.Entry<String, Integer>> list = new ArrayList<>(hashMap.entrySet());
   list.sort(Map.Entry.comparingByKey());

   Map<String, Integer> sortedMap = new LinkedHashMap<>();
   for (Map.Entry<String, Integer> entry : list) {
       sortedMap.put(entry.getKey(), entry.getValue());
   }
   // Now 'sortedMap' will contain the entries sorted based on keys.
   ```

By transferring the elements to a `TreeMap` or using custom sorting logic, you can achieve the desired sorting of the HashMap's contents.