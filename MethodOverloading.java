```java
// Method Overloading Example
// Same method name with different parameters
// This is Compile-Time Polymorphism

class Student {

    String name;
    int age;
    int date;

    // info() with 1 parameter
    public void info(String name) {
        System.out.println("INFO1");
    }

    // info() with 2 parameters
    public void info(String name, int age) {
        System.out.println("INFO2");
    }

    // info() with 3 parameters
    public void info(String name, int age, int date) {
        System.out.println("INFO3");
    }
}

class Main {
    public static void main(String[] args) {

        // Creating Student object
        Student s = new Student();

        // Calling info() with 2 arguments
        // Java selects info(String name, int age)
        s.info("Karthik", 99);

        // Output: INFO2
    }
}
```
