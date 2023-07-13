import java.util.*;

public class Example21 {
    public static void main(String[] args) {
        Set <Integer> hs=new HashSet<>();
        System.out.println(hs.add(10));
        System.out.println(hs.add(null));
        System.out.println(hs.add(15));
        System.out.println(hs.add(20));
        System.out.println(hs.add(2));
        System.out.println(hs.add(30));
        System.out.println(hs.add(15));
        System.out.println("Displaying using toString():");
        System.out.println(hs);
        System.out.println("Displaying using for each:");
        for(Integer obj: hs)
            System.out.print(obj+ " ");
        Iterator <Integer> it=hs.iterator();
        System.out.println();
        System.out.println("Displaying using iterator:");
        while(it.hasNext())
        {
            Integer obj=it.next();
            System.out.print(obj+" ");
        }
   }
}