import java.util.*;
class Example{
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        
        ListIterator<String> iterator = list.listIterator();
        
        // Concurrent modification: Adding an element directly to the list
        list.add("Orange");
        
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }
    }
}