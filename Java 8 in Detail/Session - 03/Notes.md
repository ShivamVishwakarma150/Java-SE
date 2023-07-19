# **Static Methods in Interfaces**:

1. **Definition**: Static methods in interfaces are methods that are defined with the `static` keyword within the interface body. Unlike regular instance methods in interfaces, static methods belong to the interface itself and do not require an object to be invoked.

2. **Syntax**: The syntax to define a static method in an interface is similar to regular methods, but with the `static` keyword before the access modifier (e.g., `public`, `private`, etc.). The method body is provided within the interface itself.

```java
static public <return_type> <method_name>(<parameter_list>) {
    // Method body
}
```

3. **Example**:

```java
interface Greet {
    static public void message() {
        System.out.println("Good Morning");
    }
}
```

**Explanation**:

- In the given example, we have an interface named `Greet` that contains a static method called `message()`.
- The method `message()` is defined with the `static` keyword, making it a static method of the `Greet` interface.
- The method simply prints "Good Morning" when invoked.

**Purpose and Characteristics of Static Methods in Interfaces**:

1. **Utility Methods**: Static methods in interfaces are commonly used to define utility methods that are related to the functionality of the interface. These methods provide common functionalities that are relevant to all implementations of the interface.

2. **No Instance Binding**: Unlike regular interface methods, static methods in interfaces do not depend on any instance of the class. They are not inherited by implementing classes, and there's no need to override them.

3. **Accessing Static Methods**: Static methods in interfaces can be accessed using the interface name followed by the method name, without creating an instance of the interface.

```java
InterfaceName.staticMethodName();
```

4. **Cannot Be Overridden**: Static methods in interfaces cannot be overridden by implementing classes. However, they can be "hidden" if a class defines a static method with the same signature, but it will not be considered an override.

5. **Utility and Convenience**: Static methods in interfaces are often used to provide convenience methods that are commonly used with the interface. For example, the Java 8 `Collection` interface includes the `stream()` method, which returns a stream of elements in the collection.

In conclusion, static methods in interfaces provide a way to define utility methods that are related to the interface itself, not tied to any specific object. They offer a convenient mechanism for organizing common functionalities within the context of the interface, and their use enhances the flexibility and maintainability of the code.

<br/>
<br/>

## **Important Points**:

**1. Scope of Static Methods**: Since static methods in interfaces do not belong to a particular object, they are not part of the classes implementing the interface. They are only associated with the interface itself.

**2. Calling Static Methods**: To call a static method defined in an interface, the method name should be preceded by the interface name. It is not possible to call the static method using an object reference of the implementation class.

**3. Example Interface**: In the given example, we have an interface named `SampleInterface` with two methods: `method1()` (abstract method) and `method2()` (static method).

```java
package staticmethodexample;

public interface SampleInterface {
    public void method1(); // This is an abstract method

    public static void method2() {
        System.out.println("In SampleInterface.method2");
    }
}
```

**4. Implementing the Interface**: When a class implements the `SampleInterface`, it is required to compulsorily override the abstract method `method1()`.

```java
package staticmethodexample;

public class SampleImpl implements SampleInterface {
    @Override
    public void method1() {
        System.out.println("In SampleImpl.method1");
    }
}
```

**5. Calling Static Method**: In the `UseSample` class (driver class), when we call `method1()` on the `SampleImpl` object, it executes the implementation of `method1()` defined in `SampleImpl`. However, to call the static method `method2()` of the `SampleInterface`, we directly use the interface name `SampleInterface.method2()`. Attempting to call the static method using `obj.method2()` will result in an error.

```java
package staticmethodexample;

public class UseSample {
    public static void main(String[] args) {
        SampleInterface obj = new SampleImpl();
        obj.method1(); // Executes SampleImpl's method1()
        SampleInterface.method2(); // Calls SampleInterface's static method2()

        // Uncommenting the code below will show an error
        // obj.method2();
    }
}
```

**Output**:

```
In SampleImpl.method1
In SampleInterface.method2
```

In conclusion, static methods in interfaces provide a way to define utility methods that are related to the interface itself and are not bound to any particular object. They must be called using the interface name, making them accessible without creating an instance of the interface. Static methods enhance the functionality of interfaces by allowing the definition of utility methods that can be used by all implementations of the interface.

**6. No Overriding of Static Methods**: Interface static methods cannot be overridden in the implementing classes. This ensures that the behavior of the static method remains consistent across all implementations of the interface.

