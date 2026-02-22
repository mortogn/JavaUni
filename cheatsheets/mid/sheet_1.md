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
