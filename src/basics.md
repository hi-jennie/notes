1. **Compatibility and Conversion between Raw and Typed ArrayList**

```java
public class ArrayListCompatibility {
    public static void main(String[] args) {
        // From raw ArrayList to typed ArrayList
        // If you have a raw ArrayList and you know the type of elements it contains, 
        // you can convert it to a typed ArrayList. 
        // However, this conversion requires type checking and may lead to ClassCastException:
        ArrayList rawList = new ArrayList();
        rawList.add("Hello");
        rawList.add("World");

        try {
            ArrayList<String> stringList = (ArrayList<String>) rawList;
            // Note: The actual types of elements in rawList must match the specified type (String).
            for (String s : stringList) {
                System.out.println(s);
            }
        } catch (ClassCastException e) {
            System.out.println("Type conversion error: " + e.getMessage());
        }

        // From typed ArrayList to raw ArrayList
        // Converting a typed ArrayList to a raw ArrayList is relatively simple,
        // just assign the typed ArrayList to a raw ArrayList. 
        // However, this operation loses compile-time type checking:
        ArrayList<String> typedList = new ArrayList<String>();
        typedList.add("Hello");
        typedList.add("World");

        ArrayList rawList2 = typedList;
        // rawList2 is now a raw type ArrayList without type checking
        for (Object obj : rawList2) {
            System.out.println(obj);
        }
    }
}
```