import java.util.*;
class Example16{
    public static void main(String[] args) {
        Vector<Integer> v=new Vector<>();
        int x=10;
        for(int i=1;i<=5;i++)
        {
            v.add(x);
            x=x+10;
        }
        Iterator <Integer> it=v.iterator();
        while(it.hasNext())
        {
            Integer obj=it.next();
            System.out.println(obj);
            if(obj%20==0)
            {
                v.remove(obj);
            }
        }
        System.out.println("Final vector:"+v);
    }
}