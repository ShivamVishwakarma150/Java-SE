## Before Java 8, interfaces were limited in their functionality and had specific rules for their members:

1. Every method inside an interface is always public and abstract:
   - When you define a method inside an interface, it is automatically assumed to be public and abstract, even if you don't explicitly use the `public` and `abstract` keywords.
   - Public: All interface methods are accessible from any class that implements the interface.
   - Abstract: Interface methods are declared without an implementation, meaning they don't have a method body. They only provide the method signature that implementing classes must define.

Example:
```java
public interface MyInterface {
    void doSomething(); // This is a public abstract method
}
```

2. Every variable inside an interface is public, static, and final:
   - Similarly, when you define a variable inside an interface, it is automatically assumed to be public, static, and final, even if you don't explicitly use these keywords.
   - Public: All interface variables are accessible from any class that implements the interface.
   - Static: Interface variables belong to the interface itself, not to instances of classes that implement the interface. Therefore, they are shared among all classes that implement the interface.
   - Final: Interface variables cannot be modified after they are initialized. They are considered constants.

Example:
```java
public interface MyInterface {
    int MY_CONSTANT = 100; // This is a public static final variable
}
```

These rules ensured that interfaces acted as pure contracts, defining a set of methods that any implementing class must provide. Before Java 8, interfaces were used primarily for defining APIs and achieving multiple inheritance-like behavior through implementing multiple interfaces. However, they were limited in their ability to provide default implementations for methods, leading to code duplication if multiple classes implemented similar functionality.

With the introduction of Java 8, interfaces were enhanced with new features, such as default methods and static methods, which allowed for more powerful and flexible interfaces without breaking the existing rules and contract nature of interfaces.

<br/>
<br/>

Java 8 introduced significant enhancements to interfaces, making them more flexible and powerful. The main improvements are:

**1. Default Methods:**
   - Before Java 8, if you wanted to add a new method to an existing interface, all classes implementing that interface would be forced to provide an implementation for the new method, which could break backward compatibility.
   - Java 8 introduced default methods, which are methods with a default implementation in the interface itself. Classes that implement the interface are not required to provide an implementation for default methods. If a class does not override the default method, the default implementation from the interface will be used.
   - This feature allows developers to add new methods to existing interfaces without breaking the code of classes that already implement them.

Example:
```java
public interface MyInterface {
    // Abstract method, to be implemented by implementing classes
    void doSomething();

    // Default method with a default implementation
    default void doSomethingElse() {
        System.out.println("Doing something else in the interface.");
    }
}
```

**2. Static Methods:**
   - Java 8 also introduced static methods in interfaces. These methods are declared as `static` and have an implementation in the interface itself.
   - Similar to default methods, implementing classes are not required to provide an implementation for static methods, and they can be called directly using the interface name.
   - Static methods in interfaces are often used as utility methods or helper methods that are relevant to the interface's functionality.

Example:
```java
public interface MyInterface {
    // Abstract method, to be implemented by implementing classes
    void doSomething();

    // Default method with a default implementation
    default void doSomethingElse() {
        System.out.println("Doing something else in the interface.");
    }

    // Static method with an implementation
    static void staticMethod() {
        System.out.println("This is a static method in the interface.");
    }
}
```

By adding default methods and static methods to interfaces, Java 8 made interfaces more extensible and reduced the need for abstract base classes in certain cases. These enhancements allowed for better code reuse and improved the expressiveness of interfaces in the Java language.

<br/>
<br/>

# Default Method

A Default Method in Java is a method with a concrete code body that is provided within the interface itself. It allows interfaces to have methods with default implementations, which are automatically available to all classes that implement the interface. The main points about default methods are:

**1. Syntax:**
   - A default method is declared using the `default` keyword before the method signature.
   - The method must have a concrete code block enclosed within curly braces `{}`.

Example:
```java
public interface Greet {
    // Default method with a default implementation
    default void message() {
        System.out.println("Good Morning");
    }
}
```

**2. Virtual Extension Methods:**
   - Default methods are also known as virtual extension methods or defender methods.
   - They provide a way to add new methods to existing interfaces without breaking the classes that already implement them.
   - When a new method is added as a default method to an interface, all classes that implement that interface will automatically inherit the new method with the default implementation. Implementing classes can then choose to use the default implementation or override the method with their own implementation.

