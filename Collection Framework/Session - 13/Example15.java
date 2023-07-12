import java.util.*;
class Example15{
    public static void main(String[] args) {
        Vector<Integer> v=new Vector<>();
        System.out.println("Initial cap:"+v.capacity());
        
        int x=10;
        for(int i=1;i<=11;i++)
        {
            v.add(x);
            x=x+10;
        }
        System.out.println("First ele:"+v.firstElement());
        System.out.println("Final cap:"+v.capacity());
        
    }
}