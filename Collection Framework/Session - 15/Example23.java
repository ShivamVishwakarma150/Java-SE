import java.util.*;

public class Example23 {
    public static void main(String[] args) {
        SortedSet <Integer> ss=new TreeSet<>();
        System.out.println(ss.add(10));
        System.out.println(ss.add(15));
        System.out.println(ss.add(20));
        System.out.println(ss.add(2));
        System.out.println(ss.add(30));
        System.out.println(ss.add(15));
        System.out.println("Min ele:"+ss.first());
        System.out.println("Max ele:"+ss.last());
   }
}