**7. Avoiding Undesired Results**: By disallowing the overriding of static methods, Java prevents the possibility of having different behaviors for the same static method in different implementation classes. This can help in avoiding unexpected and undesired results.

**8. @Override Annotation**: If an attempt is made to annotate the implementing class's static method with `@Override`, the compiler will generate a syntax error. This is because static methods cannot be overridden, and using `@Override` for them is not allowed.

**9. Static Method in Implementing Class**: If a static method with the same name as that of a static method in the interface is defined in the implementing class, it will be considered as a separate static method of the class, and it will not override the static method of the interface.

**Example**:

In the given example, we have an interface `Greet1` with a static method `greet()`. We also have a class `Greetings` that implements `Greet1` and defines its own static method `greet()` with the same name.

```java
public interface Greet1 {
    public static void greet() {
        System.out.println("Good Morning");
    }
}

public class Greetings implements Greet1 {
    public static void greet() {
        System.out.println("Good Evening");
    }
}

public class UseGreetings {
    public static void main(String[] args) {
        Greet1.greet(); // Calls the static method from the interface
        Greetings.greet(); // Calls the static method from the implementing class
    }
}
```

**Output**:

```
Good Morning
Good Evening
```

In conclusion, static methods in interfaces cannot be overridden in the implementing classes. This ensures consistent behavior for the static method across all implementations. Additionally, defining a static method in the implementing class with the same name as the static method in the interface does not override the interface's static method; it merely creates a separate static method in the class.

<br/>
<br/>

**Benefits of Static Method**:

1. **Grouping of Utility Methods**: Static methods in interfaces allow us to group related utility methods together within the interface itself. This can lead to more organized and modular code by keeping related methods in the same logical place.

2. **Additional Level of Security**: Since static methods in interfaces are not part of the implementing classes, they cannot be overridden or modified by the implementing classes. This can provide an additional level of security, ensuring that critical utility methods retain their intended behavior across all implementations.

**Can We Have main() Method in Interface?**:

1. **Java 8 Onwards**: Starting from Java 8, it is legal to have a `main()` method defined in an interface. Prior to Java 8, the `main()` method could only be defined in classes.

2. **Run Code Directly from Interface**: Yes, if there is a `main()` method defined in an interface, we can run the code directly using the interface itself, without needing any implementing classes. This is because Java 8 introduced a feature called "default methods" in interfaces, which allows interfaces to contain method bodies. As a result, the `main()` method can now be directly included in the interface.

**Explanation**:

Static methods in interfaces provide a way to group utility methods together within the interface, promoting better organization and modularization of code. These methods are not tied to any specific implementing class, making them immune to being overridden or modified by implementing classes. This helps in maintaining the integrity of utility methods and ensuring consistent behavior across implementations.

Additionally, Java 8 introduced the ability to have method bodies in interfaces through default methods. This made it possible to define the `main()` method directly in an interface. Prior to Java 8, the `main()` method had to be defined in a class to serve as the entry point for the Java application. However, with Java 8 and later versions, the `main()` method can reside in an interface, allowing us to run the code directly using the interface name.

Here's an example of a `main()` method defined in an interface:

```java
public interface RunnableInterface {
    static void main(String[] args) {
        System.out.println("Running code from the interface.");
    }
}
```

Now, we can run the code directly from the interface without any implementing class:

```java
public class UseRunnableInterface {
    public static void main(String[] args) {
        RunnableInterface.main(args);
    }
}
```

**Output**:

```
Running code from the interface.
```

In conclusion, static methods in interfaces offer benefits such as better organization of utility methods and an additional level of security. Moreover, since Java 8, it is possible to have a `main()` method directly in an interface, allowing us to run code without needing an implementing class.

## Example Code 

In the provided example, we have defined a `Greet` interface with a `main()` method. As mentioned earlier, starting from Java 8, it is legal to have a `main()` method in an interface, and we can directly run the code from the interface itself.

**Code**:
```java
public interface Greet {
    public static void main(String[] args) {
        System.out.println("Good Morning");
    }
}
```

**Compilation**: To compile the `Greet.java` file, you can use the `javac` command in the terminal or command prompt:
```
javac Greet.java
```

**Execution**: To execute the program, you can use the `java` command, followed by the name of the interface (`Greet` in this case):
```
java Greet
```

**Output**:
```
Good Morning
```

As you can see, the code is executed directly from the `Greet` interface, and it prints "Good Morning" to the console. This demonstrates that the `main()` method defined in the interface serves as the entry point for the Java application, just like a `main()` method defined in a class.