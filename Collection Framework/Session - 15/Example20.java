import java.util.*;

public class Example20 {
    public static void main(String[] args) {
        Set <Integer> hs=new HashSet<>();
        System.out.println(hs.add(10));
        System.out.println(hs.add(null));
        System.out.println(hs.add(15));
        System.out.println(hs.add(20));
        System.out.println(hs.add(2));
        System.out.println(hs.add(30));
        System.out.println(hs.add(15));
        System.out.println(hs);
   }
}