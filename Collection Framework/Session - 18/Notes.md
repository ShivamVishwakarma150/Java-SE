# The Comparator Interface

**1. The Comparator Interface:**

   - The `Comparator` interface is used to order objects of a user-defined class according to custom sorting criteria.
   - This interface is part of the `java.util` package and contains two methods: `equals()` and `compare()`.

**2. Syntax of the `compare()` method:**

   - The `compare()` method has the following syntax: `public int compare(Object obj1, Object obj2)`.
   - It compares two objects and determines their order.
   - The method returns a negative integer if the first argument is considered "less than" the second argument, zero if they are considered equal, and a positive integer if the first argument is considered "greater than" the second argument.

**3. Important points regarding Comparator:**

   - When using the `Comparator` interface, the objects being compared do not need to implement the `Comparable` interface.
   - This means that we can sort objects that are not naturally sortable or do not have a default natural ordering.
   - For example, we can sort `StringBuffer` objects using a `Comparator`.
   - Additionally, when using the `Comparator` interface, the objects being compared do not need to be of the same type. We can compare heterogeneous objects as well.

By using the `Comparator` interface, we have the flexibility to define custom sorting logic for our user-defined classes. This allows us to sort objects based on specific criteria that may not be covered by their natural ordering or when comparing objects of different types.

![Alt text](image.png)

**Exercise 1: Sort Integers in Descending Order using TreeSet**
```java
import java.util.*;
public class IntegerDescendingSort {
    public static void main(String[] args) {
        Set<Integer> ss=new TreeSet<>(new MyIntComparator());
        ss.add(10);
        ss.add(5);
        ss.add(20);
        ss.add(7);
        ss.add(2);
        System.out.println(ss);
        
    }
}
class MyIntComparator implements Comparator
{

    @Override
    public int compare(Object o1, Object o2) {
        
        Integer i1=(Integer)o1;
        Integer i2=(Integer)o2;
        return i2-i1;
    }
    
}
```

**Exercise 2: Sort Strings in Descending Order using TreeSet**
```java
import java.util.*;
public class StringDescendingSort {
    public static void main(String[] args) {
        Set<String> ss=new TreeSet<>(new MyStringComparator());
        ss.add("Bhopal");
        ss.add("India");
        ss.add("Indore");
        ss.add("Delhi");
        ss.add("Mumbai");
        System.out.println(ss);
        
    }
}
class MyStringComparator implements Comparator
{

    @Override
    public int compare(Object o1, Object o2) {
        
        String s1=(String)o1;
        String s2=(String)o2;
        return s2.compareTo(s1);
    }
    
}
```

**Exercise 3: Sort String and StringBuffer objects based on length and alphabetical order**
```java
import java.util.*;
public class StringAndStringBufferSort {
    public static void main(String[] args) {
        TreeSet ss=new TreeSet(new MyStringComparator());
        ss.add("Bhopal");
        ss.add(new StringBuffer("India"));
        ss.add("Indore");
        ss.add(new StringBuffer("Delhi"));
        ss.add("Mumbai");
        System.out.println(ss);
        
    }
}
class MyStringComparator implements Comparator
{

    @Override
    public int compare(Object o1, Object o2) {
        
        String s1=o1.toString();
        String s2=o2.toString();
        int x= s1.length()-s2.length();
        if(x!=0)
            return x;
        return s1.compareTo(s2);
    }
    
}
```

**Exercise 4: Sort Person objects in alphabetical order of name**
```java
import java.util.Comparator;
import java.util.TreeSet;

class Person {
    private String name;
    
    public Person(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public String toString() {
        return name;
    }
}

public class PersonNameSort {
    public static void main(String[] args) {
        TreeSet<Person> treeSet = new TreeSet<>(Comparator.comparing(Person::getName));
        
        treeSet.add(new Person("John"));
        treeSet.add(new Person("Alice"));
        treeSet.add(new Person("Bob"));
        treeSet.add(new Person("Carol"));
        
        for (Person person : treeSet) {
            System.out.println(person);
        }
    }
}
```

<br/>
<br/>

# Comparable V/s Comparator

|                  | Comparable                                            | Comparator                                            |
|------------------|-------------------------------------------------------|-------------------------------------------------------|
| Purpose          | Defines the default natural sorting order of a class   | Defines a custom sorting order for a class             |
| Interface        | Implemented by the class itself                        | Implemented separately as a separate class or inline   |
| Method           | compareTo()                                           | compare()                                              |
| Sorting Order    | Single sorting sequence                                | Multiple sorting sequences                             |
| Usage            | For predefined classes or custom classes' default order| When a different sorting order is desired              |
| Modification     | Requires modifying the class itself                     | No modification to the class is required               |
| Flexibility      | Limited flexibility, default order cannot be changed   | Greater flexibility, can define multiple sorting orders|
| Control          | Less control over sorting behavior                     | More control over sorting behavior                     |
| Class Dependency | Relies on the class implementing the Comparable        | Independent of the class being sorted                  |

The Comparable interface is used to define the default natural sorting order for a class, and it is implemented by the class itself. It provides a single sorting sequence and requires modifying the class itself to change the sorting order. It is typically used for predefined classes or when defining the default sorting order for custom classes.

On the other hand, the Comparator interface is used to define a custom sorting order for a class. It is implemented separately as a separate class or inline, providing more flexibility in defining multiple sorting sequences. It does not require modifying the class being sorted and offers greater control over the sorting behavior.

The choice between Comparable and Comparator depends on the specific requirements and whether the default sorting order needs to be modified or a custom sorting order needs to be defined.