Example:
```java
// Interface with a default method
public interface Greet {
    default void message() {
        System.out.println("Good Morning");
    }
}

// Implementing class using the default method
public class GreetingImpl implements Greet {
    // No need to implement the message() method here
}

// Another implementing class overriding the default method
public class CustomGreetingImpl implements Greet {
    @Override
    public void message() {
        System.out.println("Hello there!");
    }
}
```

**3. Accessibility of Default Methods:**
   - Default methods are always `public`, even if the `public` keyword is not explicitly used in the method declaration.
   - They are accessible to all classes that implement the interface, either by using the default implementation directly or by overriding the method with a custom implementation.

Default methods in Java 8 provide a powerful way to enhance existing interfaces without breaking backward compatibility. They promote better code reuse and extensibility in Java programming.

<br/>
<br/>

# Example to understand default method

1. Interface `SampleInterface`:
```java
package defaultmethodexample;

public interface SampleInterface {
    public void method1(); // This is an abstract method.

    default public void method2() { // This is a default method.
        System.out.println("SampleInterface.method2");
    }
}
```

Explanation:
- The `SampleInterface` declares an abstract method `method1()` without an implementation. Any class that implements this interface must provide its own implementation for `method1()`.
- It also defines a default method `method2()` with a concrete implementation using `System.out.println("SampleInterface.method2");`.

2. Class `SampleImpl`:
```java
package defaultmethodexample;

public class SampleImpl implements SampleInterface {
    @Override
    public void method1() {
        System.out.println("In SampleImpl.method1");
    }

    @Override
    public void method2() {
        System.out.println("In SampleImpl.method2");
    }
}
```

Explanation:
- The `SampleImpl` class implements the `SampleInterface` and provides its own implementation for both `method1()` and `method2()` by using the `@Override` annotation.
- The overridden `method1()` prints "In SampleImpl.method1".
- The overridden `method2()` prints "In SampleImpl.method2".

3. Class `UseSample`:
```java
package defaultmethodexample;

public class UseSample {
    public static void main(String[] args) {
        SampleInterface obj = new SampleImpl();
        obj.method1();
        obj.method2();
    }
}
```

Explanation:
- The `UseSample` class serves as the driver class.
- In the `main` method, we create an object of the `SampleImpl` class and store it in a reference of the `SampleInterface`.
- When we call `obj.method1()`, it executes the overridden implementation in `SampleImpl`, which prints "In SampleImpl.method1".
- When we call `obj.method2()`, it also executes the overridden implementation in `SampleImpl`, which prints "In SampleImpl.method2".

4. Output:
```
In SampleImpl.method1
In SampleImpl.method2
```

Explanation:
- When we run the `UseSample` class, it produces the above output as explained in the previous steps.
- The class `SampleImpl` has the flexibility to override the default method `method2()` provided by the `SampleInterface` and provide its own implementation, which is demonstrated in the output.

<br/>
<br/>

# Extending Interfaces That Contain Default Method

- When we extend an interface that contains a default
method, there are 3 possibilities:

  - Not mention the default method at all, which lets our  extended interface inherit the default method.
  - Re declare the default method, which makes it abstract.
  - Redefine the default method, which overrides it. Make  sure to prefix it with default keyword , otherwise it will become abstract.


## **Let's go through each case one by one and explain the concepts along with the code examples:**

**1. Example (Case 1) - Inheriting the Default Method:**
- In this case, we have an interface `SampleInterface1` with a default method `method1()`.
- We then create another interface `SampleInterface2` that extends `SampleInterface1` without mentioning the default method `method1()`.
- Finally, we implement `SampleInterface2` in the class `SampleImpl`.

```java
package defaultmethodexample;

public interface SampleInterface1 {
    default public void method1() {
        System.out.println("In SampleInterface1.method1");
    }
}

public interface SampleInterface2 extends SampleInterface1 {
}

public class SampleImpl implements SampleInterface2 {
}

public class UseSample {
    public static void main(String[] args) {
        SampleInterface2 obj = new SampleImpl();
        obj.method1();
    }
}
```

Output:
```
In SampleInterface1.method1
```

Explanation:
- In this example, the class `SampleImpl` implements `SampleInterface2`.
- `SampleInterface2` extends `SampleInterface1`, so it inherits the default method `method1()`.
- When we call `obj.method1()`, the implementation of `method1()` defined in `SampleInterface1` will be executed.

