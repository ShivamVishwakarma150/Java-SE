import java.util.Enumeration;
import java.util.Vector;

public class Example17 {
    public static void main(String[] args) {
        Vector<Integer> v=new Vector<>();
        int x=10;
        for(int i=1;i<=5;i++)
        {
            v.add(x);
            x=x+10;
        }
        Enumeration <Integer> en=v.elements();
        while(en.hasMoreElements())
        {
            Integer obj=en.nextElement();
            System.out.println(obj);
            if(obj%20==0)
            {
                v.remove(obj);
            }
        }
        System.out.println("Final vector:"+v);
    }
}
