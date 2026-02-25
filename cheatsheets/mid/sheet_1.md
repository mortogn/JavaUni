# Java cheatsheet mid

### 1. Basic Syntax

#### 1.1 Hello World

```java
public class Hello {
    public static void main(String args[]) {
        System.out.println("Hello World!");
    }
}
```

**Note:** `filename` and `class name` must match for a java program.

#### 1.2 Taking Input

In java inputs can be stored in a variable with the help of `Scanner` class.

```java
import java.util.Scanner; //importing the Scanner class

public class Hello {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        System.out.println("Hello World!");
    }
}
```

For different type of data types, we must use different methods within the `Scanner` class.

Some of the methods for different data types,

- `nextBoolean()` - Reads a boolean value from the user
- `nextByte()` - Reads a byte value from the user
- `nextDouble()` - Reads a double value from the user
- `nextFloat()` - Reads a float value from the user
- `nextInt()` - Reads a int value from the user
- `nextLine()` - Reads a String value from the user
- `nextLong()` - Reads a long value from the user
- `nextShort()` - Reads a short value from the user

#### 1.3 Declaring a new method

```java
public class MethodClass {
    int add(int a, int b) {
        return a + b;
    }

    public static void main(String args[]) {
        MethodClass mc = new MethodClass(); // <- Creating a new object
        mc.add(5, 10); // <- Call the method through the object
    }
}
```

#### 1.4 Static Keyword Use cases

To avoid the previous problem of creating an object before using any type of method or variable from a class, we can use static keyword.

```java
import java.util.Scanner;

public class Palindrome {

    static boolean isPalindrome(int n) {
        [...]
    }

    public static void main(String args[]) {
        [...]

        // Here we are directly calling `isPalindrome` method.
        if (isPalindrome(num)) {
            System.out.println(num + " is a palindrome number.");
        } else {
            System.out.println(num + " is not a palindrome number.");
        }
    }
}

```

#### 1.5 Constructor

Constructor is a special kind of method that runs when a class is initiated. It is primarily used to create an object with initial values.

- Constructor must have the same name as the class.
- Constructor does not have a return type (not even void).

```java
public class Bank {
    // constructor
    Bank() {
        [...]
    }
}
```

#### 1.6 Method overloading

Method overloadding is when we have multiple method that share the same name but is different based on the parameters it accepts. The difference can either be data type of parameters, or the number of parameters.

```java

public class Overload {
    static int add(int a, int b) {
        return a + b;
    }

    static double add(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {
        // calls the first method because of int data type
        int resultInt = add(1, 2);
        // calls the second method because of double data type
        double resultDouble = add(1.2, 2.2);
    }
}

```

#### 1.7 `this` keyword

`this` keyword is used to access properties and/or method of a class. This is used to primarily avoid naming conflict. `this` access value of object instead of it being global to all objects of a class.

```java
public class Bank {
    String name;

    Bank(String name) {
        this.name = name; // will set the value of instance variable `name`
    }
}
```

`this` can also be used to call a constructor of a class.

```java

public class CallConstructor {

    int count;

    CallConstructor() {
        System.out.println("Call Constructor");
    }

    CallConstructor(int count) {
        this(); // Calling the first constructor to print 'Call Constructor'
        this.count = 10;
    }

    public static void main(String[] args) {
        // Second construstor is being called because of constructor overloading
        CallConstructor cc = new CallConstructor(10);
    }
}

```

#### 1.8 Inheritance in java

Inheritance is the way we can extend a class to have other properties and methods of a different class.

```java
// Person.java
public class Person {
    String name;
    int age;

    void showAge() {
        [...]
    }
}

// Student.java
public class Student extends Person {
    int id;
    int semester;

    void printInfo() {
        System.out.println(id);
        System.out.println(name); // accessed from `Person` class
        showAge(); // accessed from `Person` class
        System.out.println(semester);
    }
}
```