**2. Example (Case 2) - Re-declaring the Default Method:**
- In this case, we have an interface `SampleInterface1` with a default method `method1()`.
- We then create another interface `SampleInterface2` that extends `SampleInterface1` and re-declares the default method `method1()` (making it abstract).
- The class `SampleImpl` implements `SampleInterface2` but doesn't provide an implementation for `method1()`.
- The compiler will give an error since `method1()` is now an abstract method in `SampleInterface2`.

```java
package defaultmethodexample;

public interface SampleInterface1 {
    default public void method1() {
        System.out.println("In SampleInterface1.method1");
    }
}

public interface SampleInterface2 extends SampleInterface1 {
    public void method1(); // This method now becomes abstract
}

public class SampleImpl implements SampleInterface2 {
}
```

Error: `SampleImpl is not abstract and does not override abstract method method1() in SampleInterface2`

Explanation:
- In this example, when `SampleInterface2` re-declares the default method `method1()`, it becomes abstract.
- The class `SampleImpl` is not abstract, but it doesn't provide an implementation for the abstract method `method1()` from `SampleInterface2`, leading to a compilation error.

**3. Example (Case 3) - Redefining the Default Method:**
- In this case, we have an interface `SampleInterface1` with a default method `method1()`.
- We then create another interface `SampleInterface2` that extends `SampleInterface1` and overrides the default method `method1()`.
- The class `SampleImpl` implements `SampleInterface2`.

```java
package defaultmethodexample;

public interface SampleInterface1 {
    default public void method1() {
        System.out.println("In SampleInterface1.method1");
    }
}

public interface SampleInterface2 extends SampleInterface1 {
    default public void method1() {
        System.out.println("In SampleInterface2.method1");
    }
}

public class SampleImpl implements SampleInterface2 {
}

public class UseSample {
    public static void main(String[] args) {
        SampleInterface2 obj = new SampleImpl();
        obj.method1();
    }
}
```

Output:
```
In SampleInterface2.method1
```

Explanation:
- In this example, `SampleInterface2` redefines the default method `method1()` and provides its own implementation.
- When we call `obj.method1()`, the implementation of `method1()` defined in `SampleInterface2` will be executed, overriding the implementation in `SampleInterface1`.


<br/>
<br/>

# **Default Methods And Multiple Inheritance**
- In Java, a class can implement N number of interfaces.
- Now, suppose two interfaces which are implemented by a single class contain the same default method .
  - Then can you tell what will happen ?
  - In this case, the code simply won't compile, as there's a
  conflict caused by multiple interface inheritance (a.k.a
  the Diamond Problem)


**1. Example - Default Method Conflict (Diamond Problem):**
```java
public interface Greet1 {
    default public void greet(){
        System.out.println("Good Morning");
    }
}

public interface Greet2 {
    default public void greet(){
        System.out.println("Good Afternoon");
    }
}

public class Greetings implements Greet1, Greet2 {
}

public class UseGreetings {
    public static void main(String[] args) {
        Greetings obj = new Greetings();
        obj.greet();
    }
}
```
Output:
```
Error: class Greetings inherits unrelated defaults for greet() from types Greet1 and Greet2
```

Explanation:
- In this example, we have two interfaces `Greet1` and `Greet2`, both containing a default method `greet()`.
- The class `Greetings` implements both `Greet1` and `Greet2`.
- Since both interfaces have the same default method name, there is a conflict, and the code will not compile.

**2. Solution - Overriding Default Method in Implementing Class:**
```java
public interface Greet1 {
    default public void greet(){
        System.out.println("Good Morning");
    }
}

public interface Greet2 {
    default public void greet(){
        System.out.println("Good Afternoon");
    }
}

public class Greetings implements Greet1, Greet2 {
    @Override
    public void greet(){
        System.out.println("Good Evening");
    }
}

public class UseGreetings {
    public static void main(String[] args) {
        Greetings obj = new Greetings();
        obj.greet();
    }
}
```
Output:
```
Good Evening
```

Explanation:
- In this example, the class `Greetings` implements both `Greet1` and `Greet2`.
- To resolve the conflict caused by the two default methods, the implementing class `Greetings` must override the `greet()` method.
- The `@Override` annotation indicates that we are overriding the default method from the interfaces.
- Now, when we call `obj.greet()`, the overridden implementation of `greet()` in `Greetings` will be executed, and it will print "Good Evening."

**3. Calling Interface's Method:**
```java
public class Greetings implements Greet1, Greet2 {
    @Override
    public void greet(){
        Greet1.super.greet(); // Calling Greet1's version of greet()
        Greet2.super.greet(); // Calling Greet2's version of greet()
    }
}

public class UseGreetings {
    public static void main(String[] args) {
        Greetings obj = new Greetings();
        obj.greet();
    }
}
```
Output:
```
Good Morning
Good Afternoon
```

Explanation:
- In this example, the class `Greetings` implements both `Greet1` and `Greet2`.
- Instead of completely overriding the `greet()` method, we use the syntax `Greet1.super.greet()` and `Greet2.super.greet()` to call each interface's version of the method.
- When we call `obj.greet()`, the `greet()` method in `Greetings` will call both `Greet1`'s and `Greet2`'s versions of the method, and it will print "Good Morning" and "Good Afternoon."

By overriding the default method or using the syntax `interfaceName.super.methodName()`, we can resolve the conflict caused by multiple interface inheritance and choose which version of the default method to call in the implementing class.

<br/>
<br/>

# Overriding Object Class Methods

Explanation:
In Java, all classes implicitly inherit from the `java.lang.Object` class, which is the root class of the class hierarchy. The `Object` class contains several important methods, such as `toString()`, `equals()`, `hashCode()`, etc. These methods provide fundamental behaviors for all Java objects.

When defining a default method in an interface, you can run into a problem if you try to override a method from the `Object` class, such as `toString()`. The reason is straightforward:

1. Base Class for All Classes: `Object` is the base class for all Java classes. Every class in Java either directly or indirectly extends the `Object` class. This means that every object in Java inherits the methods defined in `Object`.

2. Priority of Class Methods: When an object is created, the methods defined in the class take priority over default methods defined in interfaces. In other words, if a class has a method with the same signature as a default method in an interface, the class method will be used, not the default method from the interface.

Given these points, it becomes clear why we cannot override `Object` class methods with default methods in interfaces. If you define a default method in an interface with the same signature as a method from `Object`, the class method will always be used because of the priority of class methods over default methods.

Let's see the example code and the error message it produces:

```java
public interface Greet1 {
    default public String toString() {
        return "Good Morning";
    }
}
```

When we try to compile this interface, we get the following error:
```
Error: default method toString in interface Greet1 overrides a member of java.lang.Object
```

This error message is telling us that the `toString()` method in `Greet1` is trying to override a member (i.e., a method) of the `java.lang.Object` class, which is not allowed due to the reasons mentioned above.

In summary, we cannot have default methods in interfaces that override methods from the `java.lang.Object` class to avoid any confusion about which method should be used when dealing with objects in Java.

<br/>
<br/>

# Benefits Of Default Method

**1. Backward Compatibility:** One of the main benefits of default methods is that they help keep the code backward compatible. Before Java 8, if new methods were added to an interface, all the classes implementing that interface would have to be modified to provide an implementation for those new methods. This could lead to a lot of code changes and potential compatibility issues when upgrading to a new version of the interface.

With default methods, new methods can be added to an existing interface without breaking the existing implementation classes. The default implementation provided in the interface will be used by all the existing classes that don't override the new method. This allows for smooth upgrades and maintains backward compatibility.

**2. Enhancing Existing Interfaces:** Default methods enable the enhancement of existing interfaces with new functionalities without affecting the classes implementing those interfaces. It allows us to introduce new methods that have a default implementation, ensuring that the existing code continues to work seamlessly without any modifications.

**3. Supporting Libraries and API Evolution:** Default methods are especially useful when working with libraries and APIs. If a library adds new methods to an interface in a later version, existing code that uses the older version of the library won't be affected because the new methods will have default implementations in the updated interface. This ensures that developers can safely upgrade to the latest version of the library without worrying about breaking their existing code.

**4. Stream Support:** Default methods played a significant role in the introduction of streams in Java 8. The `Stream` API provides powerful functional-style operations for working with collections. To add these operations to the existing `Collection` interfaces, default methods were used to include methods like `forEach()`, `stream()`, `parallelStream()`, etc. This allowed seamless integration of streams with the existing collection classes without requiring changes to their implementations.

In summary, default methods in Java interfaces offer a way to evolve existing APIs without breaking compatibility with existing code. They enable the addition of new methods to interfaces with default implementations, which can be overridden by implementing classes when needed. This flexibility enhances code reusability and library evolution, making it easier to work with Java's evolving ecosystem.